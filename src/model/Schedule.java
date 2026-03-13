package model;

import java.time.LocalDateTime;

public class Schedule {

    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
    private Train train;

    public LocalDateTime getArrivalTime() { return arrivalTime; }
    public void setArrivalTime(LocalDateTime arrivalTime) { this.arrivalTime = arrivalTime; }

    public LocalDateTime getDepartureTime() { return departureTime; }
    public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }

    public Train getTrain() { return train; }
    public void setTrain(Train train) { this.train = train; }
}