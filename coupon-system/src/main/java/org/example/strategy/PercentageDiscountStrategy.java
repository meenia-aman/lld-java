package org.example.strategy;

import org.example.enums.DiscountType;

/**
 * PercentageDiscountConfig
 */
public class PercentageDiscountStrategy implements DiscountStrategy {

    private double percentage;
    private double max_capped_at;

    public PercentageDiscountStrategy(int percentage) {
        this.percentage = percentage;
        this.max_capped_at = 0;
    }

    public PercentageDiscountStrategy(int percentage, double max_capped_at) {
        this.percentage = percentage;
        this.max_capped_at = max_capped_at;
    }

    @Override
    public double calculateDiscount(double eligibleAmount) {
        double discount_amount = (eligibleAmount / 100) * percentage;

        if (max_capped_at > 0) discount_amount = Math.min(
            max_capped_at,
            percentage
        );

        return discount_amount;
    }

    @Override
    public DiscountType getType() {
        return DiscountType.PERCENTAGE_BASED;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public double getMax_capped_at() {
        return max_capped_at;
    }

    public void setMax_capped_at(double max_capped_at) {
        this.max_capped_at = max_capped_at;
    }
}
