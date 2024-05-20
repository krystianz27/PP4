package pl.krystian.ecommerce.sales;

import org.junit.jupiter.api.Test;
import pl.krystian.ecommerce.sales.offering.Offer;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;


public class SalesTest {

    private SalesFacade thereIsSalesFacade() {
        return new SalesFacade();
    }

    private String thereIsExampleCustomer(String name) {
        return name;
    }

    private String thereIsProduct(String name, BigDecimal price) {
        return name;
    }

    @Test
    void itAddProductToCart() {
        var customerId = thereIsExampleCustomer("Krystian");
        var productId = thereIsProduct("product a", BigDecimal.valueOf(10));
        SalesFacade sales = thereIsSalesFacade();
        //ACT
        sales.addToCart(customerId, productId);

        //ASSERT
        Offer currentOffer = sales.getCurrentOffer(customerId);
        assertEquals(BigDecimal.valueOf(10), currentOffer.getTotal());
        assertEquals(1, currentOffer.getItemsCount());
    }



    @Test
    void itAddMultipleProductsToCart() {
        var customerId = thereIsExampleCustomer("Krystian");
        var productA = thereIsProduct("product a", BigDecimal.valueOf(10));
        var productB= thereIsProduct("product b", BigDecimal.valueOf(20));
        SalesFacade sales = thereIsSalesFacade();

        //ACT
        sales.addToCart(customerId, productA);
        sales.addToCart(customerId, productB);

        //ASERT
        Offer currentOffer = sales.getCurrentOffer(customerId);
        assertEquals(BigDecimal.valueOf(0), currentOffer.getTotal());
    }


    @Test
    void itDoesNotShareCustomersCarts() {
        var customerA = thereIsExampleCustomer("Krystian");
        var customerB = thereIsExampleCustomer("Michal");
        var productA = thereIsProduct("product a", BigDecimal.valueOf(10));
        var productB= thereIsProduct("product b", BigDecimal.valueOf(20));
        SalesFacade sales = thereIsSalesFacade();

        //ACT
        sales.addToCart(customerA, productA);
        sales.addToCart(customerB, productB);

        //ASERT
        Offer currentOfferA = sales.getCurrentOffer(customerA);
        assertEquals(BigDecimal.valueOf(10), currentOfferA.getTotal());

        Offer currentOfferB = sales.getCurrentOffer(customerB);
        assertEquals(BigDecimal.valueOf(20), currentOfferB.getTotal());


    }

    @Test
    void itShowsCurrentOffer() {
        SalesFacade sales = thereIsSalesFacade();
        var customerId = thereIsExampleCustomer("Krystian");

        Offer offer = sales.getCurrentOffer(customerId);

        assertEquals(0,offer.getItemsCount());
        assertEquals(BigDecimal.ZERO,offer.getTotal());
    }


    @Test
    void itRemoveProductFromCart() {

    }

    @Test
    void itAllowToAcceptOffer() {

    }

    @Test
    void itAllowToPayForReservation() {

    }
}
