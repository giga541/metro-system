package model;

import enums.LineColor;
import interfaces.Scheduleable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line extends Transport implements Scheduleable {

    private String lineName;
    private Schedule schedule;
    private List<Station> stations = new ArrayList<>();

    public void addStation(Station station) {
        stations.add(station);
    }

    @Override
    public void addToSchedule() {
        System.out.println("Line " + lineName + " added to schedule");
    }

    @Override
    public String getScheduleInfo() {
        return "Line: " + lineName + " has " + stations.size() + " stations";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(lineName, line.lineName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineName);
    }

    public List<Station> getStations() { return stations; }
    public String getLineName() { return lineName; }
    public void setLineName(String lineName) { this.lineName = lineName; }
    public Schedule getSchedule() { return schedule; }
    public void setSchedule(Schedule schedule) { this.schedule = schedule; }

    private LineColor color;

    public LineColor getColor() {
        return color;
    }

    public void setColor(LineColor color) {
        this.color = color;
    }
}