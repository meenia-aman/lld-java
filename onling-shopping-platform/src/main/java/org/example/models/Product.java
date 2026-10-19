package org.example.models;

import java.util.UUID;
import org.example.enums.ProductCategory;

/**
 * Product
 */
public class Product {

    private final String id;
    private String name;
    private String description;
    private double amount;
    private ProductCategory category;

    public Product(
        String name,
        String description,
        double amount,
        ProductCategory category
    ) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ProductCategory getCategory() {
        return category;
    }
}
