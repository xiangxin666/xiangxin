package com.ace.trade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TradeOrder implements Serializable {

    private String orderId;

    private Integer userid;

    private String orderStatus;

    private String payStatus;

    private String shippingStatus;

    private String address;

    private String consignee;

    private Integer goodsId;

    private Integer goodsNumber;

    private BigDecimal goodsPrice;

    private BigDecimal goodsAmount;

    private BigDecimal shippingFee;

    private BigDecimal orderAmount;

    private String couponId;

    private BigDecimal couponPaid;

    private BigDecimal moneyPaid;

    private BigDecimal payAmount;

    private Date addTime;

    private Date confirmTime;

    private Date payTime;

    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.order_id
     *
     * @return the value of trade_order.order_id
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.order_id
     *
     * @param orderId the value for trade_order.order_id
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.userid
     *
     * @return the value of trade_order.userid
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.userid
     *
     * @param userid the value for trade_order.userid
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.order_status
     *
     * @return the value of trade_order.order_status
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.order_status
     *
     * @param orderStatus the value for trade_order.order_status
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.pay_status
     *
     * @return the value of trade_order.pay_status
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public String getPayStatus() {
        return payStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.pay_status
     *
     * @param payStatus the value for trade_order.pay_status
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.shipping_status
     *
     * @return the value of trade_order.shipping_status
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public String getShippingStatus() {
        return shippingStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.shipping_status
     *
     * @param shippingStatus the value for trade_order.shipping_status
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.address
     *
     * @return the value of trade_order.address
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.address
     *
     * @param address the value for trade_order.address
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.consignee
     *
     * @return the value of trade_order.consignee
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public String getConsignee() {
        return consignee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.consignee
     *
     * @param consignee the value for trade_order.consignee
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.goods_id
     *
     * @return the value of trade_order.goods_id
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.goods_id
     *
     * @param goodsId the value for trade_order.goods_id
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.goods_number
     *
     * @return the value of trade_order.goods_number
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.goods_number
     *
     * @param goodsNumber the value for trade_order.goods_number
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.goods_price
     *
     * @return the value of trade_order.goods_price
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.goods_price
     *
     * @param goodsPrice the value for trade_order.goods_price
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.goods_amount
     *
     * @return the value of trade_order.goods_amount
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.goods_amount
     *
     * @param goodsAmount the value for trade_order.goods_amount
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.shipping_fee
     *
     * @return the value of trade_order.shipping_fee
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.shipping_fee
     *
     * @param shippingFee the value for trade_order.shipping_fee
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.order_amount
     *
     * @return the value of trade_order.order_amount
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.order_amount
     *
     * @param orderAmount the value for trade_order.order_amount
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.coupon_id
     *
     * @return the value of trade_order.coupon_id
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public String getCouponId() {
        return couponId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.coupon_id
     *
     * @param couponId the value for trade_order.coupon_id
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.coupon_paid
     *
     * @return the value of trade_order.coupon_paid
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public BigDecimal getCouponPaid() {
        return couponPaid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.coupon_paid
     *
     * @param couponPaid the value for trade_order.coupon_paid
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setCouponPaid(BigDecimal couponPaid) {
        this.couponPaid = couponPaid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.money_paid
     *
     * @return the value of trade_order.money_paid
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public BigDecimal getMoneyPaid() {
        return moneyPaid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.money_paid
     *
     * @param moneyPaid the value for trade_order.money_paid
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setMoneyPaid(BigDecimal moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.pay_amount
     *
     * @return the value of trade_order.pay_amount
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.pay_amount
     *
     * @param payAmount the value for trade_order.pay_amount
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.add_time
     *
     * @return the value of trade_order.add_time
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.add_time
     *
     * @param addTime the value for trade_order.add_time
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.confirm_time
     *
     * @return the value of trade_order.confirm_time
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public Date getConfirmTime() {
        return confirmTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.confirm_time
     *
     * @param confirmTime the value for trade_order.confirm_time
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_order.pay_time
     *
     * @return the value of trade_order.pay_time
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_order.pay_time
     *
     * @param payTime the value for trade_order.pay_time
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_order
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", userid=").append(userid);
        sb.append(", orderStatus=").append(orderStatus);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", shippingStatus=").append(shippingStatus);
        sb.append(", address=").append(address);
        sb.append(", consignee=").append(consignee);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsNumber=").append(goodsNumber);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", goodsAmount=").append(goodsAmount);
        sb.append(", shippingFee=").append(shippingFee);
        sb.append(", orderAmount=").append(orderAmount);
        sb.append(", couponId=").append(couponId);
        sb.append(", couponPaid=").append(couponPaid);
        sb.append(", moneyPaid=").append(moneyPaid);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", addTime=").append(addTime);
        sb.append(", confirmTime=").append(confirmTime);
        sb.append(", payTime=").append(payTime);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_order
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
        TradeOrder other = (TradeOrder) that;
        return (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getOrderStatus() == null ? other.getOrderStatus() == null : this.getOrderStatus().equals(other.getOrderStatus()))
            && (this.getPayStatus() == null ? other.getPayStatus() == null : this.getPayStatus().equals(other.getPayStatus()))
            && (this.getShippingStatus() == null ? other.getShippingStatus() == null : this.getShippingStatus().equals(other.getShippingStatus()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getConsignee() == null ? other.getConsignee() == null : this.getConsignee().equals(other.getConsignee()))
            && (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getGoodsNumber() == null ? other.getGoodsNumber() == null : this.getGoodsNumber().equals(other.getGoodsNumber()))
            && (this.getGoodsPrice() == null ? other.getGoodsPrice() == null : this.getGoodsPrice().equals(other.getGoodsPrice()))
            && (this.getGoodsAmount() == null ? other.getGoodsAmount() == null : this.getGoodsAmount().equals(other.getGoodsAmount()))
            && (this.getShippingFee() == null ? other.getShippingFee() == null : this.getShippingFee().equals(other.getShippingFee()))
            && (this.getOrderAmount() == null ? other.getOrderAmount() == null : this.getOrderAmount().equals(other.getOrderAmount()))
            && (this.getCouponId() == null ? other.getCouponId() == null : this.getCouponId().equals(other.getCouponId()))
            && (this.getCouponPaid() == null ? other.getCouponPaid() == null : this.getCouponPaid().equals(other.getCouponPaid()))
            && (this.getMoneyPaid() == null ? other.getMoneyPaid() == null : this.getMoneyPaid().equals(other.getMoneyPaid()))
            && (this.getPayAmount() == null ? other.getPayAmount() == null : this.getPayAmount().equals(other.getPayAmount()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getConfirmTime() == null ? other.getConfirmTime() == null : this.getConfirmTime().equals(other.getConfirmTime()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_order
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getOrderStatus() == null) ? 0 : getOrderStatus().hashCode());
        result = prime * result + ((getPayStatus() == null) ? 0 : getPayStatus().hashCode());
        result = prime * result + ((getShippingStatus() == null) ? 0 : getShippingStatus().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getConsignee() == null) ? 0 : getConsignee().hashCode());
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getGoodsNumber() == null) ? 0 : getGoodsNumber().hashCode());
        result = prime * result + ((getGoodsPrice() == null) ? 0 : getGoodsPrice().hashCode());
        result = prime * result + ((getGoodsAmount() == null) ? 0 : getGoodsAmount().hashCode());
        result = prime * result + ((getShippingFee() == null) ? 0 : getShippingFee().hashCode());
        result = prime * result + ((getOrderAmount() == null) ? 0 : getOrderAmount().hashCode());
        result = prime * result + ((getCouponId() == null) ? 0 : getCouponId().hashCode());
        result = prime * result + ((getCouponPaid() == null) ? 0 : getCouponPaid().hashCode());
        result = prime * result + ((getMoneyPaid() == null) ? 0 : getMoneyPaid().hashCode());
        result = prime * result + ((getPayAmount() == null) ? 0 : getPayAmount().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getConfirmTime() == null) ? 0 : getConfirmTime().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        return result;
    }
}