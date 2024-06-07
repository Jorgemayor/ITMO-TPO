package usecase;

import comp.CustomDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class SiteTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  @BeforeEach
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<>();
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  public String waitForWindow(int timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      System.out.println(e.getMessage());
    }
    Set<String> whNow = driver.getWindowHandles();
    Set<String> whThen = (Set<String>) vars.get("window_handles");
    if (whNow.size() > whThen.size()) {
      whNow.removeAll(whThen);
    }
    return whNow.iterator().next();
  }

  @Test
  public void site() {
    driver.get(CustomDriver.getSiteUrl());
    driver.manage().window().setSize(new Dimension(1050, 748));
    driver.findElement(By.xpath("//body[@id=\'yDmH0d\']/c-wiz/div/div[2]/c-wiz/div/nav/div[4]/div/button/span")).click();
    {
      WebElement element = driver.findElement(By.xpath("//body[@id=\'yDmH0d\']/c-wiz/div/div[2]/c-wiz/div[4]/c-wiz/div[2]/div/span/button"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.xpath("//input[@id=\'i48\']")).sendKeys("https://se.ifmo.ru/courses/testing");
    vars.put("window_handles", driver.getWindowHandles());
    driver.findElement(By.cssSelector(".VfPpkd-kBDsod > .hhikbc")).click();
    vars.put("win7672", waitForWindow(2000));
    vars.put("root", driver.getWindowHandle());
    driver.switchTo().window(vars.get("win7672").toString());
    driver.switchTo().frame(0);
    driver.findElement(By.xpath("//body[@id=\'yDmH0d\']/c-wiz/div/div/c-wiz/div/div[3]/div/div/div/div/div")).click();
    driver.findElement(By.xpath("//body[@id=\'yDmH0d\']/c-wiz/div/div/c-wiz/div/div[3]/div/div/div/div[2]/ul/li/span[4]")).click();
    driver.findElement(By.xpath("//body[@id=\'yDmH0d\']/c-wiz/div/div/c-wiz/div/div[3]/div/div/div/div/div")).click();
  }
}
