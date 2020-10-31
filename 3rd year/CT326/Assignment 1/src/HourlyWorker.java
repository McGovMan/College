// Definition of class HourlyWorker

import org.joda.money.*;

import java.time.LocalDate;

public final class HourlyWorker extends Employee {

    private Money wage; // wage per hour
    private double hours; // hours worked for week

    // constructor for class HourlyWorker
    public HourlyWorker(String first, String last,
                        double wagePerHour, double hoursWorked, LocalDate join) {
        super(first, last, join); // call superclass constructor
        setWage(wagePerHour);
        setHours(hoursWorked);
    }

    // Set the wage
    public void setWage(double wagePerHour) {
        wage = Money.of(CurrencyUnit.USD, wagePerHour > 0 ? wagePerHour : 0);
    }

    // Set the hours worked
    public void setHours(double hoursWorked) {
        hours = (hoursWorked >= 0 && hoursWorked < 168
                ? hoursWorked : 0);
    }

    // Get the HourlyWorker's pay per month
    public double earnings() {
        Money earnings = wage.multipliedBy(Double.valueOf(hours).longValue()).multipliedBy(4);

        return earnings.getAmount().doubleValue();
    }

    public String toString() {
        return "Hourly worker: " + super.toString();
    }
}
