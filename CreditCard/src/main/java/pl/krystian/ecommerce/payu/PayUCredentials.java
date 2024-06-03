package pl.krystian.ecommerce.payu;

public class PayUCredentials {
    boolean sandbox;
    String clientSecret;
    String sandbox;

    public static PayUCredentials sandbox(String clientId) {
        return new PayUCredentials(clientId, clientSecret);
    }


}
