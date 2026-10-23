package org.example.repository.couponRedemption;

import java.util.HashMap;
import java.util.Map;
import org.example.models.CouponRedemption;

/**
 * InMemoryCouponRedemptionRepository
 */
public class InMemoryCouponRedemptionRepository
    implements CouponRedemptionRepository
{

    private Map<String, CouponRedemption> couponList = new HashMap<>();

    @Override
    public CouponRedemption add(CouponRedemption couponRedemption) {
        this.couponList.put(couponRedemption.getOderId(), couponRedemption);
        return couponRedemption;
    }

    @Override
    public CouponRedemption update(CouponRedemption couponRedemption) {
        this.couponList.put(couponRedemption.getId(), couponRedemption);
        return couponRedemption;
    }

    @Override
    public CouponRedemption getByOrderId(String orderId) {
        return this.couponList.getOrDefault(orderId, null);
    }
}
