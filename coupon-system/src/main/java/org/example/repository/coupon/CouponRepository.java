package org.example.repository.coupon;

import org.example.models.Coupon;

/**
 * CouponRepository
 */
public interface CouponRepository {
    Coupon add(Coupon coupon);
    Coupon update(Coupon coupon);
    Coupon getByCode(String code);
}
