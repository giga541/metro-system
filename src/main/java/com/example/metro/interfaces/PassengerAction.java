package main.java.com.example.metro.interfaces;
import main.java.com.example.metro.model.Passenger;

@FunctionalInterface
public interface PassengerAction {

    void perform(Passenger passenger);
}