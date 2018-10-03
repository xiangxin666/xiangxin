package com.ace.trade.common.rocketmq;

import com.ace.trade.common.exception.AceMQException;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AceMQConsumer {
    public static final Logger LOGGER = LoggerFactory.getLogger(AceMQConsumer.class);
    private String groupName;
    private String topic;
    private String tag="*";
    private String namesrvAddr;

    /**
     * Minimum consumer thread number
     */
    private int consumeThreadMin = 20;

    /**
     * Max consumer thread number
     */
    private int consumeThreadMax = 64;

    private IMessageProcessor  processor;

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public void setConsumeThreadMin(int consumeThreadMin) {
        this.consumeThreadMin = consumeThreadMin;
    }

    public void setConsumeThreadMax(int consumeThreadMax) {
        this.consumeThreadMax = consumeThreadMax;
    }

    public void setProcessor(IMessageProcessor processor) {
        this.processor = processor;
    }

    public  void init() throws AceMQException {
        if(StringUtils.isBlank(groupName)){
            throw new AceMQException("groupName is null");
        }
        if(StringUtils.isBlank(topic)){
            throw new AceMQException("topic is null");
        }
        if(StringUtils.isBlank(namesrvAddr)){
            throw new AceMQException("namesrvAddr is null");
        }
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(this.groupName);
        consumer.setNamesrvAddr(this.namesrvAddr);
        try {
            consumer.subscribe(this.topic, this.tag);
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            consumer.setConsumeThreadMin(this.consumeThreadMin);
            consumer.setConsumeThreadMax(this.consumeThreadMax);
            AceMessageListener aceMessageListener=new AceMessageListener();
            aceMessageListener.setProcessor(this.processor);
            consumer.setMessageListener(aceMessageListener);
            consumer.start();
            LOGGER.info("consumer is start!groupName:{},topic:{},namesrvAddr:{}",groupName,topic,namesrvAddr);
        } catch (MQClientException e) {
            LOGGER.info("consumer is start!groupName:{},topic:{},namesrvAddr:{}",groupName,topic,namesrvAddr,e);
            throw new AceMQException(e);
        }

    }
}
