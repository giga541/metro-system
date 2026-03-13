package model;

//<<<<<<< HEAD
/// / Version Rebase-A
//=======

/// / Version Rebase-B
//>>>>>>> 8a372c0 (change comment in rebase-b)
public class Train {

    private int trainNumber;
    private int capacity;
    private Driver driver;
    private Speed speed;

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

    public Speed getSpeed() {
        return speed;
    }

    public void setSpeed(Speed speed) {
        this.speed = speed;
    }
}