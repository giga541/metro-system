package com.solvd.metro.interfaces;
import com.solvd.metro.model.Ticket;

@FunctionalInterface
public interface TicketValidator {

    boolean validate(Ticket ticket);
}