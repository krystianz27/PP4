package pl.krystian.ecommerce.sales.offering;

import pl.krystian.ecommerce.catalog.Product;
import pl.krystian.ecommerce.sales.cart.CartLines;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OfferCalculator {
//    private final Map<String, BigDecimal> productPrices;
//
//    public OfferCalculator(List<Product> products) {
//        this.productPrices = products.stream()
//                .collect(Collectors.toMap(Product::getId, Product::getPrice));
//    }

    public Offer calculate(List<CartLines> lines) {
        int itemsCount = lines.stream().mapToInt(CartLines::getQuantity).sum();
//        BigDecimal total = calculateTotal(lines);
        BigDecimal total = BigDecimal.ZERO;
        return new Offer(itemsCount, total);
    }

//    private BigDecimal calculateTotal(List<CartLines> lines) {
//        BigDecimal total = BigDecimal.ZERO;
//        for (CartLines line : lines) {
//            BigDecimal price = productPrices.getOrDefault(line.getProductId(), BigDecimal.ZERO);
//            BigDecimal productTotal = price.multiply(BigDecimal.valueOf(line.getQuantity()));
//            total = total.add(productTotal);
//        }
//        return total;
    }








//public class OfferCalculator {
//    public Offer calculate(List<CartLines> lines) {
//        int itemsCount = lines.stream().mapToInt(CartLines::getQuantity).sum();
//        BigDecimal total = calculateTotal(lines);
//
//        return new Offer(itemsCount, total);
//    }
//
//
//    private BigDecimal calculateTotal(List<CartLines> lines) {
//        BigDecimal total = BigDecimal.ZERO;
//        for (CartLines line : lines) {
//            BigDecimal productTotal = line.getProductPrice().multiply(BigDecimal.valueOf(line.getQuantity()));
//            total = total.add(productTotal);
//        }
//        return total;
//    }
//}
