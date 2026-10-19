package org.example.service;

import java.util.ArrayList;
import java.util.List;
import org.example.dtos.RequestProductByFilter;
import org.example.enums.ProductCategory;
import org.example.models.Product;
import org.example.repository.product.ProductRepository;

/**
 * ProductService
 */
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(
        String name,
        String description,
        double amount,
        ProductCategory category
    ) {
        Product product = new Product(name, description, amount, category);
        productRepository.add(product);
        return product;
    }

    public Product getProductById(String id) {
        return productRepository.getById(id);
    }

    public List<Product> getPrdouctByFilters(RequestProductByFilter filter) {
        List<Product> products = productRepository.getAll();

        List<Product> finalProducts = new ArrayList<>();

        for (Product product : products) {
            if (filter.category() != null) {
                if (product.getCategory().equals(filter.category())) {
                    finalProducts.add(product);
                }
            }
        }
        return finalProducts;
    }
}
