package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Station extends Infrastructure implements Scheduleable {

    private String location;
    private List<Platform> platforms = new ArrayList<>();

    public void addPlatform(Platform platform) {
        platforms.add(platform);
    }

    @Override
    public void addToSchedule() {
        System.out.println("Station " + location + " added to schedule");
    }

    @Override
    public String getScheduleInfo() {
        return "Station: " + location + " in " + getCity();
    }

    @Override
    public String toString() {
        return "Station{location=" + location + ", city=" + getCity() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Station)) return false;
        Station station = (Station) o;
        return Objects.equals(location, station.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }

    public List<Platform> getPlatforms() { return platforms; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}