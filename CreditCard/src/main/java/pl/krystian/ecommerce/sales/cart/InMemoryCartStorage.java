package pl.krystian.ecommerce.sales.cart;

import pl.krystian.ecommerce.sales.cart.Cart;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryCartStorage {
    private Map<String, Cart> cartStorage;

    public InMemoryCartStorage() {
        this.cartStorage = new HashMap<>();
    }

    public Optional<Cart> findByCustomer(String customerId) {
        return Optional.ofNullable(cartStorage.get(customerId));
    }

    public Optional<Cart> loadForCustomer(String customerId) {
        return Optional.empty();
    }

    public void saveCart(String customerId, Cart cart) {
        cartStorage.put(customerId, cart);
    }

    public void save(String customerId, Cart cart) {
        cartStorage.put(customerId, cart);
    }


//    public Optional<Cart> findByCustomer(String customerId) {
//        return null;
//    }
}
