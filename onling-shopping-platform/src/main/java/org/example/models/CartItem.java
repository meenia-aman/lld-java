package org.example.models;

/**
 * CartItem
 */
public class CartItem {

    private String productId;
    private int count;

    public CartItem(String productId, int count) {
        this.productId = productId;
        this.count = count;
    }

    public int updateCount(int count) {
        return (this.count = count);
    }

    public String getProductId() {
        return productId;
    }

    public int getCount() {
        return count;
    }
}
