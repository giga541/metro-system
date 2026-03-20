package model;

public class Line extends Transport implements Scheduleable {

    private String lineName;
    private Schedule schedule;
    private Station[] stations = new Station[0];

    @Override
    public void addToSchedule() {
        System.out.println("Line " + lineName + " added to schedule");
    }

    @Override
    public String getScheduleInfo() {
        return "Line: " + lineName + " has " + stations.length + " stations";
    }

    public void addStation(Station station) {
        Station[] newStations = new Station[stations.length + 1];
        System.arraycopy(stations, 0, newStations, 0, stations.length);
        newStations[stations.length] = station;
        stations = newStations;
    }

    public Station[] getStations() {
        return stations;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}