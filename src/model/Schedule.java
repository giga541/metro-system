package model;

import java.time.LocalDateTime;

public class Schedule {

    private Schedule schedule;

    private LocalDateTime arrivalTime;

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
}