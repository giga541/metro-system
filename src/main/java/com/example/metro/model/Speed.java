package main.java.com.example.metro.model;

public class Speed {

    private String trainModel;
    private int trainSpeed;

    public Speed(String trainModel, int trainSpeed) {
        this.trainModel = trainModel;
        this.trainSpeed = trainSpeed;
    }

    public String getTrainModel() {
        return trainModel;
    }

    public int getTrainSpeed() {
        return trainSpeed;
    }

}