package com.solvd.metro;

import com.solvd.metro.constants.Constants;
import com.solvd.metro.enums.*;
import com.solvd.metro.exception.TicketBookingException;
import com.solvd.metro.exception.TrainNotFoundException;
import com.solvd.metro.interfaces.Bookable;
import com.solvd.metro.interfaces.Identifiable;
import com.solvd.metro.model.*;
import com.solvd.metro.records.TrainSchedule;
import com.solvd.metro.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {

//        // Speed
//        Speed speed = new Speed("model3", 90);
//        logger.info("Train model: {} speed: {}", speed.getTrainModel(), speed.getTrainSpeed());
//
//        // Drivers
//        Driver driver = new Driver();
//        driver.setName("Mike");
//        Driver driver2 = new Driver();
//        driver2.setName("John");
//        logger.info("Driver name: {}", driver.getName());
//        logger.info("DriverId: {}", driver.getDriverId());
//        logger.info("Total drivers: {}", Driver.getTotalDrivers());
//
//        // Passengers
//        Passenger passenger1 = new Passenger();
//        passenger1.setName("Giga");
//        passenger1.setSeatNumber("A1");
//        Passenger passenger2 = new Passenger();
//        passenger2.setName("John");
//        passenger2.setSeatNumber("B2");
//
//        // Trains
//        Train train1 = new Train();
//        train1.setTrainNumber(101);
//        train1.setCapacity(50);
//        Train train2 = new Train();
//        train2.setTrainNumber(102);
//        train2.setCapacity(80);
//        train1.setSpeed(speed);
//        train1.setStatus(TrainStatus.ACTIVE);
//        train2.setStatus(TrainStatus.MAINTENANCE);
//        logger.info("{} status: {}", train1.getTrainNumber(), train1.getStatus().getDescription());
//        logger.info("{} status: {}", train2.getTrainNumber(), train2.getStatus().getDescription());
//        logger.info("Is train1 available? {}", train1.getStatus().isAvailable());
//
//        // Tickets
//        Ticket ticket1 = new Ticket();
//        ticket1.setPrice(new BigDecimal("2.50"));
//        ticket1.setPurchaseTime(LocalDateTime.now());
//        Ticket ticket2 = new Ticket();
//        ticket2.setPrice(new BigDecimal("3.50"));
//        ticket2.setPurchaseTime(LocalDateTime.now());
//        ticket1.setTicketType(TicketType.SINGLE);
//        ticket2.setTicketType(TicketType.MONTHLY);
//        logger.info("Ticket type: {}", ticket1.getTicketType().getDescription());
//        logger.info("Is unlimited? {}", ticket2.getTicketType().isUnlimited());
//
//        // Booking
//        Booking booking = new Booking();
//        try {
//            booking.bookTicket(passenger1, train1, ticket1);
//        } catch (TicketBookingException e) {
//            logger.error("Booking failed: {}", e.getMessage());
//        } finally {
//            logger.info("Booking attempt finished");
//        }
//
//        // AutoCloseable
//        try (MetroSystemSession session = new MetroSystemSession("Main Session")) {
//            session.doWork();
//        } catch (Exception e) {
//            logger.error("Session error: {}", e.getMessage());
//        } finally {
//            logger.info("Session block finished");
//        }
//
//        // Platforms and Stations
//        Platform platform1 = new Platform();
//        platform1.setPlatformNumber(1);
//        Platform platform2 = new Platform();
//        platform2.setPlatformNumber(2);
//
//        Station station1 = new Station();
//        station1.setLocation("Central Station");
//        station1.setCity("Tbilisi");
//        station1.addPlatform(platform1);
//        Station station2 = new Station();
//        station2.setLocation("North Station");
//        station2.setCity("Tbilisi");
//        station2.addPlatform(platform2);
//        station1.setStationType(StationType.TERMINAL);
//        station2.setStationType(StationType.JUNCTION);
//        logger.info("Station type: {}", station1.getStationType().getInfo());
//
//        // Schedule
//        Schedule schedule = new Schedule();
//        schedule.addTrainSchedule(new TrainSchedule(train1, LocalDateTime.now(), LocalDateTime.now().plusMinutes(30)));
//        schedule.addTrainSchedule(new TrainSchedule(train2, LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(1).plusMinutes(30)));
//
//        // Lines with stations
//        Line line1 = new Line();
//        line1.setLineName("Red Line");
//        line1.setSchedule(schedule);
//        line1.addStation(station1);
//        line1.addStation(station2);
//        Line line2 = new Line();
//        line2.setLineName("Blue Line");
//        line1.setColor(LineColor.RED);
//        logger.info("Line color: {}", line1.getColor().getDisplayName());
//
//        // Payment
//        Payment payment = new Payment();
//        payment.setPaymentMethod(PaymentMethod.CARD);
//        logger.info("Payment: {}", payment.getPaymentMethod().getPaymentInfo());
//
//        // Metro System
//        MetroSystem metro = new MetroSystem();
//        metro.addTrain(train1);
//        metro.addTrain(train2);
//        metro.addPassenger(passenger1);
//        metro.addPassenger(passenger2);
//        metro.addLine(line1);
//        metro.addLine(line2);
//        metro.addTicket(ticket1);
//        metro.addTicket(ticket2);
//
//        // Vehicle array with parent type - polymorphism
//        metro.addVehicle(train1);
//        metro.addVehicle(new Bus());
//
//        logger.info("--- Metro System ---");
//        logger.info("Train 1: {}", metro.getTrains().get(0));
//        logger.info("Train 2: {}", metro.getTrains().get(1));
//        logger.info("Passenger 1: {}", metro.getPassengers().get(0));
//        logger.info("Passenger 2: {}", metro.getPassengers().get(1));
//        logger.info("Station 1: {}", line1.getStations().get(0));
//        logger.info("Station 2: {}", line1.getStations().get(1));
//        logger.info("Ticket 1 price: {}", metro.getTickets().get(0).getPrice());
//        logger.info("Ticket 2 price: {}", metro.getTickets().get(1).getPrice());
//
//        logger.info("--- Schedule for {} ---", line1.getLineName());
//        for (TrainSchedule ts : schedule.getTrainSchedules()) {
//            logger.info("Train: {} | Arrival: {} | Departure: {}", ts.train().getTrainNumber(), ts.arrivalTime(), ts.departureTime());
//        }
//
//        logger.info("--- Polymorphism ---");
//        booking.printVehicleType(train1);
//        booking.printVehicleType(new Bus());
//
//        logger.info("--- Equals & HashCode ---");
//        Train train3 = new Train();
//        train3.setTrainNumber(101);
//        logger.info("train1 equals train3: {}", train1.equals(train3));
//        logger.info("train1 hashCode: {}", train1.hashCode());
//        logger.info("train3 hashCode: {}", train3.hashCode());
//
//        logger.info("toString: {}", train1);
//        logger.info("toString: {}", passenger1);
//        logger.info("toString: {}", station1);
//
//        // interfaces - polymorphism via method parameter
//        Booking book = new Booking();
//        book.startMoving(train1);
//        book.processPayment(ticket1);
//        book.showScheduleInfo(line1);
//
//        // Identifiable
//        Identifiable identifiable = train1;
//        logger.info("ID: {}", identifiable.getId());
//        logger.info("Type: {}", identifiable.getType());
//
//        // Bookable
//        Bookable bookable = ticket1;
//        logger.info("Is available: {}", bookable.isAvailable());
//        bookable.book();
//        logger.info("Is available after booking: {}", bookable.isAvailable());
//
//        // final class constant
//        logger.info("Metro name: {}", Constants.METRO_NAME);
//        logger.info("Max capacity: {}", Constants.MAX_CAPACITY);
//
//        // final method
//        passenger1.printInfo();
//
//        // find a specific train's schedule
//        try {
//            TrainSchedule ts = schedule.findByTrain(101);
//            logger.info("Train: {}", ts.train().getTrainNumber());
//            logger.info("Arrives at: {}", ts.arrivalTime());
//            logger.info("Departs at: {}", ts.departureTime());
//        } catch (TrainNotFoundException e) {
//            logger.error("Error: {}", e.getMessage());
//        } finally {
//            logger.info("Schedule search finished");
//        }
//
//        // Generics
//        Pair<Passenger, Ticket> passengerTicket1 = new Pair<>(passenger1, ticket1);
//        Pair<Passenger, Ticket> passengerTicket2 = new Pair<>(passenger2, ticket2);
//        logger.info("Passenger: {} | Ticket price: {}", passengerTicket1.getFirst().getName(), passengerTicket1.getSecond().getPrice());
//        logger.info("Passenger: {} | Ticket price: {}", passengerTicket2.getFirst().getName(), passengerTicket2.getSecond().getPrice());
//
//        Container<Train> activeTrain = new Container<>("Active", train1);
//        Container<Train> maintenanceTrain = new Container<>("Under Maintenance", train2);
//        logger.info("Train status: {} -> {}", activeTrain.getLabel(), activeTrain.getItem().getTrainNumber());
//        logger.info("Train status: {} -> {}", maintenanceTrain.getLabel(), maintenanceTrain.getItem().getTrainNumber());
//
//        // MetroService
//        MetroService metroService = new MetroService();
//
//        // Runnable
//        logger.info("--- Runnable Tasks ---");
//        metroService.runTask(() -> logger.info("Checking all train statuses..."));
//        metroService.runTask(() -> metro.printSystemInfo());
//
//        // Predicate
//        logger.info("--- Trains with capacity >= 60 ---");
//        List<Train> bigTrains = metroService.getTrainsWithMinCapacity(metro.getTrains(), 60);
//        for (Train t : bigTrains) {
//            logger.info("{} capacity: {}", t.getTrainNumber(), t.getCapacity());
//        }
//
//        // Function
//        logger.info("--- Train Summaries ---");
//        logger.info(metroService.getTrainSummary(train1));
//        logger.info(metroService.getTrainSummary(train2));
//
//        // Consumer
//        logger.info("--- All Passengers ---");
//        metroService.printAllPassengers(metro.getPassengers());
//
//        // Supplier
//        logger.info("--- Default Ticket Price ---");
//        logger.info("Default price: {}", metroService.getDefaultTicketPrice());
//
//        // BiFunction
//        logger.info("--- Total Price with Service Fee ---");
//        logger.info("Total: {}", metroService.calculateTotalPrice(passenger1, ticket1));
//
//        // Filter Trains
//        logger.info("--- Filter Trains (caller decides) ---");
//        List<Train> activeTrains = metroService.filterTrains(metro.getTrains(), t -> t.getStatus() == TrainStatus.ACTIVE);
//        List<Train> highCapacityTrains = metroService.filterTrains(metro.getTrains(), t -> t.getCapacity() >= 60);
//        List<Train> specificTrain = metroService.filterTrains(metro.getTrains(), t -> t.getTrainNumber() == 101);
//        for (Train t : activeTrains) {
//            logger.info("Active train: {}", t.getTrainNumber());
//        }
//        for (Train t : highCapacityTrains) {
//            logger.info("High capacity train: {}", t.getTrainNumber());
//        }
//        for (Train t : specificTrain) {
//            logger.info("Specific train: {}", t.getTrainNumber());
//        }
//
//        // Validate Tickets
//        logger.info("--- Validate Tickets (caller decides) ---");
//        logger.info("Ticket1 valid? {}", metroService.validateTicket(ticket1, t -> t.getPrice() != null && t.getAmount().doubleValue() > 0 && t.isAvailable()));
//        logger.info("Ticket2 valid? {}", metroService.validateTicket(ticket2, t -> t.getTicketType() == TicketType.MONTHLY));
//
//        // Passenger Actions
//        logger.info("--- Passenger Actions (caller decides) ---");
//        metroService.performOnPassengers(metro.getPassengers(), p -> logger.info("Boarding: {}", p.getName()));
//        metroService.performOnPassengers(metro.getPassengers(), p -> logger.info("Checking ticket for: {}", p.getName()));
//
//        // System Info
//        logger.info("--- System Info ---");
//        metro.printSystemInfo();
//        metro.printFirstElements();
//
//        // Reflection
//        ReflectionService reflectionService = new ReflectionService();
//        reflectionService.extractInfo(Train.class);
//        reflectionService.createObjectAndCallMethod();
//
//        // Optional
//        Optional<Train> optionalTrain = reflectionService.createTrainWithReflection();
//        if (optionalTrain.isPresent()) {
//            logger.info("Train created via reflection: {}", optionalTrain.get().getTrainNumber());
//        } else {
//            logger.info("Train could not be created");
//        }
//        optionalTrain.ifPresent(t -> logger.info("Train type: {}", t.getType()));
//        Train trainOrDefault = optionalTrain.orElse(new Train());
//        logger.info("Train number: {}", trainOrDefault.getTrainNumber());
//
//        // word count
//        WordCountService wordCountService = new WordCountService();
//        try {
//            wordCountService.countUniqueWords(
//                    "src/main/resources/homer.txt",
//                    "src/main/resources/result.txt"
//            );
//        } catch (IOException e) {
//            logger.error("Error counting words: {}", e.getMessage());
//        }
//
//        // Thread 1 - using Runnable
//        Thread thread1 = new Thread(new ThreadDemo.TrainStatusRunnable("Train 101"));
//        thread1.start();
//        thread1.join();
//
//        // Thread 2 - using Thread class
//        ThreadDemo.PassengerBoardingThread thread2 = new ThreadDemo.PassengerBoardingThread("Giga");
//        thread2.start();
//        thread2.join();

        // Connection Pool Demo
        logger.info("--- Connection Pool Demo ---");
        ConnectionPoolDemo.run();
    }
}