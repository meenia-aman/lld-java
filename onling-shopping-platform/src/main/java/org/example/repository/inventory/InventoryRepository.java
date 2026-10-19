package org.example.repository.inventory;

import org.example.models.Inventory;

/**
 * InventoryRepository
 */
public interface InventoryRepository {
    Inventory add(Inventory i);
    Inventory update(Inventory i);
    Inventory getById(String id);
}
