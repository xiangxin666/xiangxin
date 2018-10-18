package com.ace.trade.pay.service.impl;

import com.ace.trade.common.constants.TradeEnums;
import com.ace.trade.common.protocol.Result;
import com.ace.trade.common.protocol.pay.CallbackPaymentReq;
import com.ace.trade.common.protocol.pay.CallbackPaymentRes;
import com.ace.trade.common.protocol.pay.CreatePaymentReq;
import com.ace.trade.common.protocol.pay.CreatePaymentRes;
import com.ace.trade.common.rocketmq.AceMQProducer;
import com.ace.trade.common.util.IDGenerator;
import com.ace.trade.entity.TradePay;
import com.ace.trade.entity.TradePayExample;
import com.ace.trade.mapper.TradePayMapper;
import com.ace.trade.pay.service.IPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PayServiceImpl implements IPayService {
    @Autowired
    private TradePayMapper tradePayMapper;
    //@Autowired
    //private Trade
    @Autowired
    private AceMQProducer aceMQProducer;
    private ExecutorService executorService = Executors.newFixedThreadPool(10);
    public Result<CreatePaymentRes> createPayment(CreatePaymentReq createPaymentReq) {
        Result<CreatePaymentRes> result = new  Result<CreatePaymentRes>();
        result.setRetCode(TradeEnums.RetEnum.SUCCESS.getCode());
        result.setRetCode(TradeEnums.RetEnum.SUCCESS.getDesc());
        try{
            TradePayExample tradePayExample =new TradePayExample();
            tradePayExample.createCriteria()
                    .andOrderIdEqualTo(createPaymentReq.getOrderId())
                    .andIsPaidEqualTo(TradeEnums.YesNoEnum.YES.getCode());
            long count = this.tradePayMapper.countByExample(tradePayExample);
            if(count>0){
                throw new Exception( "该订单已支付");
            }
            String payId = IDGenerator.generateUUID();
            TradePay tradePay =new TradePay();
            tradePay.setPayId(payId);
            tradePay.setOrderId(createPaymentReq.getOrderId());
            tradePay.setIsPaid(TradeEnums.YesNoEnum.NO.getCode());
            tradePay.setPayAmount(createPaymentReq.getPayAmount());
            tradePayMapper.insert(tradePay);
            System.out.println("支付订单成功："+payId);
        }catch(Exception ex){
            result.setRetCode(TradeEnums.RetEnum.FAIL.getCode());
            result.setRetCode(ex.getMessage());
        }

        return result;
    }

    @Override
    @Transactional
    public Result<CallbackPaymentRes> callbackPayment(CallbackPaymentReq callbackPaymentReq) {
        Result<CallbackPaymentRes> result = new  Result<CallbackPaymentRes>();
        result.setRetCode(TradeEnums.RetEnum.SUCCESS.getCode());
        result.setRetCode(TradeEnums.RetEnum.SUCCESS.getDesc());

        if(callbackPaymentReq.getIsPaid().equals(TradeEnums.YesNoEnum.YES.getCode())){
            //更新支付状态
            TradePay tradePay =tradePayMapper.selectByPrimaryKey(callbackPaymentReq.getPayId());
            if(tradePay == null){
                throw new RuntimeException( "未找到支付订单");
            }
            if(tradePay.getIsPaid().equals(TradeEnums.YesNoEnum.YES.getCode())){
                throw new RuntimeException( "该订单已支付");
            }
            tradePay.setIsPaid(TradeEnums.YesNoEnum.YES.getCode());
            int i = tradePayMapper.updateByPrimaryKeySelective(tradePay);
            //发送可靠消息
            if(i == 1){

            }

        }
        return null;
    }
}
