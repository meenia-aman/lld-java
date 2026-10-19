package org.example.models;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Cart
 */
public class Cart {

    private final String id;
    private String userId;
    private Map<String, CartItem> items = new HashMap<>();

    public Cart(String userId, Map<String, CartItem> items) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public Map<String, CartItem> getItems() {
        return items;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setItems(Map<String, CartItem> items) {
        this.items = items;
    }

    public void addItem(CartItem item) {
        items.put(item.getProductId(), item);
    }

    public void removeItem(CartItem item) {
        items.remove(item.getProductId());
    }
}
