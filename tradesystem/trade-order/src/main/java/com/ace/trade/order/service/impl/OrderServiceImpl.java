package com.ace.trade.order.service.impl;

import com.ace.trade.common.protocol.Result;
import com.ace.trade.common.protocol.order.ConfirmOrderReq;
import com.ace.trade.common.protocol.order.ConfirmOrderRes;
import com.ace.trade.order.service.IOrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {
    public Result<ConfirmOrderRes> confirmOrder(ConfirmOrderReq confirmOrderReq) {
        Result<ConfirmOrderRes> result =null;
        try {
            result  = new  Result<ConfirmOrderRes>(ConfirmOrderRes.class);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("返回结果初始化错误！");
        } catch (InstantiationException e) {
            throw new RuntimeException("返回结果初始化错误！");
        }
        //1.检查校验
        //2.创建不可见订单
        //3.调用远程服务，扣优惠券，扣库存，扣余额 如果调用陈宫

        return result;
    }
}
