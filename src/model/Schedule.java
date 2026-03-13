package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private List<Train> trains = new ArrayList<>();
    private List<LocalDateTime> arrivalTimes = new ArrayList<>();
    private List<LocalDateTime> departureTimes = new ArrayList<>();

    public void addTrain(Train train) {
        trains.add(train);
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void addArrivalTime(LocalDateTime arrivalTime) {
        arrivalTimes.add(arrivalTime);
    }

    public List<LocalDateTime> getArrivalTimes() {
        return arrivalTimes;
    }

    public void addDepartureTime(LocalDateTime departureTime) {
        departureTimes.add(departureTime);
    }

    public List<LocalDateTime> getDepartureTimes() {
        return departureTimes;
    }
}