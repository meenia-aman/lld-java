package org.example.repository.inventory;

import java.util.HashMap;
import java.util.Map;
import org.example.models.Inventory;

/**
 * InMemoryInventoryRepository
 */
public class InMemoryInventoryRepository implements InventoryRepository {

    private Map<String, Inventory> inventoryList = new HashMap<>();

    @Override
    public Inventory add(Inventory i) {
        inventoryList.put(i.getProductId(), i);
        return i;
    }

    @Override
    public Inventory update(Inventory i) {
        inventoryList.put(i.getProductId(), i);
        return i;
    }

    @Override
    public Inventory getById(String id) {
        return inventoryList.getOrDefault(id, null);
    }
}
