package comp.functions;

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

    public double calc(double x, double eps) {
        double sinVal = sin.calc(x, eps);
        double cosVal = cos.calc(x, eps);
        if (Double.isNaN(cosVal) || Double.isNaN(sinVal) || cosVal == 0) {
            return Double.NaN;
        }
        return sinVal / cosVal;
    }
}
