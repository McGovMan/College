// PieceWorker class derived from Employee

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.time.LocalDate;

public final class PieceWorker extends Employee {

    private Money wagePerPiece; // wage per piece output
    private int quantity; // output for week

    // constructor for class PieceWorker
    public PieceWorker(String first, String last,
                       double wage, int numberOfItems, double taxCredits, LocalDate join) {
        super(first, last, taxCredits, join); // call superclass constructor
        setWage(wage);
        setQuantity(numberOfItems);
    }

    // set PieceWorker's wage
    public void setWage(double wage) {
        wagePerPiece = Money.of(CurrencyUnit.USD, (wage > 0 ? wage : 0));
    }

    // set number of items output
    public void setQuantity(int numberOfItems) {
        quantity = (numberOfItems > 0 ? numberOfItems : 0);
    }

    // determine PieceWorker's earnings per month
    public Money earnings(taxCalculator taxCalc) {
        Money grossPerMonth = wagePerPiece.multipliedBy(Integer.valueOf(quantity).longValue()).multipliedBy(4);

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
        return "Piece worker: " + super.toString();
    }
}
