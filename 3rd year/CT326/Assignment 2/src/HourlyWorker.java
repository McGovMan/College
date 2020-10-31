// Definition of class HourlyWorker

import org.joda.money.*;

import java.time.LocalDate;

public final class HourlyWorker extends Employee {

    private Money wage; // wage per hour
    private double hours; // hours worked for week

    // constructor for class HourlyWorker
    public HourlyWorker(String first, String last,
                        double wagePerHour, double hoursWorked, double taxCredits, LocalDate join) {
        super(first, last, taxCredits, join); // call superclass constructor
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
    public Money earnings(taxCalculator taxCalc) {
        Money grossPerMonth = wage.multipliedBy(Double.valueOf(hours).longValue()).multipliedBy(4);

        if (this.checkForLowWage(grossPerMonth)) {
            // give bonus if employee has been there 5 years
            if (LocalDate.now().isAfter(this.getJoinDate().plusYears(5))) {
                grossPerMonth.plus(200);
            } // else employee hasn't been there 5 years and gets no bonus
        }

        // return gross Per Month After Tax
        return taxCalc.calculateTax(grossPerMonth, this.getTaxCredits());
    }

    public String toString() {
        return "Hourly worker: " + super.toString();
    }
}
