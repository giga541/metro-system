package model;

import enums.TrainStatus;
import interfaces.Identifiable;
import interfaces.Moveable;

import java.util.Objects;

public class Train extends Vehicle implements Moveable, Identifiable {

    private int trainNumber;
    private int capacity;
    private Driver driver;
    private Speed speed;

    @Override
    public void move() {
        System.out.println("Train " + trainNumber + " is moving on the tracks at speed: " + getSpeed());
    }

    @Override
    public int getSpeed() {
        return speed != null ? speed.getTrainSpeed() : 0;
    }

    @Override
    public int getId() {
        return trainNumber;
    }

    @Override
    public String getType() {
        return "Train";
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Speed getSpeedObject() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return trainNumber == train.trainNumber && capacity == train.capacity && Objects.equals(driver, train.driver) && Objects.equals(speed, train.speed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainNumber, capacity, driver, speed);
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainNumber=" + trainNumber +
                ", capacity=" + capacity +
                ", driver=" + driver +
                ", speed=" + speed +
                '}';
    }

    private TrainStatus status;

    public TrainStatus getStatus() {
        return status;
    }

    public void setStatus(TrainStatus status) {
        this.status = status;
    }
}