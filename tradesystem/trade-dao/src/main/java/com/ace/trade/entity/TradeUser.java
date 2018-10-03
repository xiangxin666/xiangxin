package com.ace.trade.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TradeUser implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_user.user_id
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_user.user_name
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_user.user_password
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private String userPassword;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_user.user_mobile
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private String userMobile;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_user.user_score
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private Integer userScore;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_user.user_reg_time
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private Date userRegTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trade_user.user_money
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private BigDecimal userMoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table trade_user
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_user.user_id
     *
     * @return the value of trade_user.user_id
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_user.user_id
     *
     * @param userId the value for trade_user.user_id
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_user.user_name
     *
     * @return the value of trade_user.user_name
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_user.user_name
     *
     * @param userName the value for trade_user.user_name
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_user.user_password
     *
     * @return the value of trade_user.user_password
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_user.user_password
     *
     * @param userPassword the value for trade_user.user_password
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_user.user_mobile
     *
     * @return the value of trade_user.user_mobile
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public String getUserMobile() {
        return userMobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_user.user_mobile
     *
     * @param userMobile the value for trade_user.user_mobile
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_user.user_score
     *
     * @return the value of trade_user.user_score
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public Integer getUserScore() {
        return userScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_user.user_score
     *
     * @param userScore the value for trade_user.user_score
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setUserScore(Integer userScore) {
        this.userScore = userScore;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_user.user_reg_time
     *
     * @return the value of trade_user.user_reg_time
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public Date getUserRegTime() {
        return userRegTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_user.user_reg_time
     *
     * @param userRegTime the value for trade_user.user_reg_time
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setUserRegTime(Date userRegTime) {
        this.userRegTime = userRegTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trade_user.user_money
     *
     * @return the value of trade_user.user_money
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public BigDecimal getUserMoney() {
        return userMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trade_user.user_money
     *
     * @param userMoney the value for trade_user.user_money
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    public void setUserMoney(BigDecimal userMoney) {
        this.userMoney = userMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_user
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", userPassword=").append(userPassword);
        sb.append(", userMobile=").append(userMobile);
        sb.append(", userScore=").append(userScore);
        sb.append(", userRegTime=").append(userRegTime);
        sb.append(", userMoney=").append(userMoney);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_user
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
        TradeUser other = (TradeUser) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getUserPassword() == null ? other.getUserPassword() == null : this.getUserPassword().equals(other.getUserPassword()))
            && (this.getUserMobile() == null ? other.getUserMobile() == null : this.getUserMobile().equals(other.getUserMobile()))
            && (this.getUserScore() == null ? other.getUserScore() == null : this.getUserScore().equals(other.getUserScore()))
            && (this.getUserRegTime() == null ? other.getUserRegTime() == null : this.getUserRegTime().equals(other.getUserRegTime()))
            && (this.getUserMoney() == null ? other.getUserMoney() == null : this.getUserMoney().equals(other.getUserMoney()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_user
     *
     * @mbg.generated Sat Sep 01 21:47:27 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getUserPassword() == null) ? 0 : getUserPassword().hashCode());
        result = prime * result + ((getUserMobile() == null) ? 0 : getUserMobile().hashCode());
        result = prime * result + ((getUserScore() == null) ? 0 : getUserScore().hashCode());
        result = prime * result + ((getUserRegTime() == null) ? 0 : getUserRegTime().hashCode());
        result = prime * result + ((getUserMoney() == null) ? 0 : getUserMoney().hashCode());
        return result;
    }
}