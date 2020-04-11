
/**
 * Write a description of class Wheel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Wheel
{
    private int radius = 0;
    private String name = "";
    private double circumference;
    private double distance;
    private double tplAmount;
    private Engine engine;
    private Car car;
    
    public Wheel(String name, int radius)
    {
        this.name = name;
        this.radius = radius;
        circumference = radius * Math.PI * 2;
    }
    
    public double getDistance(float fuelLevel) {
        tplAmount = engine.getTpl() + engine.getTotalNumTurns();
        distance = circumference * tplAmount * car.getFuel();
        car.setFuel(0);
        return distance;
    }
    
    public String name() {
        return name;
    }
    
    public int radius() {
        return radius;
    }
    
    public double circumference() {
        return circumference;
    }
}
