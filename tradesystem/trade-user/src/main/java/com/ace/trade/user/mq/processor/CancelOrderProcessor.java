package com.ace.trade.user.mq.processor;

import com.ace.trade.common.constants.TradeEnums;
import com.ace.trade.common.protocol.mq.CancelOrderMQ;
import com.ace.trade.common.protocol.user.ChangeUserMoneyReq;
import com.ace.trade.common.rocketmq.IMessageProcessor;
import com.ace.trade.user.service.IUserService;
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
    IUserService iUserService;

    public boolean handleMessage(MessageExt messageExt) {

        try {
            String  body = new String (messageExt.getBody(),"UTF-8");
            String msgId=messageExt.getMsgId();
            String tags = messageExt.getTags();
            String keys =messageExt.getKeys();

            CancelOrderMQ cancelOrderMQ = JSON.parseObject(body,CancelOrderMQ.class);
            LOGGER.info("user CancelOrderProcessor receive msg :"+ messageExt);
            if(cancelOrderMQ.getUserMoney() != null && cancelOrderMQ.getUserMoney().compareTo(BigDecimal.ZERO)==1){
                ChangeUserMoneyReq changeUserMoneyReq=    new ChangeUserMoneyReq();
                changeUserMoneyReq.setUserId(cancelOrderMQ.getUserId());
                changeUserMoneyReq.setMoneyLogType(TradeEnums.UserMoneyLogTypeEnum.RETURNED.getCode());
                changeUserMoneyReq.setOrderId(cancelOrderMQ.getOrderId());
                changeUserMoneyReq.setUserMoney(cancelOrderMQ.getUserMoney());
                iUserService.changeUserMoney(changeUserMoneyReq);
            }
            return  true ;
        } catch (Exception e) {
            return false;
        }
    }
}
