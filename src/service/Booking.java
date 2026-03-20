package service;

import model.*;

public class Booking {

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