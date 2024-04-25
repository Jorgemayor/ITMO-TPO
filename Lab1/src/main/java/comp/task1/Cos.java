package comp.task1;

public class Cos {

    public static double calc(double x) {
        return calc(x, true);
    }

    static double factorial(int n) {
        double fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static double calc(double x, boolean rad) {

        if (!rad) x = x*Math.PI/180;

        // Convert angle x to be between -2π and 2π
        x = x % (2 * Math.PI);

        double cosX = 1;
        int sign = -1;
        int power = 2;
        int fact = 2;

        int iter = 100;

        for (int i = 0; i < iter; i++) {
            cosX += sign * Math.pow(x, power) / factorial(fact);
            sign *= -1;
            power += 2;
            fact += 2;
        }

        return cosX;
    }
}
