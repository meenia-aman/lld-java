package org.example.repository.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.models.Product;

/**
 * InMemoryProductRepository
 */
public class InMemoryProductRepository implements ProductRepository {

    private Map<String, Product> products = new HashMap<>();

    @Override
    public Product add(Product p) {
        products.put(p.getId(), p);
        return p;
    }

    @Override
    public Product update(Product p) {
        products.put(p.getName(), p);
        return p;
    }

    @Override
    public List<Product> getAll() {
        return products.values().stream().toList();
    }

    @Override
    public Product getById(String id) {
        return products.getOrDefault(id, null);
    }
}
