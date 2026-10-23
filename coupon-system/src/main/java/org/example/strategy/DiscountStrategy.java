package org.example.strategy;

import org.example.enums.DiscountType;

/**
 * DiscountConfig
 */
public interface DiscountStrategy {
    DiscountType getType();
    double calculateDiscount(double eligibleAmount);
}
