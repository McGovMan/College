// PieceWorker class derived from Employee

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.time.LocalDate;

public final class PieceWorker extends Employee {

    private Money wagePerPiece; // wage per piece output
    private int quantity; // output for week

    // constructor for class PieceWorker
    public PieceWorker(String first, String last,
                       double wage, int numberOfItems, LocalDate join) {
        super(first, last, join); // call superclass constructor
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
    public double earnings() {
        Money earnings = wagePerPiece.multipliedBy(Integer.valueOf(quantity).longValue()).multipliedBy(4);

        return earnings.getAmount().doubleValue();
    }

    public String toString() {
        return "Piece worker: " + super.toString();
    }
}
