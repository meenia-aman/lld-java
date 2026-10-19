package org.example;

import java.util.List;
import org.example.dtos.RequestProductByFilter;
import org.example.enums.PaymentType;
import org.example.enums.ProductCategory;
import org.example.models.Cart;
import org.example.models.CartItem;
import org.example.models.Order;
import org.example.models.Product;
import org.example.models.Transaction;
import org.example.models.User;
import org.example.repository.cart.CartRepository;
import org.example.repository.cart.InMemoryCartRepository;
import org.example.repository.inventory.InMemoryInventoryRepository;
import org.example.repository.inventory.InventoryRepository;
import org.example.repository.order.InMemoryOrderRepository;
import org.example.repository.order.OrderRepository;
import org.example.repository.product.InMemoryProductRepository;
import org.example.repository.product.ProductRepository;
import org.example.repository.transactions.InMemoryTransactionRepository;
import org.example.repository.transactions.TransactionRepository;
import org.example.repository.user.InMemoryUserRepository;
import org.example.repository.user.UserRepository;
import org.example.service.CartService;
import org.example.service.InventoryService;
import org.example.service.OnlineShoppingPlatform;
import org.example.service.OrderService;
import org.example.service.PaymentService;
import org.example.service.ProductService;
import org.example.service.UserService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static void main() {
        System.out.println(
            " ==================== Online Shopping Platform =================="
        );

        UserRepository userRepository = new InMemoryUserRepository();
        ProductRepository productRepository = new InMemoryProductRepository();
        CartRepository cartRepository = new InMemoryCartRepository();
        OrderRepository orderRepository = new InMemoryOrderRepository();
        TransactionRepository transactionRepository =
            new InMemoryTransactionRepository();
        InventoryRepository inventoryRepository =
            new InMemoryInventoryRepository();

        UserService userService = new UserService(userRepository);
        ProductService productService = new ProductService(productRepository);
        CartService cartService = new CartService(cartRepository);
        PaymentService paymentService = new PaymentService(
            transactionRepository
        );
        InventoryService inventoryService = new InventoryService(
            inventoryRepository
        );

        OrderService orderService = new OrderService(
            inventoryService,
            cartService,
            paymentService,
            productService,
            orderRepository
        );

        OnlineShoppingPlatform shoppingPlatform = new OnlineShoppingPlatform(
            productService,
            userService,
            cartService,
            orderService,
            paymentService,
            inventoryService
        );

        System.out.println("=======Creating Producst=======");
        Product p1 = shoppingPlatform.createProduct(
            "Macbook",
            "Macbook air m5",
            1200,
            ProductCategory.ELECTRONICS
        );

        Product p2 = shoppingPlatform.createProduct(
            "Macbook",
            "Macbook pro m5",
            2000,
            ProductCategory.ELECTRONICS
        );

        Product p3 = shoppingPlatform.createProduct(
            "Jeans",
            "Levis Jeans",
            200,
            ProductCategory.FASHION
        );

        RequestProductByFilter filter = new RequestProductByFilter(
            ProductCategory.ELECTRONICS
        );
        List<Product> products = shoppingPlatform.getProducts(filter);

        for (Product product : products) {
            System.out.println(
                "Product Name " +
                    product.getName() +
                    " Description " +
                    product.getDescription() +
                    " Amount " +
                    product.getAmount() +
                    " Id " +
                    product.getId()
            );
        }

        shoppingPlatform.addInventory(p1.getId(), 10);
        shoppingPlatform.addInventory(p2.getId(), 1);
        shoppingPlatform.addInventory(p3.getId(), 2);

        User user = shoppingPlatform.createUser(
            "Aman Meenia",
            "aman@gmail.com",
            "Trikuta Nagar Jammu"
        );

        CartItem cartItem1 = new CartItem(p1.getId(), 1);
        CartItem cartItem2 = new CartItem(p3.getId(), 2);
        CartItem cartItem3 = new CartItem(p2.getId(), 1);

        List<CartItem> items = List.of(cartItem1, cartItem2, cartItem3);

        shoppingPlatform.addItemToCart(user.getId(), items);
        shoppingPlatform.addItemToCart(user.getId(), items);

        Cart cart = shoppingPlatform.getCartById(user.getId());
        System.out.println("Cart Items " + cart.getItems().size());
        Order order = shoppingPlatform.createOrder(user.getId());

        Transaction transaction = shoppingPlatform.createPayment(
            order.getId(),
            PaymentType.UPI
        );

        System.out.println("Transaction Stautus " + transaction.getStatus());
        transaction = shoppingPlatform.makePayment(transaction.getId());

        System.out.println("Transaction Stautus " + transaction.getStatus());
    }
}
