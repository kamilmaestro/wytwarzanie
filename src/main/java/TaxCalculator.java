import java.math.BigDecimal;

interface TaxCalculator {
  BigDecimal calculateTax(BigDecimal price);
}

class ZeroTaxCalculator implements TaxCalculator {

  static String testingStaticMethods() {
    return "static";
  }

  @Override
  public BigDecimal calculateTax(BigDecimal price) {
    return BigDecimal.ZERO;
  }

}

class XTaxCalculator implements TaxCalculator {

  BigDecimal multiplier;

  XTaxCalculator(BigDecimal multiplier) {
    this.multiplier = multiplier;
  }

  public BigDecimal calculateTax(BigDecimal price) {
    return price.multiply(multiplier);
  }

}
