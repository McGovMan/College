public class TravelIreland {
    public static void main(String[] args) {
        // This instantiation populates the default trip objects that are stored
        BusEireann be = new BusEireann();

        // Prints out details stored on all Bus Eireann trips
        System.out.println(be.getAllTrips());

        // Selects the trip
        Trip selectedTrip = be.getTrip(521);

        // Sets up the booking object
        Booking booking = new Booking(selectedTrip, 10);
        boolean success = be.makeBooking(booking);

        if (success) { // Prints out details on booking if successful
            System.out.println("\nBooking Successful!");
            System.out.println("-------------------------------------------------");
            System.out.println("Number of Passengers: " + booking.getNumPassengers());
            System.out.println("Trip Details: [" + booking.getTrip().getStartingLocation() + "] to [" + booking.getTrip().getDestination() + "]");
            System.out.println("Trip ID: " + booking.getTrip().getTripID());
            System.out.println("Total Cost: €" + booking.getTotalCost());
            System.out.println("-------------------------------------------------\n\n");
        } else {
            System.out.println("\n\nBooking Failed!");
        }

        System.out.println(be.getAllTrips());
    }
}
