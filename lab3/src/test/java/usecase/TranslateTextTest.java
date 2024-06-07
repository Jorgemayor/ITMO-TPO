package usecase;

import comp.CustomDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;

import java.util.List;

public class TranslateTextTest {
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
  public void translateText() {
    for (WebDriver driver : drivers) {
      driver.get(CustomDriver.getSiteUrl());
      driver.manage().window().setSize(new Dimension(1050, 748));
      driver.findElement(By.xpath("//body[@id=\'yDmH0d\']/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div/div[2]/div[2]/c-wiz/span/span/div/textarea")).click();
      driver.findElement(By.xpath("//body[@id=\'yDmH0d\']/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div/div[2]/div[2]/c-wiz/span/span/div/textarea")).sendKeys("Probando");
      driver.findElement(By.xpath("//button[@id=\'i16\']/span[3]")).click();
      driver.findElement(By.xpath("//button[@id=\'i17\']/span[3]")).click();
    }
  }
}
