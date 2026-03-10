import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args){

        Speed train = new Speed("model3",90);

//        train.setSpeed(100);

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
    }
}

//At least 10 classes
//All classes must contain properties (minimum 1)
//All private variables must have getters and setters.
//Create custom constructors if needed.
//Create at least one static block (read at home, forgot to mention), method, variable.
//Create at least one business method for your hierarchy (f.i. if hierarchy is Airport then you can create a class named BookingService where is a method named book and this method checks if seats are not occupied, calculates cost of this seat, sends an email (can be system out ptinln) and so on)
//Create separate class with main() which will instantiate objects of implemented classes.
