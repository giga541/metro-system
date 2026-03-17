package model;

public class Train extends Vehicle {

    private int trainNumber;
    private int capacity;
    private Driver driver;
    private Speed speed;

    @Override
    public String getType() { return "Train"; }

    public int getTrainNumber() { return trainNumber; }
    public void setTrainNumber(int trainNumber) { this.trainNumber = trainNumber; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public Driver getDriver() { return driver; }
    public void setDriver(Driver driver) { this.driver = driver; }

    public Speed getSpeedObject() { return speed; }
    public void setSpeed(Speed speed) { this.speed = speed; }
}