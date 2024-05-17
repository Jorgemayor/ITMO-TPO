package comp.functions;

public class Log {

    private final Ln ln;
    private final double base;

    public Log(Ln ln, double base) {
        if (base <= 0 || base == 1) {
            throw new IllegalArgumentException("Base must be greater than 0 and not 1");
        }
        this.ln = ln;
        this.base = base;
    }

    public Log() {
        this.ln = new Ln();
        this.base = 10;
    }

    public double calc(double x, double esp) {
        return ln.calc(x, esp) / ln.calc(this.base, esp);
    }
}