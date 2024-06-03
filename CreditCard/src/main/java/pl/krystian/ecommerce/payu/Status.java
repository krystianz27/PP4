package pl.krystian.ecommerce.payu;

public class Status {
    String statusCode;

    public Status setStatusCode(String statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getStatusCode() {
        return statusCode;
    }
}
