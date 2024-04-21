package pl.krystian.ecommerce.catalog;

import org.junit.jupiter.api.Test;
import java.util.UUID;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class HashMapStorageStorageTest {
    private ProductStorage thereIsHashMapStorage() {
        return new HashMapProductStorage();
    }

    private Product thereIsExampleProduct() {
        return new Product(UUID.randomUUID(), "Test", "desc");
    }
    @Test
    void itAllowsToStoreProduct(){
        Product product = thereIsExampleProduct();
        ProductStorage hashmapStorage = thereIsHashMapStorage();

        hashmapStorage.add(product);

        List<Product> products = hashmapStorage.allProducts();
        assertThat(products)
                .hasSize(1)
                .extracting(Product::getName)
                .contains("Test");
    }


    @Test
    void itAllowsToLoadAllProduct(){}
    @Test
    void itAllowsToLoadProductById(){}
}
