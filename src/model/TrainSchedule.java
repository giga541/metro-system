package model;

import java.time.LocalDateTime;

public record TrainSchedule(Train train, LocalDateTime arrivalTime, LocalDateTime departureTime) {

    public String getSummary() {
        return "Train " + train.getTrainNumber() + " arrives at " + arrivalTime + " departs at " + departureTime;
    }
}