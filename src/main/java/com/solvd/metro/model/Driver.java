package com.solvd.metro.model;

import com.solvd.metro.Main;
import com.solvd.metro.interfaces.Identifiable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Driver extends Person implements Identifiable {

    private static final Logger logger = LogManager.getLogger(Driver.class);

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
        logger.info("Driver class initialized");
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