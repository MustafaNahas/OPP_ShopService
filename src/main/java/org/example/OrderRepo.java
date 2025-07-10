package org.example;

import java.util.List;

public interface OrderRepo {
    /** Store a new order. @return true if the order was added, false otherwise. */
    boolean addOrder(Order order);

    /** Remove an order by its id. @return true if something was removed. */
    boolean removeOrder(String id);

    /** Fetch a single order (null if it doesn’t exist). */
    Order getOrder(String id);

    /** Retrieve an immutable snapshot of all stored orders. */
    List<Order> getAllOrders();
}
