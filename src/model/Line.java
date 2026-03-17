package model;

public class Line extends Transport {

    private String lineName;
    private Schedule schedule;
    private Station[] stations = new Station[10];
    private int stationCount = 0;

    public void addStation(Station station) { stations[stationCount++] = station; }
    public Station[] getStations() { return stations; }

    public String getLineName() { return lineName; }
    public void setLineName(String lineName) { this.lineName = lineName; }

    public Schedule getSchedule() { return schedule; }
    public void setSchedule(Schedule schedule) { this.schedule = schedule; }
}