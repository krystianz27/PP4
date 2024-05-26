package pl.krystian.ecommerce.sales.cart;

public class CartLines {
    private String productId;
    private Integer qty;


    public CartLines(String productId, Integer qty) {
        this.productId = productId;
        this.qty = qty;
    }

    public String getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return qty;
    }

}
