package org.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.example.enums.OrderStatus;
import org.example.enums.PaymentType;
import org.example.models.Cart;
import org.example.models.CartItem;
import org.example.models.Order;
import org.example.models.OrderItem;
import org.example.models.Product;
import org.example.models.Transaction;
import org.example.repository.order.OrderRepository;

/**
 * OrderService
 */
public class OrderService {

    private InventoryService inventoryService;
    private CartService cartService;
    private PaymentService paymentService;
    private ProductService productService;
    private OrderRepository orderRepository;

    public OrderService(
        InventoryService inventoryService,
        CartService cartService,
        PaymentService paymentService,
        ProductService productService,
        OrderRepository orderRepository
    ) {
        this.inventoryService = inventoryService;
        this.cartService = cartService;
        this.paymentService = paymentService;
        this.productService = productService;
        this.orderRepository = orderRepository;
    }

    private Order createOrderFun(
        List<OrderItem> orderItems,
        double total_amount,
        String userId
    ) {
        Order order = new Order(userId, total_amount, orderItems);

        return orderRepository.add(order);
    }

    Order createOrder(String userId) {
        Cart cart = cartService.getCartByUserId(userId);
        // Check cart is empty or not
        if (cart == null) {
            System.out.println(
                "Please slected one or more items before creating the order"
            );
            return null;
        }

        // Check whether we have that much stock present
        List<CartItem> cartIems = new ArrayList<>();
        for (Map.Entry<String, CartItem> iEntry : cart.getItems().entrySet()) {
            CartItem item = iEntry.getValue();
            cartIems.add(item);
        }

        boolean reserved = inventoryService.reserveStockForKProducts(cartIems);
        if (reserved == false) {
            System.out.println("Unable to resever the stock");
            return null;
        }

        List<OrderItem> orderItems = new ArrayList<>();

        double total_amount = 0.0;
        for (CartItem item : cartIems) {
            Product product = productService.getProductById(
                item.getProductId()
            );
            OrderItem orderItem = new OrderItem(
                item.getProductId(),
                item.getCount(),
                product.getAmount()
            );
            total_amount += orderItem.getTotalPrice();
            orderItems.add(orderItem);
        }

        Order order = this.createOrderFun(orderItems, total_amount, userId);
        return order;
    }

    Order getOrderById(String orderId) {
        return orderRepository.getById(orderId);
    }

    Transaction createPayment(String orderId, PaymentType paymentType) {
        Order order = getOrderById(orderId);
        if (order == null) {
            System.out.println("No order found with id " + orderId);
            return null;
        }

        Transaction transaction = paymentService.createTransaction(
            order.getUserId(),
            order.getId(),
            order.getPrice(),
            paymentType
        );

        return transaction;
    }

    Transaction makePayment(String transactionId) {
        Transaction transaction = paymentService.pay(transactionId);

        Order order = getOrderById(transaction.getOrderId());

        order.setStatus(OrderStatus.CONFIRMED);
        orderRepository.update(order);
        System.out.println(
            "=============== Order placed successfully ====================="
        );
        System.out.println("Total Price " + order.getPrice());
        for (OrderItem item : order.getItems()) {
            System.out.println(
                "Productid " +
                    item.getProductId() +
                    " Price " +
                    item.getPrice() +
                    " Stock " +
                    item.getStock()
            );
        }
        return transaction;
    }
}
