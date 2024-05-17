package comp;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class CsvWriter {

    private static final CSVFormat FORMAT = CSVFormat.DEFAULT.builder().setDelimiter(';').build();
    private CSVPrinter csvPrinter;

    public CsvWriter(String path) {
        try {
            Writer writer = new FileWriter(path, true);
            this.csvPrinter = FORMAT.print(writer);
        } catch (IOException e) {
            System.out.println("Wrong path");
        }
    }

    public void write(double x, double res) {
        try {
            csvPrinter.printRecord(x, res);
        } catch (IOException e) {
            System.out.println("Wrong path");
        }
    }
}
