package pl.krystian.ecommerce.infrastructure;

import pl.krystian.ecommerce.sales.payment.PaymentDetails;
import pl.krystian.ecommerce.sales.payment.PaymentGateway;
import pl.krystian.ecommerce.sales.payment.RegisterPaymentRequest;

public class PayUPaymentGw implements PaymentGateway {

    @Override
    public PaymentDetails registerPayment(RegisterPaymentRequest registerPaymentRequest) {
        return null;
    }
}
