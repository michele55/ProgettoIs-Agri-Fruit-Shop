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
public class TestLogin {
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
  public void loginUtenteNonPresente() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1936, 1056));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("mmichele@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("bottone")).click();
    assertThat(driver.findElement(By.cssSelector("h2")).getText(), is("Errore Login, email o password errati"));
  }
  @Test
  public void loginUtenteCorretto() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("alex@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("cavese12");
    driver.findElement(By.id("bottone")).click();
    {
      List<WebElement> elements = driver.findElements(By.id("imm"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void loginUtenteCampiVuoti() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("password")).click();
    driver.findElement(By.id("bottone")).click();
    {
      List<WebElement> elements = driver.findElements(By.linkText("Accedi"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void loginUtentePwdMancante() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("alex@gmail.com");
    driver.findElement(By.id("bottone")).click();
    {
      List<WebElement> elements = driver.findElements(By.linkText("Accedi"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void loginUtenteEmailMancante() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("cavese12");
    driver.findElement(By.id("bottone")).click();
    {
      List<WebElement> elements = driver.findElements(By.linkText("Accedi"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void loginAmmFallito() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.id("bottoneAmm")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("Amministratore1@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("bottone")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector("h2"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void loginAmmCorretto() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.id("bottoneAmm")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("amm1mario@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("bottone")).click();
    {
      List<WebElement> elements = driver.findElements(By.linkText("Mario"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void loginAmmCampiVuoti() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.id("bottoneAmm")).click();
    driver.findElement(By.id("bottone")).click();
    driver.findElement(By.name("password")).click();
    {
      List<WebElement> elements = driver.findElements(By.linkText("Accedi"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void loginAmmPwdMancante() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.id("bottoneAmm")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("amm1mario@gmail.com");
    driver.findElement(By.id("bottone")).click();
    {
      List<WebElement> elements = driver.findElements(By.linkText("Accedi"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void loginAmmEmailMancante() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.id("bottoneAmm")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("bottone")).click();
    {
      List<WebElement> elements = driver.findElements(By.linkText("Accedi"));
      assert(elements.size() > 0);
    }
  }
}
