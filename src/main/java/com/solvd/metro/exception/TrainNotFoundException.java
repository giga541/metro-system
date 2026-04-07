package com.solvd.metro.exception;

public class TrainNotFoundException extends RuntimeException {

    public TrainNotFoundException(String message) {
        super(message);
    }
}
