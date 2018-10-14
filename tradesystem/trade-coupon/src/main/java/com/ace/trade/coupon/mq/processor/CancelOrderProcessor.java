package com.ace.trade.coupon.mq.processor;

import com.ace.trade.common.constants.TradeEnums;
import com.ace.trade.common.protocol.coupon.ChangeCouponStatusReq;
import com.ace.trade.common.protocol.mq.CancelOrderMQ;
import com.ace.trade.common.protocol.user.ChangeUserMoneyReq;
import com.ace.trade.common.rocketmq.IMessageProcessor;
import com.ace.trade.coupon.service.ICouponService;
import com.ace.trade.entity.TradeCoupon;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;


public class CancelOrderProcessor implements IMessageProcessor {
    public static  final Logger LOGGER = LoggerFactory.getLogger(CancelOrderProcessor.class);
    @Autowired
    ICouponService couponService;

    public boolean handleMessage(MessageExt messageExt) {

        try {
            String  body = new String (messageExt.getBody(),"UTF-8");
            String msgId=messageExt.getMsgId();
            String tags = messageExt.getTags();
            String keys =messageExt.getKeys();
            LOGGER.info("coupon CancelOrderProcessor receive msg :"+ messageExt);

            CancelOrderMQ cancelOrderMQ = JSON.parseObject(body,CancelOrderMQ.class);
            if(StringUtils.isNotBlank(cancelOrderMQ.getCouponId())){
                ChangeCouponStatusReq changeCouponStatusReq =new ChangeCouponStatusReq();
                changeCouponStatusReq.setOderId(changeCouponStatusReq.getOderId());
                changeCouponStatusReq.setCouponId(changeCouponStatusReq.getCouponId());
                changeCouponStatusReq.setIsUsed(TradeEnums.YesNoEnum.NO.getCode());
                this.couponService.changeCouponStatus(changeCouponStatusReq);
            }

            return  true ;
        } catch (Exception e) {
            return false;
        }
    }
}
