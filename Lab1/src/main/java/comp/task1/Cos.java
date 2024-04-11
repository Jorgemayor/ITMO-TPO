package comp.task1;

public class Cos {
    public static double calc(double x) {
        double y = x*Math.PI/180;

        int n = 10;
        int i, j, fac;
        double cosine = 0;

        // cos x = 1 – (x2)/2! + (x4)/4! – (x6)/6! + ... = Sum ((-1)n * x(2n)/(2n)!) for n = 0 to n = infinity
        for(i=0; i<=n; i++){
            fac = 1;
            for(j=2; j<=2*i; j++){
                fac *= j;
            }
            cosine += Math.pow(-1.0,i) * Math.pow(y,2*i) / fac;
        }
        return cosine;
    }
}
