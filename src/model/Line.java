package model;

public class Line extends Transport {

    private String lineName;
    private Schedule schedule;
    private Station[] stations = new Station[0];

    public void addStation(Station station) {
        Station[] newStations = new Station[stations.length + 1];
        System.arraycopy(stations, 0, newStations, 0, stations.length);
        newStations[stations.length] = station;
        stations = newStations;
    }

    public Station[] getStations() { return stations; }

    public String getLineName() { return lineName; }
    public void setLineName(String lineName) { this.lineName = lineName; }

    public Schedule getSchedule() { return schedule; }
    public void setSchedule(Schedule schedule) { this.schedule = schedule; }
}