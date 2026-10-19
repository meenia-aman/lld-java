package org.example.models;

/**
 * OrderItem
 */
public class OrderItem {

    private String productId;
    private int stock;
    private double price;

    public OrderItem(String productId, int stock, double price) {
        this.productId = productId;
        this.stock = stock;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalPrice() {
        return this.stock * this.price;
    }
}
