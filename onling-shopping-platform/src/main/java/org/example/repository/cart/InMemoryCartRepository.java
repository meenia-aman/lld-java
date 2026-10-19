package org.example.repository.cart;

import java.util.HashMap;
import java.util.Map;
import org.example.models.Cart;

/**
 * InMemoryCartRepository
 */
public class InMemoryCartRepository implements CartRepository {

    private Map<String, Cart> carts = new HashMap<>();

    @Override
    public Cart add(Cart c) {
        carts.put(c.getUserId(), c);
        return c;
    }

    @Override
    public Cart update(Cart c) {
        carts.put(c.getUserId(), c);
        return c;
    }

    @Override
    public Cart getByUserId(String userId) {
        return carts.getOrDefault(userId, null);
    }
}
