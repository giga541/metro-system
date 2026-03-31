package interfaces;

import model.Train;
import model.Ticket;
import model.Passenger;

public class MetroLambdas {

    @FunctionalInterface
    public interface TicketValidator {
        boolean validate(Ticket ticket);
    }

    @FunctionalInterface
    public interface TrainFilter {
        boolean filter(Train train);
    }

    @FunctionalInterface
    public interface PassengerAction {
        void perform(Passenger passenger);
    }
}