package org.example;

import java.time.LocalDate;
import java.util.List;

public class ShopService {
    private final ProductRepo productRepo;
    private final OrderListRepo orderRepo;


    public ShopService(ProductRepo productRepo, OrderListRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo   = orderRepo;
    }
    public Order placeOrder(String orderId, List<String> productIds) {

        double total = 0.0;

        for (String pid : productIds) {
            Product p = productRepo.getProduct(pid);
            if (p == null) {
                System.out.println("Product with id '" + pid + "' does not exist – order aborted.");
                return null;                    // stop – at least one product is missing
            }
            total += p.price();
        }

        // All products exist → create and store order
        Order order = new Order(orderId, LocalDate.now(), total, productIds);
        boolean stored = orderRepo.addOrder(order);

        if (!stored) {
            System.out.println("Order id '" + orderId + "' already exists – order not stored.");
            return null;
        }
        return order;
    }

}
