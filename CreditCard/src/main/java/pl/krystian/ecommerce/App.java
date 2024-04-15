package pl.krystian.ecommerce;
import pl.krystian.ecommerce.catalog.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//import java.util.List;


@SpringBootApplication
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class,args);
    }

    @Bean
    ProductCatalog createMyProductCatalog(){
//        ProductCatalog productCatalog = new ProductCatalog(new HashMapProductStorage());
        ProductCatalog productCatalog = new ProductCatalog(new ArrayListProductStorage());

        productCatalog.addProduct("Legoset 1","Desc1");
        productCatalog.addProduct("Legoset 2","Desc2");
        return productCatalog;

    }
}