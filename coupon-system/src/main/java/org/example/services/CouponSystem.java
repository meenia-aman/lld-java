package org.example.services;

import org.example.dtos.CartRequest;
import org.example.dtos.CartResponse;
import org.example.enums.RedemptionStatus;
import org.example.models.Coupon;
import org.example.models.CouponRedemption;

/**
 * CouponSystem
 */
public class CouponSystem {

    private CouponService couponService;
    private CouponRedemptionService couponRedemptionService;

    public CouponSystem(
        CouponService couponService,
        CouponRedemptionService couponRedemptionService
    ) {
        this.couponService = couponService;
        this.couponRedemptionService = couponRedemptionService;
    }

    public Coupon createCoupon(Coupon coupon) {
        return couponService.createCoupon(coupon);
    }

    Coupon getCouponByCode(String code) {
        return couponService.getCouponByCode(code);
    }

    public CartResponse applyCouponToCart(CartRequest cartRequest) {
        Coupon coupon = this.getCouponByCode(cartRequest.coupon_code());

        if (coupon == null) {
            CartResponse cartResponse = new CartResponse(
                cartRequest.id(),
                false,
                cartRequest.items(),
                cartRequest.userContext(),
                cartRequest.total_amount(),
                cartRequest.total_amount_after_discount(),
                cartRequest.applied_coupons(),
                "Invalid coupon"
            );
            return cartResponse;
        }

        return couponRedemptionService.getUpdatedAmountAfterCouponApply(
            cartRequest,
            coupon
        );
    }

    public CartResponse CreateCouponUsageEntry(CartRequest cartRequest) {
        return couponRedemptionService.createNewCouponRedemption(cartRequest);
    }

    public RedemptionStatus updateCouponStatus(
        String orderId,
        RedemptionStatus status
    ) {
        return couponRedemptionService.updateRedeptionStatus(orderId, status);
    }

    public CouponRedemption getCouponRedemptionEntryByOrderId(String orderId) {
        return couponRedemptionService.getCouponEntryByOrderId(orderId);
    }
}
