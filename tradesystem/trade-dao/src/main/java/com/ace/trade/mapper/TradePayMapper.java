package com.ace.trade.mapper;

import com.ace.trade.entity.TradePay;
import com.ace.trade.entity.TradePayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradePayMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_pay
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    long countByExample(TradePayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_pay
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    int deleteByExample(TradePayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_pay
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    int deleteByPrimaryKey(String payId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_pay
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    int insert(TradePay record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_pay
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    int insertSelective(TradePay record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_pay
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    List<TradePay> selectByExample(TradePayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_pay
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    TradePay selectByPrimaryKey(String payId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_pay
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    int updateByExampleSelective(@Param("record") TradePay record, @Param("example") TradePayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_pay
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    int updateByExample(@Param("record") TradePay record, @Param("example") TradePayExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_pay
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    int updateByPrimaryKeySelective(TradePay record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_pay
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    int updateByPrimaryKey(TradePay record);
}