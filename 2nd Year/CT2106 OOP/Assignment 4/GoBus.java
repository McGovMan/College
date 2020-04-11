public class GoBus extends transport {

    public GoBus() {
        // Making different trip objects
        Trip route430 = new Trip("GoBus", "Galway", "Ballina", "22/11", "18.10", "22/11", "20.30", 430, 60,30);
        Trip route720 = new Trip("GoBus", "Galway", "Dublin", "22/11", "18.00", "22/11", "22.30", 720, 60,30);
        Trip route707 = new  Trip("GoBus", "Cork", "Dublin", "22/11", "17.00", "22/11", "18.20", 707, 60,15);

        // Adding trips to trips arraylist
        trips.add(route430);
        trips.add(route720);
        trips.add(route707);
    }
}
