package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMapRepo implements OrderRepo {
    private final Map<String, Order> orders = new HashMap<>();
    @Override
    public boolean addOrder(Order order) {
        if (order == null || orders.containsKey(order.id())) return false;
        orders.put(order.id(), order);
        return true;
    }

    @Override
    public boolean removeOrder(String id) {
        return orders.remove(id) != null;
    }

    @Override
    public Order getOrder(String id) {
        return orders.get(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return List.copyOf(orders.values());
    }
}
