package org.example.dtos;

import org.example.enums.ProductCategory;

/**
 * CartItem
 */
public record CartItem(
    String productId,
    double amount,
    double discounted_amount,
    ProductCategory category,
    int count
) {}
