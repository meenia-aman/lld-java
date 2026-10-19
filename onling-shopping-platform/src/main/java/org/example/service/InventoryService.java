package org.example.service;

import java.util.List;
import org.example.models.Cart;
import org.example.models.CartItem;
import org.example.models.Inventory;
import org.example.repository.inventory.InventoryRepository;

/**
 * InventoryService
 */
public class InventoryService {

    private InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    Inventory updateInventory(String productId, int stock) {
        Inventory inventory = inventoryRepository.getById(productId);

        if (inventory == null) {
            inventory = new Inventory(productId, stock, 0);
        } else {
            inventory.setTotalStock(inventory.getTotalStock() + stock);
        }

        inventoryRepository.update(inventory);

        return inventory;
    }

    Inventory getInventoryByProductId(String productId) {
        return inventoryRepository.getById(productId);
    }

    boolean reserveStock(String productId, int stockCount) {
        Inventory inventory = inventoryRepository.getById(productId);
        if (inventory == null) {
            System.out.println(
                "Please select the valid Product or product is not available"
            );
            return false;
        }

        if (
            inventory.getTotalStock() < inventory.getReserveStock() + stockCount
        ) {
            int stockPresent =
                inventory.getTotalStock() - inventory.getReserveStock();
            System.out.println(
                "Only " +
                    stockPresent +
                    " stock preset for product " +
                    productId
            );
            return false;
        }

        inventory.setReserveStock(inventory.getReserveStock() + stockCount);

        System.out.println(
            "Rserving stock for proudct " + productId + " Stock " + stockCount
        );
        inventoryRepository.update(inventory);

        return true;
    }

    boolean releseStock(String productId, int stockCount) {
        Inventory inventory = inventoryRepository.getById(productId);
        if (inventory == null) {
            System.out.println(
                "Please select the valid Product or product is not available"
            );
            return false;
        }

        if (inventory.getReserveStock() < stockCount) {
            System.out.println(
                "Please select the valid order for which you want to release the stock"
            );
            return false;
        }

        inventory.setReserveStock(inventory.getReserveStock() - stockCount);

        inventoryRepository.update(inventory);

        System.out.println(
            "Releasing the reserved stock for proudct " +
                productId +
                " Stock " +
                stockCount
        );
        return true;
    }

    boolean stockSold(String productId, int stockCount) {
        Inventory inventory = inventoryRepository.getById(productId);
        if (inventory == null) {
            System.out.println(
                "Please select the valid Product or product is not available"
            );
            return false;
        }

        if (inventory.getReserveStock() < stockCount) {
            System.out.println(
                "Please select the valid order for which you want to release the stock"
            );
            return false;
        }

        inventory.setReserveStock(inventory.getReserveStock() - stockCount);
        inventory.setTotalStock(inventory.getTotalStock() - stockCount);

        inventoryRepository.update(inventory);

        System.out.println(
            stockCount + " Unit of stock sold for product " + productId
        );
        return true;
    }

    boolean reserveStockForKProducts(List<CartItem> items) {
        int idx = -1;
        // Reserving stocks for all itmes one by one
        for (int i = 0; i < items.size(); i++) {
            CartItem item = items.get(i);
            boolean reserved = this.reserveStock(
                item.getProductId(),
                item.getCount()
            );

            if (reserved == false) {
                idx = i;
                break;
            }
        }

        // If failed ot reserve the stock for any of the item that rollback
        if (idx != -1) {
            for (int i = 0; i < idx; i++) {
                CartItem item = items.get(i);
                this.releseStock(item.getProductId(), item.getCount());
            }

            return false;
        }

        return true;
    }
}
