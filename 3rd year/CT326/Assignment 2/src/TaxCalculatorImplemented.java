// Definition of class TaxCalculatorImplemented

import org.joda.money.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculatorImplemented implements taxCalculator {

    public TaxCalculatorImplemented() {

    }

    @Override
    public Money calculateTax(Money earnings, Money taxCredits) {
        // tax owed = (earnings * 20%) - taxCredits
        Money taxOwed = earnings.dividedBy(5.0, RoundingMode.UNNECESSARY).minus(taxCredits);

        // If tax credits bring tax owed into a negative, set taxOwed to zero.
        if (taxOwed.getAmount().doubleValue() < 0) taxOwed = Money.of(CurrencyUnit.USD, 0);

        // Take home pay
        return earnings.minus(taxOwed);
    }
}
