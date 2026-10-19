package org.example.dtos;

import org.example.enums.ProductCategory;

/**
 * RequestProductFilter
 */
public record RequestProductByFilter(ProductCategory category) {}
