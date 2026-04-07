package com.solvd.metro.service;

public class MetroSystemSession implements AutoCloseable {

    private String sessionName;

    public MetroSystemSession(String sessionName) {
        this.sessionName = sessionName;
        System.out.println("Session opened: " + sessionName);
    }

    public void doWork() {
        System.out.println("Working in session: " + sessionName);
    }

    @Override
    public void close() {
        System.out.println("Session closed: " + sessionName);
    }
}