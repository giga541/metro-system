package model;

import java.util.ArrayList;
import java.util.List;

public class MetroSystem {

    private List<Train> trains = new ArrayList<>();
    private List<Station> stations = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();
    private List<Line> lines = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();

    public List<Train> getTrains() {
        return trains;
    }

    public void addTrain(Train train) {
        trains.add(train);
    }

    public List<Station> getStations() {
        return stations;
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public List<Line> getLines() {
        return lines;
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
}