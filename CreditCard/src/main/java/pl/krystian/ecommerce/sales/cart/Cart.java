package pl.krystian.ecommerce.sales.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {

    HashMap<String, Integer> productsQty;

    public Cart() {
        this.productsQty = new HashMap<>();
    }

    public static Cart empty() {
        return new Cart();
    }

    public void addProduct(String productId) {
        if (!isInCart(productId)) {
            putIntoCart(productId);
        }
        else {
            increaseQuantity(productId);
        }

    }

    private void increaseQuantity(String productId) {
        productsQty.put(productId, productsQty.get(productId) + 1);
    }

    private void putIntoCart(String productId) {
        productsQty.put(productId, 1);
    }

    private boolean isInCart(String productId) {
        return productsQty.containsKey(productId);

//        return products.stream()
//                .filter(p -> products.equals(productId))
//                .count();
    }

    public boolean isEmpty() {
        return productsQty.isEmpty();
    }

    public int getProductsCount() {
        return productsQty.values().size();
    }

    public List<CartLines> getLines() {
        return productsQty
                .entrySet()
                .stream()
                .map(es -> new CartLines(es.getKey(), es.getValue()))
                .toList();
    }
}
