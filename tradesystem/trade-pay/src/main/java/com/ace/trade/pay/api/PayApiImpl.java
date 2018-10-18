package com.ace.trade.pay.api;

import com.ace.trade.common.api.IPayApi;
import com.ace.trade.common.constants.TradeEnums;
import com.ace.trade.common.protocol.Result;
import com.ace.trade.common.protocol.pay.CallbackPaymentReq;
import com.ace.trade.common.protocol.pay.CallbackPaymentRes;
import com.ace.trade.common.protocol.pay.CreatePaymentReq;
import com.ace.trade.common.protocol.pay.CreatePaymentRes;
import com.ace.trade.pay.service.IPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class PayApiImpl implements IPayApi {
    @Autowired
    private IPayService payService;
    @RequestMapping( value ="/createPayment" ,method = RequestMethod.POST)
    @ResponseBody
    public Result<CreatePaymentRes> createPayment(CreatePaymentReq createPaymentReq) {
        return payService.createPayment(createPaymentReq);
    }
    @RequestMapping( value ="/createPayment" ,method = RequestMethod.POST)
    @ResponseBody
    public Result<CallbackPaymentRes> callbackPayment(CallbackPaymentReq callbackPaymentReq) {
        Result<CallbackPaymentRes> result =new Result<CallbackPaymentRes>();
        try{
            result= payService.callbackPayment(callbackPaymentReq);
        }catch (Exception e){
            result.setRetCode(TradeEnums.RetEnum.FAIL.getCode());
            result.setRetInfo(e.getMessage());
        }
        return null;
    }
}
