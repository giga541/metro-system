public class Driver {

    private String driverName;
    private static int driverId;

    static {
        driverId = 107;
        System.out.println("Driver system initialized");
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