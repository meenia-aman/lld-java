package org.example.services;

import java.time.LocalDateTime;
import java.util.List;
import org.example.dtos.CartRequest;
import org.example.dtos.CartResponse;
import org.example.dtos.EligibilityResponse;
import org.example.enums.RedemptionStatus;
import org.example.models.Coupon;
import org.example.models.CouponRedemption;
import org.example.repository.couponRedemption.CouponRedemptionRepository;

/**
 * CouponRedemptionService
 */
public class CouponRedemptionService {

    private CouponValidationService couponValidationService;
    private CalculateDiscountService calculateDiscountService;
    private CouponRedemptionRepository couponRedemptionRepository;

    public CouponRedemptionService(
        CouponRedemptionRepository couponRedemptionRepository,
        CalculateDiscountService calculateDiscountService,
        CouponValidationService couponValidationService
    ) {
        this.couponRedemptionRepository = couponRedemptionRepository;
        this.calculateDiscountService = calculateDiscountService;
        this.couponValidationService = couponValidationService;
    }

    EligibilityResponse validateCoupon(CartRequest cartRequest, Coupon coupon) {
        return couponValidationService.validateCoupon(cartRequest, coupon);
    }

    double getDiscountedAmount(CartRequest cartRequest, Coupon coupon) {
        return calculateDiscountService.getDiscountAmount(cartRequest, coupon);
    }

    public CartResponse getUpdatedAmountAfterCouponApply(
        CartRequest cartRequest,
        Coupon coupon
    ) {
        EligibilityResponse eligibilityResponse = this.validateCoupon(
            cartRequest,
            coupon
        );

        if (!eligibilityResponse.success()) {
            CartResponse cartResponse = new CartResponse(
                cartRequest.id(),
                false,
                cartRequest.items(),
                cartRequest.userContext(),
                cartRequest.total_amount(),
                cartRequest.total_amount_after_discount(),
                cartRequest.applied_coupons(),
                eligibilityResponse.message()
            );
            return cartResponse;
        }

        double discounted_amount = this.getDiscountedAmount(
            cartRequest,
            coupon
        );

        double amount_after_coupon =
            cartRequest.total_amount_after_discount() - discounted_amount;

        List<String> coupons = cartRequest.applied_coupons();
        coupons.add(cartRequest.coupon_code());

        CartResponse cartResponse = new CartResponse(
            cartRequest.id(),
            true,
            cartRequest.items(),
            cartRequest.userContext(),
            cartRequest.total_amount(),
            amount_after_coupon,
            coupons,
            "Coupon applied successfully and total amount price updated according to that"
        );

        return cartResponse;
    }

    CartResponse validateCartForEntry(CartRequest cartRequest) {
        CartResponse cartResponse = new CartResponse(
            cartRequest.id(),
            true,
            cartRequest.items(),
            cartRequest.userContext(),
            cartRequest.total_amount(),
            cartRequest.total_amount_after_discount(),
            cartRequest.applied_coupons(),
            "Coupon applied successfully and total amount price updated according to that"
        );
        return cartResponse;
    }

    public CartResponse createNewCouponRedemption(CartRequest cartRequest) {
        CartResponse cartResponse = this.validateCartForEntry(cartRequest);

        if (!cartResponse.success()) {
            return cartResponse;
        }

        CouponRedemption couponRedemption = new CouponRedemption(
            cartRequest.userContext().userId(),
            cartRequest.orderId(),
            cartRequest.total_amount(),
            cartResponse.total_amount_after_discount(),
            cartResponse.applied_couponse(),
            LocalDateTime.now(),
            LocalDateTime.now().plusMinutes(15)
        );
        couponRedemptionRepository.add(couponRedemption);

        return cartResponse;
    }

    public RedemptionStatus updateRedeptionStatus(
        String orderId,
        RedemptionStatus status
    ) {
        CouponRedemption couponRedemption =
            couponRedemptionRepository.getByOrderId(orderId);

        if (couponRedemption == null) {
            System.out.println("Enter the valid orderId");
            return null;
        }

        couponRedemption.setRedemptionStatus(status);
        couponRedemptionRepository.update(couponRedemption);
        return status;
    }

    public CouponRedemption getCouponEntryByOrderId(String orderId) {
        return couponRedemptionRepository.getByOrderId(orderId);
    }
}
