package pl.krystian.ecommerce.sales.offering;

import pl.krystian.ecommerce.sales.cart.CartItem;

import java.math.BigDecimal;
import java.util.List;

public class OfferCalculator {
//    private final Map<String, BigDecimal> productPrices;
//
//    public OfferCalculator(List<Product> products) {
//        this.productPrices = products.stream()
//                .collect(Collectors.toMap(Product::getId, Product::getPrice));
//    }

    public Offer calculate(List<CartItem> lines) {
        int itemsCount = lines.stream().mapToInt(CartItem::getQuantity).sum();
//        BigDecimal total = calculateTotal(lines);
        BigDecimal total = BigDecimal.ZERO;
//        return new Offer(itemsCount, total)
        return new Offer(itemsCount, total);
    }


//    private BigDecimal calculateTotal(List<CartItem> lines) {
//        BigDecimal total = BigDecimal.ZERO;
//        for (CartItem line : lines) {
//            BigDecimal price = productPrices.getOrDefault(line.getProductId(), BigDecimal.ZERO);
//            BigDecimal productTotal = price.multiply(BigDecimal.valueOf(line.getQuantity()));
//            total = total.add(productTotal);
//        }
//        return total;
    }








//public class OfferCalculator {
//    public Offer calculate(List<CartItem> lines) {
//        int itemsCount = lines.stream().mapToInt(CartItem::getQuantity).sum();
//        BigDecimal total = calculateTotal(lines);
//
//        return new Offer(itemsCount, total);
//    }
//
//
//    private BigDecimal calculateTotal(List<CartItem> lines) {
//        BigDecimal total = BigDecimal.ZERO;
//        for (CartItem line : lines) {
//            BigDecimal productTotal = line.getProductPrice().multiply(BigDecimal.valueOf(line.getQuantity()));
//            total = total.add(productTotal);
//        }
//        return total;
//    }
//}
