package comp.functions;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Sin {

    public BigDecimal calc(BigDecimal x, double eps) {
        MathContext mc = new MathContext(10, RoundingMode.HALF_UP);

        if (x == null ) {
            throw new IllegalArgumentException("Argument must be a non-null number");
        }

        BigDecimal TWO_PI = new BigDecimal(Math.PI * 2, mc);
        BigDecimal PI = new BigDecimal(Math.PI, mc);
        BigDecimal ONE = BigDecimal.ONE;
        BigDecimal ZERO = BigDecimal.ZERO;

        // Normalize x to the range [-2PI, 2PI]
        x = x.remainder(TWO_PI, mc);

        BigDecimal fact = ONE;
        BigDecimal result_l = ONE;
        BigDecimal result = ZERO;
        BigDecimal xx = x.multiply(x, mc);
        BigDecimal pow = x;
        int sign = 1;
        int cnt = 1;

        while (result_l.subtract(result).abs(mc).compareTo(new BigDecimal(eps)) > 0) {
            fact = fact.divide(new BigDecimal(cnt), mc);
            result_l = result;
            result = result.add(pow.multiply(fact, mc).multiply(new BigDecimal(sign), mc), mc);
            sign = -sign;
            fact = fact.divide(new BigDecimal(cnt + 1), mc);
            pow = pow.multiply(xx, mc);
            cnt += 2;
        }

        // Handle edge cases
        if (result.abs(mc).compareTo(ONE) > 0) return null; // Return null for out of range
        if (result.abs(mc).compareTo(new BigDecimal(eps)) < 0) return ZERO;

        return result;
    }
}