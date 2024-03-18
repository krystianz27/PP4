package pl.krystian.creditcard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pl.krystian.ecommerce.Product;
import pl.krystian.ecommerce.ProductCatalog;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;


public class ProductCatalogTest {
    @Test
    void itAllowsListingProducts() {
        ProductCatalog catalog = thereIsProductCatalog();

        List<Product> products = catalog.allProducts();

        assert products.isEmpty();
    }

    private ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog();
    }


    @Test
    void itAllowsToAddProduct() {
        ProductCatalog catalog = thereIsProductCatalog();
        catalog.addProduct("Legoset 8083", "nice one");

        List<Product> allProducts = catalog.allProducts();
        assertThat(allProducts).hasSize(1);

    }


    @Test
    void itLoadSingProductById() {
        ProductCatalog catalog = thereIsProductCatalog();

        String id = catalog.addProduct("Legoset 8083", "nice one");

        Product loaded = catalog.getProductBy(id);
        assertThat(loaded.getId()).isEqualTo(id);
    }


    @Test
    void itAllowsToChangePrice() {
        ProductCatalog catalog = thereIsProductCatalog();
        String id = catalog.addProduct("Legoset 8083", "nice one");

        catalog.changePrice(id, BigDecimal.valueOf(10.10));

        Product loaded = catalog.getProductBy(id);

        assertThat(loaded.getPrice()).isEqualTo(BigDecimal.valueOf(10.10));
    }
}
