package pl.krystian.ecommerce.payu;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class PayU {
    RestTemplate http;

    public PayU(RestTemplate http, PayUCredentials payUCredentials) {
        this.http = http;
    }

    public OrderCreateResponse handle(OrderCreateRequest orderCreateRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Authorization", String.format("Bearer %s", getToken()));

        HttpEntity<OrderCreateRequest> request = new HttpEntity<>(orderCreateRequest, headers);

        ResponseEntity<OrderCreateResponse> orderCreateResponse = http.postForEntity(
                "https://secure.snd.payu.com/api/v2_1/orders",
                    orderCreateRequest,
                    OrderCreateResponse.class
            );

        return orderCreateResponse.getBody();
    }


    private String getToken() {
        String body = String.format("grant_type=client_credentials&client_id=%s&client_secret=%s",
                "300746",
                "22f4175da9f0f72bcce976dd8bd7504f"); //2ee86..65d
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<String> request = new HttpEntity<>(body, headers);

        ResponseEntity<AccessTookenResponse> atResponse = http.postForEntity(
                "https://secure.snd.payu.com/pl/standard/user/oauth/authorize",
                request,
                AccessTookenResponse.class);


        return atResponse.getBody().getAccessToken();
    }
}
