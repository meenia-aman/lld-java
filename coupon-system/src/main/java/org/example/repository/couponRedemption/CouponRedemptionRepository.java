package org.example.repository.couponRedemption;

import org.example.models.CouponRedemption;

/**
 * CouponRedemptionRepository
 */
public interface CouponRedemptionRepository {
    CouponRedemption add(CouponRedemption couponRedemption);
    CouponRedemption update(CouponRedemption couponRedemption);
    CouponRedemption getByOrderId(String orderId);
}
