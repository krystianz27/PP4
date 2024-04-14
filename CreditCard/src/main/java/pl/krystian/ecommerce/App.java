package pl.krystian.ecommerce;
import pl.krystian.ecommerce.catalog.HashMapProductStorage;
import pl.krystian.ecommerce.catalog.Product;
import pl.krystian.ecommerce.catalog.ProductCatalog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.krystian.ecommerce.catalog.ProductStorage;

import java.util.List;


@SpringBootApplication
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class,args);
    }

    @Bean
    ProductCatalog createMyProductCatalog(){
        ProductCatalog productCatalog = new ProductCatalog(new HashMapProductStorage());
//        ProductCatalog productCatalog = new ProductCatalog();

        productCatalog.addProduct("Legoset 1","Desc1");
        productCatalog.addProduct("Legoset 2","Desc2");
        return productCatalog;

    }
}