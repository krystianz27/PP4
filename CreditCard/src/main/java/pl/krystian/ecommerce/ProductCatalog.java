package pl.krystian.ecommerce;

import java.math.BigDecimal;
import java.util.*;

public class ProductCatalog {
    private ArrayList<Product> products;

    public ProductCatalog() {
        this.products = new ArrayList<>();
    }

    public List<Product> allProducts() {
        return Collections.unmodifiableList(products);
    }

    public String addProduct(String name, String description) {
        UUID id = UUID.randomUUID();

        Product newProduct = new Product(id, name, description);
        products.add(newProduct);

        return id.toString();
//        return newProduct.getId();

    }

    public Product getProductBy(String id) {
        return products.stream().filter(product -> product.getId().equals(id))
                .findFirst()
                .get();
    }

    public void changePrice(String id, BigDecimal price) {
        Product loadedProduct = getProductBy(id);
        loadedProduct.changePrice(price);
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


