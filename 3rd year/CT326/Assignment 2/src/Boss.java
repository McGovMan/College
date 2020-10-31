// Boss class derived from Employee.

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.time.LocalDate;

public final class Boss extends Employee {

    private Money weeklySalary;

    // constructor for class Boss
    public Boss(String first, String last, double salary, double taxCredits, LocalDate join) {
        super(first, last, taxCredits, join); // call superclass constructor
        setWeeklySalary(salary);
    }

    // set Boss's salary
    public void setWeeklySalary(double salary) {
        weeklySalary = Money.of(CurrencyUnit.USD, (salary > 0 ? salary : 0));
    }

    // get Boss's pay per month
    public Money earnings(taxCalculator taxCalc) {
        Money grossPerMonth = weeklySalary.multipliedBy(4);

        if (this.checkForLowWage(grossPerMonth)) {
            // give bonus if employee has been there 5 years
            if (LocalDate.now().isAfter(this.getJoinDate().plusYears(5))) {
                grossPerMonth.plus(200);
            } // else employee hasn't been there 5 years and gets no bonus
        }

        // return gross Per Month After Tax
        return taxCalc.calculateTax(grossPerMonth, this.getTaxCredits());
    }

    // get String representation of Boss's name
    public String toString() {
        return "Boss: " + super.toString();
    }
} // end class Boss
