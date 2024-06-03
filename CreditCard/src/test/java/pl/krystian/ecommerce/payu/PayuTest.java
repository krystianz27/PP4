package pl.krystian.ecommerce.payu;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PayuTest {
    @Test
    void creatingNewPayment() {
        PayU payu = thereIsPayU();
        OrderCreateRequest orderCreateRequest = createExampleOrderCreateRequest();

        OrderCreateResponse response = payu.handle(orderCreateRequest);

        assertNotNull(response.getRedirectUri()); // where to redirect customer
        assertNotNull(response.getOrderId()); // transaction ids

    }

    private OrderCreateRequest createExampleOrderCreateRequest() {

        var createRequest = new OrderCreateRequest();
        createRequest
                .setNotifyUrl("https://my.example.shop.krystian.pl/api/order")
                .setCustomerIp("127.0.0.1")
                .setMerchantPosId("300746")
                .setDescription("My ebook")
                .setCurrencyCode("PLN")
                .setTotalAmount(21000)
                .setExtOrderId(UUID.randomUUID().toString())
                .setBuyer((new Buyer())
                        .setEmail("john.doe@example.com")
                        .setFirstName("John")
                        .setLastName("Doe")
                        .setLanguage("pl")
                )
                .setProducts(Arrays.asList(
                        new Product()
                                .setName("Product X")
                                .setQuantity(1)
                                .setUnitPrice(21000)
                ));

        return createRequest;
    }

    private PayU thereIsPayU() {
        return new PayU(
            new RestTemplate(),
                PayUCredentials.sandbox(
                        "300747",
                        "22f4175da9f0f72bcce976dd8bd7504f"

                )
        );
    }

    private PayU thereIsPayU() {
        return new PayU(
                new RestTemplate(),
                PayUCredentials.sandbox(
                        "300746",
                        "22f4175da9f0f72bcce976dd8bd7504f"
                )
        )
    }
}
