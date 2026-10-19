package org.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.models.Cart;
import org.example.models.CartItem;
import org.example.repository.cart.CartRepository;

/**
 * CartService
 */
public class CartService {

    private CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart addItemToCart(String userId, List<CartItem> items) {
        Cart cart = cartRepository.getByUserId(userId);

        Map<String, CartItem> cartItems = new HashMap<>();

        for (CartItem item : items) {
            cartItems.put(item.getProductId(), item);
        }

        if (cart == null) {
            cart = new Cart(userId, cartItems);
        } else {
            cart.setItems(cartItems);
        }

        cartRepository.update(cart);
        System.out.println("Items added to cart ");
        for (CartItem item : items) {
            System.out.println(
                " Product Id " +
                    item.getProductId() +
                    " count " +
                    item.getCount()
            );
        }

        return cart;
    }

    public Cart getCartByUserId(String userId) {
        return cartRepository.getByUserId(userId);
    }
}
