package insa.testingtools.jmeter;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import junit.framework.TestCase;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;

// import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import org.openqa.selenium.support.ui.Select;

public class TestInsaWebsite extends TestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    // new FirefoxDriver();
    driver = new HtmlUnitDriver();
    baseUrl = "https://www.insa-rouen.fr/";
    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
  }

  @Test
  public void testInsaWebsite() throws Exception {
    driver.get(baseUrl + "/");

    driver.findElement(By.linkText("Formation")).click();
    /*
    // driver.findElement(By.xpath("(//a[contains(text(),'Recruter un stagiaire/ingénieur INSA')])[2]")).click();
    // driver.findElement(By.id("input-recherche")).clear();
    driver.findElement(By.id("input-recherche")).sendKeys("informatique");
    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
    driver.findElement(By.cssSelector("span.tx-indexedsearch-title.title > a")).click();
    */
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
