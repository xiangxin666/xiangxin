package com.ace.trade.user.service;

import com.ace.trade.common.protocol.Result;
import com.ace.trade.common.protocol.user.QueryUserReq;
import com.ace.trade.common.protocol.user.QueryUserRes;

public interface IUserService {
    public Result<QueryUserRes> queryUserById(QueryUserReq queryUserReq);
}
