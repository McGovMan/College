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
                            double salary, double commission, int quantity, LocalDate join) {
        super(first, last, join); // call superclass constructor
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
    public double earnings() {
        Money earnings = salary.plus(commission * quantity).multipliedBy(4);

        return earnings.getAmount().doubleValue();
    }

    // get String representation of CommissionWorker's name
    public String toString() {
        return "Commission worker: " + super.toString();
    }
} // end class CommissionWorker
