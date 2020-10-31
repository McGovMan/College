// Abstract base class Employee.

// Java core packages
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import javax.swing.*;
import java.text.DecimalFormat;
import java.time.*;

public abstract class Employee {

    private String firstName;
    private String lastName;
    private LocalDate joinDate;
    private Integer id;
    private static Integer counter = 1;
    private Money taxCredits;

    // constructor (kept for backwards compatibility)
    public Employee(String first, String last) {
        firstName = first;
        lastName = last;
    }

    // constructor
    public Employee(String first, String last, Double tax, LocalDate join) {
        firstName = first;
        lastName = last;
        joinDate = join;
        taxCredits = Money.of(CurrencyUnit.USD, tax);
        id = counter;
        counter++;
    }

    // get first name
    public String getFirstName() {
        return firstName;
    }

    // get last name
    public String getLastName() {
        return lastName;
    }

    // get join date
    public LocalDate getJoinDate() {
        return joinDate;
    }

    // get id
    public Integer getID() {
        return id;
    }

    // get tax credits
    public Money getTaxCredits() {
        return taxCredits;
    }

    public String toString() {
        return firstName + ' ' + lastName;
    }

    // checks earnings and throws a LowWageException if earnings is lower than 100
    public Boolean checkForLowWage(Money grossPerMonth)
    {
        try {
            if (grossPerMonth.getAmount().doubleValue() < 100)
            {
                // Throw exception if earnings before bonus is lower than 100
                DecimalFormat precision2 = new DecimalFormat("0.00");
                throw new LowWageException("Employee " + this.getFirstName() + " " +
                        this.getLastName() + " has earned $" + grossPerMonth.getAmount().doubleValue() + " gross, which is less than $100 in one month.");
            }
        }
        catch (LowWageException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Low Wage Exception", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public abstract Money earnings(taxCalculator taxCalc);
}
