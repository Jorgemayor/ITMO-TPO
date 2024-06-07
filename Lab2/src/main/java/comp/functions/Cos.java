package comp.functions;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Cos {

    private final Sin sin;

    public Cos(Sin sin) {
        this.sin = sin;
    }

    public Cos() {
        this.sin = new Sin();
    }

    public BigDecimal calc(BigDecimal x, double eps) {
        MathContext mc = new MathContext(10, RoundingMode.HALF_UP);

        BigDecimal TWO_PI = new BigDecimal(Math.PI * 2, mc);
        BigDecimal PI = new BigDecimal(Math.PI, mc);
        BigDecimal HALF_PI = PI.divide(BigDecimal.valueOf(2), mc);

        x = x.remainder(TWO_PI, mc);

        if (x.compareTo(PI.negate()) < 0) {
            while (x.compareTo(PI.negate()) < 0) {
                x = x.add(TWO_PI, mc);
            }
        }

        if (x.compareTo(PI) > 0) {
            while (x.compareTo(PI) > 0) {
                x = x.subtract(TWO_PI, mc);
            }
        }

        BigDecimal sinVal = sin.calc(x, eps);
        if (sinVal == null) {
            return null;
        }

        BigDecimal sinSquared = sinVal.multiply(sinVal, mc);
        BigDecimal result;

        if (x.compareTo(HALF_PI) > 0 || x.compareTo(HALF_PI.negate()) < 0) {
            result = BigDecimal.ONE.subtract(sinSquared, mc).sqrt(mc).negate();
        } else {
            result = BigDecimal.ONE.subtract(sinSquared, mc).sqrt(mc);
        }

        if (result.abs(mc).compareTo(BigDecimal.ONE) > 0) return null; // Return null for out of range
        if (result.abs(mc).compareTo(new BigDecimal(eps)) <= 0) return BigDecimal.ZERO;

        return result;
    }
}
