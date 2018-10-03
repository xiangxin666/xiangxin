package com.ace.trade.user.service.impl;

import com.ace.trade.common.constants.TradeEnums;
import com.ace.trade.common.protocol.Result;
import com.ace.trade.common.protocol.user.QueryUserReq;
import com.ace.trade.common.protocol.user.QueryUserRes;
import com.ace.trade.entity.TradeUser;
import com.ace.trade.mapper.TradeUserMapper;
import com.ace.trade.user.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private TradeUserMapper tradeUserMapper;

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
}

