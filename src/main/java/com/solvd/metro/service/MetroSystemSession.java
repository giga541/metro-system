package com.solvd.metro.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MetroSystemSession implements AutoCloseable {

    private static final Logger logger = LogManager.getLogger(MetroSystemSession.class);

    private String sessionName;

    public MetroSystemSession(String sessionName) {
        this.sessionName = sessionName;
        logger.info("Session opened: {}", sessionName);
    }

    public void doWork() {
        System.out.println("Working in session: " + sessionName);
    }

    @Override
    public void close() {
        System.out.println("Session closed: " + sessionName);
    }
}