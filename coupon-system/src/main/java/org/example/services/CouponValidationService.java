package org.example.services;

import java.util.List;
import org.example.dtos.CartRequest;
import org.example.dtos.EligibilityResponse;
import org.example.models.Coupon;
import org.example.models.EligibilityRule;

/**
 * CouponValidationService
 * This service is responsible for checking the elgibility of this coupon in current cart
 */
public class CouponValidationService {

    public EligibilityResponse validateCoupon(
        CartRequest cartRequest,
        Coupon coupon
    ) {
        List<EligibilityRule> eligibilityRules = coupon.getEligibilityRules();

        for (EligibilityRule eligibilityRule : eligibilityRules) {
            EligibilityResponse response = eligibilityRule.validate(
                cartRequest,
                coupon
            );

            if (!response.success()) {
                return response;
            }
        }
        String successMessage =
            "Coupon  " +
            coupon.getCode() +
            " is applicable to cart " +
            cartRequest.id();
        return new EligibilityResponse(true, successMessage);
    }
}
