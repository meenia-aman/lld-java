package org.example.services;

import org.example.dtos.CartItem;
import org.example.dtos.CartRequest;
import org.example.enums.StackingCategory;
import org.example.models.Coupon;
import org.example.strategy.DiscountStrategy;

/**
 * CaculateDiscountService
 */
public class CalculateDiscountService {

    public double getDiscountAmount(CartRequest cartRequest, Coupon coupon) {
        DiscountStrategy discountStrategy = coupon.getDiscountStrategy();

        double discounted_amount = 0.0;
        double total_amount = 0;
        if (coupon.getStackingCategory() == StackingCategory.CART) {
            total_amount = cartRequest.total_amount_after_discount();
        } else if (
            coupon.getStackingCategory() == StackingCategory.ITEM_OFFER
        ) {
            for (CartItem item : cartRequest.items()) {
                if (coupon.getApplicablecategory().equals(item.category())) {
                    total_amount += item.discounted_amount();
                }
            }
        } else if (coupon.getStackingCategory() == StackingCategory.PAYMENT) {
            total_amount = cartRequest.total_amount_after_discount();
        } else if (coupon.getStackingCategory() == StackingCategory.DELIVERY) {
            total_amount = 0;
        }

        discounted_amount = discountStrategy.calculateDiscount(total_amount);

        return discounted_amount;
    }
}
