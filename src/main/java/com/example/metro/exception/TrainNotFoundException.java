package main.java.com.example.metro.exception;

public class TrainNotFoundException extends RuntimeException {

    public TrainNotFoundException(String message) {
        super(message);
    }
}
