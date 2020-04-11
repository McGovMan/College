public class BusEireann extends transport {

    public BusEireann() {
        // Making different trip objects
        Trip route521 = new Trip("Bus Eireann", "Galway", "Ballina", "22/11", "18.10", "22/11", "20.30", 521, 60,30);
        Trip route641 = new Trip("Bus Eireann", "Galway", "Derry", "22/11", "18.00", "22/11", "22.30", 641, 60,30);
        Trip route511 = new Trip("Bus Eireann", "Galway", "Limerick", "22/11", "17.00", "22/11", "18.20", 501, 60,15);

        // Adding trips to trips arraylist
        trips.add(route521);
        trips.add(route641);
        trips.add(route511);
    }
}