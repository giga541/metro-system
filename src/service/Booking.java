package service;

import model.Passenger;
import model.Train;
import model.Ticket;

public class Booking {

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