package model;

import java.time.LocalDateTime;

public class Schedule {

    private Train[] trains = new Train[10];
    private LocalDateTime[] arrivalTimes = new LocalDateTime[10];
    private LocalDateTime[] departureTimes = new LocalDateTime[10];

    private int count = 0;

    public void addEntry(Train train, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        trains[count] = train;
        arrivalTimes[count] = arrivalTime;
        departureTimes[count] = departureTime;
        count++;
    }

    public Train[] getTrains() { return trains; }
    public LocalDateTime[] getArrivalTimes() { return arrivalTimes; }
    public LocalDateTime[] getDepartureTimes() { return departureTimes; }
    public int getCount() { return count; }
}