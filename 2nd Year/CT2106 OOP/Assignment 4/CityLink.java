public class CityLink extends transport {

    public CityLink() {
        // Making different trip objects
        Trip route660 = new Trip("City Link", "Galway", "Dublin", "22/11", "18.10", "22/11", "20.30", 660, 60,30);
        Trip route251 = new Trip("City Link", "Galway", "Cork", "22/11", "18.00", "22/11", "22.30", 251, 60,30);
        Trip route923 = new Trip("City Link", "Galway", "Clifden", "22/11", "17.00", "22/11", "18.20", 501, 60,15);

        // Adding trips to trips arraylist
        trips.add(route660);
        trips.add(route251);
        trips.add(route923);
    }
}
