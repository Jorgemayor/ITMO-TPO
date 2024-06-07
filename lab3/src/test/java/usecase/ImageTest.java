package usecase;

import comp.CustomDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;

import java.util.List;

public class ImageTest {

  private List<WebDriver> drivers;

  @BeforeEach
  public void setUp() {
    drivers = CustomDriver.newDrivers();
  }
  @AfterEach
  public void tearDown() {
    for (WebDriver driver : drivers) {
      driver.quit();
    }
  }

  @Test
  public void voiceSpeed() {
    for (WebDriver driver : drivers) {
      System.out.println(driver.getTitle());
      driver.get("https://translate.google.ru/?sl=en&tl=es&op=translate");
      driver.manage().window().setSize(new Dimension(1050, 748));
      driver.findElement(By.xpath("//body[@id=\'yDmH0d\']/c-wiz/div/div[2]/c-wiz/div/nav/div[2]/div/button/span")).click();
      driver.findElement(By.xpath("//body[@id=\'yDmH0d\']/c-wiz/div/div[2]/c-wiz/div[5]/c-wiz/div[2]/c-wiz/div/div/div/div/div[2]/div[2]/div/label")).click();
      driver.findElement(By.xpath("//input[@id=\'ucj-39\']")).sendKeys("D:\\Users\\jorge\\Documents\\ITMO\\3 course\\6 sem\\TPO\\ITMO--\\lab3\\src\\test\\resources\\redes.png");
    }
  }
}
