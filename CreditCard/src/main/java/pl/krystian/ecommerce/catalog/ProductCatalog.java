package pl.krystian.ecommerce.catalog;

import java.math.BigDecimal;
import java.util.*;

public class ProductCatalog{
    ProductStorage productStorage;

    public ProductCatalog(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    public List<Product> allProducts() {
        return productStorage.allProducts();
    }

    public String addProduct(String name, String description) {
        UUID id = UUID.randomUUID();

        Product newProduct = new Product(id, name, description);
        productStorage.add(newProduct);

        return newProduct.getId();
    }

    public Product getProductBy(String id) {
        return productStorage.getProductBy(id);
    }

    public void changePrice(String id, BigDecimal newPrice) {
        Product loadedProduct = this.getProductBy(id);
        loadedProduct.changePrice(newPrice);
    }

    public void publishProduct(String productId) {
        Product product = getProductBy(productId);

        if (product.getImage() == null) {
            throw new ProductCantBePublishedException();
        }

        if (product.getPrice() == null) {
            throw new ProductCantBePublishedException();
        }

        product.setOnline(true);
    }


}


