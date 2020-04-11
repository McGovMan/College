
/**
 * Write a description of class TestCar here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestCar
{
    public static void main(String []args) {
        Car car = new Car("Masey Furguson 200");
        Engine engine = new Engine("2 Lither Wan", 30);
        car.add(engine);
        Wheel wheel = new Wheel ("Good Oul Wheel", 15);
        car.add(wheel);
        car.setFuel(100);
        System.out.printf("Current fuel: %.2f\n", car.getFuel());
        car.drive();
        car.printState();
        car.setFuel(50);
        System.out.printf("Current fuel: %.2f\n", car.getFuel());
        car.drive();
        car.printState();
    }
}
