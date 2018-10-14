package com.ace.trade.order.mq.processor;

import com.ace.trade.common.constants.TradeEnums;
import com.ace.trade.common.protocol.mq.CancelOrderMQ;
import com.ace.trade.common.protocol.user.ChangeUserMoneyReq;
import com.ace.trade.common.rocketmq.IMessageProcessor;
import com.ace.trade.entity.TradeOrder;
import com.ace.trade.mapper.TradeOrderMapper;
import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;


public class CancelOrderProcessor implements IMessageProcessor {
    public static  final Logger LOGGER = LoggerFactory.getLogger(CancelOrderProcessor.class);
    @Autowired
    TradeOrderMapper  tradeOrderMapper;

    public boolean handleMessage(MessageExt messageExt) {

        try {
            String  body = new String (messageExt.getBody(),"UTF-8");
            String msgId=messageExt.getMsgId();
            String tags = messageExt.getTags();
            String keys =messageExt.getKeys();

            CancelOrderMQ cancelOrderMQ = JSON.parseObject(body,CancelOrderMQ.class);
            LOGGER.info("order CancelOrderProcessor receive msg :"+ messageExt);
            TradeOrder tradeOrder = new TradeOrder();
            tradeOrder.setOrderId(cancelOrderMQ.getOrderId());
            tradeOrder.setOrderStatus(TradeEnums.OrderStatusEnum.CANCEL.getStatusCode());
            tradeOrderMapper.updateByPrimaryKeySelective(tradeOrder);
            return  true ;
        } catch (Exception e) {
            return false;
        }
    }
}
