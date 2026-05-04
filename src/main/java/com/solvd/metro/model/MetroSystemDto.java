package com.solvd.metro.model;

import java.util.ArrayList;
import java.util.List;

public class MetroSystemDto {

    private List<Train> trains = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();
    private List<Station> stations = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();
    private List<Line> lines = new ArrayList<>();

    public List<Train> getTrains() { return trains; }
    public void setTrains(List<Train> trains) { this.trains = trains; }

    public List<Passenger> getPassengers() { return passengers; }
    public void setPassengers(List<Passenger> passengers) { this.passengers = passengers; }

    public List<Station> getStations() { return stations; }
    public void setStations(List<Station> stations) { this.stations = stations; }

    public List<Ticket> getTickets() { return tickets; }
    public void setTickets(List<Ticket> tickets) { this.tickets = tickets; }

    public List<Line> getLines() { return lines; }
    public void setLines(List<Line> lines) { this.lines = lines; }
}