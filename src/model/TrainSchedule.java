package model;

import java.time.LocalDateTime;

public class TrainSchedule {

    private Train train;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;

    public TrainSchedule(Train train, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        this.train = train;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public Train getTrain() { return train; }
    public void setTrain(Train train) { this.train = train; }

    public LocalDateTime getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(LocalDateTime arrivalTime) { this.arrivalTime = arrivalTime; }

    public LocalDateTime getDepartureTime() { return departureTime; }
    public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }
}