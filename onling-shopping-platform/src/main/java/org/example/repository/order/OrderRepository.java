package org.example.repository.order;

import java.util.List;
import org.example.models.Order;

/**
 * OrderRepository
 */

public interface OrderRepository {
    Order add(Order o);
    Order update(Order o);
    Order getById(String id);
    List<Order> getOrderByUserId(String userId);
}
