import java.util.ArrayList;

public abstract class transport {
    public ArrayList<Trip> trips = new ArrayList<>();

    // Bus Constructor unused
    public transport() {
    }

    public String toString(int i) {
        String str = "";
        str += "Company: " + trips.get(i).companyName + "\n";
        str += "Trip ID: " + trips.get(i).tripID + "\n";
        str += "Origin: " + trips.get(i).startingLocation + "\n";
        str += "Destination: " + trips.get(i).destination + "\n";
        str += "Departure Date: " + trips.get(i).dateOfDeparture + "\n";
        str += "Departure Time: " + trips.get(i).timeOfDeparture + "\n";
        str += "Arrival Data: " + trips.get(i).dateOfArrival + "\n";
        str += "Arrival Time: " + trips.get(i).timeOfArrival + "\n";
        str += "Fare: €" + trips.get(i).fare + " per passenger" + "\n";
        str += "Currently available seats: " + trips.get(i).availableSeats + "\n";
        return str;
    }

    // Makes booking if bus has enough seats
    public Boolean makeBooking(Booking booking) {
        if (booking.getTrip().getAvailableSeats() >= booking.getNumPassengers()) {
            return true;
        }
        return false;
    }

    // Calls the toString method for all trips in arraylist
    public String getAllTrips() {
        String str = "";
        for (int i = 0; i < trips.size(); i++) {
            str += toString(i) + "\n\n";
        }
        return str;
    }

    // Returns the trip object that contains the tripID that is passed in
    public Trip getTrip(int tripID) {
        for (int i = 0; i < trips.size(); i++) {
            if (trips.get(i).getTripID() == tripID) {
                return trips.get(i);
            }
        }
        return null;
    }
}
