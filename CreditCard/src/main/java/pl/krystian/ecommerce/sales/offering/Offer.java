package pl.krystian.ecommerce.sales.offering;

import java.math.BigDecimal;

public class Offer {

    private int itemsCount;
    private BigDecimal total;

    public Offer(int itemsCount, BigDecimal total) {
        this.itemsCount = itemsCount;
        this.total = total;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public BigDecimal getTotal() {
        return total;
    }

//    public int getItemsCount() {
//        return 0;
//    }

//    public BigDecimal getTotal() {
//        return BigDecimal.ZERO;
//    }
}
