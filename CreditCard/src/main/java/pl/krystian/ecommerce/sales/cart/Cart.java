package pl.krystian.ecommerce.sales.cart;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {

    private final HashMap<String, Integer> productsQuantities;
//
    public Cart() {
        this.productsQuantities = new HashMap<>();
    }

    public static Cart empty() {
        return new Cart();
    }

    public void add(String productId) {
        if (!isInCart(productId)) {
            putIntoCart(productId);
        }
        else {
            increaseQuantity(productId);
        }
    }

    private void increaseQuantity(String productId) {
        productsQuantities.put(productId, productsQuantities.get(productId) + 1);
    }

    private void putIntoCart(String productId) {
        productsQuantities.put(productId, 1);
    }

    private boolean isInCart(String productId) {
        return productsQuantities.containsKey(productId);
    }

    public boolean isEmpty() {
        return productsQuantities.values().isEmpty();
    }

    public int getItemsCount() {
        return productsQuantities.values().size();
    }

    public List<CartItem> getCartItems() {
        return productsQuantities
                .entrySet()
                .stream()
                .map(es -> new CartItem(es.getKey(), es.getValue()))
                .collect(Collectors.toList());
    }
}
