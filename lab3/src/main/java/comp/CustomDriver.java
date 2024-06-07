package comp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class CustomDriver {
    private static final String URL = "https://translate.google.ru/?sl=es&tl=fr&op=translate";

    public static String getSiteUrl() {
        return URL;
    }

    public static ChromeDriver newChromeDriver() {
        return new ChromeDriver();
    }

    public static FirefoxDriver newFirefoxDriver() {
        return new FirefoxDriver();
    }

    public static List<WebDriver> newDrivers() {
        ArrayList<WebDriver> drivers = new ArrayList<>(2);
        drivers.add(newChromeDriver());
        drivers.add(newFirefoxDriver());
        return drivers;
    }
}
