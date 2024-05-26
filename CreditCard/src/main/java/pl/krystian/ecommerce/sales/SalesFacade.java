package pl.krystian.ecommerce.sales;

import pl.krystian.ecommerce.sales.cart.Cart;
import pl.krystian.ecommerce.sales.cart.InMemoryCartStorage;
import pl.krystian.ecommerce.sales.offering.AcceptOfferRequest;
import pl.krystian.ecommerce.sales.offering.Offer;
import pl.krystian.ecommerce.sales.offering.OfferCalculator;
import pl.krystian.ecommerce.sales.reservation.ReservationDetail;

public class SalesFacade {
    private InMemoryCartStorage cartStorage;
    private OfferCalculator offerCalculator;

    public SalesFacade(InMemoryCartStorage cartStorage, OfferCalculator offerCalculator) {
        this.cartStorage = cartStorage;
        this.offerCalculator = offerCalculator;
    }

    public Offer getCurrentOffer(String customerId) {
        Cart cart = loadCartForCustomer(customerId);

        Offer currentOffer = offerCalculator.calculate(cart.getLines());

        return currentOffer;
    }

    public ReservationDetail acceptOffer(String customerId, AcceptOfferRequest acceptOfferRequest) {
        return new ReservationDetail();
    }

    public void addToCart(String customerId, String productId) {
        Cart cart = loadCartForCustomer(customerId);

        cart.addProduct(productId);

    }

    private Cart loadCartForCustomer(String customerId) {
        return cartStorage.findByCustomer(customerId)
                .orElse(Cart.empty());
    }
}
