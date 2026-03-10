public class Booking {

    public void bookTicket(Passenger passenger, Train train, Ticket ticket) {

        if(train.getCapacity() > 0) {

            System.out.println("Ticket booked for " + passenger.getName());
            System.out.println("Train number: " + train.getTrainNumber());
            System.out.println("Price: " + ticket.getPrice());

        } else {

            System.out.println("No seats available");

        }

    }

}