package model;

import interfaces.Identifiable;

public class Driver extends Person implements Identifiable {

    @Override
    public int getId() {
        return driverId;
    }

    @Override
    public String getType() {
        return "Driver";
    }

    private static int totalDrivers = 0;

    private int driverId;

    static {
        totalDrivers = 0;
        System.out.println("Driver class initialized");
    }

    public Driver() {
        totalDrivers++;
        this.driverId = totalDrivers;
    }

    public static int getTotalDrivers() {
        return totalDrivers;
    }

    public int getDriverId() {
        return driverId;
    }
}