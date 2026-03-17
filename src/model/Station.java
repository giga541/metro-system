package model;

import java.util.Objects;

public class Station extends Infrastructure {

    private String location;
    private Platform[] platforms = new Platform[5];
    private int platformCount = 0;

    public void addPlatform(Platform platform) { platforms[platformCount++] = platform; }
    public Platform[] getPlatforms() { return platforms; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

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
}