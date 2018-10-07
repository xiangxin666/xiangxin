package com.ace.trade.order.service.impl;

import com.ace.trade.common.api.ICouponApi;
import com.ace.trade.common.api.IGoodsApi;
import com.ace.trade.common.api.IUserApi;
import com.ace.trade.common.constants.MQEnums;
import com.ace.trade.common.constants.TradeEnums;
import com.ace.trade.common.exception.AceMQException;
import com.ace.trade.common.exception.AceOrderException;
import com.ace.trade.common.protocol.Result;
import com.ace.trade.common.protocol.coupon.ChangeCouponStatusReq;
import com.ace.trade.common.protocol.coupon.ChangeCouponStatusRes;
import com.ace.trade.common.protocol.coupon.QueryCouponReq;
import com.ace.trade.common.protocol.coupon.QueryCouponRes;
import com.ace.trade.common.protocol.goods.QueryGoodsReq;
import com.ace.trade.common.protocol.goods.QueryGoodsRes;
import com.ace.trade.common.protocol.goods.ReduceGoodsNumberReq;
import com.ace.trade.common.protocol.goods.ReduceGoodsNumberRes;
import com.ace.trade.common.protocol.mq.CancelOrderMQ;
import com.ace.trade.common.protocol.order.ConfirmOrderReq;
import com.ace.trade.common.protocol.order.ConfirmOrderRes;
import com.ace.trade.common.protocol.user.ChangeUserMoneyReq;
import com.ace.trade.common.protocol.user.ChangeUserMoneyRes;
import com.ace.trade.common.protocol.user.QueryUserReq;
import com.ace.trade.common.protocol.user.QueryUserRes;
import com.ace.trade.common.rocketmq.AceMQProducer;
import com.ace.trade.common.util.IDGenerator;
import com.ace.trade.entity.TradeOrder;
import com.ace.trade.mapper.TradeOrderMapper;
import com.ace.trade.order.service.IOrderService;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.producer.SendResult;
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
    @Autowired
    private AceMQProducer aceMQProducer;
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
            String orderId=saveNoConfirmOrder(confirmOrderReq);
            //3.调用远程服务，扣优惠券，扣库存，扣余额 如果调用成功-->更改订单状态可见 ，失败--》发送mq消息，取消订单
            callRemoteService(orderId,confirmOrderReq);
        } catch (Exception e) {
            result.setRetCode(TradeEnums.RetEnum.FAIL.getCode());
            result.setRetInfo(e.getMessage());
        }


        return result;
    }
    //3.调用远程服务，扣优惠券，扣库存，扣余额 如果调用成功-->更改订单状态可见 ，失败--》发送mq消息，取消订单
    private void callRemoteService(String orderId,ConfirmOrderReq confirmOrderReq) {
        try{
            //调用优惠券
            if(StringUtils.isNoneBlank(confirmOrderReq.getCouponId())){
                ChangeCouponStatusReq changeCouponStatusReq=new ChangeCouponStatusReq();
                changeCouponStatusReq.setCouponId(confirmOrderReq.getCouponId());
                changeCouponStatusReq.setIsUsed(TradeEnums.YesNoEnum.YES.getCode());
                changeCouponStatusReq.setOderId(orderId);
                Result<ChangeCouponStatusRes>  result = couponApi.changeCouponStatus(changeCouponStatusReq);
                if(!result.getRetCode().equals(TradeEnums.RetEnum.SUCCESS.getCode())){
                    throw new Exception("优惠券使用失败");
                }
            }

            //扣余额
            if(confirmOrderReq.getMoneyPaid() !=null && confirmOrderReq.getMoneyPaid().compareTo(BigDecimal.ZERO)==1){
                ChangeUserMoneyReq changeUserMoneyReq=new ChangeUserMoneyReq();
                changeUserMoneyReq.setOrderId(orderId);
                changeUserMoneyReq.setUserId(confirmOrderReq.getUserId());
                changeUserMoneyReq.setMoneyLogType(TradeEnums.UserMoneyLogTypeEnum.PAID.getCode());
                Result<ChangeUserMoneyRes>  result= userApi.changeUserMoney(changeUserMoneyReq);
                if(!result.getRetCode().equals(TradeEnums.RetEnum.SUCCESS.getCode())){
                    throw new Exception("扣余额失败");
                }
            }

            //扣库存  Result<ReduceGoodsNumberRes> reduceGoodsNumber(ReduceGoodsNumberReq reduceGoodsNumberReq);
            ReduceGoodsNumberReq reduceGoodsNumberReq = new ReduceGoodsNumberReq();
            reduceGoodsNumberReq.setOrderId(orderId);
            reduceGoodsNumberReq.setGoodsId(confirmOrderReq.getGoodsId());
            reduceGoodsNumberReq.setGoodsNumber(confirmOrderReq.getGoodsNumber());
            Result<ReduceGoodsNumberRes> result = goodsApi.reduceGoodsNumber(reduceGoodsNumberReq);
            if(!result.getRetCode().equals(TradeEnums.RetEnum.SUCCESS.getCode())){
                throw new Exception("扣库存失败");
            }
            //更改订单状态
            TradeOrder tradeOrder =new TradeOrder();
            tradeOrder.setOrderId(orderId);
            tradeOrder.setOrderStatus(TradeEnums.OrderStatusEnum.CONFIRM.getStatusCode());
            tradeOrder.setConfirmTime(new Date());
            int i = traderOrderMapper.updateByPrimaryKeySelective(tradeOrder);
            if(i<=0){
                throw new Exception("更改订单状态失败");
            }
        }catch(Exception ex){
            //发送mq消息
            CancelOrderMQ cancelOrderMQ = new CancelOrderMQ();
            cancelOrderMQ.setUserMoney(confirmOrderReq.getMoneyPaid());
            cancelOrderMQ.setOrderId(orderId);
            cancelOrderMQ.setGooodsNumber(confirmOrderReq.getGoodsNumber());
            cancelOrderMQ.setGoodsId(confirmOrderReq.getGoodsId());
            cancelOrderMQ.setCouponId(confirmOrderReq.getCouponId());
            cancelOrderMQ.setUserId(confirmOrderReq.getUserId());
            try {
                SendResult sendResult = this.aceMQProducer.sendMessage(MQEnums.TopicEnum.ORDER_CANCEL,orderId, JSON.toJSONString(cancelOrderMQ));
                System.out.println(sendResult);
            } catch (AceMQException e) {
                e.printStackTrace();
            }
        }
    }

    public String saveNoConfirmOrder(ConfirmOrderReq confirmOrderReq) throws Exception {
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

        return  orderId;
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
    }


    private BigDecimal calculateShippingFee(BigDecimal goodsAmount){
        if(goodsAmount.doubleValue()>100.00){
            return BigDecimal.ZERO;
        }else {
            return new BigDecimal(10);
        }
    }
}
