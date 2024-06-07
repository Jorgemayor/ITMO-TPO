package comp.functions;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Csc {
    private final Sin sin;

    public Csc(Sin sin) {
        this.sin = sin;
    }

    public Csc() {
        this.sin = new Sin();
    }

    public BigDecimal calc(BigDecimal x, double eps) {
        MathContext mc = new MathContext(10, RoundingMode.HALF_UP);

        BigDecimal sinVal = sin.calc(x, eps);
        if (sinVal == null || sinVal.compareTo(BigDecimal.ZERO) == 0) {
            return null; // Return null if sinVal is NaN or zero
        }
        return BigDecimal.ONE.divide(sinVal, mc);
    }
}