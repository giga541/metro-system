package enums;

public enum TrainStatus {

    ACTIVE("Train is running normally"),
    MAINTENANCE("Train is under maintenance"),
    OUT_OF_SERVICE("Train is out of service");

    private final String description;

    static {
        System.out.println("TrainStatus enum loaded");
    }

    TrainStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAvailable() {
        return this == ACTIVE;
    }
}