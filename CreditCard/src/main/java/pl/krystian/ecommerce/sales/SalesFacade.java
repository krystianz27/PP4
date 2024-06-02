package pl.krystian.ecommerce.sales;

import pl.krystian.ecommerce.sales.cart.Cart;
import pl.krystian.ecommerce.sales.cart.HashMapCartStorage;
import pl.krystian.ecommerce.sales.reservation.AcceptOfferRequest;
import pl.krystian.ecommerce.sales.offering.Offer;
import pl.krystian.ecommerce.sales.offering.OfferCalculator;
import pl.krystian.ecommerce.sales.payment.PaymentDetails;
import pl.krystian.ecommerce.sales.payment.PaymentGateway;
import pl.krystian.ecommerce.sales.payment.RegisterPaymentRequest;
import pl.krystian.ecommerce.sales.reservation.Reservation;
import pl.krystian.ecommerce.sales.reservation.ReservationDetails;
import pl.krystian.ecommerce.sales.reservation.ReservationRepository;

import java.util.UUID;


public class SalesFacade {
    private HashMapCartStorage cartStorage;
    private OfferCalculator offerCalculator;
    private PaymentGateway paymentGateway;
    private ReservationRepository reservationRepository;

    public SalesFacade(HashMapCartStorage cartStorage, OfferCalculator offerCalculator,
                       PaymentGateway paymentGateway, ReservationRepository reservationRepository) {
        this.cartStorage = cartStorage;
        this.offerCalculator = offerCalculator;
        this.paymentGateway = paymentGateway;
        this.reservationRepository = reservationRepository;
    }

//    private Cart getCartForCustomer(String customerId) {
//        return cartStorage.loadForCustomer(customerId)
//                .orElse(Cart.empty());
//    }

    public Offer getCurrentOffer(String customerId) {
        Cart cart = cartStorage.loadForCustomer(customerId)
                .orElse(Cart.empty());

        Offer offer = offerCalculator.calculate(cart.getCartItems());

        return offer;
    }

    public void addProduct(String customerId, String productId) {
        Cart cart = cartStorage.loadForCustomer(customerId)
                .orElse(Cart.empty());

        cart.add(productId);
    }

    public ReservationDetails acceptOffer(String customerId, AcceptOfferRequest acceptOfferRequest) {
        String reservationId = UUID.randomUUID().toString();
        Offer offer = this.getCurrentOffer(customerId);

        PaymentDetails paymentDetails = paymentGateway.registerPayment(
                RegisterPaymentRequest.of(reservationId, acceptOfferRequest, offer.getTotal())
        );

        Reservation reservation = Reservation.of(
                reservationId,
                customerId,
                acceptOfferRequest,
                offer,
                paymentDetails);

        reservationRepository.add(reservation);

        return new ReservationDetails(reservationId, paymentDetails.getPaymentUrl());
    }


}
