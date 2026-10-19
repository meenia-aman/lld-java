package org.example.repository.product;

import java.util.List;
import org.example.models.Product;

/**
 * ProductRepository
 */
public interface ProductRepository {
    Product add(Product p);
    Product update(Product p);
    Product getById(String id);
    List<Product> getAll();
}
