import org.joda.money.Money;

public interface taxCalculator {

  // Returns the tax owed for a particular time period based on the earnings and the tax credits
  // An implementation of this method might e.g. implmenet a simplified version of the Irish tax System
  // where the tax owed = (earnings * 20%) - taxCredits.

  public Money calculateTax(Money earnings, Money taxCredits);

}
