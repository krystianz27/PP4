package pl.krystian.ecommerce.payu;

public class AccessTookenResponse {
    String access_token;

    public String getAccess_token() {
        return access_token;
    }

    public AccessTookenResponse setAccess_token(String access_token) {
        this.access_token = access_token;
        return this;
    }

    public String getAccessToken() {
        return access_token;
    }
}
