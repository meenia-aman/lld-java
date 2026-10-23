package org.example.repository.coupon;

import java.util.HashMap;
import java.util.Map;
import org.example.models.Coupon;

/**
 * InMemoryCouponRepository
 */
public class InMemoryCouponRepository implements CouponRepository {

    private Map<String, Coupon> coupons = new HashMap<>();

    @Override
    public Coupon add(Coupon coupon) {
        this.coupons.put(coupon.getCode(), coupon);
        return this.coupons.getOrDefault(coupon.getCode(), null);
    }

    @Override
    public Coupon update(Coupon coupon) {
        this.coupons.put(coupon.getCode(), coupon);
        return coupon;
    }

    @Override
    public Coupon getByCode(String code) {
        return this.coupons.getOrDefault(code, null);
    }
}
