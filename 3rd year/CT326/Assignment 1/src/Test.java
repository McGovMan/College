// Driver for Employee hierarchy

// Java core packages
import java.text.DecimalFormat;
import java.time.LocalDate;

// Java extension packages
import javax.swing.JOptionPane;

public class Test {

    // test Employee hierarchy
    public static void main(String args[]) {
        Employee[] employeeArray = new Employee[4];
        String output = "";

        // Assigning all test employees
        employeeArray[0] = new Boss("John", "Smith", 800.0, LocalDate.parse("2014-01-08"));
        employeeArray[1] = new CommissionWorker( "Sue", "Jones", 400.0, 3.0, 150, LocalDate.parse("2016-01-08"));
        employeeArray[2] = new PieceWorker("Bob", "Lewis", 2.5, 200, LocalDate.parse("2017-01-08"));
        employeeArray[3] = new HourlyWorker("Karen", "Price", 13.75, 1, LocalDate.parse("2014-01-08"));

        DecimalFormat precision2 = new DecimalFormat("0.00");

        // Looping over each employee, doing calculations on earnings and getting ready to print information
        for (Employee employee : employeeArray) {
            double earnings = employee.earnings();

            if (employee.checkForLowWage(earnings)) {
                // give bonus if employee has been there 5 years
                if (LocalDate.now().isAfter(employee.getJoinDate().plusYears(5))) {
                    earnings += 200;
                } // else employee hasn't been there 5 years and gets no bonus
            }

            // Add employee info and earnings to string to be printed by JOptionePane
            output += employee.toString() + " earned $"
                    + precision2.format(earnings) + "\n";
        }

        // Display employee information
        JOptionPane.showMessageDialog(null, output,
                "Demonstrating Polymorphism",
                JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
} // end class Test
