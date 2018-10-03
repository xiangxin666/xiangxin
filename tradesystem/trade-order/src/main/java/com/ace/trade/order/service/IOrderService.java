package com.ace.trade.order.service;

import com.ace.trade.common.protocol.Result;
import com.ace.trade.common.protocol.order.ConfirmOrderReq;
import com.ace.trade.common.protocol.order.ConfirmOrderRes;

public interface IOrderService {
    public Result<ConfirmOrderRes> confirmOrder(ConfirmOrderReq confirmOrderReq);
}
