// Boss class derived from Employee.

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.time.LocalDate;

public final class Boss extends Employee {

    private Money weeklySalary;

    // constructor for class Boss
    public Boss(String first, String last, double salary, LocalDate join) {
        super(first, last, join); // call superclass constructor
        setWeeklySalary(salary);
    }

    // set Boss's salary
    public void setWeeklySalary(double salary) {
        weeklySalary = Money.of(CurrencyUnit.USD, (salary > 0 ? salary : 0));
    }

    // get Boss's pay per month
    public double earnings() {
        return weeklySalary.multipliedBy(4).getAmount().doubleValue();
    }

    // get String representation of Boss's name
    public String toString() {
        return "Boss: " + super.toString();
    }
} // end class Boss
