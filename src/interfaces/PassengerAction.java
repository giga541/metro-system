package interfaces;
import model.Passenger;

@FunctionalInterface
public interface PassengerAction {

    void perform(Passenger passenger);
}