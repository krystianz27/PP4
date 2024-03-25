package pl.krystian.ecommerce.catalog;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getId() {
        Product product = new Product(UUID.randomUUID(),"Product1", "Desc1");
        assertEquals(product.getName(), "Product1");
        assertEquals(product.getDescription(), "Desc1");
        System.out.println(product.getUUID());
        System.out.println(product.getId());
    }

//    @Test
//    void getUUID() {
//    }
//
//    @Test
//    void getName() {
//    }
//
//    @Test
//    void getPrice() {
//    }
//
//    @Test
//    void changePrice() {
//    }
//
//    @Test
//    void getImage() {
//    }
//
//    @Test
//    void setImage() {
//    }
//
//    @Test
//    void setOnline() {
//    }
//
//    @Test
//    void getOnline() {
//    }
//
//    @Test
//    void getDescription() {
//    }
}