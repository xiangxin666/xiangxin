package com.ace.trade.goods.mq.processor;

import com.ace.trade.common.constants.MQEnums;
import com.ace.trade.common.constants.TradeEnums;
import com.ace.trade.common.protocol.coupon.ChangeCouponStatusReq;
import com.ace.trade.common.protocol.goods.AddGoodsNumberReq;
import com.ace.trade.common.protocol.mq.CancelOrderMQ;
import com.ace.trade.common.rocketmq.IMessageProcessor;
import com.ace.trade.entity.TradeMqConsumerLog;
import com.ace.trade.entity.TradeMqConsumerLogExample;
import com.ace.trade.entity.TradeMqConsumerLogKey;
import com.ace.trade.goods.service.IGoodsService;
import com.ace.trade.mapper.TradeMqConsumerLogMapper;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class CancelOrderProcessor implements IMessageProcessor {
    public static  final Logger LOGGER = LoggerFactory.getLogger(CancelOrderProcessor.class);
    @Autowired
    IGoodsService goodsService;
    @Autowired
    TradeMqConsumerLogMapper tradeMqConsumerLogMapper;

    public boolean handleMessage(MessageExt messageExt) {
        TradeMqConsumerLog mqConsumerLog =null;
        try {
            String groupName= "goods_orderTopic_cancel_group";
            String  body = new String (messageExt.getBody(),"UTF-8");
            String msgId=messageExt.getMsgId();
            String tags = messageExt.getTags();
            String keys =messageExt.getKeys();
            LOGGER.info("goods CancelOrderProcessor receive msg :"+ messageExt);


            TradeMqConsumerLogKey tradeMqConsumerLogKey =new TradeMqConsumerLogKey();
            tradeMqConsumerLogKey.setGroupName(groupName);
            tradeMqConsumerLogKey.setMsgTag(tags);
            tradeMqConsumerLogKey.setMsgKeys(keys);
             mqConsumerLog = this.tradeMqConsumerLogMapper.selectByPrimaryKey(tradeMqConsumerLogKey);
            if (mqConsumerLog != null){
                String consumeStatus = mqConsumerLog.getConsumerStatus();
                if(MQEnums.ConsumerSatus.SUCCESS.getStatusCode().equals(consumeStatus)){
                       //返回成功，重复的处理消息
                       LOGGER.warn("消息已处理");
                       return true;
                }else if(MQEnums.ConsumerSatus.PROCESSING.getStatusCode().equals(consumeStatus)){
                      //返回失败，有消费者正在处理中
                      LOGGER.warn("消息正在处理，请稍后再试");
                      return false;
                }else if(MQEnums.ConsumerSatus.FAIL.getStatusCode().equals(consumeStatus)){
                     if(mqConsumerLog.getConsumerTimes()>=3){
                         //返回失败，超过三次不处理了
                         LOGGER.warn("消息超过三次不处理了");
                         return true;
                     }
                     //更新处理中的状态
                    TradeMqConsumerLog tradeMqConsumerLog1 = new TradeMqConsumerLog();
                    tradeMqConsumerLog1.setGroupName(mqConsumerLog.getGroupName());
                    tradeMqConsumerLog1.setMsgTag(mqConsumerLog.getMsgTag());
                    tradeMqConsumerLog1.setMsgKeys(mqConsumerLog.getMsgKeys());
                    tradeMqConsumerLog1.setConsumerStatus(MQEnums.ConsumerSatus.PROCESSING.getStatusCode());
                    tradeMqConsumerLog1.setConsumerTimes(mqConsumerLog.getConsumerTimes()+1);
                    //防止并发，用乐观锁的机制
                    TradeMqConsumerLogExample example =new TradeMqConsumerLogExample();
                    example.createCriteria().andGroupNameEqualTo(mqConsumerLog.getGroupName())
                            .andMsgKeysEqualTo(mqConsumerLog.getMsgKeys())
                            .andMsgTagEqualTo(mqConsumerLog.getMsgTag())
                            .andConsumerTimesEqualTo(mqConsumerLog.getConsumerTimes());
                    int i=tradeMqConsumerLogMapper.updateByExampleSelective(tradeMqConsumerLog1,example);
                    if(i<=0){
                        //存在并发，处理失败
                        LOGGER.warn("存在并发，处理失败");
                        return false;
                    }

                }
            }else{
                //插入去重表,并发时用主键冲突控制
                try{
                    mqConsumerLog = new TradeMqConsumerLog();
                    mqConsumerLog.setGroupName(groupName);
                    mqConsumerLog.setMsgKeys(tags);
                    mqConsumerLog.setConsumerTimes(0);
                    mqConsumerLog.setMsgBody(body);
                    mqConsumerLog.setConsumerStatus(MQEnums.ConsumerSatus.PROCESSING.getStatusCode());
                    tradeMqConsumerLogMapper.insert(mqConsumerLog);
                }catch(Exception ex){
                    LOGGER.warn("有订阅者正在处理，请稍后再试");
                    return false;
                }
            }

            //业务逻辑处理
            CancelOrderMQ cancelOrderMQ =JSON.parseObject(body,CancelOrderMQ.class);
            AddGoodsNumberReq addGoodsNumberReq = new AddGoodsNumberReq();
            addGoodsNumberReq.setGoodsId(cancelOrderMQ.getGoodsId());
            addGoodsNumberReq.setGoodsNumber(cancelOrderMQ.getGooodsNumber());
            addGoodsNumberReq.setOrderId(cancelOrderMQ.getOrderId());
            goodsService.addGoodsNumber(addGoodsNumberReq);


            //跟新日志表处理状态成功
            TradeMqConsumerLog tradeMqConsumerLog1 = new TradeMqConsumerLog();
            tradeMqConsumerLog1.setGroupName(mqConsumerLog.getGroupName());
            tradeMqConsumerLog1.setMsgTag(mqConsumerLog.getMsgTag());
            tradeMqConsumerLog1.setMsgKeys(mqConsumerLog.getMsgKeys());
            tradeMqConsumerLog1.setConsumerStatus(MQEnums.ConsumerSatus.SUCCESS.getStatusCode());
            tradeMqConsumerLog1.setConsumerTimes(mqConsumerLog.getConsumerTimes()+1);
            tradeMqConsumerLogMapper.updateByPrimaryKeySelective(tradeMqConsumerLog1);

            return  true ;
        } catch (Exception e) {
            TradeMqConsumerLog tradeMqConsumerLog1 = new TradeMqConsumerLog();
            tradeMqConsumerLog1.setGroupName(mqConsumerLog.getGroupName());
            tradeMqConsumerLog1.setMsgTag(mqConsumerLog.getMsgTag());
            tradeMqConsumerLog1.setMsgKeys(mqConsumerLog.getMsgKeys());
            tradeMqConsumerLog1.setConsumerStatus(MQEnums.ConsumerSatus.FAIL.getStatusCode());
            tradeMqConsumerLog1.setConsumerTimes(mqConsumerLog.getConsumerTimes()+1);
            tradeMqConsumerLogMapper.updateByPrimaryKeySelective(tradeMqConsumerLog1);
            return false;
        }



    }
}
