package pl.krystian.ecommerce.sales.reservation;

import java.math.BigDecimal;

public class ReservationDetail {

    public String getReservationId() {
        return "123xyz";
    }

    public String getPaymentUrl() {
        return "http://payment.dev/123xyz";
    }

    public BigDecimal getTotal() {
        return BigDecimal.ZERO;
    }
}
