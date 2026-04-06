package main.java.com.example.metro.interfaces;
import main.java.com.example.metro.model.Ticket;

@FunctionalInterface
public interface TicketValidator {

    boolean validate(Ticket ticket);
}