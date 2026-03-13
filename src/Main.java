import model.*;
import service.Booking;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Speed speed = new Speed("model3", 90);
        System.out.println(speed.getTrainModel() + " " + speed.getTrainSpeed());

        Driver driver = new Driver();
        driver.setDriverName("Mike");
        Driver driver2 = new Driver();
        driver2.setDriverName("John");
        System.out.println(driver.getDriverName());
        System.out.println(driver.getDriverId());
        System.out.println(Driver.getTotalDrivers());

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

        Ticket ticket1 = new Ticket();
        ticket1.setPrice(new BigDecimal("2.50"));
        ticket1.setPurchaseTime(LocalDateTime.now());
        Ticket ticket2 = new Ticket();
        ticket2.setPrice(new BigDecimal("3.50"));
        ticket2.setPurchaseTime(LocalDateTime.now());

        Booking booking = new Booking();
        booking.bookTicket(passenger1, train1, ticket1);

        Station station1 = new Station();
        station1.setLocation("Central Station");
        Station station2 = new Station();
        station2.setLocation("North Station");

        Line line1 = new Line();
        line1.setName("Red Line");
        Line line2 = new Line();
        line2.setName("Blue Line");

        Schedule schedule = new Schedule();
        schedule.setArrivalTime(LocalDateTime.now());
        schedule.setDepartureTime(LocalDateTime.now().plusMinutes(30));
        schedule.setTrain(train1);

        MetroSystem metro = new MetroSystem();
        metro.addTrain(train1);
        metro.addTrain(train2);
        metro.addPassenger(passenger1);
        metro.addPassenger(passenger2);
        metro.addStation(station1);
        metro.addStation(station2);
        metro.addLine(line1);
        metro.addLine(line2);
        metro.addTicket(ticket1);
        metro.addTicket(ticket2);

        System.out.println("Train 1 capacity: " + metro.getTrains().get(0).getCapacity());
        System.out.println("Train 2 capacity: " + metro.getTrains().get(1).getCapacity());
        System.out.println("Passenger 1: " + metro.getPassengers().get(0).getName());
        System.out.println("Passenger 2: " + metro.getPassengers().get(1).getName());
        System.out.println("Station 1: " + metro.getStations().get(0).getLocation());
        System.out.println("Station 2: " + metro.getStations().get(1).getLocation());
        System.out.println("Ticket 1 price: " + metro.getTickets().get(0).getPrice());
        System.out.println("Ticket 2 price: " + metro.getTickets().get(1).getPrice());
        System.out.println("Arrival: " + schedule.getArrivalTime());
        System.out.println("Departure: " + schedule.getDepartureTime());
        System.out.println("Train number: " + schedule.getTrain().getTrainNumber());
    }
}