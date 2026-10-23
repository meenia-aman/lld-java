package org.example.models;

import org.example.dtos.CartRequest;
import org.example.dtos.EligibilityResponse;

/**
 * MinCartAmount
 */
public class MinCartAmountEligibilityRule implements EligibilityRule {

    @Override
    public EligibilityResponse validate(
        CartRequest cartRequest,
        Coupon coupon
    ) {
        if (cartRequest.total_amount() > coupon.getMinimumCartAmount()) {
            return new EligibilityResponse(true, "Coupon Applied Successfully");
        }

        String errorMessage =
            "Your cart must be of amount " +
            coupon.getMinimumCartAmount() +
            " to applicable for this coupon " +
            coupon.getCode();
        return new EligibilityResponse(false, errorMessage);
    }
}
