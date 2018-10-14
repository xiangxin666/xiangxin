package com.ace.trade.goods.service.impl;

import com.ace.trade.common.constants.TradeEnums;
import com.ace.trade.common.protocol.Result;
import com.ace.trade.common.protocol.coupon.QueryCouponReq;
import com.ace.trade.common.protocol.goods.*;
import com.ace.trade.entity.TradeGoods;
import com.ace.trade.entity.TradeGoodsNumberLog;
import com.ace.trade.entity.TradeGoodsNumberLogKey;
import com.ace.trade.goods.service.IGoodsService;
import com.ace.trade.mapper.TradeGoodsMapper;
import com.ace.trade.mapper.TradeGoodsNumberLogMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    TradeGoodsMapper tradeGoodsMapper;
    @Autowired
    TradeGoodsNumberLogMapper tradeGoodsNumberLogMapper;

    public Result<QueryGoodsRes> queryGoods(QueryGoodsReq queryGoodsReq) {
        Result<QueryGoodsRes> result =new  Result<QueryGoodsRes>();
        result.setRetCode(TradeEnums.RetEnum.SUCCESS.getCode());
        result.setRetInfo(TradeEnums.RetEnum.SUCCESS.getDesc());
        try{
            if(queryGoodsReq == null || queryGoodsReq.getGoodsId() == null ){
                    throw  new Exception("查询商品信息ID不正确");
            }

            TradeGoods tradeGoods = this.tradeGoodsMapper.selectByPrimaryKey(queryGoodsReq.getGoodsId());
            if(tradeGoods != null){
                BeanUtils.copyProperties(tradeGoods,result.getData());
            }else{
                throw  new Exception("未查询到该商品");
            }
        }catch (Exception e){
            result.setRetCode(TradeEnums.RetEnum.FAIL.getCode());
            result.setRetInfo(e.getMessage());
        }
        return result;
    }

    @Transactional
    public Result<ReduceGoodsNumberRes> reduceGoodsNumber(ReduceGoodsNumberReq reduceGoodsNumberReq) {
        Result<ReduceGoodsNumberRes>  result=new  Result<ReduceGoodsNumberRes>();
        result.setRetCode(TradeEnums.RetEnum.SUCCESS.getCode());
        result.setRetInfo(TradeEnums.RetEnum.SUCCESS.getDesc());
        if(reduceGoodsNumberReq == null || reduceGoodsNumberReq.getGoodsId() == null
                || reduceGoodsNumberReq.getGoodsNumber()==null || reduceGoodsNumberReq.getGoodsNumber() <=0 ){
            throw  new RuntimeException("扣减库存请求参数不正确");
        }
        TradeGoods tradeGoods =new TradeGoods();
        tradeGoods.setGoodsId(reduceGoodsNumberReq.getGoodsId());
        tradeGoods.setGoodsNumber(reduceGoodsNumberReq.getGoodsNumber());
        int i = this.tradeGoodsMapper.reduceGoodsNumber(tradeGoods);
        if(i<=0){
            throw  new RuntimeException("扣减库存失败");
        }
        TradeGoodsNumberLog tradeGoodsNumberLog =new TradeGoodsNumberLog();
        tradeGoodsNumberLog.setGoodsId(reduceGoodsNumberReq.getGoodsId());
        tradeGoodsNumberLog.setGoodsNumber(reduceGoodsNumberReq.getGoodsNumber());
        tradeGoodsNumberLog.setOrderId(reduceGoodsNumberReq.getOrderId());
        tradeGoodsNumberLog.setLogTime(new Date());
        this.tradeGoodsNumberLogMapper.insert(tradeGoodsNumberLog);
        return result;
    }

    public Result<AddGoodsNumberRes> addGoodsNumber(AddGoodsNumberReq addGoodsNumberReq) {
        Result<AddGoodsNumberRes> result = new  Result<AddGoodsNumberRes>();
        result.setRetCode(TradeEnums.RetEnum.SUCCESS.getCode());
        result.setRetInfo(TradeEnums.RetEnum.SUCCESS.getDesc());
        try{
            if(addGoodsNumberReq == null || addGoodsNumberReq.getGoodsId() == null
                    || addGoodsNumberReq.getGoodsNumber()==null || addGoodsNumberReq.getGoodsNumber() <=0 ){
                throw  new RuntimeException("增加库存请求参数不正确");
            }
            if(addGoodsNumberReq.getGoodsId() !=null){
                TradeGoodsNumberLogKey tradeGoodsNumberLogKey =new TradeGoodsNumberLogKey();
                tradeGoodsNumberLogKey.setOrderId(addGoodsNumberReq.getOrderId());
                tradeGoodsNumberLogKey.setGoodsId(addGoodsNumberReq.getGoodsId());
                TradeGoodsNumberLog tradeGoodsNumberLog = this.tradeGoodsNumberLogMapper.selectByPrimaryKey(tradeGoodsNumberLogKey);

                if(tradeGoodsNumberLog !=null){
                    throw  new Exception("未找到扣库存记录");
                }
            }
            TradeGoods tradeGoods =new TradeGoods();
            tradeGoods.setGoodsId(addGoodsNumberReq.getGoodsId());
            tradeGoods.setGoodsNumber(addGoodsNumberReq.getGoodsNumber());
            int  i= this.tradeGoodsMapper.addGoodsNumber(tradeGoods);
            if(i<=0){
                throw  new Exception("增加库存失败");
            }
        }catch (Exception e){
            result.setRetCode(TradeEnums.RetEnum.FAIL.getCode());
            result.setRetInfo(e.getMessage());
        }


        return result;
    }
}
