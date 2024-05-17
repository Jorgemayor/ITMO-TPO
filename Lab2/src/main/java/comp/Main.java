package comp;


import comp.functions.*;

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
        System.out.println(sin.calc(1, 0.001));
        System.out.println("Cosines");
        System.out.println(cos.calc(1, 0.001));
        System.out.println("Tan");
        System.out.println(tan.calc(Math.PI / 2, 0.001));
        System.out.println("Csc");
        System.out.println(csc.calc(1, 0.001));
        System.out.println("Ln");
        System.out.println(ln.calc(1, 0.001));
        System.out.println("Log");
        System.out.println(log.calc( 1, 0.001));

        System.out.println("\nTask:");
        Task task = new Task();
        System.out.println(task.calc(-1, 0.001));

        System.out.println("\nWriter");
        CsvWriter writer = new CsvWriter("src/main/resources/results.csv");
        for(double d=-15; d<=15; d+=0.1)
            writer.write(d, task.calc(d, 0.001));
    }
}