package com.solvd.metro.service;

public class Connection {

    private final int id;

    public Connection(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Connection{id=" + id + "}";
    }
}