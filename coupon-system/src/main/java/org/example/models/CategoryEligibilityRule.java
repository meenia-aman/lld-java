package org.example.models;

import org.example.dtos.CartItem;
import org.example.dtos.CartRequest;
import org.example.dtos.EligibilityResponse;

/**
 * CategoryEligibilityRule
 */
public class CategoryEligibilityRule implements EligibilityRule {

    @Override
    public EligibilityResponse validate(
        CartRequest cartRequest,
        Coupon coupon
    ) {
        for (CartItem item : cartRequest.items()) {
            if (item.category().equals(coupon.getApplicablecategory())) {
                return new EligibilityResponse(true, "Coupon is eligible");
            }
        }

        return new EligibilityResponse(
            false,
            "This coupon is not applicable for this kind of items"
        );
    }
}
