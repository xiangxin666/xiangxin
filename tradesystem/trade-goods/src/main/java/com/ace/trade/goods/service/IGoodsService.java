package com.ace.trade.goods.service;

import com.ace.trade.common.protocol.Result;
import com.ace.trade.common.protocol.goods.*;

public interface IGoodsService {
    public Result<QueryGoodsRes> queryGoods(QueryGoodsReq queryGoodsReq);

    public Result<ReduceGoodsNumberRes> reduceGoodsNumber(ReduceGoodsNumberReq reduceGoodsNumberReq);

    public Result<AddGoodsNumberRes> addGoodsNumber(AddGoodsNumberReq reduceGoodsNumberReq);
}
