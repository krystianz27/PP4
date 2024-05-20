package pl.krystian.ecommerce.sales.cart;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class CartTest {
    private static final String PRODUCT_1 = "Lego set X";
    private static final String PRODUCT_2 = "Lego set Y";

    private String thereIsProduct(String id) {
        return id;
    }

    @Test
    void newlyCreatedCartIsEmpty() {
        Cart cart = Cart.empty();

        assertThat(cart.isEmpty()).isTrue();
    }


    @Test
    void cartWithProductsIsNoEmpty() {
        Cart cart = Cart.empty();
        String productId = thereIsProduct(PRODUCT_1);


        cart.addProduct(productId);
        assertThat(cart.isEmpty()).isFalse();
    }


    @Test
    void itExposeProductsCountV2() {
        Cart cart = Cart.empty();
        String productId1 = thereIsProduct(PRODUCT_1);
        String productId2 = thereIsProduct(PRODUCT_2);

        cart.addProduct(productId1);
        cart.addProduct(productId2);

        assertThat(cart.getProductsCount()).isEqualTo(2);

    }


    @Test
    void itExposeProductsCountV1() {
        Cart cart = Cart.empty();
        String productId = thereIsProduct(PRODUCT_1);

        cart.addProduct(productId);

        assertThat(cart.getProductsCount()).isEqualTo(1);

    }


    @Test
    void itExposeProductsCountV3() {
        Cart cart = Cart.empty();
        String productId = thereIsProduct(PRODUCT_1);

        cart.addProduct(productId);
        cart.addProduct(productId);

        assertThat(cart.getProductsCount()).isEqualTo(2);

    }


    @Test
    void itExposeCollectedItems() {
        Cart cart = Cart.empty();
        String productId = thereIsProduct(PRODUCT_1);

        cart.addProduct(productId);

        List<CartLines> lines = cart.getLines();

        assertThat(lines)
                .hasSize(1)
                .extracting("productId")
                .contains(PRODUCT_1);

        assertCartContainsProductQuantity(lines, PRODUCT_2, 1);
    }

    private void assertCartContainsProductQuantity(List<CartLines> lines, String productId, int expectedQty) {
        assertThat(lines)
                .filteredOn(cartLines -> cartLines.getProductId().equals(productId))
                .extracting(cartLines -> cartLines.getQuantity())
                .first()
                .isEqualTo(expectedQty);
    }


    @Test
    void itExposeCollectedItemsWithQuantity() {
        Cart cart = Cart.empty();
        String productId1 = thereIsProduct(PRODUCT_1);
        String productId2 = thereIsProduct(PRODUCT_2);

        cart.addProduct(productId1);
        cart.addProduct(productId1);
        cart.addProduct(productId1);

        cart.addProduct(productId2);

        List<CartLines> lines = cart.getLines();


        assertCartContainsProductQuantity(lines, PRODUCT_1, 3);
        assertCartContainsProductQuantity(lines, PRODUCT_2, 1);
    }
}
