package com.solvd.metro.service;

import com.solvd.metro.interfaces.PassengerAction;
import com.solvd.metro.interfaces.TicketValidator;
import com.solvd.metro.interfaces.TrainFilter;
import com.solvd.metro.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class MetroService {

    private static final Logger logger = LogManager.getLogger(MetroService.class);

    public boolean validateTicket(Ticket ticket, TicketValidator validator) {
        return validator.validate(ticket);
    }

    public void performOnPassengers(List<Passenger> passengers, PassengerAction action) {
        passengers.forEach(action::perform);
    }

    // Predicate - filter trains by capacity
    public List<Train> getTrainsWithMinCapacity(List<Train> trains, int minCapacity) {
        Predicate<Train> hasEnoughCapacity = train -> train.getCapacity() >= minCapacity;
        return trains.stream()
                .filter(hasEnoughCapacity)
                .collect(Collectors.toList());
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
                logger.info("Passenger: {} Seat: {}", p.getName(), p.getSeatNumber());
        passengers.forEach(printPassenger);
    }

    // Supplier - supply default ticket price
    public double getDefaultTicketPrice() {
        Supplier<Double> defaultPrice = () -> 1.50;
        return defaultPrice.get();
    }

    // BiFunction - calculate total price based on ticket type
    public double calculateTotalPrice(Passenger passenger, Ticket ticket) {
        BiFunction<Passenger, Ticket, Double> calculatePrice = (p, t) ->
                t.getAmount().doubleValue() * 1.1; // 10% com.solvd.metro.service fee
        return calculatePrice.apply(passenger, ticket);
    }

    // custom lambda - TrainFilter
    public List<Train> filterTrains(List<Train> trains, TrainFilter filter) {
        return trains.stream()
                .filter(filter::filter)
                .collect(Collectors.toList());
    }

    public void runTask(Runnable task) {
        logger.info("Starting task...");
        task.run();
        logger.info("Task finished.");
    }
}