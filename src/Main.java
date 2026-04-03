import constants.Constants;
import enums.*;
import exception.TicketBookingException;
import exception.TrainNotFoundException;
import interfaces.Bookable;
import interfaces.Identifiable;
import model.*;
import records.TrainSchedule;
import service.Booking;
import service.MetroService;
import service.MetroSystemSession;
import service.ReflectionService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
        train1.setStatus(TrainStatus.ACTIVE);
        train2.setStatus(TrainStatus.MAINTENANCE);
        System.out.println(train1.getTrainNumber() + " status: " + train1.getStatus().getDescription());
        System.out.println(train2.getTrainNumber() + " status: " + train2.getStatus().getDescription());
        System.out.println("Is train1 available? " + train1.getStatus().isAvailable());

        // Tickets
        Ticket ticket1 = new Ticket();
        ticket1.setPrice(new BigDecimal("2.50"));
        ticket1.setPurchaseTime(LocalDateTime.now());
        Ticket ticket2 = new Ticket();
        ticket2.setPrice(new BigDecimal("3.50"));
        ticket2.setPurchaseTime(LocalDateTime.now());
        ticket1.setTicketType(TicketType.SINGLE);
        ticket2.setTicketType(TicketType.MONTHLY);
        System.out.println("Ticket type: " + ticket1.getTicketType().getDescription());
        System.out.println("Is unlimited? " + ticket2.getTicketType().isUnlimited());

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
        station1.setStationType(StationType.TERMINAL);
        station2.setStationType(StationType.JUNCTION);
        System.out.println("Station type: " + station1.getStationType().getInfo());

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
        line1.setColor(LineColor.RED);
        System.out.println("Line color: " + line1.getColor().getDisplayName());

        //payment
        Payment payment = new Payment();
        payment.setPaymentMethod(PaymentMethod.CARD);
        System.out.println("Payment: " + payment.getPaymentMethod().getPaymentInfo());

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
        for (TrainSchedule ts : schedule.getTrainSchedules()) {
            System.out.println("Train: " + ts.train().getTrainNumber()
                    + " | Arrival: " + ts.arrivalTime()
                    + " | Departure: " + ts.departureTime());
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
            System.out.println("Train: " + ts.train().getTrainNumber());
            System.out.println("Arrives at: " + ts.arrivalTime());
            System.out.println("Departs at: " + ts.departureTime());
        } catch (TrainNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Schedule search finished");
        }

        // Generics
        Pair<Passenger, Ticket> passengerTicket1 = new Pair<>(passenger1, ticket1);
        Pair<Passenger, Ticket> passengerTicket2 = new Pair<>(passenger2, ticket2);
        System.out.println("Passenger: " + passengerTicket1.getFirst().getName()
                + " | Ticket price: " + passengerTicket1.getSecond().getPrice());
        System.out.println("Passenger: " + passengerTicket2.getFirst().getName()
                + " | Ticket price: " + passengerTicket2.getSecond().getPrice());

        Container<Train> activeTrain = new Container<>("Active", train1);
        Container<Train> maintenanceTrain = new Container<>("Under Maintenance", train2);
        System.out.println("Train status: " + activeTrain.getLabel()
                + " -> " + activeTrain.getItem().getTrainNumber());
        System.out.println("Train status: " + maintenanceTrain.getLabel()
                + " -> " + maintenanceTrain.getItem().getTrainNumber());

        // MetroService
        MetroService metroService = new MetroService();

        // Runnable
        System.out.println("\n--- Runnable Tasks ---");
        metroService.runTask(() -> System.out.println("Checking all train statuses..."));
        metroService.runTask(() -> metro.printSystemInfo());

        // Predicate
        System.out.println("\n--- Trains with capacity >= 60 ---");
        List<Train> bigTrains = metroService.getTrainsWithMinCapacity(metro.getTrains(), 60);
        for (Train t : bigTrains) {
            System.out.println(t.getTrainNumber() + " capacity: " + t.getCapacity());
        }

        // Function
        System.out.println("\n--- Train Summaries ---");
        System.out.println(metroService.getTrainSummary(train1));
        System.out.println(metroService.getTrainSummary(train2));

        // Consumer
        System.out.println("\n--- All Passengers ---");
        metroService.printAllPassengers(metro.getPassengers());

        // Supplier
        System.out.println("\n--- Default Ticket Price ---");
        System.out.println("Default price: " + metroService.getDefaultTicketPrice());

        // BiFunction
        System.out.println("\n--- Total Price with Service Fee ---");
        System.out.println("Total: " + metroService.calculateTotalPrice(passenger1, ticket1));


        System.out.println("\n--- Filter Trains (caller decides) ---");
        List<Train> activeTrains = metroService.filterTrains(
                metro.getTrains(),
                t -> t.getStatus() == TrainStatus.ACTIVE
        );
        List<Train> highCapacityTrains = metroService.filterTrains(
                metro.getTrains(),
                t -> t.getCapacity() >= 60
        );
        List<Train> specificTrain = metroService.filterTrains(
                metro.getTrains(),
                t -> t.getTrainNumber() == 101
        );
        for (Train t : activeTrains) {
            System.out.println("Active train: " + t.getTrainNumber());
        }
        for (Train t : highCapacityTrains) {
            System.out.println("High capacity train: " + t.getTrainNumber());
        }
        for (Train t : specificTrain) {
            System.out.println("Specific train: " + t.getTrainNumber());
        }

        System.out.println("\n--- Validate Tickets (caller decides) ---");
        System.out.println("Ticket1 valid? " + metroService.validateTicket(
                ticket1,
                t -> t.getPrice() != null && t.getAmount().doubleValue() > 0 && t.isAvailable()
        ));
        System.out.println("Ticket2 valid? " + metroService.validateTicket(
                ticket2,
                t -> t.getTicketType() == TicketType.MONTHLY
        ));

        System.out.println("\n--- Passenger Actions (caller decides) ---");
        metroService.performOnPassengers(
                metro.getPassengers(),
                p -> System.out.println("Boarding: " + p.getName())
        );
        metroService.performOnPassengers(
                metro.getPassengers(),
                p -> System.out.println("Checking ticket for: " + p.getName())
        );

        System.out.println("\n--- System Info ---");
        metro.printSystemInfo();
        metro.printFirstElements();

        // Reflection
        ReflectionService reflectionService = new ReflectionService();
        reflectionService.extractInfo(Train.class);
        reflectionService.createObjectAndCallMethod();

    }
}