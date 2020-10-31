// Driver for Employee hierarchy

// Java core packages
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;

// Java extension packages
import javax.swing.JOptionPane;

public class Test {

    // test Employee hierarchy
    public static void main(String[] args) {
        Employee[] employeeArray = new Employee[4];
        String implementedOutput = "";
        String anonymousInnerClassOutput = "";
        String lambdaFunctionOutput = "";

        // Assigning all test employees
        employeeArray[0] = new Boss("John", "Smith", 800.0, 300.0, LocalDate.parse("2014-01-08"));
        employeeArray[1] = new CommissionWorker( "Sue", "Jones", 400.0, 3.0, 150, 250.0, LocalDate.parse("2016-01-08"));
        employeeArray[2] = new PieceWorker("Bob", "Lewis", 2.5, 200, 200.0, LocalDate.parse("2017-01-08"));
        employeeArray[3] = new HourlyWorker("Karen", "Price", 13.75, 1, 150.0, LocalDate.parse("2014-01-08"));

        DecimalFormat precision2 = new DecimalFormat("0.00");

        /*
         * Looping over each employee, doing calculations on earnings and getting ready to print information
        */

        // TaxCalculator Implemented
        // Display information on what way we are implementing the tax calculator
        JOptionPane.showMessageDialog(null, "Demonstrating using a class that implements taxCalculator",
                "Testing Information",
                JOptionPane.INFORMATION_MESSAGE);

        for (Employee employee : employeeArray) {
            // Add employee info and earnings to string to be printed by JOptionPane
            TaxCalculatorImplemented taxCalc = new TaxCalculatorImplemented();

            implementedOutput += employee.toString() + " earned $"
                    + precision2.format(employee.earnings(taxCalc).getAmount().doubleValue()) + "\n";
        }

        // Display employee information
        JOptionPane.showMessageDialog(null, implementedOutput,
                "Demonstrating using a class that implements taxCalculator",
                JOptionPane.INFORMATION_MESSAGE);

        // Anonymous Inner Class
        // Display information on what way we are implementing the tax calculator
        JOptionPane.showMessageDialog(null, "Demonstrating using an anonymous inner class",
                "Testing Information",
                JOptionPane.INFORMATION_MESSAGE);

        taxCalculator taxCalc = new taxCalculator()
        {
            @Override
            public Money calculateTax(Money earnings, Money taxCredits) {
                // tax owed = (earnings * 20%) - taxCredits
                Money taxOwed = earnings.dividedBy(5.0, RoundingMode.UNNECESSARY).minus(taxCredits);

                // If tax credits bring tax owed into a negative, set taxOwed to zero.
                if (taxOwed.getAmount().doubleValue() < 0) taxOwed = Money.of(CurrencyUnit.USD, 0);

                // Take home pay
                return earnings.minus(taxOwed);
            }
        };

        for (Employee employee : employeeArray) {
            // Add employee info and earnings to string to be printed by JOptionPane
            anonymousInnerClassOutput += employee.toString() + " earned $"
                    + precision2.format(employee.earnings(taxCalc).getAmount().doubleValue()) + "\n";
        }

        // Display employee information
        JOptionPane.showMessageDialog(null, anonymousInnerClassOutput,
                "Demonstrating using an anonymous inner class",
                JOptionPane.INFORMATION_MESSAGE);

        // Lambda function
        // Display information on what way we are implementing the tax calculator
        JOptionPane.showMessageDialog(null, "Demonstrating using a lambda function",
                "Testing Information",
                JOptionPane.INFORMATION_MESSAGE);

        taxCalc = (earnings, taxCredits) -> {
            // tax owed = (earnings * 20%) - taxCredits
            Money taxOwed = earnings.dividedBy(5.0, RoundingMode.UNNECESSARY).minus(taxCredits);

            // If tax credits bring tax owed into a negative, set taxOwed to zero.
            if (taxOwed.getAmount().doubleValue() < 0) taxOwed = Money.of(CurrencyUnit.USD, 0);

            // Take home pay
            return earnings.minus(taxOwed);
        };

        for (Employee employee : employeeArray) {
            // Add employee info and earnings to string to be printed by JOptionPane
            lambdaFunctionOutput += employee.toString() + " earned $"
                    + precision2.format(employee.earnings(taxCalc).getAmount().doubleValue()) + "\n";
        }

        // Display employee information
        JOptionPane.showMessageDialog(null, lambdaFunctionOutput,
                "Demonstrating using a lambda function",
                JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
} // end class Test
