package comp.functions;

public class Csc {
    private final Sin sin;

    public Csc(Sin sin) {
        this.sin = sin;
    }

    public Csc() {
        this.sin = new Sin();
    }

    public double calc(double x, double eps) {
        double sinVal = sin.calc(x, eps);
        if (Double.isNaN(sinVal) || sinVal == 0) {
            return Double.NaN;
        }
        return 1 / sinVal;
    }
}