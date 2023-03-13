package rules.discount;

import helper.ProductEnum;
import helper.StringValueHelper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import rules.DiscountRule;
import rules.Product;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class FractionPriceRule implements DiscountRule {

    private final int numToBuy;
    private final double fraction;

    public String getType() {
        return StringValueHelper.FRACTION_RULE_TYPE;
    }

    /**
     * Method apply discount: Buy > N products, pay X% of the original price
     * @param productQuantity product quantity
     * @param products products map
     * @return discount value
     */
    public double calculateDiscount(Map<String, Integer> productQuantity,
                                    Map<String, Product> products) {
        double discount = 0.0;
        for (Map.Entry<String, Integer> productItem : productQuantity.entrySet()) {
            String code = productItem.getKey();
            if (code.equals(ProductEnum.COFFEE_CODE.getValue())) {
                int quantity = productItem.getValue();
                if (quantity >= numToBuy) {
                    discount += quantity * products.get(code).getPrice() * fraction / 100;
                }
            }
        }
        return discount;
    }
}
