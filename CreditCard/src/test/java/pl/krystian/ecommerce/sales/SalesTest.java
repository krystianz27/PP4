package pl.krystian.ecommerce.sales;

import org.junit.jupiter.api.Test;
import pl.krystian.ecommerce.sales.cart.HashMapCartStorage;
import pl.krystian.ecommerce.sales.offering.Offer;
import pl.krystian.ecommerce.sales.offering.OfferCalculator;
import pl.krystian.ecommerce.sales.reservation.CartStorage;
import pl.krystian.ecommerce.sales.reservation.ReservationRepository;
import pl.krystian.ecommerce.sales.reservation.SpyPaymentGateway;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.math.BigDecimal;


public class SalesTest {

    private SalesFacade thereIsSales() {
        return new SalesFacade(
                new HashMapCartStorage(),
                new OfferCalculator(),
                new SpyPaymentGateway(),
                new ReservationRepository()
        );
    }

    private String thereIsCustomer(String name) {
        return name;
    }

    private String thereIsExampleProduct(String name, BigDecimal price) {
        return name;
    }


    @Test
    void itShowsCurrentOffer() {
        String customerId = thereIsCustomer("Kuba");
        SalesFacade sales = thereIsSales();

        Offer offer = sales.getCurrentOffer(customerId);

        assertThat(offer.getTotal()).isEqualTo(BigDecimal.ZERO);
        assertThat(offer.getItemsCount()).isEqualTo(0);
    }

    @Test
    void itAddsProductToCart() {
        String productId = thereIsExampleProduct("X", BigDecimal.valueOf(10));
        String customerId = thereIsCustomer("Kuba");
        SalesFacade sales = thereIsSales();

        sales.addProduct(customerId, productId);

        Offer offer = sales.getCurrentOffer(customerId);

        assertThat(offer.getTotal()).isEqualTo(BigDecimal.valueOf(10));
        assertThat(offer.getItemsCount()).isEqualTo(1);
    }


    @Test
    void itAcceptCustomersCurrentOffer() {

    }

    @Test
    void itConfirmPayment() {

    }

}
