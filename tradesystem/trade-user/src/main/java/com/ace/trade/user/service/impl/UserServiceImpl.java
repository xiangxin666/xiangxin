package com.ace.trade.user.service.impl;

import com.ace.trade.common.constants.TradeEnums;
import com.ace.trade.common.protocol.Result;
import com.ace.trade.common.protocol.user.ChangeUserMoneyReq;
import com.ace.trade.common.protocol.user.ChangeUserMoneyRes;
import com.ace.trade.common.protocol.user.QueryUserReq;
import com.ace.trade.common.protocol.user.QueryUserRes;
import com.ace.trade.entity.TradeUser;
import com.ace.trade.entity.TradeUserMoneyLog;
import com.ace.trade.entity.TradeUserMoneyLogExample;
import com.ace.trade.mapper.TradeUserMapper;
import com.ace.trade.mapper.TradeUserMoneyLogMapper;
import com.ace.trade.user.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private TradeUserMapper tradeUserMapper;
    @Autowired
    private TradeUserMoneyLogMapper tradeUserMoneyLogMapper;
    public Result<QueryUserRes> queryUserById(QueryUserReq queryUserReq) {
        Result<QueryUserRes> result= null;
        try {
            result = new Result<QueryUserRes>(QueryUserRes.class);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("返回结果初始化错误！");
        } catch (InstantiationException e) {
            throw new RuntimeException("返回结果初始化错误！");
        }
        result.setRetCode(TradeEnums.RetEnum.SUCCESS.getCode());
        result.setRetInfo(TradeEnums.RetEnum.SUCCESS.getDesc());
        try{
            if(queryUserReq ==null || queryUserReq.getUserId() == null ){
                throw new RuntimeException("请求参数不正确！");
            }

           TradeUser tradeUser= tradeUserMapper.selectByPrimaryKey(queryUserReq.getUserId());
            if(tradeUser!=null){
                BeanUtils.copyProperties(tradeUser,result.getData());
            }else{
                throw new RuntimeException("未查到该用户！");
            }
        }catch(Exception ex){
            result.setRetCode(TradeEnums.RetEnum.FAIL.getCode());
            result.setRetInfo(TradeEnums.RetEnum.FAIL.getDesc());
        }
        return result;
    }

    @Transactional
    public Result<ChangeUserMoneyRes> changeUserMoney(ChangeUserMoneyReq changeUserMoneyReq) {
        Result<ChangeUserMoneyRes> resResult =new  Result<ChangeUserMoneyRes>();
        resResult.setRetCode(TradeEnums.RetEnum.SUCCESS.getCode());
        resResult.setRetInfo(TradeEnums.RetEnum.SUCCESS.getDesc());

        if (changeUserMoneyReq == null || changeUserMoneyReq.getUserId()== null || changeUserMoneyReq.getUserMoney() ==null){
            throw new RuntimeException("请求参数不正确，无法进行余额支付");
        }
        if (changeUserMoneyReq.getUserMoney().compareTo(BigDecimal.ZERO)<=0){
            throw new RuntimeException("金额不能小于0");
        }

        TradeUserMoneyLog tradeUserMoneyLog = new TradeUserMoneyLog();
        tradeUserMoneyLog.setCreateTime(new Date());
        tradeUserMoneyLog.setUserMoney(changeUserMoneyReq.getUserMoney());
        tradeUserMoneyLog.setUserId(changeUserMoneyReq.getUserId());
        tradeUserMoneyLog.setOrderId(changeUserMoneyReq.getOrderId());

        TradeUser tradeUser =new TradeUser();
        tradeUser.setUserId(changeUserMoneyReq.getUserId());
        tradeUser.setUserMoney(changeUserMoneyReq.getUserMoney());


        TradeUserMoneyLogExample logExample =new TradeUserMoneyLogExample();
        logExample.createCriteria()
                .andUserIdEqualTo(changeUserMoneyReq.getUserId())
                .andOrderIdEqualTo(changeUserMoneyReq.getOrderId())
                .andMoneyLogTypeEqualTo(TradeEnums.UserMoneyLogTypeEnum.PAID.getCode());

        long  count = this.tradeUserMoneyLogMapper.countByExample(logExample);
        //订单付款
        if(changeUserMoneyReq.getMoneyLogType().equals(TradeEnums.UserMoneyLogTypeEnum.PAID.getCode())){
            if(count>0){
                throw new RuntimeException("请勿重复付款！");
            }
            tradeUserMapper.reduceUserMoney(tradeUser);
        }
        //订单退款
        if(changeUserMoneyReq.getMoneyLogType().equals(TradeEnums.UserMoneyLogTypeEnum.RETURNED.getCode())){
           //是否有付款记录（实现消息幂等1.业务逻辑实现（本次使用）2.去重表）
            if(count==0){
                throw new RuntimeException("未付款成功，不能退款");
            }
            // 防止多次退款（实现消息幂等1.业务逻辑实现（本次使用）2.去重表）
            logExample.createCriteria()
                    .andUserIdEqualTo(changeUserMoneyReq.getUserId())
                    .andOrderIdEqualTo(changeUserMoneyReq.getOrderId())
                    .andMoneyLogTypeEqualTo(TradeEnums.UserMoneyLogTypeEnum.RETURNED.getCode());
              count = this.tradeUserMoneyLogMapper.countByExample(logExample);
            if(count>0){
                throw new RuntimeException("已经退过款，不能退款");
            }
        }
        tradeUserMapper.addUserMoney(tradeUser);
        //日志
        tradeUserMoneyLogMapper.insert(tradeUserMoneyLog);
        return null;
    }
}

