package com.ace.trade.mapper;

import com.ace.trade.entity.TradeUserMoneyLog;
import com.ace.trade.entity.TradeUserMoneyLogExample;
import com.ace.trade.entity.TradeUserMoneyLogKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeUserMoneyLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_user_money_log
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    long countByExample(TradeUserMoneyLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_user_money_log
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    int deleteByExample(TradeUserMoneyLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_user_money_log
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    int deleteByPrimaryKey(TradeUserMoneyLogKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_user_money_log
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    int insert(TradeUserMoneyLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_user_money_log
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    int insertSelective(TradeUserMoneyLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_user_money_log
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    List<TradeUserMoneyLog> selectByExample(TradeUserMoneyLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_user_money_log
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    TradeUserMoneyLog selectByPrimaryKey(TradeUserMoneyLogKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_user_money_log
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    int updateByExampleSelective(@Param("record") TradeUserMoneyLog record, @Param("example") TradeUserMoneyLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_user_money_log
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    int updateByExample(@Param("record") TradeUserMoneyLog record, @Param("example") TradeUserMoneyLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_user_money_log
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    int updateByPrimaryKeySelective(TradeUserMoneyLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trade_user_money_log
     *
     * @mbg.generated Sat Sep 01 23:12:45 CST 2018
     */
    int updateByPrimaryKey(TradeUserMoneyLog record);
}