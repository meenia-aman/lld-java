package org.example.models;

import org.example.dtos.CartRequest;
import org.example.dtos.EligibilityResponse;

/**
 * EligibilityRule
 */
public interface EligibilityRule {
    EligibilityResponse validate(CartRequest cartRequest, Coupon coupon);
}
