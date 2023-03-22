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
public class ModificaUtenteTest {
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
  public void modUtenteCapErrato() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("alex@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("bottone")).click();
    driver.findElement(By.linkText("Modifica")).click();
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("11a");
    driver.findElement(By.id("ncivico")).click();
    driver.findElement(By.id("ncivico")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector("tr:nth-child(1) > td:nth-child(2)"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void modUtenteCivicoErrato() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("alex@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("bottone")).click();
    driver.findElement(By.linkText("Modifica")).click();
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("83045");
    driver.findElement(By.id("ncivico")).click();
    driver.findElement(By.id("ncivico")).sendKeys("qwert");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("citta")).click();
    {
      List<WebElement> elements = driver.findElements(By.id("errorecivico"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void modUtenteFormatoViaErr() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("alex@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("bottone")).click();
    driver.findElement(By.linkText("Modifica")).click();
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("83045");
    driver.findElement(By.id("ncivico")).click();
    driver.findElement(By.id("ncivico")).sendKeys("3");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("4444");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.cssSelector("tr:nth-child(9) input")).click();
    driver.findElement(By.id("erroreindirizzo")).click();
    {
      List<WebElement> elements = driver.findElements(By.id("erroreindirizzo"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void modUtenteFormCittaErr() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("alex@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("bottone")).click();
    driver.findElement(By.linkText("Modifica")).click();
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("83045");
    driver.findElement(By.id("ncivico")).click();
    driver.findElement(By.id("ncivico")).sendKeys("3");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("Via Umberto Saba");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).sendKeys("3232");
    driver.findElement(By.id("provincia")).click();
    {
      List<WebElement> elements = driver.findElements(By.id("errorecitta"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void modUtenteSuccess() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("alex@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("bottone")).click();
    driver.findElement(By.linkText("Modifica")).click();
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("83045");
    driver.findElement(By.id("ncivico")).click();
    driver.findElement(By.id("ncivico")).sendKeys("3");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("via umberto saba");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).sendKeys("Calitri");
    driver.findElement(By.id("provincia")).click();
    driver.findElement(By.id("provincia")).sendKeys("Avellino");
    driver.findElement(By.id("codice_fiscale")).click();
    driver.findElement(By.id("codice_fiscale")).sendKeys("RSSNNM00B19A509K");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("conferma")).click();
    driver.findElement(By.id("conferma")).sendKeys("qwertyuiop");
    driver.findElement(By.cssSelector("tr:nth-child(9) input")).click();
    {
      List<WebElement> elements = driver.findElements(By.id("bottone"));
      assert(elements.size() > 0);
    }
  }
}
