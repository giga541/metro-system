package service;

import model.Passenger;
import model.Train;
import model.Ticket;
import model.Vehicle;

public class Booking {

    public void printVehicleType(Vehicle vehicle) {
        System.out.println("Vehicle type: " + vehicle.getType());
    }

    public void bookTicket(Passenger passenger, Train train, Ticket ticket) {

        if (train.getCapacity() > 0) {

            System.out.println("model.Ticket booked for " + passenger.getName());
            System.out.println("model.Train number: " + train.getTrainNumber());
            System.out.println("Price: " + ticket.getPrice());

        } else {

            System.out.println("No seats available");

        }

    }

}