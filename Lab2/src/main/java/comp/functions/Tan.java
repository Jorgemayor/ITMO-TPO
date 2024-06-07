package comp.functions;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Tan {
    private final Sin sin;
    private final Cos cos;

    public Tan(Sin sin, Cos cos) {
        this.sin = sin;
        this.cos = cos;
    }

    public Tan() {
        this.sin = new Sin();
        this.cos = new Cos();
    }

    public BigDecimal calc(BigDecimal x, double eps) {
        MathContext mc = new MathContext(10, RoundingMode.HALF_UP);

        BigDecimal sinVal = sin.calc(x, eps);
        BigDecimal cosVal = cos.calc(x, eps);

        if (sinVal == null || cosVal == null || cosVal.compareTo(BigDecimal.ZERO) == 0) {
            return null; // Return null if sinVal or cosVal is NaN or cosVal is zero
        }

        return sinVal.divide(cosVal, mc);
    }
}