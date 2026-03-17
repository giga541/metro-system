package model;

import java.time.LocalDateTime;

public class Schedule {

    private Train[] trains = new Train[0];
    private LocalDateTime[] arrivalTimes = new LocalDateTime[0];
    private LocalDateTime[] departureTimes = new LocalDateTime[0];

    public void addEntry(Train train, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        Train[] newTrains = new Train[trains.length + 1];
        System.arraycopy(trains, 0, newTrains, 0, trains.length);
        newTrains[trains.length] = train;
        trains = newTrains;

        LocalDateTime[] newArrivals = new LocalDateTime[arrivalTimes.length + 1];
        System.arraycopy(arrivalTimes, 0, newArrivals, 0, arrivalTimes.length);
        newArrivals[arrivalTimes.length] = arrivalTime;
        arrivalTimes = newArrivals;

        LocalDateTime[] newDepartures = new LocalDateTime[departureTimes.length + 1];
        System.arraycopy(departureTimes, 0, newDepartures, 0, departureTimes.length);
        newDepartures[departureTimes.length] = departureTime;
        departureTimes = newDepartures;
    }

    public Train[] getTrains() { return trains; }
    public LocalDateTime[] getArrivalTimes() { return arrivalTimes; }
    public LocalDateTime[] getDepartureTimes() { return departureTimes; }
}