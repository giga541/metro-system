package model;

public class Driver {

    private Driver driver;
    private Speed speed;

    private String driverName;
    private static int driverId;

    static {
        driverId = 107;
        System.out.println("model.Driver system initialized");
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public static int getDriverId() {
        return driverId;
    }

    public static void setDriverId(int driverId) {
        Driver.driverId = driverId;
    }
}