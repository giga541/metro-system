package com.solvd.metro.interfaces;
import com.solvd.metro.model.Passenger;

@FunctionalInterface
public interface PassengerAction {

    void perform(Passenger passenger);
}