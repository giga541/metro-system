package main.java.com.example.metro.exception;

public class InvalidTicketPriceException extends RuntimeException {

    public InvalidTicketPriceException(String message) {
        super(message);
    }
}
