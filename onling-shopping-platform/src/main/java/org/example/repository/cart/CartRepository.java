package org.example.repository.cart;

import org.example.models.Cart;

/**
 * CartRepository
 */
public interface CartRepository {
    Cart add(Cart c);
    Cart update(Cart c);
    Cart getByUserId(String userId);
}
