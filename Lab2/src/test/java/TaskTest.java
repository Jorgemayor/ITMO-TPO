import comp.functions.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class TaskTest {
    private static Sin mockedSin;
    private static Cos mockedCos;
    private static Tan mockedTan;
    private static Csc mockedCsc;

    private static Ln mockedLn;
    private static Log mockedLog2;
    private static Log mockedLog5;

    private static Sin sin;

    private static Cos cos;
    private static Tan tan;
    private static Csc csc;
    private static Ln ln;
    private static Log log2;
    private static Log log5;

    private static final double eps = 0.1;
    private static final MathContext mc = new MathContext(10, RoundingMode.HALF_UP);


    @BeforeAll
    static void init() {
        mockedSin = Mockito.mock(Sin.class);
        mockedCos = Mockito.mock(Cos.class);
        mockedTan = Mockito.mock(Tan.class);
        mockedCsc = Mockito.mock(Csc.class);

        mockedLn = Mockito.mock(Ln.class);
        mockedLog2 = Mockito.mock(Log.class);
        mockedLog5 = Mockito.mock(Log.class);

        sin = new Sin();
        cos = new Cos(sin);
        tan = new Tan(sin, cos);
        csc = new Csc(sin);

        ln = new Ln();
        log2 = new Log(ln, 2);
        log5 = new Log(ln, 5);

        try {
            Reader cosReader = new FileReader("src/test/resources/cos.csv");
            Reader sinReader = new FileReader("src/test/resources/sin.csv");
            Reader tanReader = new FileReader("src/test/resources/tan.csv");
            Reader lnReader = new FileReader("src/test/resources/ln.csv");
            Reader log2Reader = new FileReader("src/test/resources/log2.csv");
            Reader log5Reader = new FileReader("src/test/resources/log5.csv");

            for (CSVRecord record : CSVFormat.DEFAULT.parse(cosReader)) {
                Mockito.when(mockedCos.calc(BigDecimal.valueOf(Double.parseDouble(record.get(0))), eps))
                        .thenReturn(BigDecimal.valueOf(Double.parseDouble(record.get(1))));
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(sinReader)) {
                Mockito.when(mockedSin.calc(BigDecimal.valueOf(Double.parseDouble(record.get(0))), eps))
                        .thenReturn(BigDecimal.valueOf(Double.parseDouble(record.get(1))));
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(tanReader)) {
                Mockito.when(mockedTan.calc(BigDecimal.valueOf(Double.parseDouble(record.get(0))), eps))
                        .thenReturn(BigDecimal.valueOf(Double.parseDouble(record.get(1))));
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(lnReader)) {
                Mockito.when(mockedLn.calc(BigDecimal.valueOf(Double.parseDouble(record.get(0))), eps))
                        .thenReturn(BigDecimal.valueOf(Double.parseDouble(record.get(1))));
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(log2Reader)) {
                Mockito.when(mockedLog2.calc(BigDecimal.valueOf(Double.parseDouble(record.get(0))), eps))
                        .thenReturn(BigDecimal.valueOf(Double.parseDouble(record.get(1))));
            }
            for (CSVRecord record : CSVFormat.DEFAULT.parse(log5Reader)) {
                Mockito.when(mockedLn.calc(BigDecimal.valueOf(Double.parseDouble(record.get(0))), eps))
                        .thenReturn(BigDecimal.valueOf(Double.parseDouble(record.get(1))));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/task.csv")
    void testMock(double valueD, double expectedD) {
        BigDecimal value = new BigDecimal(valueD, mc);
        BigDecimal expected = new BigDecimal(expectedD, mc);
        Task task = new Task(mockedCos, mockedTan, mockedCsc, mockedLn, mockedLog2, mockedLog5);
        Assertions.assertEquals(expected, task.calc(value, eps));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/task.csv")
    void testCos(double valueD, double expectedD) {
        BigDecimal value = new BigDecimal(valueD);
        BigDecimal expected = new BigDecimal(expectedD);
        Task task = new Task(cos, mockedTan, mockedCsc, mockedLn, mockedLog2, mockedLog5);
        Assertions.assertEquals(expected, task.calc(value, eps));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/task.csv")
    void testTan(double valueD, double expectedD) {
        BigDecimal value = new BigDecimal(valueD);
        BigDecimal expected = new BigDecimal(expectedD);
        Task task = new Task(mockedCos, tan, mockedCsc, mockedLn, mockedLog2, mockedLog5);
        Assertions.assertEquals(expected, task.calc(value, eps));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/task.csv")
    void testCosTan(double valueD, double expectedD) {
        BigDecimal value = new BigDecimal(valueD);
        BigDecimal expected = new BigDecimal(expectedD);
        Task task = new Task(cos, tan, mockedCsc, mockedLn, mockedLog2, mockedLog5);
        Assertions.assertEquals(expected, task.calc(value, eps));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/task.csv")
    void testTanArg(double valueD, double expectedD) {
        BigDecimal value = new BigDecimal(valueD);
        BigDecimal expected = new BigDecimal(expectedD);
        Task task = new Task(mockedCos, new Tan(sin, cos), mockedCsc, mockedLn, mockedLog2, mockedLog5);
        Assertions.assertEquals(expected, task.calc(value, eps));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/task.csv")
    void testCsc(double valueD, double expectedD) {
        BigDecimal value = new BigDecimal(valueD);
        BigDecimal expected = new BigDecimal(expectedD);
        Task task = new Task(mockedCos, mockedTan, csc, mockedLn, mockedLog2, mockedLog5);
        Assertions.assertEquals(expected, task.calc(value, eps));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/task.csv")
    void testCscArg(double valueD, double expectedD) {
        BigDecimal value = new BigDecimal(valueD);
        BigDecimal expected = new BigDecimal(expectedD);
        Task task = new Task(mockedCos, mockedTan, new Csc(mockedSin), mockedLn, mockedLog2, mockedLog5);
        Assertions.assertEquals(expected, task.calc(value, eps));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/task.csv")
    void testArg(double valueD, double expectedD) {
        BigDecimal value = new BigDecimal(valueD);
        BigDecimal expected = new BigDecimal(expectedD);
        Task task = new Task(cos, new Tan(sin, cos), new Csc(sin), mockedLn, mockedLog2, mockedLog5);
        Assertions.assertEquals(expected, task.calc(value, eps));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/task.csv")
    void testLn(double valueD, double expectedD) {
        BigDecimal value = new BigDecimal(valueD);
        BigDecimal expected = new BigDecimal(expectedD);
        Task task = new Task(mockedCos, mockedTan, mockedCsc, ln, mockedLog2, mockedLog5);
        Assertions.assertEquals(expected, task.calc(value, eps));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/task.csv")
    void testLog2(double valueD, double expectedD) {
        BigDecimal value = new BigDecimal(valueD);
        BigDecimal expected = new BigDecimal(expectedD);
        Task task = new Task(mockedCos, mockedTan, mockedCsc, mockedLn, log2, mockedLog5);
        Assertions.assertEquals(expected, task.calc(value, eps));
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/task.csv")
    void testLog5(double valueD, double expectedD) {
        BigDecimal value = new BigDecimal(valueD);
        BigDecimal expected = new BigDecimal(expectedD);
        Task task = new Task(mockedCos, mockedTan, mockedCsc, mockedLn, mockedLog2, log5);
        Assertions.assertEquals(expected, task.calc(value, eps));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/task.csv")
    void testAllLog(double valueD, double expectedD) {
        BigDecimal value = new BigDecimal(valueD);
        BigDecimal expected = new BigDecimal(expectedD);
        Task task = new Task(mockedCos, mockedTan, mockedCsc, ln, log2, log5);
        Assertions.assertEquals(expected, task.calc(value, eps));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/task.csv")
    void testAll(double valueD, double expected) {
        Task task = new Task(cos, new Tan(sin, cos), new Csc(sin), ln, log2, log5);
        double value = task.calc(new BigDecimal(valueD, mc), eps).doubleValue();
        Assertions.assertEquals(expected, value, eps);
    }
}