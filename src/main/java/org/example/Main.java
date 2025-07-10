package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        // --- Inventories ------------------------------------
        ProductRepo repo = new ProductRepo();


        OrderListRepo orderRepo = new OrderListRepo();


        ShopService shop = new ShopService(repo, orderRepo);

        repo.addProduct(new Product("p001", "Coffee Mug", 7.99,4));
        repo.addProduct(new Product("p002", "Notebook",   3.49,5));
        repo.addProduct(new Product("p003", "Notebook2",   3.49,6));
        repo.addProduct(new Product("p004", "Notebook3",   3.49,9));

        // --- Place an order -------------------------
        shop.placeOrder("o1", List.of("p001", "p002"));   // success
        shop.placeOrder("o2", List.of("p001", "pX"));   // fails ("pX" missing)

        // --- Show all stored orders ---------------
        orderRepo.getAllOrders().forEach(System.out::println);

       // System.out.println(repo.getProduct("p001"));   // Product[id=p001, name=Coffee Mug, price=7.99]

       // repo.removeProduct("p001");
       // repo.removeProduct("p002");

        repo.getAllProducts().forEach(System.out::println);
    }
}
