package com.ace.trade.entity;

import java.io.Serializable;

public class TradeGoodsNumberLogKey implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_goods_number_log.goods_id
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private Integer goodsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_goods_number_log.order_id
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private String orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table trade_goods_number_log
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_goods_number_log.goods_id
     *
     * @return the value of trade_goods_number_log.goods_id
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_goods_number_log.goods_id
     *
     * @param goodsId the value for trade_goods_number_log.goods_id
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_goods_number_log.order_id
     *
     * @return the value of trade_goods_number_log.order_id
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_goods_number_log.order_id
     *
     * @param orderId the value for trade_goods_number_log.order_id
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
        sb.append(", goodsId=").append(goodsId);
        sb.append(", orderId=").append(orderId);
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
        TradeGoodsNumberLogKey other = (TradeGoodsNumberLogKey) that;
        return (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()));
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
        return result;
    }
}