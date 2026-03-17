package model;

public class Driver extends Person {

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