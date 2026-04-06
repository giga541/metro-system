package main.java.com.example.metro.enums;

public enum TicketType {

    SINGLE("Single Journey", 1),
    DAILY("Daily Pass", 10),
    MONTHLY("Monthly Pass", 200);

    private final String description;
    private final int maxJourneys;

    static {
        System.out.println("TicketType enum loaded");
    }

    TicketType(String description, int maxJourneys) {
        this.description = description;
        this.maxJourneys = maxJourneys;
    }

    public String getDescription() { return description; }
    public int getMaxJourneys() { return maxJourneys; }

    public boolean isUnlimited() {
        return this == MONTHLY;
    }
}