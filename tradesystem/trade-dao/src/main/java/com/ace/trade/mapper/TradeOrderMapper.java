package com.ace.trade.mapper;

import com.ace.trade.entity.TradeOrder;
import com.ace.trade.entity.TradeOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_order
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    long countByExample(TradeOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_order
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    int deleteByExample(TradeOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_order
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    int deleteByPrimaryKey(String orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_order
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    int insert(TradeOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_order
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    int insertSelective(TradeOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_order
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    List<TradeOrder> selectByExample(TradeOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_order
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    TradeOrder selectByPrimaryKey(String orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_order
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    int updateByExampleSelective(@Param("record") TradeOrder record, @Param("example") TradeOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_order
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    int updateByExample(@Param("record") TradeOrder record, @Param("example") TradeOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_order
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    int updateByPrimaryKeySelective(TradeOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_order
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    int updateByPrimaryKey(TradeOrder record);
}