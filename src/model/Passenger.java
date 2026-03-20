package model;

import java.util.Objects;

public class Passenger extends Person {

    private String seatNumber;

    public final void printInfo() {
        System.out.println("Passenger: " + getName() + ", Seat: " + seatNumber);
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(seatNumber, passenger.seatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(seatNumber);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "seatNumber='" + seatNumber + '\'' +
                '}';
    }
}