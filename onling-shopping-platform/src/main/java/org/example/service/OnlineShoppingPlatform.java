package org.example.service;

import java.util.List;
import org.example.dtos.RequestProductByFilter;
import org.example.enums.PaymentType;
import org.example.enums.ProductCategory;
import org.example.models.Cart;
import org.example.models.CartItem;
import org.example.models.Inventory;
import org.example.models.Order;
import org.example.models.Product;
import org.example.models.Transaction;
import org.example.models.User;

/**
 * OnlineShoppingPlatform
 */
public class OnlineShoppingPlatform {

    private ProductService productService;
    private UserService userService;
    private CartService cartService;
    private OrderService orderService;
    private PaymentService paymentService;
    private InventoryService inventoryService;

    public OnlineShoppingPlatform(
        ProductService productService,
        UserService userService,
        CartService cartService,
        OrderService orderService,
        PaymentService paymentService,
        InventoryService inventoryService
    ) {
        this.productService = productService;
        this.userService = userService;
        this.cartService = cartService;
        this.orderService = orderService;
        this.paymentService = paymentService;
        this.inventoryService = inventoryService;
    }

    public User createUser(String name, String email, String address) {
        return userService.createUser(name, email, address);
    }

    public User getUserById(String userId) {
        return userService.getUserById(userId);
    }

    public Product createProduct(
        String name,
        String description,
        double amount,
        ProductCategory category
    ) {
        return productService.createProduct(
            name,
            description,
            amount,
            category
        );
    }

    public List<Product> getProducts(RequestProductByFilter filter) {
        return productService.getPrdouctByFilters(filter);
    }

    public Inventory addInventory(String productId, int stock) {
        return inventoryService.updateInventory(productId, stock);
    }

    public Inventory getInventoryById(String productId) {
        return inventoryService.getInventoryByProductId(productId);
    }

    public Cart addItemToCart(String userId, List<CartItem> items) {
        return cartService.addItemToCart(userId, items);
    }

    public Cart getCartById(String userId) {
        return cartService.getCartByUserId(userId);
    }

    public Order createOrder(String userId) {
        return orderService.createOrder(userId);
    }

    public Transaction createPayment(String orderId, PaymentType paymentType) {
        return orderService.createPayment(orderId, paymentType);
    }

    public Transaction makePayment(String transactionId) {
        return orderService.makePayment(transactionId);
    }
}
