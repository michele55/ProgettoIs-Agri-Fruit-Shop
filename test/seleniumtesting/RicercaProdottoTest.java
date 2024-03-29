package seleniumtesting;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class RicercaProdottoTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void testRicercaProd() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.id("input_ricerca")).click();
    driver.findElement(By.id("input_ricerca")).sendKeys("uv");
    driver.findElement(By.linkText("uva armonera del Cilento 4.0")).click();
    {
      List<WebElement> elements = driver.findElements(By.name("uva armonera del Cilento"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void ricercaProdManc() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.id("input_ricerca")).click();
    driver.findElement(By.id("input_ricerca")).click();
    driver.findElement(By.id("input_ricerca")).sendKeys("uvetta");
    {
      List<WebElement> elements = driver.findElements(By.linkText("uvetta"));
      assert(elements.size() == 0);
    }
  }
}
