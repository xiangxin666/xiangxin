package com.ace.trade.order.service.impl;

import com.ace.trade.common.api.IGoodsApi;
import com.ace.trade.common.constants.TradeEnums;
import com.ace.trade.common.exception.AceOrderException;
import com.ace.trade.common.protocol.Result;
import com.ace.trade.common.protocol.goods.QueryGoodsReq;
import com.ace.trade.common.protocol.goods.QueryGoodsRes;
import com.ace.trade.common.protocol.order.ConfirmOrderReq;
import com.ace.trade.common.protocol.order.ConfirmOrderRes;
import com.ace.trade.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IGoodsApi goodsApi;

    public Result<ConfirmOrderRes> confirmOrder(ConfirmOrderReq confirmOrderReq) {
        Result<ConfirmOrderRes> result =null;
        try {
            result  = new  Result<ConfirmOrderRes>(ConfirmOrderRes.class);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("返回结果初始化错误！");
        } catch (InstantiationException e) {
            throw new RuntimeException("返回结果初始化错误！");
        }
        //0.数据准备
        QueryGoodsReq queryGoodsReq =new QueryGoodsReq();
        queryGoodsReq.setGoodsId(confirmOrderReq.getGoodsId());
        Result<QueryGoodsRes> queryGoodsRes = goodsApi.queryGoods(queryGoodsReq);
        //1.检查校验
        checkConfirmOrder(confirmOrderReq,queryGoodsRes);
        //2.创建不可见订单
        saveNoConfirmOrder(confirmOrderReq);
        //3.调用远程服务，扣优惠券，扣库存，扣余额 如果调用成功-->更改订单状态可见 ，失败--》发送mq消息，取消订单

        return result;
    }

    public void saveNoConfirmOrder(ConfirmOrderReq confirmOrderReq) {
    }

    private void checkConfirmOrder(ConfirmOrderReq confirmOrderReq,Result<QueryGoodsRes> queryGoodsRes) {
        if(confirmOrderReq==null){
            throw new AceOrderException("下单信息不能为空");
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
}
