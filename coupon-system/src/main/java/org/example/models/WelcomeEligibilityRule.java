package org.example.models;

import org.example.dtos.CartRequest;
import org.example.dtos.EligibilityResponse;

/**
 * WelconEligibilityRule
 */
public class WelcomeEligibilityRule implements EligibilityRule {

    @Override
    public EligibilityResponse validate(
        CartRequest cartRequest,
        Coupon coupon
    ) {
        if (
            cartRequest.userContext().total_order_count() > 0
        ) return new EligibilityResponse(
            false,
            "This coupong is applicable for new users only"
        );
        return new EligibilityResponse(true, "Coupong Applied Successfully");
    }
}
