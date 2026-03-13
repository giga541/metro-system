package model;

public class Driver {

    private static int totalDrivers = 0;

    private int driverId;
    private String driverName;

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

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
}