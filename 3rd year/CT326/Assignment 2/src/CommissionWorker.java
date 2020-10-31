// CommissionWorker class derived from Employee

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.time.LocalDate;

public final class CommissionWorker extends Employee {

    private Money salary; // base salary per week
    private double commission; // amount per item sold
    private int quantity; // total items sold for week

    // constructor for class CommissionWorker
    public CommissionWorker(String first, String last,
                            double salary, double commission, int quantity, double taxCredits, LocalDate join) {
        super(first, last, taxCredits, join); // call superclass constructor
        setSalary(salary);
        setCommission(commission);
        setQuantity(quantity);
    }

    // set CommissionWorker's weekly base salary
    public void setSalary(double weeklySalary) {
        salary = Money.of(CurrencyUnit.USD, (weeklySalary > 0 ? weeklySalary : 0));
    }

    // set CommissionWorker's commission
    public void setCommission(double itemCommission) {
        commission = (itemCommission > 0 ? itemCommission : 0);
    }

    // set CommissionWorker's quantity sold
    public void setQuantity(int totalSold) {
        quantity = (totalSold > 0 ? totalSold : 0);
    }

    // determine CommissionWorker's earnings per month
    public Money earnings(taxCalculator taxCalc) {
        Money grossPerMonth = salary.plus(commission * quantity).multipliedBy(4);

        if (this.checkForLowWage(grossPerMonth)) {
            // give bonus if employee has been there 5 years
            if (LocalDate.now().isAfter(this.getJoinDate().plusYears(5))) {
                grossPerMonth.plus(200);
            } // else employee hasn't been there 5 years and gets no bonus
        }

        // return gross Per Month After Tax
        return taxCalc.calculateTax(grossPerMonth, this.getTaxCredits());
    }

    // get String representation of CommissionWorker's name
    public String toString() {
        return "Commission worker: " + super.toString();
    }
} // end class CommissionWorker
