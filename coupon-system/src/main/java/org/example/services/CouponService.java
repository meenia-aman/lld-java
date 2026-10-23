package org.example.services;

import org.example.models.Coupon;
import org.example.repository.coupon.CouponRepository;

/**
 * CouponService
 */
public class CouponService {

    private CouponRepository couponRepository;

    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public Coupon createCoupon(Coupon coupon) {
        return couponRepository.add(coupon);
    }

    public Coupon getCouponByCode(String code) {
        return couponRepository.getByCode(code);
    }
}
