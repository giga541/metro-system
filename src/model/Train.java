package model;

// Version Rebase-A
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
}