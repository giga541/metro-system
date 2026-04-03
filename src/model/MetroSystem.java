package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MetroSystem {

    private static final String METRO_SYSTEM_NAME = "Tbilisi Metro";

    static {
        System.out.println("MetroSystem class loaded!");
        System.out.println("Welcome to " + METRO_SYSTEM_NAME);
    }

    private List<Train> trains = new ArrayList<>();
    private List<Passenger> passengers = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();
    private Set<Line> lines = new HashSet<>();
    private Map<Integer, Train> trainMap = new HashMap<>();

    public static String getMetroSystemName() {
        return METRO_SYSTEM_NAME;
    }

    public void addTrain(Train train) {
        trains.add(train);
        trainMap.put(train.getTrainNumber(), train); // also add to map
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public void addVehicle(Vehicle vehicle) {

    }

    public void printSystemInfo() {

        System.out.println("Total trains: " + trains.size());
        System.out.println("Total passengers: " + passengers.size());
        System.out.println("Total tickets: " + tickets.size());
        System.out.println("Total lines: " + lines.size());

        System.out.println("No trains? " + trains.isEmpty());

        // get() - first element from List
        if (!trains.isEmpty()) {
            System.out.println("First train: " + trains.get(0));
        }

        // get from Map by key
        Train foundTrain = trainMap.get(101);
        if (foundTrain != null) {
            System.out.println("Train from map: " + foundTrain);
        }

        // iterate List
        System.out.println("\n--- All Trains ---");
        trains.stream()
                .map(Train::toString)
                .forEach(System.out::println);

        // iterate Set
        System.out.println("\n--- All Lines ---");
        lines.stream()
                .map(Line::getLineName)
                .forEach(System.out::println);

        // iterate Map
        System.out.println("\n--- Train Map ---");
        trainMap.entrySet().stream()
                .map(e -> "Key: " + e.getKey() + " -> " + e.getValue())
                .forEach(System.out::println);

        // remove()
        if (!passengers.isEmpty()) {
            passengers.remove(0);
            System.out.println("Removed first passenger, remaining: " + passengers.size());
        }
    }

    // retrieve first element from each collection type
    public void printFirstElements() {

        if (!trains.isEmpty()) {
            System.out.println("First train: " + trains.get(0));
        }

        if (!lines.isEmpty()) {
            Line firstLine = lines.iterator().next();
            System.out.println("First line: " + firstLine.getLineName());
        }

        if (!trainMap.isEmpty()) {
            Map.Entry<Integer, Train> firstEntry = trainMap.entrySet().iterator().next();
            System.out.println("First map entry: " + firstEntry.getKey() + " -> " + firstEntry.getValue());
        }
    }

    public List<Train> getTrains() {
        return trains;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public Set<Line> getLines() {
        return lines;
    }

    public Map<Integer, Train> getTrainMap() {
        return trainMap;
    }
}