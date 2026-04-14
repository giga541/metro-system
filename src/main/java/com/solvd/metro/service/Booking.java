package com.solvd.metro.service;

import com.solvd.metro.exception.*;
import com.solvd.metro.interfaces.Payable;
import com.solvd.metro.model.*;
import com.solvd.metro.interfaces.Scheduleable;
import com.solvd.metro.interfaces.Moveable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class Booking {

    private static final Logger logger = LogManager.getLogger(Booking.class);

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
            logger.info("Ticket booked for {}", passenger.getName());
            logger.info("Train number: {}", train.getTrainNumber());
            logger.info("Price: {}", ticket.getPrice());
        } catch (Exception e) {
            throw new TicketBookingException("Booking failed unexpectedly: " + e.getMessage());
        }

        ticket.book();
        logger.info("Ticket booked for {}", passenger.getName());
        logger.info("Train number: {}", train.getTrainNumber());
        logger.info("Price: ", ticket.getPrice());
    }

    public void processPayment(Payable payable) {
        logger.info("Amount to pay: {}", payable.getAmount());
        payable.processPayment();
    }

    public void startMoving(Moveable moveable) {
        moveable.move();
        logger.info("Moving at speed: {}", moveable.getSpeed());
    }

    public void showScheduleInfo(Scheduleable schedulable) {
        schedulable.addToSchedule();
        logger.info(schedulable.getScheduleInfo());
    }

    public void printVehicleType(Vehicle vehicle) {
        logger.info("Vehicle type: {}", vehicle.getType());
    }
}