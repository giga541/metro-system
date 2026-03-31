package interfaces;
import model.Ticket;

@FunctionalInterface
public interface TicketValidator {

    boolean validate(Ticket ticket);
}