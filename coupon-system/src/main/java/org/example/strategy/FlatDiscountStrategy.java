package org.example.strategy;

import org.example.enums.DiscountType;

/**
 * FlatDiscounConfig
 */
public class FlatDiscountStrategy implements DiscountStrategy {

    private double amount;

    public FlatDiscountStrategy(double amount) {
        this.amount = amount;
    }

    @Override
    public double calculateDiscount(double eligibleAmount) {
        return eligibleAmount - this.amount;
    }

    @Override
    public DiscountType getType() {
        return DiscountType.FLAT_DISCOUNT;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
