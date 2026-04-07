package com.solvd.metro.enums;

public enum TrainStatus {

    ACTIVE("Train is running normally"),
    MAINTENANCE("Train is under maintenance"),
    OUT_OF_SERVICE("Train is out of com.solvd.metro.service");

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