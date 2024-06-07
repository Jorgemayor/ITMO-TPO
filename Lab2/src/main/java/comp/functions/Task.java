package comp.functions;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Task {

    private final Cos cos;
    private final Tan tan;
    private final Csc csc;
    private final Log log2;
    private final Log log5;
    private final Ln ln;

    public Task() {
        this.cos = new Cos();
        this.tan = new Tan();
        this.csc = new Csc();
        this.ln = new Ln();
        this.log2 = new Log(ln, 2);
        this.log5 = new Log(ln, 5);
    }

    public Task(Cos cos, Tan tan, Csc csc, Ln ln, Log log2, Log log5) {
        this.cos = cos;
        this.tan = tan;
        this.csc = csc;
        this.ln = ln;
        this.log2 = log2;
        this.log5 = log5;
    }

    public BigDecimal calc(BigDecimal x, double eps) {
        MathContext mc = new MathContext(10, RoundingMode.HALF_UP);

        if (x.compareTo(BigDecimal.ZERO) <= 0) {
            // x <= 0 : (((((csc(x) ^ 2) ^ 2) / tan(x)) - tan(x)) * (cos(x) ^ 2))
            BigDecimal cscVal = csc.calc(x, eps);
            BigDecimal tanVal = tan.calc(x, eps);
            BigDecimal cosVal = cos.calc(x, eps);

            if (cscVal == null) {
                cscVal = BigDecimal.valueOf(Double.MAX_VALUE);
            }

            if (tanVal == null || tanVal.compareTo(BigDecimal.ZERO) <= 0) {
                return BigDecimal.valueOf(Double.MAX_VALUE);
            }

            if (cosVal == null) {
                cosVal = BigDecimal.valueOf(Double.MAX_VALUE);
            }

            return (cscVal.pow(2, mc).pow(2, mc).divide(tanVal, mc).subtract(tanVal, mc))
                    .multiply(cosVal.pow(2, mc), mc);
        } else {
            // x > 0 : (((((log_2(x) / log_2(x)) ^ 2) / ln(x)) + log_5(x)) ^ 3)
            BigDecimal log2Val = log2.calc(x, eps);
            BigDecimal lnVal = ln.calc(x, eps);
            BigDecimal log5Val = log5.calc(x, eps);

            if (log2Val == null || log2Val.compareTo(BigDecimal.ZERO) == 0) {
                log2Val = BigDecimal.ONE;
            }

            if (log5Val == null || lnVal == null || lnVal.compareTo(BigDecimal.ZERO) == 0) {
                log5Val = BigDecimal.valueOf(Double.MAX_VALUE);
                lnVal = BigDecimal.ONE;
            }

            return ((log2Val
                    .divide(log2Val, mc))
                    .pow(2, mc)
                    .divide(lnVal, mc)
                    .add(log5Val, mc))
                    .pow(3, mc);
        }
    }
}
