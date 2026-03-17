package model;

public class MetroSystem {

    private Train[] trains = new Train[10];
    private Station[] stations = new Station[10];
    private Passenger[] passengers = new Passenger[10];
    private Line[] lines = new Line[10];
    private Ticket[] tickets = new Ticket[10];

    private int trainCount = 0;
    private int stationCount = 0;
    private int passengerCount = 0;
    private int lineCount = 0;
    private int ticketCount = 0;

    public Train[] getTrains() { return trains; }
    public void addTrain(Train train) { trains[trainCount++] = train; }

    public Station[] getStations() { return stations; }
    public void addStation(Station station) { stations[stationCount++] = station; }

    public Passenger[] getPassengers() { return passengers; }
    public void addPassenger(Passenger passenger) { passengers[passengerCount++] = passenger; }

    public Line[] getLines() { return lines; }
    public void addLine(Line line) { lines[lineCount++] = line; }

    public Ticket[] getTickets() { return tickets; }
    public void addTicket(Ticket ticket) { tickets[ticketCount++] = ticket; }

    private Vehicle[] vehicles = new Vehicle[10];
    private int vehicleCount = 0;

    public void addVehicle(Vehicle vehicle) { vehicles[vehicleCount++] = vehicle; }
    public Vehicle[] getVehicles() { return vehicles; }
}