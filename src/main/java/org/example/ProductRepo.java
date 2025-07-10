package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepo {
    private final List<Product> products = new ArrayList<>();
    private final Map<String, Product> index = new HashMap<>();

    public boolean addProduct(Product p) {
        if (p == null || index.containsKey(p.id())) return false;
        products.add(p);
        index.put(p.id(), p);
        return true;
    }

    public boolean removeProduct(String id) {
        Product removed = index.remove(id);
        if (removed == null) return false;
        products.remove(removed);
        return true;
    }
    public Product getProduct(String id) {
        return index.get(id);
    }
    public List<Product> getAllProducts() {
        return List.copyOf(products);
    }
}
