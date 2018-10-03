package com.ace.trade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TradeUserMoneyLog extends TradeUserMoneyLogKey implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_user_money_log.money_log_type
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private String moneyLogType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_user_money_log.user_money
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private BigDecimal userMoney;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_user_money_log.create_time
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table trade_user_money_log
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_user_money_log.money_log_type
     *
     * @return the value of trade_user_money_log.money_log_type
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public String getMoneyLogType() {
        return moneyLogType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_user_money_log.money_log_type
     *
     * @param moneyLogType the value for trade_user_money_log.money_log_type
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setMoneyLogType(String moneyLogType) {
        this.moneyLogType = moneyLogType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_user_money_log.user_money
     *
     * @return the value of trade_user_money_log.user_money
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public BigDecimal getUserMoney() {
        return userMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_user_money_log.user_money
     *
     * @param userMoney the value for trade_user_money_log.user_money
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_user_money_log.create_time
     *
     * @return the value of trade_user_money_log.create_time
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_user_money_log.create_time
     *
     * @param createTime the value for trade_user_money_log.create_time
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_user_money_log
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", moneyLogType=").append(moneyLogType);
        sb.append(", userMoney=").append(userMoney);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_user_money_log
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
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
        TradeUserMoneyLog other = (TradeUserMoneyLog) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getMoneyLogType() == null ? other.getMoneyLogType() == null : this.getMoneyLogType().equals(other.getMoneyLogType()))
            && (this.getUserMoney() == null ? other.getUserMoney() == null : this.getUserMoney().equals(other.getUserMoney()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_user_money_log
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getMoneyLogType() == null) ? 0 : getMoneyLogType().hashCode());
        result = prime * result + ((getUserMoney() == null) ? 0 : getUserMoney().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}