package com.solvd.metro.model;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "metroSystem")
@XmlAccessorType(XmlAccessType.FIELD)
public class MetroSystemDto {

    @XmlElementWrapper(name = "trains")
    @XmlElement(name = "train")
    private List<Train> trains = new ArrayList<>();

    @XmlElementWrapper(name = "passengers")
    @XmlElement(name = "passenger")
    private List<Passenger> passengers = new ArrayList<>();

    @XmlElementWrapper(name = "stations")
    @XmlElement(name = "station")
    private List<Station> stations = new ArrayList<>();

    @XmlElementWrapper(name = "tickets")
    @XmlElement(name = "ticket")
    private List<Ticket> tickets = new ArrayList<>();

    @XmlElementWrapper(name = "lines")
    @XmlElement(name = "line")
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