package com.ace.trade.entity;

import java.io.Serializable;

public class TradeMqProducerTempKey implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_mq_producer_temp.group_name
     *
     * @mbg.generated Sat Oct 20 11:34:54 CST 2018
     */
    private String groupName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_mq_producer_temp.msg_tag
     *
     * @mbg.generated Sat Oct 20 11:34:54 CST 2018
     */
    private String msgTag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_mq_producer_temp.msg_keys
     *
     * @mbg.generated Sat Oct 20 11:34:54 CST 2018
     */
    private String msgKeys;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table trade_mq_producer_temp
     *
     * @mbg.generated Sat Oct 20 11:34:54 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_mq_producer_temp.group_name
     *
     * @return the value of trade_mq_producer_temp.group_name
     *
     * @mbg.generated Sat Oct 20 11:34:54 CST 2018
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_mq_producer_temp.group_name
     *
     * @param groupName the value for trade_mq_producer_temp.group_name
     *
     * @mbg.generated Sat Oct 20 11:34:54 CST 2018
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_mq_producer_temp.msg_tag
     *
     * @return the value of trade_mq_producer_temp.msg_tag
     *
     * @mbg.generated Sat Oct 20 11:34:54 CST 2018
     */
    public String getMsgTag() {
        return msgTag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_mq_producer_temp.msg_tag
     *
     * @param msgTag the value for trade_mq_producer_temp.msg_tag
     *
     * @mbg.generated Sat Oct 20 11:34:54 CST 2018
     */
    public void setMsgTag(String msgTag) {
        this.msgTag = msgTag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_mq_producer_temp.msg_keys
     *
     * @return the value of trade_mq_producer_temp.msg_keys
     *
     * @mbg.generated Sat Oct 20 11:34:54 CST 2018
     */
    public String getMsgKeys() {
        return msgKeys;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_mq_producer_temp.msg_keys
     *
     * @param msgKeys the value for trade_mq_producer_temp.msg_keys
     *
     * @mbg.generated Sat Oct 20 11:34:54 CST 2018
     */
    public void setMsgKeys(String msgKeys) {
        this.msgKeys = msgKeys;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_mq_producer_temp
     *
     * @mbg.generated Sat Oct 20 11:34:54 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", groupName=").append(groupName);
        sb.append(", msgTag=").append(msgTag);
        sb.append(", msgKeys=").append(msgKeys);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_mq_producer_temp
     *
     * @mbg.generated Sat Oct 20 11:34:54 CST 2018
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TradeMqProducerTempKey other = (TradeMqProducerTempKey) that;
        return (this.getGroupName() == null ? other.getGroupName() == null : this.getGroupName().equals(other.getGroupName()))
            && (this.getMsgTag() == null ? other.getMsgTag() == null : this.getMsgTag().equals(other.getMsgTag()))
            && (this.getMsgKeys() == null ? other.getMsgKeys() == null : this.getMsgKeys().equals(other.getMsgKeys()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_mq_producer_temp
     *
     * @mbg.generated Sat Oct 20 11:34:54 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGroupName() == null) ? 0 : getGroupName().hashCode());
        result = prime * result + ((getMsgTag() == null) ? 0 : getMsgTag().hashCode());
        result = prime * result + ((getMsgKeys() == null) ? 0 : getMsgKeys().hashCode());
        return result;
    }
}