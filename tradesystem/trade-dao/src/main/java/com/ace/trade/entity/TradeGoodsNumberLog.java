package com.ace.trade.entity;

import java.io.Serializable;
import java.util.Date;

public class TradeGoodsNumberLog extends TradeGoodsNumberLogKey implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_goods_number_log.goods_number
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private Integer goodsNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_goods_number_log.log_time
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private Date logTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table trade_goods_number_log
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_goods_number_log.goods_number
     *
     * @return the value of trade_goods_number_log.goods_number
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_goods_number_log.goods_number
     *
     * @param goodsNumber the value for trade_goods_number_log.goods_number
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_goods_number_log.log_time
     *
     * @return the value of trade_goods_number_log.log_time
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public Date getLogTime() {
        return logTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_goods_number_log.log_time
     *
     * @param logTime the value for trade_goods_number_log.log_time
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_goods_number_log
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsNumber=").append(goodsNumber);
        sb.append(", logTime=").append(logTime);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_goods_number_log
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
        TradeGoodsNumberLog other = (TradeGoodsNumberLog) that;
        return (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getGoodsNumber() == null ? other.getGoodsNumber() == null : this.getGoodsNumber().equals(other.getGoodsNumber()))
            && (this.getLogTime() == null ? other.getLogTime() == null : this.getLogTime().equals(other.getLogTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_goods_number_log
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getGoodsNumber() == null) ? 0 : getGoodsNumber().hashCode());
        result = prime * result + ((getLogTime() == null) ? 0 : getLogTime().hashCode());
        return result;
    }
}