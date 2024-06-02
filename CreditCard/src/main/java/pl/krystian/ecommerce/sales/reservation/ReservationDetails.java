package pl.krystian.ecommerce.sales.reservation;

import java.math.BigDecimal;

public class ReservationDetails {
    private final String reservationId;
    private final String paymentUrl;

    public ReservationDetails(String paymentUrl, String reservationId) {
        this.paymentUrl = paymentUrl;
        this.reservationId = reservationId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public BigDecimal getTotal() {
        return BigDecimal.ZERO;
    }
}
