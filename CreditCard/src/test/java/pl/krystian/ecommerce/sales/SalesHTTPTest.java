package pl.krystian.ecommerce.sales;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.krystian.ecommerce.catalog.ProductCatalog;

import java.math.BigDecimal;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SalesHTTPTest {
    @Autowired
    TestRestTemplate http;

    @LocalServerPort
    private int port;

    @Autowired
    ProductCatalog catalog;

    @Test
    void itAllowToAcceptOffer() {
        //Arrange
        String productId = thereIsExampleProduct("Example Product", BigDecimal.valueOf(10.10));

        //ACT
        //add product to cart
        String addProductToCartURL = String.format(
                "http://localhost:%s/%s/%s",
                port,
                "api/add-to-cart",
                productId
        );

        ResponseEntity<Object> addProductResponse = http.postForEntity(
                addProductToCartURL, null, Object.class);


        // Get current offer
        String getCurrentOfferUrl = String.format("http://localhost:%s/api/current-offer", port);
        ResponseEntity<Offer> currentOfferResponse = http.getForEntity(getCurrentOfferUrl, Offer.class);
        Offer currentOffer = currentOfferResponse.getBody();



        // accept offer
        String acceptOfferUrl = String.format(
                "http://localhost:%s/%s",
                port,
                "api/accept-offer"
        );

        AcceptOfferRequest acceptOfferRequest = new AcceptOfferRequest();
        acceptOfferRequest
                .setFirstName("Krystian")
                .setLastName("Z")
                .setEmail("krystian@example.com");


        ResponseEntity<ReservationDetail> reservationDetailResponseEntity =
                http.postForEntity(acceptOfferUrl, acceptOfferRequest, ReservationDetail.class);

//        assertThat(reservationDetailResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertEquals(HttpStatus.OK, reservationDetailResponseEntity.getStatusCode());
        assertNotNull(reservationDetailResponseEntity.getBody().getReservationId());
        assertNotNull(reservationDetailResponseEntity.getBody().getPaymentUrl());
        assertEquals(currentOffer.getTotal(), reservationDetailResponseEntity.getBody().getTotal());

        //Arrange
        //-> reservationWithIdExist
        //-> thereIsPaymentURLAvailable
    }

    private String thereIsExampleProduct(String name, BigDecimal price) {
        var id = catalog.addProduct(name, name);
        catalog.changePrice(id,price);
        return id;
    }

}
