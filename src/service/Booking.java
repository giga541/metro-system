package service;

import exception.*;
import interfaces.Payable;
import model.*;
import interfaces.Scheduleable;
import interfaces.Moveable;

import java.math.BigDecimal;

public class Booking {

    public void bookTicket(Passenger passenger, Train train, Ticket ticket) throws TicketBookingException {

        if (passenger == null) {
            throw new PassengerNotFoundException("Passenger not found!");
        }

        if (train == null) {
            throw new TrainNotFoundException("Train not found!");
        }

        if (ticket.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidTicketPriceException("Ticket price must be greater than 0!");
        }

        if (train.getCapacity() <= 0) {
            throw new NoSeatsAvailableException("No seats available on train " + train.getTrainNumber());
        }

        try {
            ticket.book();
            System.out.println("Ticket booked for " + passenger.getName());
            System.out.println("Train number: " + train.getTrainNumber());
            System.out.println("Price: " + ticket.getPrice());
        } catch (Exception e) {
            throw new TicketBookingException("Booking failed unexpectedly: " + e.getMessage());
        }

        ticket.book();
        System.out.println("Ticket booked for " + passenger.getName());
        System.out.println("Train number: " + train.getTrainNumber());
        System.out.println("Price: " + ticket.getPrice());
    }

    public void processPayment(Payable payable) {
        System.out.println("Amount to pay: " + payable.getAmount());
        payable.processPayment();
    }

    public void startMoving(Moveable moveable) {
        moveable.move();
        System.out.println("Moving at speed: " + moveable.getSpeed());
    }

    public void showScheduleInfo(Scheduleable schedulable) {
        schedulable.addToSchedule();
        System.out.println(schedulable.getScheduleInfo());
    }

    public void printVehicleType(Vehicle vehicle) {
        System.out.println("Vehicle type: " + vehicle.getType());
    }
}