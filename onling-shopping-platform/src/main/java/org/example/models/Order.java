package org.example.models;

import java.util.List;
import java.util.UUID;
import org.example.enums.OrderStatus;

/**
 * Order
 */
public class Order {

    private final String id;
    private String userId;
    private double price;
    private List<OrderItem> items;
    private OrderStatus status;

    public Order(String userId, double price, List<OrderItem> items) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.price = price;
        this.items = items;
        this.status = OrderStatus.PENDING;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public double getPrice() {
        return price;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public OrderStatus setStatus(OrderStatus status) {
        this.status = status;
        return this.status;
    }
}
