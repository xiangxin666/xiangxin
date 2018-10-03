package com.ace.trade.user.api;

import com.ace.trade.common.api.IUserApi;
import com.ace.trade.common.protocol.Result;
import com.ace.trade.common.protocol.user.ChangeUserMoneyReq;
import com.ace.trade.common.protocol.user.ChangeUserMoneyRes;
import com.ace.trade.common.protocol.user.QueryUserReq;
import com.ace.trade.common.protocol.user.QueryUserRes;
import com.ace.trade.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserApiImpl implements IUserApi {

    @Autowired
    IUserService userService;
    @RequestMapping( value ="/queryUserById" ,method = RequestMethod.POST)
    @ResponseBody
    public Result<QueryUserRes> queryUserById(@RequestBody  QueryUserReq queryUserReq) {
        return userService.queryUserById(queryUserReq);
    }

    @RequestMapping( value ="/changeUserMoney" ,method = RequestMethod.POST)
    @ResponseBody
    public Result<ChangeUserMoneyRes> changeUserMoney(ChangeUserMoneyReq changeUserMoneyReq) {
        return null;
    }
}
