package pl.krystian.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.krystian.ecommerce.catalog.ArrayListProductStorage;
import pl.krystian.ecommerce.catalog.ProductCatalog;
import pl.krystian.ecommerce.infrastructure.PayUPaymentGw;
import pl.krystian.ecommerce.sales.SalesFacade;
import pl.krystian.ecommerce.sales.cart.HashMapCartStorage;
import pl.krystian.ecommerce.sales.offering.OfferCalculator;
import pl.krystian.ecommerce.sales.reservation.CartStorage;
import pl.krystian.ecommerce.sales.reservation.ReservationRepository;

import java.math.BigDecimal;


@SpringBootApplication
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class,args);
    }

    @Bean
    ProductCatalog createCatalog(){
        ProductCatalog catalog = new ProductCatalog(new ArrayListProductStorage());

        var pid1 = catalog.addProduct("Legoset 1","Desc1");
        catalog.changePrice(pid1, BigDecimal.valueOf(100.10));

        var pid2 = catalog.addProduct("Legoset 2","Desc2");
        catalog.changePrice(pid2, BigDecimal.valueOf(50.10));

        return catalog;
    }

    @Bean
    SalesFacade createMySalesFacade() {
//        InMemoryCartStorage cartStorage = new InMemoryCartStorage();
//        OfferCalculator offerCalculator = new OfferCalculator();
//        return  new SalesFacade(cartStorage, offerCalculator);
        return new SalesFacade(
                new HashMapCartStorage(),
                new OfferCalculator(),
                new PayUPaymentGw(),
                new ReservationRepository()
    );
    }
}