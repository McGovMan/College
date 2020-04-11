
/**
 * Write a description of class Car here.
 *
 * @author Conor McGovern
 * @version 24.09.19
 */
public class Car
{
    private String name = "";
    private double distance = 0;
    private double totalKm = 0;
    private float fuelLevel = 0;
    private Engine engine;
    private Wheel wheel;
    
    public Car(String name)
    {
        this.name = name;
    }
    
    public void add(Engine engine) {
        this.engine = engine;
    }
    
    public void add(Wheel wheel) {
        this.wheel = wheel;
    }
    
    public void setFuel(float fuelLevel) {
        this.fuelLevel = fuelLevel;
    }
    
    public float getFuel() {
        return this.fuelLevel;
    }
    
    public void drive() {
        distance = wheel.getDistance(fuelLevel);
        totalKm += distance;
    }
    
    public void printState() {
        System.out.printf("Configuration: Car Body %s", name);
        System.out.printf("Engine name: %s", engine.getEngineName());
        System.out.printf("Engine turns per litre: %.2f", engine.getTpl());
        System.out.printf("Engine's total turns count: %s", engine.getTotalNumTurns());
        System.out.printf("Wheel name: %s", wheel.name());
        System.out.printf("Wheel Radius: %d", wheel.radius());
        System.out.printf("Wheel circumference: %s", wheel.circumference());
        System.out.printf("Distance this trip: %.2lf", distance);
        System.out.printf("Total distance travelled: %.2lf", totalKm);
        System.out.printf("Current fuel status: %.2f", fuelLevel);
    }
}
