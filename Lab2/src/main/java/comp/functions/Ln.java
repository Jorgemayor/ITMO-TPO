package comp.functions;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Ln {
    public BigDecimal calc(BigDecimal x, double eps) {
        MathContext mc = new MathContext(10, RoundingMode.HALF_UP);

        if (x == null || x.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Argument must be a positive number");
        }

        BigDecimal ONE = BigDecimal.ONE;
        BigDecimal TWO = new BigDecimal(2);
        BigDecimal constant = x.subtract(ONE).multiply(x.subtract(ONE), mc)
                .divide(x.add(ONE).multiply(x.add(ONE), mc), mc);

        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal currentValue = x.subtract(ONE).divide(x.add(ONE), mc);
        int step = 1;

        BigDecimal epsilon = new BigDecimal(eps / 2, mc);

        while (currentValue.abs(mc).compareTo(epsilon) > 0) {
            sum = sum.add(currentValue, mc);
            currentValue = currentValue.multiply(constant, mc)
                    .multiply(new BigDecimal(2 * step - 1), mc)
                    .divide(new BigDecimal(2 * step + 1), mc);
            step++;
        }
        sum = sum.multiply(TWO, mc);
        return sum;
    }
}