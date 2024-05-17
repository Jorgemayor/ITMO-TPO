package comp.functions;

import static java.lang.Math.pow;

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

    public double calc(double x, double eps) {

        if (x <= 0) {
            // x <= 0 : (((((csc(x) ^ 2) ^ 2) / tan(x)) - tan(x)) * (cos(x) ^ 2))
            return (pow(pow(csc.calc(x, eps), 2), 2) / tan.calc(x, eps) - tan.calc(x, eps)) * (pow(cos.calc(x, eps), 2));
        }
        else {
            // x > 0 : (((((log_2(x) / log_2(x)) ^ 2) / ln(x)) + log_5(x)) ^ 3)
            return pow(pow(log2.calc(x, eps) / log2.calc(x, eps), 2) / ln.calc(x, eps) + log5.calc(x, eps), 3);
        }
    }
}
