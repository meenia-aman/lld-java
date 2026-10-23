package org.example.strategy;

import org.example.enums.DiscountType;

/**
 * GetXgetYFreeDicountConfig
 */
public class GetXgetYFreeDicountStrategy implements DiscountStrategy {

    private int items;
    private int free_items;

    public GetXgetYFreeDicountStrategy(int items, int free_items) {
        this.items = items;
        this.free_items = free_items;
    }

    @Override
    public double calculateDiscount(double eligibleAmount) {
        return eligibleAmount;
    }

    @Override
    public DiscountType getType() {
        return DiscountType.BUY_X_GET_Y_FREE;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public int getFree_items() {
        return free_items;
    }

    public void setFree_items(int free_items) {
        this.free_items = free_items;
    }
}
