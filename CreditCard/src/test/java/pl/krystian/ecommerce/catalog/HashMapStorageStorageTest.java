package pl.krystian.ecommerce.catalog;

import org.junit.jupiter.api.Test;
import java.util.UUID;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class HashMapStorageStorageTest {
    @Test
    void itAllowsToStoreProduct(){
        Product product = thereIsExampleProduct();
        ProductStorage hashmapStorage = thereIsHashMapStorage();

        hashmapStorage.add(product);

        List<Product> products = hashmapStorage.allProducts();
        assertThat(products)
                .hasSize(1)
                .extracting(Product::getName)
                .contains("test-it");
    }

    private ProductStorage thereIsHashMapStorage() {
        return null;
    }

    private Product thereIsExampleProduct() {
        return null;
    }

    @Test
    void itAllowsToLoadAllProduct(){}
    @Test
    void itAllowsToLoadProductById(){}
}
