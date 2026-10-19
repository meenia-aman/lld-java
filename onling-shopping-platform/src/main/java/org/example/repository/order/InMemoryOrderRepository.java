package org.example.repository.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.models.Order;

/**
 * InMemoryOrderRepository
 */
public class InMemoryOrderRepository implements OrderRepository {

    private Map<String, Order> orders = new HashMap<>();

    @Override
    public Order add(Order o) {
        System.out.println("Adding order");
        System.out.println("OrderItems " + o.getItems().size());
        orders.put(o.getId(), o);
        return o;
    }

    @Override
    public Order getById(String id) {
        return orders.getOrDefault(id, null);
    }

    @Override
    public List<Order> getOrderByUserId(String userId) {
        List<Order> oList = this.orders.values().stream().toList();
        List<Order> userOrders = new ArrayList<>();
        for (Order o : oList) {
            if (o.getUserId().equals(userId)) {
                userOrders.add(o);
            }
        }
        return userOrders;
    }

    @Override
    public Order update(Order o) {
        orders.put(o.getId(), o);
        return o;
    }
}
