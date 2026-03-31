package enums;

public enum PaymentMethod {

    CASH("Cash payment", false),
    CARD("Card payment", true),
    MOBILE("Mobile payment", true);

    private final String description;
    private final boolean isDigital;

    static {
        System.out.println("PaymentMethod enum loaded");
    }

    PaymentMethod(String description, boolean isDigital) {
        this.description = description;
        this.isDigital = isDigital;
    }

    public String getDescription() { return description; }
    public boolean isDigital() { return isDigital; }

    public String getPaymentInfo() {
        return description + (isDigital ? " (digital)" : " (physical)");
    }
}