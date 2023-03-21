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
public class TestAggiungiProdottoTest {
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
  public void aggiungiProdottoSuccess() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.id("bottoneAmm")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("amm1mario@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("bottone")).click();
    driver.findElement(By.linkText("Pannello-Controllo")).click();
    driver.findElement(By.name("nome")).click();
    driver.findElement(By.name("nome")).sendKeys("Uva");
    driver.findElement(By.name("prezzo")).click();
    driver.findElement(By.name("prezzo")).sendKeys("3");
    driver.findElement(By.name("Ssn")).click();
    driver.findElement(By.name("Ssn")).sendKeys("123456789");
    driver.findElement(By.name("disponibilita")).click();
    driver.findElement(By.name("disponibilita")).sendKeys("20");
    driver.findElement(By.name("descrizione")).click();
    driver.findElement(By.name("descrizione")).sendKeys("Uva");
    driver.findElement(By.name("categoria")).click();
    {
      WebElement dropdown = driver.findElement(By.name("categoria"));
      dropdown.findElement(By.xpath("//option[. = 'Frutta']")).click();
    }
    driver.findElement(By.name("idfoto")).click();
    driver.findElement(By.name("idfoto")).sendKeys("2");
    driver.findElement(By.cssSelector("tr:nth-child(8) input")).click();
    assertThat(driver.findElement(By.cssSelector("p:nth-child(2)")).getText(), is("Prodotto Inserito"));
  }
  @Test
  public void aggiungiProdottoNomeMancante() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.id("bottoneAmm")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("amm1mario@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("bottone")).click();
    driver.findElement(By.linkText("Pannello-Controllo")).click();
    driver.findElement(By.name("prezzo")).click();
    driver.findElement(By.name("prezzo")).sendKeys("3");
    driver.findElement(By.name("Ssn")).click();
    driver.findElement(By.name("Ssn")).sendKeys("123456789");
    driver.findElement(By.name("disponibilita")).click();
    driver.findElement(By.name("disponibilita")).sendKeys("20");
    driver.findElement(By.name("descrizione")).click();
    driver.findElement(By.name("descrizione")).sendKeys("Uva");
    driver.findElement(By.name("categoria")).click();
    {
      WebElement dropdown = driver.findElement(By.name("categoria"));
      dropdown.findElement(By.xpath("//option[. = 'Frutta']")).click();
    }
    driver.findElement(By.name("idfoto")).click();
    driver.findElement(By.name("idfoto")).sendKeys("2");
    driver.findElement(By.cssSelector("tr:nth-child(8) input")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector("p:nth-child(2)"));
      assert(elements.size() == 0);
    }
  }
  @Test
  public void aggiungiProdottoFormatoNomeErr() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.id("bottoneAmm")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("amm1mario@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("bottone")).click();
    driver.findElement(By.linkText("Pannello-Controllo")).click();
    driver.findElement(By.name("nome")).click();
    driver.findElement(By.name("nome")).sendKeys("23223");
    driver.findElement(By.name("prezzo")).click();
    driver.findElement(By.name("prezzo")).sendKeys("3");
    driver.findElement(By.name("Ssn")).click();
    driver.findElement(By.name("Ssn")).sendKeys("123456789");
    driver.findElement(By.name("disponibilita")).click();
    driver.findElement(By.name("disponibilita")).sendKeys("20");
    driver.findElement(By.name("descrizione")).click();
    driver.findElement(By.name("descrizione")).sendKeys("Uva");
    driver.findElement(By.name("categoria")).click();
    {
      WebElement dropdown = driver.findElement(By.name("categoria"));
      dropdown.findElement(By.xpath("//option[. = 'Frutta']")).click();
    }
    driver.findElement(By.name("idfoto")).click();
    driver.findElement(By.name("idfoto")).sendKeys("2");
    driver.findElement(By.cssSelector("tr:nth-child(8) input")).click();
    assertThat(driver.findElement(By.cssSelector("p:nth-child(2)")).getText(), is("Errore Formato nome"));
  }
  @Test
  public void aggiungiProdottoSSNMancante() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.id("bottoneAmm")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("amm1mario@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("bottone")).click();
    driver.findElement(By.linkText("Pannello-Controllo")).click();
    driver.findElement(By.name("nome")).click();
    driver.findElement(By.name("nome")).sendKeys("Uva");
    driver.findElement(By.name("prezzo")).click();
    driver.findElement(By.name("prezzo")).sendKeys("3");
    driver.findElement(By.name("disponibilita")).click();
    driver.findElement(By.name("disponibilita")).sendKeys("20");
    driver.findElement(By.name("descrizione")).click();
    driver.findElement(By.name("descrizione")).sendKeys("Uva");
    driver.findElement(By.name("categoria")).click();
    {
      WebElement dropdown = driver.findElement(By.name("categoria"));
      dropdown.findElement(By.xpath("//option[. = 'Frutta']")).click();
    }
    driver.findElement(By.name("idfoto")).click();
    driver.findElement(By.name("idfoto")).sendKeys("2");
    driver.findElement(By.cssSelector("tr:nth-child(8) input")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector("p:nth-child(2)"));
      assert(elements.size() == 0);
    }
  }
  @Test
  public void aggiungiProdottoFormSSNErr() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.id("bottoneAmm")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("amm1mario@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    driver.findElement(By.linkText("Pannello-Controllo")).click();
    driver.findElement(By.name("nome")).click();
    driver.findElement(By.name("nome")).sendKeys("Uva");
    driver.findElement(By.name("prezzo")).click();
    driver.findElement(By.name("prezzo")).sendKeys("3");
    driver.findElement(By.name("Ssn")).click();
    driver.findElement(By.name("Ssn")).sendKeys("1ss");
    driver.findElement(By.name("disponibilita")).click();
    driver.findElement(By.name("disponibilita")).sendKeys("20");
    driver.findElement(By.name("descrizione")).click();
    driver.findElement(By.name("descrizione")).sendKeys("Uva");
    driver.findElement(By.name("categoria")).click();
    {
      WebElement dropdown = driver.findElement(By.name("categoria"));
      dropdown.findElement(By.xpath("//option[. = 'Frutta']")).click();
    }
    driver.findElement(By.name("idfoto")).click();
    driver.findElement(By.name("idfoto")).sendKeys("2");
    driver.findElement(By.cssSelector("tr:nth-child(8) input")).click();
    assertThat(driver.findElement(By.cssSelector("p:nth-child(2)")).getText(), is("Errore Formato SSN"));
  }
  @Test
  public void aggProdottoDispMancante() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.cssSelector(".header__menu__item:nth-child(3)")).click();
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.id("bottoneAmm")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("amm1mario@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("bottone")).click();
    driver.findElement(By.linkText("Pannello-Controllo")).click();
    driver.findElement(By.name("nome")).click();
    driver.findElement(By.name("nome")).sendKeys("Uva");
    driver.findElement(By.name("prezzo")).click();
    driver.findElement(By.name("prezzo")).sendKeys("3");
    driver.findElement(By.name("Ssn")).click();
    driver.findElement(By.name("Ssn")).sendKeys("123456789");
    driver.findElement(By.name("descrizione")).click();
    driver.findElement(By.name("descrizione")).sendKeys("Uva");
    driver.findElement(By.name("categoria")).click();
    {
      WebElement dropdown = driver.findElement(By.name("categoria"));
      dropdown.findElement(By.xpath("//option[. = 'Frutta']")).click();
    }
    driver.findElement(By.name("idfoto")).click();
    driver.findElement(By.name("idfoto")).sendKeys("2");
    driver.findElement(By.cssSelector("tr:nth-child(8) input")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector("p:nth-child(2)"));
      assert(elements.size() == 0);
    }
  }
  @Test
  public void aggProdottoDispErrata() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.id("bottoneAmm")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("amm1mario@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("bottone")).click();
    driver.findElement(By.linkText("Pannello-Controllo")).click();
    driver.findElement(By.name("nome")).click();
    driver.findElement(By.name("nome")).sendKeys("Uva");
    driver.findElement(By.name("prezzo")).click();
    driver.findElement(By.name("prezzo")).sendKeys("3");
    driver.findElement(By.name("Ssn")).click();
    driver.findElement(By.name("Ssn")).sendKeys("123456789");
    driver.findElement(By.name("disponibilita")).click();
    driver.findElement(By.name("disponibilita")).sendKeys("b");
    driver.findElement(By.name("descrizione")).click();
    driver.findElement(By.name("descrizione")).sendKeys("Uva");
    driver.findElement(By.name("categoria")).click();
    {
      WebElement dropdown = driver.findElement(By.name("categoria"));
      dropdown.findElement(By.xpath("//option[. = 'Frutta']")).click();
    }
    driver.findElement(By.name("idfoto")).click();
    driver.findElement(By.name("idfoto")).sendKeys("2");
    driver.findElement(By.cssSelector("tr:nth-child(8) input")).click();
    assertThat(driver.findElement(By.cssSelector("p:nth-child(2)")).getText(), is("Errore Formato Disponibilità"));
  }
  @Test
  public void aggProdottoFormatoPrezzoErr() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.id("bottoneAmm")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("amm1mario@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("bottone")).click();
    driver.findElement(By.linkText("Pannello-Controllo")).click();
    driver.findElement(By.name("nome")).click();
    driver.findElement(By.name("nome")).sendKeys("Uva");
    driver.findElement(By.name("prezzo")).click();
    driver.findElement(By.name("prezzo")).sendKeys("dieci");
    driver.findElement(By.name("Ssn")).click();
    driver.findElement(By.name("Ssn")).sendKeys("123456789");
    driver.findElement(By.name("disponibilita")).click();
    driver.findElement(By.name("disponibilita")).sendKeys("20");
    driver.findElement(By.name("descrizione")).click();
    driver.findElement(By.name("descrizione")).sendKeys("Uva");
    driver.findElement(By.name("categoria")).click();
    {
      WebElement dropdown = driver.findElement(By.name("categoria"));
      dropdown.findElement(By.xpath("//option[. = 'Frutta']")).click();
    }
    driver.findElement(By.name("idfoto")).click();
    driver.findElement(By.name("idfoto")).sendKeys("2");
    driver.findElement(By.cssSelector("tr:nth-child(8) input")).click();
    assertThat(driver.findElement(By.cssSelector("p:nth-child(2)")).getText(), is("Errore Formato Prezzo"));
  }
  @Test
  public void aggProdDescrizioneManc() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.id("bottoneAmm")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("amm1mario@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("bottone")).click();
    driver.findElement(By.linkText("Pannello-Controllo")).click();
    driver.findElement(By.name("nome")).click();
    driver.findElement(By.name("nome")).sendKeys("Uva");
    driver.findElement(By.name("prezzo")).click();
    driver.findElement(By.name("prezzo")).sendKeys("3.0");
    driver.findElement(By.name("Ssn")).click();
    driver.findElement(By.name("Ssn")).sendKeys("123456789");
    driver.findElement(By.name("disponibilita")).click();
    driver.findElement(By.name("disponibilita")).sendKeys("20");
    driver.findElement(By.name("categoria")).click();
    {
      WebElement dropdown = driver.findElement(By.name("categoria"));
      dropdown.findElement(By.xpath("//option[. = 'Frutta']")).click();
    }
    driver.findElement(By.name("idfoto")).click();
    driver.findElement(By.name("idfoto")).sendKeys("2");
    driver.findElement(By.cssSelector("tr:nth-child(8) input")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector("p:nth-child(2)"));
      assert(elements.size() == 0);
    }
  }
  @Test
  public void aggProdottoDescrErrata() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.id("bottoneAmm")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("amm1mario@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("bottone")).click();
    driver.findElement(By.linkText("Pannello-Controllo")).click();
    driver.findElement(By.name("nome")).click();
    driver.findElement(By.name("nome")).sendKeys("Uva");
    driver.findElement(By.name("prezzo")).click();
    driver.findElement(By.name("prezzo")).sendKeys("3");
    driver.findElement(By.name("Ssn")).click();
    driver.findElement(By.name("Ssn")).sendKeys("123456789");
    driver.findElement(By.name("disponibilita")).click();
    driver.findElement(By.name("disponibilita")).sendKeys("20");
    driver.findElement(By.name("descrizione")).click();
    driver.findElement(By.name("descrizione")).sendKeys("123");
    driver.findElement(By.name("categoria")).click();
    {
      WebElement dropdown = driver.findElement(By.name("categoria"));
      dropdown.findElement(By.xpath("//option[. = 'Frutta']")).click();
    }
    driver.findElement(By.name("idfoto")).click();
    driver.findElement(By.name("idfoto")).sendKeys("2");
    driver.findElement(By.cssSelector("tr:nth-child(8) input")).click();
    assertThat(driver.findElement(By.cssSelector("p:nth-child(2)")).getText(), is("Errore Formato Descrizione"));
  }
  @Test
  public void aggProdIdFotoErr() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.id("bottoneAmm")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("amm1mario@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("bottone")).click();
    driver.findElement(By.linkText("Pannello-Controllo")).click();
    driver.findElement(By.name("nome")).click();
    driver.findElement(By.name("nome")).sendKeys("Uva");
    driver.findElement(By.name("prezzo")).click();
    driver.findElement(By.name("prezzo")).sendKeys("3");
    driver.findElement(By.name("Ssn")).click();
    driver.findElement(By.name("Ssn")).sendKeys("123456789");
    driver.findElement(By.name("disponibilita")).click();
    driver.findElement(By.name("disponibilita")).sendKeys("20");
    driver.findElement(By.name("descrizione")).click();
    driver.findElement(By.name("descrizione")).sendKeys("uva");
    driver.findElement(By.name("categoria")).click();
    {
      WebElement dropdown = driver.findElement(By.name("categoria"));
      dropdown.findElement(By.xpath("//option[. = 'Frutta']")).click();
    }
    driver.findElement(By.name("idfoto")).click();
    driver.findElement(By.name("idfoto")).sendKeys("due");
    driver.findElement(By.cssSelector("tr:nth-child(8) input")).click();
    assertThat(driver.findElement(By.cssSelector("p:nth-child(2)")).getText(), is("Errore Formato IdFoto"));
  }
  @Test
  public void aggProdIdFotoMancante() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.id("bottoneAmm")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("amm1mario@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("bottone")).click();
    driver.findElement(By.linkText("Pannello-Controllo")).click();
    driver.findElement(By.name("nome")).click();
    driver.findElement(By.name("nome")).sendKeys("Uva");
    driver.findElement(By.name("prezzo")).click();
    driver.findElement(By.name("prezzo")).sendKeys("2");
    driver.findElement(By.name("Ssn")).click();
    driver.findElement(By.name("Ssn")).sendKeys("123456789");
    driver.findElement(By.name("disponibilita")).click();
    driver.findElement(By.name("disponibilita")).sendKeys("20");
    driver.findElement(By.name("descrizione")).click();
    driver.findElement(By.name("descrizione")).sendKeys("Uva");
    driver.findElement(By.name("categoria")).click();
    {
      WebElement dropdown = driver.findElement(By.name("categoria"));
      dropdown.findElement(By.xpath("//option[. = 'Frutta']")).click();
    }
    driver.findElement(By.cssSelector("tr:nth-child(8) input")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector("p:nth-child(2)"));
      assert(elements.size() == 0);
    }
  }
  @Test
  public void aggProdPrezzMancante() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.id("bottoneAmm")).click();
    driver.findElement(By.name("Email")).click();
    driver.findElement(By.name("Email")).sendKeys("amm1mario@gmail.com");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.id("bottone")).click();
    driver.findElement(By.linkText("Pannello-Controllo")).click();
    driver.findElement(By.name("nome")).click();
    driver.findElement(By.name("nome")).sendKeys("Uva");
    driver.findElement(By.name("Ssn")).click();
    driver.findElement(By.name("Ssn")).sendKeys("123456789");
    driver.findElement(By.name("disponibilita")).click();
    driver.findElement(By.name("disponibilita")).sendKeys("20");
    driver.findElement(By.name("descrizione")).click();
    driver.findElement(By.name("descrizione")).sendKeys("Uva");
    driver.findElement(By.name("categoria")).click();
    {
      WebElement dropdown = driver.findElement(By.name("categoria"));
      dropdown.findElement(By.xpath("//option[. = 'Frutta']")).click();
    }
    driver.findElement(By.name("idfoto")).click();
    driver.findElement(By.name("idfoto")).sendKeys("2");
    driver.findElement(By.cssSelector("tr:nth-child(8) input")).click();
    {
      List<WebElement> elements = driver.findElements(By.cssSelector("p:nth-child(2)"));
      assert(elements.size() == 0);
    }
  }
}
