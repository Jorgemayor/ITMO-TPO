package comp.functions;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Log {

    private final Ln ln;
    private final BigDecimal base;

    public Log(Ln ln, double base) {
        if (base <= 0 || base == 1) {
            throw new IllegalArgumentException("Base must be greater than 0 and not 1");
        }
        this.ln = ln;
        this.base = BigDecimal.valueOf(base);
    }

    public Log() {
        this.ln = new Ln();
        this.base = BigDecimal.TEN;
    }

    public BigDecimal calc(BigDecimal x, double eps) {
        MathContext mc = new MathContext(10, RoundingMode.HALF_UP);

        BigDecimal lnX = ln.calc(x, eps);
        BigDecimal lnBase = ln.calc(base, eps);
        return lnX.divide(lnBase, mc);
    }
}