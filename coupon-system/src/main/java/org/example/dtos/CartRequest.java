package org.example.dtos;

import java.util.List;

/**
 * CartRquest
 */
public record CartRequest(
    String id,
    UserContext userContext,
    List<CartItem> items,
    List<String> applied_coupons,
    double total_amount,
    double total_amount_after_discount,
    String coupon_code,
    String orderId
) {}
