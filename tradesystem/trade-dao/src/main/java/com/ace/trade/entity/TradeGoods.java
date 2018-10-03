package com.ace.trade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TradeGoods implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_goods.goods_id
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private Integer goodsId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_goods.goods_name
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private String goodsName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_goods.goods_number
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private Integer goodsNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_goods.goods_price
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private BigDecimal goodsPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_goods.goods_desc
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private String goodsDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_goods.add_time
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private Date addTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table trade_goods
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_goods.goods_id
     *
     * @return the value of trade_goods.goods_id
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_goods.goods_id
     *
     * @param goodsId the value for trade_goods.goods_id
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_goods.goods_name
     *
     * @return the value of trade_goods.goods_name
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_goods.goods_name
     *
     * @param goodsName the value for trade_goods.goods_name
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_goods.goods_number
     *
     * @return the value of trade_goods.goods_number
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_goods.goods_number
     *
     * @param goodsNumber the value for trade_goods.goods_number
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_goods.goods_price
     *
     * @return the value of trade_goods.goods_price
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_goods.goods_price
     *
     * @param goodsPrice the value for trade_goods.goods_price
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_goods.goods_desc
     *
     * @return the value of trade_goods.goods_desc
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public String getGoodsDesc() {
        return goodsDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_goods.goods_desc
     *
     * @param goodsDesc the value for trade_goods.goods_desc
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_goods.add_time
     *
     * @return the value of trade_goods.add_time
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_goods.add_time
     *
     * @param addTime the value for trade_goods.add_time
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_goods
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
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsNumber=").append(goodsNumber);
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", goodsDesc=").append(goodsDesc);
        sb.append(", addTime=").append(addTime);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_goods
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
        TradeGoods other = (TradeGoods) that;
        return (this.getGoodsId() == null ? other.getGoodsId() == null : this.getGoodsId().equals(other.getGoodsId()))
            && (this.getGoodsName() == null ? other.getGoodsName() == null : this.getGoodsName().equals(other.getGoodsName()))
            && (this.getGoodsNumber() == null ? other.getGoodsNumber() == null : this.getGoodsNumber().equals(other.getGoodsNumber()))
            && (this.getGoodsPrice() == null ? other.getGoodsPrice() == null : this.getGoodsPrice().equals(other.getGoodsPrice()))
            && (this.getGoodsDesc() == null ? other.getGoodsDesc() == null : this.getGoodsDesc().equals(other.getGoodsDesc()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_goods
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGoodsId() == null) ? 0 : getGoodsId().hashCode());
        result = prime * result + ((getGoodsName() == null) ? 0 : getGoodsName().hashCode());
        result = prime * result + ((getGoodsNumber() == null) ? 0 : getGoodsNumber().hashCode());
        result = prime * result + ((getGoodsPrice() == null) ? 0 : getGoodsPrice().hashCode());
        result = prime * result + ((getGoodsDesc() == null) ? 0 : getGoodsDesc().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        return result;
    }
}