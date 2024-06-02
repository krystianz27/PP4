package pl.krystian.ecommerce.sales.cart;

import org.junit.jupiter.api.Test;

import java.util.List;

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


        cart.add(productId);
        assertThat(cart.isEmpty()).isFalse();
    }


    @Test
    void itExposeProductsCount() {
        Cart cart = Cart.empty();
        String productId1 = thereIsProduct(PRODUCT_1);
        String productId2 = thereIsProduct(PRODUCT_2);

        cart.add(productId1);
        cart.add(productId2);

        assertThat(cart.getItemsCount()).isEqualTo(2);

    }


    @Test
    public void itShowsSingleLineWhenSameProductsAddedTwice() {
        //Arrange
        Cart cart = Cart.empty();
        String product1 = thereIsProduct(PRODUCT_1);
        //Act
        cart.add(product1);
        cart.add(product1);

        //Assert
        assertThat(cart.getItemsCount())
                .isEqualTo(1);

        assertCartContainsProductWithQuantity(cart, product1, 2);
    }

    @Test
    public void itStoreQuantityOfMultipleProducts() {
        //Arrange
        Cart cart = Cart.empty();
        String product1 = thereIsProduct(PRODUCT_1);
        String product2 = thereIsProduct(PRODUCT_2);
        //Act
        cart.add(product1);
        cart.add(product1);
        cart.add(product2);

        //Assert
        assertThat(cart.getItemsCount()).isEqualTo(2);

        assertCartContainsProductWithQuantity(cart, product1, 2);
        assertCartContainsProductWithQuantity(cart, product2, 1);
    }


    private void assertCartContainsProductWithQuantity(Cart cart, String product1, int expectedQuantity) {
        assertThat(cart.getCartItems())
                .filteredOn(cartItem -> cartItem.getProductId().equals(product1))
                .extracting(CartItem::getQuantity)
                .first()
                .isEqualTo(expectedQuantity)
        ;
    }
}
