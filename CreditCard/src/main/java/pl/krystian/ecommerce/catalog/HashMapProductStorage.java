package pl.krystian.ecommerce.catalog;

import java.util.HashMap;
import java.util.List;

public class HashMapProductStorage implements  ProductStorage {
    HashMap<String, Product> products;

    @Override
    public List<Product> allProducts() {
        return products.values()
                .stream()
                .toList();
    }

    @Override
    public void add(Product newProduct) {
        products.put(newProduct.getId(), newProduct);
    }

    @Override
    public Product getProductBy(String id) {
        return products.get(id);

    }

}
