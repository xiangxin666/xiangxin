package com.ace.trade.coupon.service.impl;

import com.ace.trade.common.constants.TradeEnums;
import com.ace.trade.common.protocol.Result;
import com.ace.trade.common.protocol.coupon.ChangeCouponStatusReq;
import com.ace.trade.common.protocol.coupon.ChangeCouponStatusRes;
import com.ace.trade.common.protocol.coupon.QueryCouponReq;
import com.ace.trade.common.protocol.coupon.QueryCouponRes;
import com.ace.trade.coupon.service.ICouponService;
import com.ace.trade.entity.TradeCoupon;
import com.ace.trade.mapper.TradeCouponMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements ICouponService {
    @Autowired
    private TradeCouponMapper tradeCouponMapper;

    public Result<QueryCouponRes> queryCoupon(QueryCouponReq queryCouponReq) {
        Result<QueryCouponRes> queryCouponRes = new Result<QueryCouponRes>();
        queryCouponRes.setRetCode(TradeEnums.RetEnum.SUCCESS.getCode());
        queryCouponRes.setRetInfo(TradeEnums.RetEnum.SUCCESS.getDesc());

        try{
            if(queryCouponReq == null || StringUtils.isBlank(queryCouponReq.getCouponId())){
                throw new Exception("请求参数不正确，优惠券编号为空!");
            }
            TradeCoupon tradeCoupon = this.tradeCouponMapper.selectByPrimaryKey(queryCouponReq.getCouponId());
            if(tradeCoupon !=null){
                BeanUtils.copyProperties(tradeCoupon,queryCouponRes);
            }else{
                throw new Exception("未查询到该优惠券");
            }
        }catch (Exception e){
            queryCouponRes.setRetCode(TradeEnums.RetEnum.FAIL.getCode());
            queryCouponRes.setRetInfo(e.getMessage());
        }

        return queryCouponRes;


    }

    public Result<ChangeCouponStatusRes> changeCouponStatus(ChangeCouponStatusReq changeCouponStatusReq) {
        Result<ChangeCouponStatusRes> result = new  Result<ChangeCouponStatusRes>();
        result.setRetCode(TradeEnums.RetEnum.SUCCESS.getCode());
        result.setRetInfo(TradeEnums.RetEnum.SUCCESS.getDesc());
        try{
            if(changeCouponStatusReq == null || StringUtils.isBlank(changeCouponStatusReq.getCouponId())){
                throw new Exception("请求参数不正确，优惠券编号为空!");
            }
            TradeCoupon tradeCoupon =new TradeCoupon();
            tradeCoupon.setCouponId(changeCouponStatusReq.getCouponId());
            tradeCoupon.setOderId(changeCouponStatusReq.getOderId());
            //使用优惠券
            if(changeCouponStatusReq.getIsUsed().equals(TradeEnums.YesNoEnum.YES.getCode())){

                    int i= this.tradeCouponMapper.useCoupon(tradeCoupon);
                    if(i<=0){
                        throw new Exception("使用该优惠券失败!");
                    }
            } else if(changeCouponStatusReq.getIsUsed().equals(TradeEnums.YesNoEnum.NO.getCode())){
                    int i= this.tradeCouponMapper.unUseCoupon(tradeCoupon);
            }

        }catch(Exception e){
            result.setRetCode(TradeEnums.RetEnum.FAIL.getCode());
            result.setRetInfo(e.getMessage());
        }
        return null;
    }
}
