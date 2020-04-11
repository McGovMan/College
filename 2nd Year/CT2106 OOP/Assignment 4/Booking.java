public class Booking {
    Trip trip;

    // Booking Constructor
    // Constructor also sets the available seats when making booking
    public Booking (Trip trip, int numPassengers) {
        // Checks if trip object is null
        if (trip != null) this.trip = trip;
        else {
            System.out.print("Trip does not exist, internal error, exiting...");
            System.exit(0);
        }

        trip.setAvailableSeats(trip.getAvailableSeats() - numPassengers);
    }

    /* Getter Methods */
    public Trip getTrip() {
        return trip;
    }

    public int getNumPassengers() {
        return trip.availableSeats;
    }

    public float getTotalCost() {
        return getNumPassengers() * trip.getFare();
    }
}
