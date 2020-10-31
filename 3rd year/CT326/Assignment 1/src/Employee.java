// Abstract base class Employee.

// Java core packages
import javax.swing.*;
import java.time.*;

public abstract class Employee {

    private String firstName;
    private String lastName;
    private LocalDate joinDate;
    private Integer id;
    private static Integer counter = 1;

    // constructor (kept for backwards compatibility)
    public Employee(String first, String last) {
        firstName = first;
        lastName = last;
    }

    // constructor
    public Employee(String first, String last, LocalDate join) {
        firstName = first;
        lastName = last;
        joinDate = join;
        id = counter;
        counter++;
    }

    // get first name
    public String getFirstName() { return firstName; }

    // get last name
    public String getLastName() {
        return lastName;
    }

    // get join date
    public LocalDate getJoinDate() { return joinDate; }

    // get id
    public Integer getID() { return id; }

    public String toString() {
        return firstName + ' ' + lastName;
    }

    // checks earnings and throws a LowWageException if earnings is lower than 100
    public Boolean checkForLowWage(double earnings)
    {
        try {
            if (earnings < 100)
            {
                // Throw exception if earnings before bonus is lower than 100
                throw new LowWageException("Employee " + this.getFirstName() + " " + this.getLastName() + " has earned $" + earnings + ", which is less than $100 in one month.");
            }
        }
        catch (LowWageException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Low Wage Exception", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public abstract double earnings();
}
