package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderListRepo implements OrderRepo{
    private final List<Order> orders = new ArrayList<>();
    private final Map<String, Order> index = new HashMap<>();

    public boolean addOrder(Order o) {
        if (o == null || index.containsKey(o.id())) return false;
        orders.add(o);
        index.put(o.id(), o);
        return true;
    }
    public boolean removeOrder(String id) {
        Order removed = index.remove(id);
        if (removed == null) return false;
        orders.remove(removed);
        return true;
    }
    public Order getOrder(String id) {
        return index.get(id);
    }
    public List<Order> getAllOrders() {
        return List.copyOf(orders);
    }

}
