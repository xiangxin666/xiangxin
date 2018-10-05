package com.ace.trade.common.client;

import com.ace.trade.common.constants.TradeEnums;
import com.ace.trade.common.protocol.Result;
import com.ace.trade.common.protocol.user.QueryUserReq;
import com.ace.trade.common.protocol.user.QueryUserRes;
import org.springframework.web.client.RestTemplate;

public class RestClient {
    private static RestTemplate restTemplate=new RestTemplate();


    public static void main(String[] args) {
        QueryUserReq queryUserReq =new QueryUserReq();
        queryUserReq.setUserId(1);
        Result<QueryUserRes> result= restTemplate.postForObject(TradeEnums.RestServerEnum.USER.getServerUrl()+"queryUserById",queryUserReq, Result.class);
        System.out.println("result1:"+ result);
    }
}
 