package comp;


import comp.functions.*;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        System.out.println("Functions:");
        Sin sin = new Sin();
        Cos cos = new Cos();
        Tan tan = new Tan();
        Csc csc = new Csc();
        Ln ln = new Ln();
        Log log = new Log();

        System.out.println("Sinus");
        System.out.println(sin.calc(BigDecimal.ONE, 0.001));
        System.out.println("Cosines");
        System.out.println(cos.calc(BigDecimal.ONE, 0.001));
        System.out.println("Tan");
        System.out.println(tan.calc(BigDecimal.valueOf(Math.PI / 2), 0.001));
        System.out.println("Csc");
        System.out.println(csc.calc(BigDecimal.ONE, 0.001));
        System.out.println("Ln");
        System.out.println(ln.calc(BigDecimal.ONE, 0.001));
        System.out.println("Log");
        System.out.println(log.calc( BigDecimal.ONE, 0.001));

        System.out.println("\nTask:");
        Task task = new Task();
        System.out.println(task.calc(BigDecimal.valueOf(-3.14), 0.1));

        System.out.println("\nWriter");
        CsvWriter writer = new CsvWriter("src/main/resources/results.csv");
        BigDecimal step = new BigDecimal(1);
        for (BigDecimal value = new BigDecimal(-15);
             value.compareTo(new BigDecimal(15)) < 0;
             value = value.add(step)) {
            writer.write(value.doubleValue(), task.calc(value, 0.1).doubleValue());
        }
    }
}