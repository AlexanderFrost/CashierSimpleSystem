package helper;

/**
 * Helper contains literal/numbers constants for reusable
 */
public class StringValueHelper {
    public static final String ICON_TEST_ANSI = "💡";
    public static final double DELTA = 0.01;
    public static final String EMPTY_STRING = "";
    public static final String DONE = "done";
    public static final String PRODUCT_PRICE_NAME = "price";
    public static final String PRODUCT_NAME = "name";

    public static final String FREE_RULE_TYPE = "FreeRule";
    public static final String REDUCED_RULE_TYPE = "ReducedPriceRule";
    public static final String FRACTION_RULE_TYPE = "FractionPriceRule";

    public static final String GREEN_TEA = "Green Tea";
    public static final String STRAWBERRIES = "Strawberries";
    public static final String COFFEE = "Coffee";

    public static final String QUANTITY_FOR_DISCOUNT = "numToBuy";
    public static final String FREE_QUANTITY = "numFree";
    public static final String NEW_PRICE = "newPrice";
    public static final String RULE_FRACTION = "fraction";

    public static final String PRODUCTS_PATH = "priv/assets/products.yml";
    public static final String RULES_PATH = "priv/assets/rules.yml";

    public static final String INVITATION_TO_ENTER_PRODUCT_CODE = "Enter product code or type 'done' to finish: ";
    public static final String INVITATION_TO_ENTER_QUANTITY = "Enter quantity of product: ";
    public static final String INVALID_PRODUCT_CODE = "Invalid product code: ";
    public static final String INVALID_PRICE = "Invalid product price: ";
    public static final String INVALID_PRICE_PARSING = "Invalid product price parsing: ";
    public static final String INVALID_RULE_PRICE_PARSING = "Invalid rule price parsing: ";
    public static final String INVALID_RULE_TYPE = "Invalid discount rule type: ";
    public static final String INVALID_FRACTION_VALUE = "Invalid fraction value: ";
    public static final String CANNOT_CONVERT_PRODUCT_CODE = "Product quantity cannot be negative or zero";
    public static final String CANNOT_CONVERT_QUANTITY = "Cannot convert quantity to integer type, " +
            "please use a correct type.";

    public static final String POUND_CURRENCY = "£";
    public static final String DISCOUNT_CAPTION = "Was applied the following discount: ";
    public static final String PRICE_WITHOUT_DISCOUNT_CAPTION = "Price without discount";
    public static final String TOTAL_DISCOUNT_CAPTION = "Total discount";
    public static final String CLI_HEADER = "************** CASHIER SIMPLE SYSTEM **************";
    public static final String SEPARATOR = "-------------------------------------------";
    public static final String CLI_FOOTER = "************** TOTAL BILL *************************";
}
