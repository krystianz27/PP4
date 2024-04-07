package pl.krystian.ecommerce.catalog;

import org.junit.jupiter.api.Test;
import pl.krystian.ecommerce.catalog.Product;
import pl.krystian.ecommerce.catalog.ProductCatalog;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;


public class ProductCatalogTest {
    private ProductCatalog createProductCatalog() {
        return new ProductCatalog();
    }

    @Test
    void itAllowsListingProducts() {
        ProductCatalog catalog = createProductCatalog();

        List<Product> products = catalog.allProducts();

        assert products.isEmpty();
    }


    @Test
    void itAllowsToAddProduct() {
        ProductCatalog catalog = createProductCatalog();
        catalog.addProduct("Legoset 8083", "nice one");

        List<Product> allProducts = catalog.allProducts();
        assertThat(allProducts).hasSize(1);

    }


    @Test
    void itLoadSingleProductById() {
        ProductCatalog catalog = createProductCatalog();

        String id = catalog.addProduct("Legoset 8083", "nice one");

        Product loaded = catalog.getProductBy(id);
        assertThat(loaded.getId()).isEqualTo(id);
    }


    @Test
    void itAllowsToChangePrice() {
        ProductCatalog catalog = createProductCatalog();
        String id = catalog.addProduct("Legoset 8083", "nice one");

        catalog.changePrice(id, BigDecimal.valueOf(10.10));

        Product loaded = catalog.getProductBy(id);

        assertThat(loaded.getPrice()).isEqualTo(BigDecimal.valueOf(10.10));
    }
}
