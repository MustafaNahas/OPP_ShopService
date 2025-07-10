package org.example;

import org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.AssertionsKt.assertNull;


class ShopServiceTest {
    private ProductRepo productRepo;
    private OrderListRepo orderRepo;
    private ShopService shop;
    @BeforeEach
    void setup(){
        productRepo = new ProductRepo();
        orderRepo= new OrderListRepo();
        shop=new ShopService(productRepo,  orderRepo);
    }
    @Test
    void shouldPlaceOrderSuccessfully() {
        productRepo.addProduct(new Product("p1", "Pen", 1.50,10));
        productRepo.addProduct(new Product("p2", "Book", 5.00,15));

        Order order = shop.placeOrder("o1", List.of("p1", "p2"));
        assertThat(order).isNotNull();

        assertThat(order.totalAmount()).isEqualTo(6.50);

    }
    @Test
    void shouldNotPlaceOrderWithInvalidProduct() {
        productRepo.addProduct(new Product("p1", "Pen", 1.50,5));

        Order order = shop.placeOrder("o1", List.of("p1", "invalid"));

        assertThat(order).isNull();
       // assertEquals(orderRepo.getAllOrders(),Null);
    }
}