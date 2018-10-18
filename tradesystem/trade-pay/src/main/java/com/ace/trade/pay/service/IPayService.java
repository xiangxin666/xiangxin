package com.ace.trade.pay.service;

import com.ace.trade.common.protocol.Result;
import com.ace.trade.common.protocol.pay.CallbackPaymentReq;
import com.ace.trade.common.protocol.pay.CallbackPaymentRes;
import com.ace.trade.common.protocol.pay.CreatePaymentReq;
import com.ace.trade.common.protocol.pay.CreatePaymentRes;

public interface IPayService {
    public Result<CreatePaymentRes> createPayment(CreatePaymentReq createPaymentReq);
    public Result<CallbackPaymentRes>  callbackPayment(CallbackPaymentReq callbackPaymentReq);
}
