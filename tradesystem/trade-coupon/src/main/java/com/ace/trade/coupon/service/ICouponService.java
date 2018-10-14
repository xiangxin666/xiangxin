package com.ace.trade.coupon.service;

import com.ace.trade.common.protocol.Result;
import com.ace.trade.common.protocol.coupon.ChangeCouponStatusReq;
import com.ace.trade.common.protocol.coupon.ChangeCouponStatusRes;
import com.ace.trade.common.protocol.coupon.QueryCouponReq;
import com.ace.trade.common.protocol.coupon.QueryCouponRes;

public interface ICouponService {
    public Result<QueryCouponRes> queryCoupon(QueryCouponReq queryCouponReq);
    public Result<ChangeCouponStatusRes> changeCouponStatus (ChangeCouponStatusReq changeCouponStatusReq);
}
