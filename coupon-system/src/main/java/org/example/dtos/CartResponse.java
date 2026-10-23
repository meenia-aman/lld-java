package org.example.dtos;

import java.util.List;

/**
 * CartResponse
 */
public record CartResponse(
    String id,
    Boolean success,
    List<CartItem> items,
    UserContext userContext,
    double total_amount,
    double total_amount_after_discount,
    List<String> applied_couponse,
    String message
) {}
