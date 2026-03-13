import model.*;
import service.Booking;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Speed train = new Speed("model3", 90);

        System.out.println(train.getTrainModel() + " " + train.getTrainSpeed());

        Driver driver = new Driver();
        driver.setDriverName("Mike");

        System.out.println(driver.getDriverName());
        System.out.println(Driver.getDriverId());

        Passenger passenger = new Passenger();
        passenger.setName("Giga");

        Train train1 = new Train();
        train1.setTrainNumber(101);
        train1.setCapacity(50);

        Ticket ticket = new Ticket();

        ticket.setPrice(new BigDecimal("2.50"));
        ticket.setPurchaseTime(LocalDateTime.now());

        System.out.println(ticket.getPrice());
        System.out.println(ticket.getPurchaseTime());

        Booking booking = new Booking();
        booking.bookTicket(passenger, train1, ticket);

        MetroSystem metro = new MetroSystem();

        metro.setTrain(train1);
        metro.setPassenger(passenger);

        Station station = new Station();
        station.setLocation("Central Station");
        metro.setStation(station);

        Line line = new Line();
        line.setName("Red Line");
        metro.setLine(line);

        System.out.println("Train capacity: " + metro.getTrain().getCapacity());
        System.out.println("Passenger: " + metro.getPassenger().getName());
        System.out.println("Station: " + metro.getStation().getLocation());

    }
}

//At least 10 classes
//All classes must contain properties (minimum 1)
//All private variables must have getters and setters.
//Create custom constructors if needed.
//Create at least one static block (read at home, forgot to mention), method, variable.
//Create at least one business method for your hierarchy (f.i. if hierarchy is Airport then you can create a class named BookingService where is a method named book and this method checks if seats are not occupied, calculates cost of this seat, sends an email (can be system out ptinln) and so on)
//Create separate class with main() which will instantiate objects of implemented classes.
