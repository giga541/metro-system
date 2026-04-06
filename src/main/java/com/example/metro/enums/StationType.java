package main.java.com.example.metro.enums;

public enum StationType {

    TERMINAL("Terminal Station", true),
    JUNCTION("Junction Station", true),
    REGULAR("Regular Station", false);

    private final String description;
    private final boolean isTransferPoint;

    static {
        System.out.println("StationType enum loaded");
    }

    StationType(String description, boolean isTransferPoint) {
        this.description = description;
        this.isTransferPoint = isTransferPoint;
    }

    public String getDescription() { return description; }
    public boolean isTransferPoint() { return isTransferPoint; }

    public String getInfo() {
        return description + (isTransferPoint ? " - transfer available" : " - no transfer");
    }
}