package rules;

import java.util.Map;

import static helper.StringValueHelper.*;

/**
 * Class contains methods for validation data from the products.yml & rules.yml
 */
public class PropertiesValidator {

    /**
     * Common method to validate product name & product price into product.yml file
     *
     * @param data     yaml content
     * @param products products map
     */
    public void productDataValidator(Map<String, Map<String, Object>> data,
                                     Map<String, Product> products) {
        for (Map.Entry<String, Map<String, Object>> product : data.entrySet()) {
            String productCode = product.getKey();
            String productName = productNameValidator(product);
            productPriceValidator(product, productCode, productName, products);
        }
    }

    /**
     * Method for product price validation:
     * Handle: double parsing
     * Handle: zero or less product price
     *
     * @param product     current product object
     * @param productCode product code
     * @param productName product name
     * @param products    products map
     */
    private void productPriceValidator(Map.Entry<String, Map<String, Object>> product,
                                       String productCode,
                                       String productName,
                                       Map<String, Product> products) {
        try {
            double productPrice = (double) product.getValue().get(PRODUCT_PRICE_NAME);
            if (productPrice <= 0) { //TODO: not sure regarding price=0.0, maybe this is a valid case, something like a free price
                System.out.printf("Found that price value = '%s' into product.yml across to %s product code is setup " +
                        "to incorrect value%n%n", productPrice, product.getKey());
                System.err.printf("Please update price = '%s' across to '%s' product code on correct " +
                        "value in product.yml file and restart a application%n", productPrice, product.getKey());
                throw new IllegalArgumentException(INVALID_PRICE);
            }
            products.put(productCode, new Product(productCode, productName, productPrice));
        } catch (Exception e) {
            System.out.println("Found that price value into product.yml cannot been parsed to double");
            System.err.println("Please update price in product.yml and restart a application");
            throw new IllegalArgumentException(INVALID_PRICE_PARSING);
        }
    }

    /**
     * Method for product name validation:
     * Handle: product name is null or empty
     *
     * @param product current product object
     * @return product name from products.yml
     */
    private String productNameValidator(Map.Entry<String, Map<String, Object>> product) {
        String productName = (String) product.getValue().get(PRODUCT_NAME);
        if (!productName.isEmpty()) {
            return (String) product.getValue().get(PRODUCT_NAME);
        } else {
            System.out.println("Found that product name value is empty");
            System.err.printf("Please fill price with not empty value across to '%s' product code" +
                    " in product.yml file and restart a application%n", product.getKey());
            throw new IllegalArgumentException(INVALID_PRICE);
        }
    }

    /**
     * Method for rule quantity validation:
     * Handle: integer parsing
     * Handle: quantity is zero or less
     *
     * @param rule                current rule
     * @param quantityForDiscount constant with name of field
     * @return expected quantity for discount from rules.yml
     */
    public int ruleDataQuantityValidator(Map.Entry<String, Map<String, Object>> rule,
                                         String quantityForDiscount) {
        int expectedQuantityForDiscount;
        try {
            expectedQuantityForDiscount = (int) rule.getValue().get(quantityForDiscount);
            if (expectedQuantityForDiscount <= 0) {
                System.out.println("Found that some rule contains '0' or less value");
                System.err.println("Please update rule on correct value in rules.yml file and restart a application");
                throw new IllegalArgumentException(INVALID_RULE_TYPE);
            }
            return expectedQuantityForDiscount;
        } catch (Exception e) {
            System.out.println("Found that numToBuy/numFree value into rules.yml cannot been parsed to integer");
            System.err.println("Please update numToBuy/numFree in rules.yml and restart a application");
            throw new IllegalArgumentException(INVALID_PRICE_PARSING);
        }
    }

    /**
     * Method for rule reduced original price validation:
     * Handle: double parsing
     * Handle: zero or less validation
     * @param rule current rule
     * @return reduced price from rules.yml
     */
    public double ruleDataReducedPriceValidator(Map.Entry<String, Map<String, Object>> rule) {
        double reducedPrice;
        try {
            reducedPrice = (double) rule.getValue().get(NEW_PRICE);
            if (reducedPrice <= 0.0) {
                System.out.println("Found that some rule 'newPrice' contains '0' or less value");
                System.err.println("Please update rule on correct value in rules.yml file and restart a application");
                throw new IllegalArgumentException(INVALID_RULE_TYPE);
            }
            return reducedPrice;
        } catch (Exception e) {
            System.out.println("Found that 'newPrice' value into rules.yml cannot been parsed to double");
            System.err.println("Please update 'newPrice' in rules.yml and restart a application");
            throw new IllegalArgumentException(INVALID_RULE_PRICE_PARSING);
        }
    }

    /**
     * Method for rule fraction validation:
     * Handle: double parsing
     * Handle: zero or less validation
     * @param rule current rule
     * @return fraction(percentage) from rules.yml
     */
    public double ruleDataFractionValidation(Map.Entry<String, Map<String, Object>> rule) {
        double fraction;
        try {
            fraction = (double) rule.getValue().get(RULE_FRACTION);
            if (fraction <= 0.0) {
                System.out.println("Found that some rule 'fraction' contains '0' or less value");
                System.err.println("Please update rule on correct value in rules.yml file and restart a application");
                throw new IllegalArgumentException(INVALID_FRACTION_VALUE);
            }
            return fraction;
        } catch (Exception e) {
            System.out.println("Found that 'fraction' value into rules.yml cannot been parsed to double");
            System.err.println("Please update 'fraction' in rules.yml and restart a application");
            throw new IllegalArgumentException(INVALID_FRACTION_VALUE);
        }
    }
}
