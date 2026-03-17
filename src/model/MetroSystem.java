package model;

public class MetroSystem {

    private Vehicle[] vehicles = new Vehicle[0];
    private Train[] trains = new Train[0];
    private Passenger[] passengers = new Passenger[0];
    private Line[] lines = new Line[0];
    private Ticket[] tickets = new Ticket[0];

    public void addVehicle(Vehicle vehicle) {
        Vehicle[] newVehicles = new Vehicle[vehicles.length + 1];
        System.arraycopy(vehicles, 0, newVehicles, 0, vehicles.length);
        newVehicles[vehicles.length] = vehicle;
        vehicles = newVehicles;
    }

    public void addTrain(Train train) {
        Train[] newTrains = new Train[trains.length + 1];
        System.arraycopy(trains, 0, newTrains, 0, trains.length);
        newTrains[trains.length] = train;
        trains = newTrains;
    }

    public void addPassenger(Passenger passenger) {
        Passenger[] newPassengers = new Passenger[passengers.length + 1];
        System.arraycopy(passengers, 0, newPassengers, 0, passengers.length);
        newPassengers[passengers.length] = passenger;
        passengers = newPassengers;
    }

    public void addLine(Line line) {
        Line[] newLines = new Line[lines.length + 1];
        System.arraycopy(lines, 0, newLines, 0, lines.length);
        newLines[lines.length] = line;
        lines = newLines;
    }

    public void addTicket(Ticket ticket) {
        Ticket[] newTickets = new Ticket[tickets.length + 1];
        System.arraycopy(tickets, 0, newTickets, 0, tickets.length);
        newTickets[tickets.length] = ticket;
        tickets = newTickets;
    }

    public Vehicle[] getVehicles() { return vehicles; }
    public Train[] getTrains() { return trains; }
    public Passenger[] getPassengers() { return passengers; }
    public Line[] getLines() { return lines; }
    public Ticket[] getTickets() { return tickets; }
}