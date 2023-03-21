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
public class TestCheckOutTest {
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
  public void checkOutSuccess() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("alex@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("cavese12");
    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    driver.findElement(By.linkText("Prodotti")).click();
    driver.findElement(By.id("btn1")).click();
    driver.findElement(By.cssSelector("#carrello img")).click();
    driver.findElement(By.id("conferma_ordine")).click();
    driver.findElement(By.cssSelector(".container:nth-child(7) > img")).click();
    driver.findElement(By.cssSelector("#sped2 > label")).click();
    driver.findElement(By.cssSelector("#dati_indirizzoesistente button")).click();
    driver.findElement(By.cssSelector(".container:nth-child(4) > img")).click();
    driver.findElement(By.id(" numerocarta")).click();
    driver.findElement(By.id(" numerocarta")).sendKeys("4539996723127890");
    driver.findElement(By.id(" titolare")).click();
    driver.findElement(By.id(" titolare")).sendKeys("Mario Rossi");
    driver.findElement(By.id(" scadenza")).click();
    driver.findElement(By.id(" scadenza")).sendKeys("2024-07-31");
    driver.findElement(By.id("cvv")).click();
    driver.findElement(By.id("cvv")).sendKeys("340");
    driver.findElement(By.id("submit")).click();
  }
  @Test
  public void checkOutTitolareMancante() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("alex@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("cavese12");
    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    driver.findElement(By.linkText("Prodotti")).click();
    driver.findElement(By.id("btn1")).click();
    driver.findElement(By.cssSelector("#carrello img")).click();
    driver.findElement(By.id("conferma_ordine")).click();
    driver.findElement(By.cssSelector(".container:nth-child(7) > img")).click();
    driver.findElement(By.cssSelector("#sped2 > label")).click();
    driver.findElement(By.cssSelector("#dati_indirizzoesistente button")).click();
    driver.findElement(By.cssSelector(".container:nth-child(4) > img")).click();
    driver.findElement(By.id(" numerocarta")).click();
    driver.findElement(By.id(" numerocarta")).sendKeys("4539996723127890");
    driver.findElement(By.id(" scadenza")).click();
    driver.findElement(By.id(" scadenza")).sendKeys("2024-07-31");
    driver.findElement(By.id("cvv")).click();
    driver.findElement(By.id("cvv")).sendKeys("340");
    driver.findElement(By.id("submit")).click();
    {
      List<WebElement> elements = driver.findElements(By.id("submit"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void checkOutFormatoNomeTitolareErrato() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("alex@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("cavese12");
    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    driver.findElement(By.linkText("Prodotti")).click();
    driver.findElement(By.id("btn1")).click();
    driver.findElement(By.cssSelector("#carrello img")).click();
    driver.findElement(By.id("conferma_ordine")).click();
    driver.findElement(By.cssSelector(".container:nth-child(7) > img")).click();
    driver.findElement(By.cssSelector("#sped2 > label")).click();
    driver.findElement(By.cssSelector("#dati_indirizzoesistente button")).click();
    driver.findElement(By.cssSelector(".container:nth-child(4) > img")).click();
    driver.findElement(By.id(" numerocarta")).click();
    driver.findElement(By.id(" numerocarta")).sendKeys("4539996723127890");
    driver.findElement(By.id(" titolare")).click();
    driver.findElement(By.id(" titolare")).sendKeys("222222");
    driver.findElement(By.id(" scadenza")).click();
    driver.findElement(By.id(" scadenza")).click();
    driver.findElement(By.id(" scadenza")).sendKeys("2024-07-31");
    {
      WebElement element = driver.findElement(By.id("cvv"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.id("cvv"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.id("cvv"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    driver.findElement(By.id("cvv")).click();
    driver.findElement(By.id("cvv")).sendKeys("340");
  }
  @Test
  public void checkOutNumeroCartaMancante() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("alex@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("cavese12");
    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    driver.findElement(By.linkText("Prodotti")).click();
    driver.findElement(By.id("btn1")).click();
    driver.findElement(By.cssSelector("#carrello img")).click();
    driver.findElement(By.id("conferma_ordine")).click();
    driver.findElement(By.cssSelector(".container:nth-child(7) > #contr")).click();
    driver.findElement(By.cssSelector("#sped2 > label")).click();
    driver.findElement(By.cssSelector("#dati_indirizzoesistente button")).click();
    driver.findElement(By.cssSelector(".container:nth-child(4) > img")).click();
    driver.findElement(By.id(" titolare")).click();
    driver.findElement(By.id(" titolare")).sendKeys("Mario Rossi");
    driver.findElement(By.id(" scadenza")).click();
    driver.findElement(By.id(" scadenza")).sendKeys("2024-07-21");
    driver.findElement(By.id("cvv")).click();
    driver.findElement(By.id("cvv")).click();
    driver.findElement(By.id("cvv")).sendKeys("140");
    driver.findElement(By.id("submit")).click();
    assertEquals(vars.get("id=submit").toString(), "null");
  }
  @Test
  public void checkoutFormatoNumeroCartaErrato() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("alex@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("cavese12");
    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    driver.findElement(By.linkText("Prodotti")).click();
    driver.findElement(By.id("img")).click();
    driver.findElement(By.xpath("(//button[@id=\'btn1\'])[3]")).click();
    driver.findElement(By.cssSelector("#carrello img")).click();
    driver.findElement(By.id("conferma_ordine")).click();
    driver.findElement(By.cssSelector(".container:nth-child(7) > img")).click();
    driver.findElement(By.cssSelector("#sped2 > label")).click();
    driver.findElement(By.cssSelector("#dati_indirizzoesistente button")).click();
    driver.findElement(By.cssSelector(".container:nth-child(4) > img")).click();
    driver.findElement(By.id(" titolare")).click();
    driver.findElement(By.id(" titolare")).sendKeys("Mario Rossi");
    driver.findElement(By.id(" scadenza")).click();
    driver.findElement(By.id(" scadenza")).sendKeys("2024-07-31");
    driver.findElement(By.id("cvv")).click();
    driver.findElement(By.id("cvv")).sendKeys("340");
    driver.findElement(By.id(" numerocarta")).click();
    driver.findElement(By.id(" numerocarta")).sendKeys("4539");
    driver.findElement(By.id("cvv")).click();
  }
  @Test
  public void checkOutDataScadenzaMancante() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("alex@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("cavese12");
    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    driver.findElement(By.linkText("Prodotti")).click();
    driver.findElement(By.id("btn1")).click();
    driver.findElement(By.cssSelector("#carrello img")).click();
    driver.findElement(By.id("conferma_ordine")).click();
    driver.findElement(By.cssSelector(".container:nth-child(7) > img")).click();
    driver.findElement(By.cssSelector("#sped2 > label")).click();
    driver.findElement(By.cssSelector("#dati_indirizzoesistente button")).click();
    driver.findElement(By.cssSelector(".container:nth-child(4) > img")).click();
    driver.findElement(By.id(" numerocarta")).click();
    driver.findElement(By.id(" numerocarta")).sendKeys("4539996723127890");
    driver.findElement(By.id(" titolare")).click();
    driver.findElement(By.id(" titolare")).sendKeys("Mario Rossi");
    driver.findElement(By.id("cvv")).click();
    driver.findElement(By.id("cvv")).sendKeys("340");
    driver.findElement(By.id("submit")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".slo > h1"));
      assert(elements.size() == 0);
    }
  }
  @Test
  public void checkOutCartaNonValida() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("alex@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("cavese12");
    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    driver.findElement(By.linkText("Prodotti")).click();
    driver.findElement(By.id("btn1")).click();
    driver.findElement(By.cssSelector("#carrello img")).click();
    driver.findElement(By.id("conferma_ordine")).click();
    driver.findElement(By.cssSelector(".container:nth-child(7) > img")).click();
    driver.findElement(By.cssSelector("#sped2 > label")).click();
    driver.findElement(By.cssSelector("#dati_indirizzoesistente button")).click();
    driver.findElement(By.cssSelector(".container:nth-child(4) > img")).click();
    driver.findElement(By.id(" numerocarta")).click();
    driver.findElement(By.id(" numerocarta")).sendKeys("4539996723127890");
    driver.findElement(By.id(" titolare")).click();
    driver.findElement(By.id(" titolare")).sendKeys("Mario Rossi");
    driver.findElement(By.id(" scadenza")).click();
    driver.findElement(By.id(" scadenza")).sendKeys("2022-07-30");
    driver.findElement(By.id("cvv")).click();
    driver.findElement(By.id("cvv")).click();
    driver.findElement(By.id("cvv")).sendKeys("340");
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".slo > h1"));
      assert(elements.size() == 0);
    }
  }
  @Test
  public void checkOutCvvMancante() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("alex@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("cavese12");
    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    driver.findElement(By.linkText("Prodotti")).click();
    driver.findElement(By.cssSelector(".img > a > p")).click();
    driver.findElement(By.xpath("(//button[@id=\'btn1\'])[2]")).click();
    driver.findElement(By.cssSelector("#carrello img")).click();
    driver.findElement(By.id("conferma_ordine")).click();
    driver.findElement(By.cssSelector(".container:nth-child(7) > img")).click();
    driver.findElement(By.cssSelector("#sped2 > label")).click();
    driver.findElement(By.cssSelector("#dati_indirizzoesistente button")).click();
    driver.findElement(By.cssSelector(".container:nth-child(4) > img")).click();
    driver.findElement(By.id(" numerocarta")).click();
    driver.findElement(By.id(" numerocarta")).sendKeys("4539996723127890");
    driver.findElement(By.id(" titolare")).click();
    driver.findElement(By.id(" titolare")).sendKeys("Mario Rossi");
    driver.findElement(By.id(" scadenza")).click();
    driver.findElement(By.id(" scadenza")).sendKeys("2024-07-31");
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".slo > h1"));
      assert(elements.size() == 0);
    }
  }
  @Test
  public void checkOutFormatoCvvErrato() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("alex@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("cavese12");
    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    driver.findElement(By.linkText("Prodotti")).click();
    driver.findElement(By.id("img")).click();
    driver.findElement(By.xpath("(//button[@id=\'btn1\'])[2]")).click();
    driver.findElement(By.cssSelector("#carrello img")).click();
    driver.findElement(By.id("conferma_ordine")).click();
    driver.findElement(By.cssSelector(".container:nth-child(7) > img")).click();
    driver.findElement(By.cssSelector("#sped2 > label")).click();
    driver.findElement(By.cssSelector("#sped2 > label")).click();
    driver.findElement(By.cssSelector("#dati_indirizzoesistente button")).click();
    driver.findElement(By.cssSelector(".container:nth-child(4) > img")).click();
    driver.findElement(By.id(" numerocarta")).click();
    driver.findElement(By.id(" numerocarta")).sendKeys("4539996723127890");
    driver.findElement(By.id(" titolare")).click();
    driver.findElement(By.id(" titolare")).sendKeys("Mario Rossi");
    driver.findElement(By.id(" scadenza")).click();
    driver.findElement(By.id(" scadenza")).sendKeys("2023-04-27");
    driver.findElement(By.id("cvv")).click();
    driver.findElement(By.id("cvv")).click();
    driver.findElement(By.id("cvv")).sendKeys("34");
    driver.findElement(By.id(" scadenza")).click();
    driver.findElement(By.id("cvv")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector(".slo > h1"));
      assert(elements.size() == 0);
    }
  }
}
