package org.example.models;

import java.util.UUID;

/**
 * Inventory
 */
public class Inventory {

    private final String id;
    private String productId;
    private int totalStock;
    private int reserveStock;

    public Inventory(String productId, int totalStock, int reserveStock) {
        this.id = UUID.randomUUID().toString();
        this.productId = productId;
        this.totalStock = totalStock;
        this.reserveStock = 0;
    }

    public String getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public int getTotalStock() {
        return totalStock;
    }

    public int getReserveStock() {
        return reserveStock;
    }

    public void setTotalStock(int totalStock) {
        this.totalStock = totalStock;
    }

    public void setReserveStock(int reserveStock) {
        this.reserveStock = reserveStock;
    }
}
