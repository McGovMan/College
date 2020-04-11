public class Trip {
    // Initalising variables
    String companyName, startingLocation, destination, dateOfDeparture, timeOfDeparture,  dateOfArrival,  timeOfArrival;
    float fare;
    int tripID, availableSeats;

    // Trip Constructor
    public Trip (String companyName, String startingLocation, String destination, String dateOfDeparture, String timeOfDeparture,  String dateOfArrival,  String timeOfArrival, int tripID, int availableSeats, float fare) {
        this.companyName = companyName;
        this.startingLocation = startingLocation;
        this.destination = destination;
        this.dateOfDeparture = dateOfDeparture;
        this.timeOfDeparture = timeOfDeparture;
        this.dateOfArrival = dateOfArrival;
        this.timeOfArrival = timeOfArrival;
        this.tripID = tripID;
        this.availableSeats = availableSeats;
        this.fare = fare;
    }

    /* Getter Methods */
    public int getTripID() {
        return tripID;
    }

    public String getStartingLocation() {
        return startingLocation;
    }

    public String getDestination() {
        return destination;
    }

    public float getFare() {
        return fare;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    /* Setter Methods */
    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
