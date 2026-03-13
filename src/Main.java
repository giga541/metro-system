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
        Driver driver2 = new Driver();
        driver2.setDriverName("John");
        System.out.println(driver.getDriverName());
        System.out.println(driver.getDriverId());

        Passenger passenger1 = new Passenger();
        passenger1.setName("Giga");

        Passenger passenger2 = new Passenger();
        passenger2.setName("John");

        Train train1 = new Train();
        train1.setTrainNumber(101);
        train1.setCapacity(50);

        Train train2 = new Train();
        train2.setTrainNumber(102);
        train2.setCapacity(80);

        Ticket ticket = new Ticket();
        ticket.setPrice(new BigDecimal("2.50"));
        ticket.setPurchaseTime(LocalDateTime.now());
        System.out.println(ticket.getPrice());
        System.out.println(ticket.getPurchaseTime());


        Booking booking = new Booking();
        booking.bookTicket(passenger1, train1, ticket);

        MetroSystem metro = new MetroSystem();

        metro.setTrain1(train1);
        metro.setTrain2(train2);

        metro.setPassenger1(passenger1);
        metro.setPassenger2(passenger2);

        Station station1 = new Station();
        station1.setLocation("Central Station");
        metro.setStation1(station1);

        Station station2 = new Station();
        station2.setLocation("North Station");
        metro.setStation2(station2);

        Line line1 = new Line();
        line1.setName("Red Line");
        metro.setLine1(line1);

        Line line2 = new Line();
        line2.setName("Blue Line");
        metro.setLine2(line2);

        System.out.println("Train 1 capacity: " + metro.getTrain1().getCapacity());
        System.out.println("Train 2 capacity: " + metro.getTrain2().getCapacity());
        System.out.println("Passenger 1: " + metro.getPassenger1().getName());
        System.out.println("Passenger 2: " + metro.getPassenger2().getName());
        System.out.println("Station 1: " + metro.getStation1().getLocation());
        System.out.println("Station 2: " + metro.getStation2().getLocation());
        System.out.println(Driver.getTotalDrivers());

        metro.setTicket1(ticket);
        Ticket ticket2 = new Ticket();
        ticket2.setPrice(new BigDecimal("3.50"));
        ticket2.setPurchaseTime(LocalDateTime.now());
        metro.setTicket2(ticket2);

        System.out.println("Ticket 1 price: " + metro.getTicket1().getPrice());
        System.out.println("Ticket 2 price: " + metro.getTicket2().getPrice());

        Schedule schedule = new Schedule();
        schedule.setArrivalTime(LocalDateTime.now());
        schedule.setDepartureTime(LocalDateTime.now().plusMinutes(30));
        schedule.setTrain(train1);

        System.out.println("Arrival: " + schedule.getArrivalTime());
        System.out.println("Departure: " + schedule.getDepartureTime());
        System.out.println("Train number: " + schedule.getTrain().getTrainNumber());
    }
}