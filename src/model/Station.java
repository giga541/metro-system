package model;

import java.util.Objects;

public class Station extends Infrastructure {

    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Station{" +
                "location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(location, station.location);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(location);
    }
}