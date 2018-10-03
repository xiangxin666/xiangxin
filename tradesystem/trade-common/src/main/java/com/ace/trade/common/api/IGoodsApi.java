package com.ace.trade.common.api;

import com.ace.trade.common.protocol.Result;
import com.ace.trade.common.protocol.goods.QueryGoodsReq;
import com.ace.trade.common.protocol.goods.QueryGoodsRes;
import com.ace.trade.common.protocol.goods.ReduceGoodsNumberReq;
import com.ace.trade.common.protocol.goods.ReduceGoodsNumberRes;

public interface IGoodsApi {

    public Result<QueryGoodsRes> queryGoods(QueryGoodsReq queryGoodsReq);

    public Result<ReduceGoodsNumberRes> reduceGoodsNumber(ReduceGoodsNumberReq reduceGoodsNumberReq);

}

