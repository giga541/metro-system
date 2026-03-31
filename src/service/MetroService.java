package service;

import enums.TrainStatus;
import interfaces.PassengerAction;
import interfaces.TicketValidator;
import interfaces.TrainFilter;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class MetroService {

    public boolean validateTicket(Ticket ticket, TicketValidator validator) {
        return validator.validate(ticket);
    }

    public void performOnPassengers(List<Passenger> passengers, PassengerAction action) {
        for (Passenger passenger : passengers) {
            action.perform(passenger);
        }
    }

    // Predicate - filter trains by capacity
    public List<Train> getTrainsWithMinCapacity(List<Train> trains, int minCapacity) {
        Predicate<Train> hasEnoughCapacity = train -> train.getCapacity() >= minCapacity;
        List<Train> result = new ArrayList<>();
        for (Train train : trains) {
            if (hasEnoughCapacity.test(train)) {
                result.add(train);
            }
        }
        return result;
    }

    // Function - convert Train to summary String
    public String getTrainSummary(Train train) {
        Function<Train, String> trainToSummary = t ->
                "Train " + t.getTrainNumber() + " | Capacity: " + t.getCapacity() + " | Status: " + t.getStatus();
        return trainToSummary.apply(train);
    }

    // Consumer - print each passenger
    public void printAllPassengers(List<Passenger> passengers) {
        Consumer<Passenger> printPassenger = p ->
                System.out.println("Passenger: " + p.getName() + " | Seat: " + p.getSeatNumber());
        for (Passenger passenger : passengers) {
            printPassenger.accept(passenger);
        }
    }

    // Supplier - supply default ticket price
    public double getDefaultTicketPrice() {
        Supplier<Double> defaultPrice = () -> 1.50;
        return defaultPrice.get();
    }

    // BiFunction - calculate total price based on ticket type
    public double calculateTotalPrice(Passenger passenger, Ticket ticket) {
        BiFunction<Passenger, Ticket, Double> calculatePrice = (p, t) ->
                t.getAmount().doubleValue() * 1.1; // 10% service fee
        return calculatePrice.apply(passenger, ticket);
    }

    // custom lambda - TicketValidator
    public boolean validateTicket(Ticket ticket) {
        TicketValidator validator = t ->
                t.getPrice() != null && t.getAmount().doubleValue() > 0 && t.isAvailable();
        return validator.validate(ticket);
    }

    // custom lambda - TrainFilter
    public List<Train> filterTrains(List<Train> trains, TrainFilter filter) {
        List<Train> result = new ArrayList<>();
        for (Train train : trains) {
            if (filter.filter(train)) {
                result.add(train);
            }
        }
        return result;
    }

    // custom lambda - PassengerAction
    public void performOnPassengers(List<Passenger> passengers) {
        PassengerAction action = passenger ->
                System.out.println("Processing passenger: " + passenger.getName());
        for (Passenger passenger : passengers) {
            action.perform(passenger);
        }
    }

    public void runTask(Runnable task) {
        System.out.println("Starting task...");
        task.run();
        System.out.println("Task finished.");
    }
}