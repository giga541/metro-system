import exception.TicketBookingException;
import exception.TrainNotFoundException;
import model.*;
import service.Booking;
import service.MetroSystemSession;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        // Speed
        Speed speed = new Speed("model3", 90);
        System.out.println(speed.getTrainModel() + " " + speed.getTrainSpeed());

        // Drivers
        Driver driver = new Driver();
        driver.setName("Mike");
        Driver driver2 = new Driver();
        driver2.setName("John");
        System.out.println(driver.getName());
        System.out.println(driver.getDriverId());
        System.out.println("Total drivers: " + Driver.getTotalDrivers());

        // Passengers
        Passenger passenger1 = new Passenger();
        passenger1.setName("Giga");
        passenger1.setSeatNumber("A1");
        Passenger passenger2 = new Passenger();
        passenger2.setName("John");
        passenger2.setSeatNumber("B2");

        // Trains
        Train train1 = new Train();
        train1.setTrainNumber(101);
        train1.setCapacity(50);
        Train train2 = new Train();
        train2.setTrainNumber(102);
        train2.setCapacity(80);
        train1.setSpeed(speed);

        // Tickets
        Ticket ticket1 = new Ticket();
        ticket1.setPrice(new BigDecimal("2.50"));
        ticket1.setPurchaseTime(LocalDateTime.now());
        Ticket ticket2 = new Ticket();
        ticket2.setPrice(new BigDecimal("3.50"));
        ticket2.setPurchaseTime(LocalDateTime.now());

        // Booking - checked exception with finally
        Booking booking = new Booking();
        try {
            booking.bookTicket(passenger1, train1, ticket1);
        } catch (TicketBookingException e) {
            System.out.println("Booking failed: " + e.getMessage());
        } finally {
            System.out.println("Booking attempt finished");
        }

        // AutoCloseable
        try (MetroSystemSession session = new MetroSystemSession("Main Session")) {
            session.doWork();
        } catch (Exception e) {
            System.out.println("Session error: " + e.getMessage());
        } finally {
            System.out.println("Session block finished");
        }

        // Platforms and Stations
        Platform platform1 = new Platform();
        platform1.setPlatformNumber(1);
        Platform platform2 = new Platform();
        platform2.setPlatformNumber(2);

        Station station1 = new Station();
        station1.setLocation("Central Station");
        station1.setCity("Tbilisi");
        station1.addPlatform(platform1);
        Station station2 = new Station();
        station2.setLocation("North Station");
        station2.setCity("Tbilisi");
        station2.addPlatform(platform2);

        // Schedule
        Schedule schedule = new Schedule();
        schedule.addTrainSchedule(new TrainSchedule(train1, LocalDateTime.now(), LocalDateTime.now().plusMinutes(30)));
        schedule.addTrainSchedule(new TrainSchedule(train2, LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(1).plusMinutes(30)));

        // Lines with stations
        Line line1 = new Line();
        line1.setLineName("Red Line");
        line1.setSchedule(schedule);
        line1.addStation(station1);
        line1.addStation(station2);
        Line line2 = new Line();
        line2.setLineName("Blue Line");

        // Metro System
        MetroSystem metro = new MetroSystem();
        metro.addTrain(train1);
        metro.addTrain(train2);
        metro.addPassenger(passenger1);
        metro.addPassenger(passenger2);
        metro.addLine(line1);
        metro.addLine(line2);
        metro.addTicket(ticket1);
        metro.addTicket(ticket2);

        // Vehicle array with parent type - polymorphism
        metro.addVehicle(train1);
        metro.addVehicle(new Bus());

        System.out.println("\n--- Metro System ---");
        System.out.println("Train 1: " + metro.getTrains().get(0));
        System.out.println("Train 2: " + metro.getTrains().get(1));
        System.out.println("Passenger 1: " + metro.getPassengers().get(0));
        System.out.println("Passenger 2: " + metro.getPassengers().get(1));
        System.out.println("Station 1: " + line1.getStations().get(0));
        System.out.println("Station 2: " + line1.getStations().get(1));
        System.out.println("Ticket 1 price: " + metro.getTickets().get(0).getPrice());
        System.out.println("Ticket 2 price: " + metro.getTickets().get(1).getPrice());

        System.out.println("\n--- Schedule for " + line1.getLineName() + " ---");
        for (int i = 0; i < schedule.getTrainSchedules().length; i++) {
            TrainSchedule ts = schedule.getTrainSchedules()[i];
            System.out.println("Train: " + ts.getTrain().getTrainNumber()
                    + " | Arrival: " + ts.getArrivalTime()
                    + " | Departure: " + ts.getDepartureTime());
        }

        System.out.println("\n--- Polymorphism ---");
        booking.printVehicleType(train1);
        booking.printVehicleType(new Bus());

        System.out.println("\n--- Equals & HashCode ---");
        Train train3 = new Train();
        train3.setTrainNumber(101);
        System.out.println("train1 equals train3: " + train1.equals(train3));
        System.out.println("train1 hashCode: " + train1.hashCode());
        System.out.println("train3 hashCode: " + train3.hashCode());

        // toString
        System.out.println(train1);
        System.out.println(passenger1);
        System.out.println(station1);

        // interfaces - polymorphism via method parameter
        Booking book = new Booking();

        book.startMoving(train1);
        book.processPayment(ticket1);
        book.showScheduleInfo(line1);

        // Identifiable
        Identifiable identifiable = train1;
        System.out.println("ID: " + identifiable.getId());
        System.out.println("Type: " + identifiable.getType());

        // Bookable
        Bookable bookable = ticket1;
        System.out.println("Is available: " + bookable.isAvailable());
        bookable.book();
        System.out.println("Is available after booking: " + bookable.isAvailable());

        // final class constant
        System.out.println("Metro name: " + Constants.METRO_NAME);
        System.out.println("Max capacity: " + Constants.MAX_CAPACITY);

        // final method
        passenger1.printInfo();

        // find a specific train's schedule - checked exception with finally
        try {
            TrainSchedule ts = schedule.findByTrain(101);
            System.out.println("Train: " + ts.getTrain().getTrainNumber());
            System.out.println("Arrives at: " + ts.getArrivalTime());
            System.out.println("Departs at: " + ts.getDepartureTime());
        } catch (TrainNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Schedule search finished");
        }
    }
}