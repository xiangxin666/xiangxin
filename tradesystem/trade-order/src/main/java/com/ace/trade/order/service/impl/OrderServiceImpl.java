package com.ace.trade.order.service.impl;

import com.ace.trade.common.api.ICouponApi;
import com.ace.trade.common.api.IGoodsApi;
import com.ace.trade.common.api.IUserApi;
import com.ace.trade.common.constants.TradeEnums;
import com.ace.trade.common.exception.AceOrderException;
import com.ace.trade.common.protocol.Result;
import com.ace.trade.common.protocol.coupon.QueryCouponReq;
import com.ace.trade.common.protocol.coupon.QueryCouponRes;
import com.ace.trade.common.protocol.goods.QueryGoodsReq;
import com.ace.trade.common.protocol.goods.QueryGoodsRes;
import com.ace.trade.common.protocol.order.ConfirmOrderReq;
import com.ace.trade.common.protocol.order.ConfirmOrderRes;
import com.ace.trade.common.protocol.user.ChangeUserMoneyReq;
import com.ace.trade.common.protocol.user.ChangeUserMoneyRes;
import com.ace.trade.common.protocol.user.QueryUserReq;
import com.ace.trade.common.protocol.user.QueryUserRes;
import com.ace.trade.common.util.IDGenerator;
import com.ace.trade.entity.TradeOrder;
import com.ace.trade.mapper.TradeOrderMapper;
import com.ace.trade.order.service.IOrderService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IGoodsApi goodsApi;
    @Autowired
    private TradeOrderMapper traderOrderMapper;
    @Autowired
    private ICouponApi couponApi;
    @Autowired
    private IUserApi userApi;

    public Result<ConfirmOrderRes> confirmOrder(ConfirmOrderReq confirmOrderReq) {
        Result<ConfirmOrderRes> result =null;
        try {
            result  = new  Result<ConfirmOrderRes>(ConfirmOrderRes.class);
        } catch (IllegalAccessException e) {
            throw new AceOrderException("返回ConfirmOrderRes结果初始化错误！");
        } catch (InstantiationException e) {
            throw new AceOrderException("返回ConfirmOrderRes结果初始化错误！");
        }
        try {
            //0.数据准备
            QueryGoodsReq queryGoodsReq =new QueryGoodsReq();
            queryGoodsReq.setGoodsId(confirmOrderReq.getGoodsId());
            Result<QueryGoodsRes> queryGoodsRes = goodsApi.queryGoods(queryGoodsReq);
            //1.检查校验
            checkConfirmOrder(confirmOrderReq,queryGoodsRes);
            //2.创建不可见订单
            saveNoConfirmOrder(confirmOrderReq);
        } catch (Exception e) {
            result.setRetCode(TradeEnums.RetEnum.FAIL.getCode());
            result.setRetInfo(e.getMessage());
        }
        //3.调用远程服务，扣优惠券，扣库存，扣余额 如果调用成功-->更改订单状态可见 ，失败--》发送mq消息，取消订单

        return result;
    }

    public void saveNoConfirmOrder(ConfirmOrderReq confirmOrderReq) throws Exception {
        TradeOrder record=new TradeOrder();
        String orderId=IDGenerator.generateUUID();
        record.setOrderId(orderId);
        record.setUserid(confirmOrderReq.getUserId());
        record.setOrderStatus(TradeEnums.OrderStatusEnum.NO_CONFIRM.getStatusCode());
        record.setPayStatus(TradeEnums.PayStatusEnum.NO_PAY.getStatusCode());
        record.setShippingStatus(TradeEnums.ShippingStatusEnum.NO_SHIP.getStatusCode());
        record.setAddress(confirmOrderReq.getAddress());
        record.setConsignee(confirmOrderReq.getConsignee());
        record.setGoodsId(confirmOrderReq.getGoodsId());
        record.setGoodsNumber(confirmOrderReq.getGoodsNumber());
        record.setGoodsPrice(confirmOrderReq.getGoodsPrice());
        BigDecimal goodAmount=confirmOrderReq.getGoodsPrice().multiply(new BigDecimal(confirmOrderReq.getGoodsNumber()));
        record.setGoodsAmount(goodAmount);
        BigDecimal shippingFee=this.calculateShippingFee(goodAmount);
        if(confirmOrderReq.getShippingFeel().compareTo(shippingFee)!=0){
            throw new Exception("快递费用不正确");
        }
        record.setShippingFee(shippingFee);

        BigDecimal orderAmount=goodAmount.add(shippingFee);
        if(orderAmount.compareTo(confirmOrderReq.getOrderAmount())!=0){
            throw new Exception("订单总价异常，请重新下单");
        }
        record.setOrderAmount(orderAmount);

        String couponId=confirmOrderReq.getCouponId();
        //优惠券不为空
        if(StringUtils.isNoneBlank(couponId)){
            //查询优惠券状态
            QueryCouponReq queryCouponReq =new QueryCouponReq();
            queryCouponReq.setCouponId(confirmOrderReq.getCouponId());
            Result<QueryCouponRes> queryCouponRes= couponApi.queryCoupon(queryCouponReq);
            if(queryCouponRes==null||!queryCouponRes.getRetCode().equals(TradeEnums.RetEnum.SUCCESS.getCode())){
                throw new Exception("优惠券非法");
            }
            if(queryCouponRes.getData().getIsUsed().equals(TradeEnums.YesNoEnum.NO.getCode())){
                throw new Exception("优惠券已使用");
            }
            record.setCouponId(couponId);
            record.setCouponPaid(queryCouponRes.getData().getCouponPrice());
        }else{
            record.setCouponPaid(BigDecimal.ZERO);
        }
        //余额支付
        if(confirmOrderReq.getMoneyPaid()!=null){
            int r=confirmOrderReq.getMoneyPaid().compareTo(BigDecimal.ZERO);
            if(r==-1){
                throw new Exception("余额金额非法");
            }
            if(r==1){
                //判断当前账户余额是否足够
                QueryUserReq queryUserReq=new QueryUserReq();
                queryUserReq.setUserId(confirmOrderReq.getUserId());
                Result<QueryUserRes> queryUserRes =userApi.queryUserById(queryUserReq);
                if( queryUserRes==null || !queryUserRes.getRetCode().equals(TradeEnums.RetEnum.SUCCESS.getCode())){
                    throw new Exception("用户非法");
                }
                if(queryUserRes.getData().getUserMoney().compareTo(confirmOrderReq.getMoneyPaid())==-1){
                    throw new Exception("余额不足");
                }
                record.setMoneyPaid(confirmOrderReq.getMoneyPaid());
            }
        }else{
            record.setMoneyPaid(BigDecimal.ZERO);
        }

        BigDecimal payAmount=orderAmount.subtract(record.getMoneyPaid()).subtract(record.getCouponPaid());
        record.setPayAmount(payAmount);
        record.setAddTime(new Date());

        int ret=this.traderOrderMapper.insert(record);
        if(ret!=1){
            throw new Exception("保存临时订单失败");
        }
    }

    private void checkConfirmOrder(ConfirmOrderReq confirmOrderReq,Result<QueryGoodsRes> queryGoodsRes) {
        if(confirmOrderReq==null){
            throw new AceOrderException("下单信息不能为空!");
        }

        if(confirmOrderReq.getUserId()==null){
            throw new AceOrderException("会员账号不能为空");
        }

        if(confirmOrderReq.getGoodsId() == null){
            throw new AceOrderException("商品编号不能为空");
        }

        if(confirmOrderReq.getGoodsNumber() == null|| confirmOrderReq.getGoodsNumber()<=0){
            throw new AceOrderException("商品购买数量不能小于0");
        }
        if(confirmOrderReq.getAddress() == null){
            throw new AceOrderException("收货地址不能为空");
        }

        if(queryGoodsRes==null || !queryGoodsRes.getRetCode().equals(TradeEnums.RetEnum.SUCCESS.getCode())){
            throw new AceOrderException("未查询到该商品["+confirmOrderReq.getGoodsId()+"]");
        }

        if(queryGoodsRes.getData().getGoodsNumber()<confirmOrderReq.getGoodsNumber()){
            throw new AceOrderException("商品库存不足");
        }

        if(queryGoodsRes.getData().getGoodsPrice().compareTo(confirmOrderReq.getGoodsPrice())!=0){
            throw new AceOrderException("商品价格有变化");
        }

        if(confirmOrderReq.getShippingFeel()==null){
            confirmOrderReq.setShippingFeel(BigDecimal.ZERO);
        }

        if(confirmOrderReq.getOrderAmount()==null){
            confirmOrderReq.setOrderAmount(BigDecimal.ZERO);
        }
/*      private Integer userId;
        private String address;
        private String consignee;
        private Integer goodsId;
        private Integer goodsNumber;
        private String couponId;
        private BigDecimal moneyPaid;//余额支付
        private BigDecimal goodsPrice;//物品单价
        private BigDecimal shippingFeel;//运费
        private BigDecimal orderAmount;//订单总价*/
    }


    private BigDecimal calculateShippingFee(BigDecimal goodsAmount){
        if(goodsAmount.doubleValue()>100.00){
            return BigDecimal.ZERO;
        }else {
            return new BigDecimal(10);
        }
    }
}
