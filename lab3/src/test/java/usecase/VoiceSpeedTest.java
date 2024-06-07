package usecase;

import comp.CustomDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;

import java.util.List;

public class VoiceSpeedTest {

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
      driver.get("https://translate.google.ru/?sl=es&tl=fr&op=translate");
      driver.manage().window().setSize(new Dimension(1050, 748));
      driver.findElement(By.xpath("//button/div[3]")).click();
      driver.findElement(By.xpath("//div[@id=\'ucj-1\']/div[3]/div/div/div/div/div/input")).click();
      driver.findElement(By.xpath("//div[@id=\'ucj-1\']/div[3]/div/div/div/div[2]/button/span[2]")).click();
      driver.findElement(By.xpath("//div[@id=\'ucj-1\']/div[3]/div/div/div[2]/div/div/input")).click();
      driver.findElement(By.xpath("//div[@id=\'ucj-1\']/div[3]/div/div/div[3]/div/div/input")).click();
    }
  }
}
