package com.ace.trade.common.protocol.mq;

import java.math.BigDecimal;

public class CancelOrderMQ {
    private  String  orderId;
    private  Integer userId;
    private  Integer goodsId;
    private  Integer gooodsNumber;
    private  String couponId;
    private  BigDecimal userMoney;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGooodsNumber() {
        return gooodsNumber;
    }

    public void setGooodsNumber(Integer gooodsNumber) {
        this.gooodsNumber = gooodsNumber;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public BigDecimal getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }
}
