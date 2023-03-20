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
public class TestRegistrazione {
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
  public void formatoPasswordErrato() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("#testocarrello > #bottone")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("mariorossi1@libero.it");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("aa");
    driver.findElement(By.id("conferma")).click();
    driver.findElement(By.id("password")).sendKeys("aaa");
    driver.findElement(By.id("conferma")).click();
    {
      List<WebElement> elements = driver.findElements(By.id("errorepassword"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void registrazioneEmailMancante() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("#testocarrello > #bottone")).click();
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("conferma")).click();
    driver.findElement(By.id("conferma")).sendKeys("qwertyuiop");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("codice_fiscale")).click();
    driver.findElement(By.id("codice_fiscale")).sendKeys("RSSMMN00C27B678K");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("Via dei platani");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).sendKeys("Avellino");
    driver.findElement(By.id("provincia")).click();
    driver.findElement(By.id("provincia")).sendKeys("Avellino");
    driver.findElement(By.id("civco")).click();
    driver.findElement(By.id("civco")).sendKeys("3");
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("83045");
    driver.findElement(By.id("iscriviti")).click();
    driver.findElement(By.id("iscriviti")).click();
    driver.findElement(By.id("iscriviti")).click();
  }
  @Test
  public void registrazioneFormatoEmailErrato() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("#testocarrello > #bottone")).click();
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("conferma")).click();
    driver.findElement(By.id("conferma")).sendKeys("qwertyuiop");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Antonio");
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("codice_fiscale")).sendKeys("RSSNNM00C27A509P");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("via rossi");
    driver.findElement(By.id("citta")).sendKeys("avellino");
    driver.findElement(By.id("provincia")).sendKeys("avellino");
    driver.findElement(By.id("civco")).click();
    driver.findElement(By.id("civco")).sendKeys("3");
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("80100");
    driver.findElement(By.id("iscriviti")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("mm");
    driver.findElement(By.id("iscriviti")).click();
  }
  @Test
  public void registrazionePasswordMancante() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("#testocarrello > #bottone")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("mariorossi@libero.it");
    driver.findElement(By.id("conferma")).click();
    driver.findElement(By.id("conferma")).sendKeys("qwertyuiop");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("codice_fiscale")).sendKeys("RSSMMN00C27B678K");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("Via dei platani");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).sendKeys("Avellino");
    driver.findElement(By.id("provincia")).sendKeys("Avellino");
    driver.findElement(By.id("civco")).click();
    driver.findElement(By.id("civco")).sendKeys("3");
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("83045");
    driver.findElement(By.id("iscriviti")).click();
    driver.findElement(By.id("iscriviti")).click();
    driver.findElement(By.id("iscriviti")).click();
    driver.findElement(By.id("iscriviti")).click();
    driver.findElement(By.id("iscriviti")).click();
  }
  @Test
  public void confermaPasswordMancante() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("#testocarrello > #bottone")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("mariorossi@libero.it");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("codice_fiscale")).sendKeys("RSSMMN00C27B678K");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("via dei platani");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).sendKeys("avellino");
    driver.findElement(By.id("provincia")).click();
    driver.findElement(By.id("provincia")).sendKeys("avellino");
    driver.findElement(By.id("civco")).click();
    driver.findElement(By.id("civco")).sendKeys("3");
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("83045");
    driver.findElement(By.id("iscriviti")).click();
    driver.findElement(By.id("iscriviti")).click();
  }
  @Test
  public void formatoConfermaPasswordErrato() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("#testocarrello > #bottone")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("mariorossi@libero.it");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("codice_fiscale")).sendKeys("RSSMMN00C27B679K");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("via dei platani");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).sendKeys("Avellino");
    driver.findElement(By.id("provincia")).sendKeys("Avellino");
    driver.findElement(By.id("civco")).click();
    driver.findElement(By.id("civco")).sendKeys("3");
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("83045");
    driver.findElement(By.id("iscriviti")).click();
    driver.findElement(By.id("iscriviti")).click();
  }
  @Test
  public void registrazioneEmailPresente() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("#testocarrello > #bottone")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("alex@gmail.com");
    driver.findElement(By.id("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("conferma")).click();
    driver.findElement(By.id("conferma")).sendKeys("qwertyuiop");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("codice_fiscale")).click();
    driver.findElement(By.id("codice_fiscale")).sendKeys("RSSNNM00B19A509K");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("via dei platani");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).sendKeys("Avellino");
    driver.findElement(By.id("provincia")).sendKeys("Avellino");
    driver.findElement(By.id("civco")).click();
    driver.findElement(By.id("civco")).sendKeys("3");
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("83045");
    driver.findElement(By.id("iscriviti")).click();
  }
  @Test
  public void registrazioneNomeMancante() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("#testocarrello > #bottone")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("mariorossi@libero.it");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("conferma")).click();
    driver.findElement(By.id("conferma")).sendKeys("qwertyuiop");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("codice_fiscale")).click();
    driver.findElement(By.id("codice_fiscale")).sendKeys("RSSMMN00C27B678K");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("via dei platani");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).sendKeys("avellino");
    driver.findElement(By.id("provincia")).click();
    driver.findElement(By.id("provincia")).sendKeys("avellino");
    driver.findElement(By.id("civco")).click();
    driver.findElement(By.id("civco")).sendKeys("3");
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("83045");
    driver.findElement(By.id("iscriviti")).click();
    driver.findElement(By.id("iscriviti")).click();
  }
  @Test
  public void registrazioneCognomeMancante() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("#testocarrello > #bottone")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("mariorossi@libero.it");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("conferma")).click();
    driver.findElement(By.id("conferma")).sendKeys("qwertyuiop");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("codice_fiscale")).click();
    driver.findElement(By.id("codice_fiscale")).sendKeys("RSSMMN00C27B678K");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("via dei platani");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).sendKeys("Avellino");
    driver.findElement(By.id("provincia")).click();
    driver.findElement(By.id("provincia")).sendKeys("Avellino");
    driver.findElement(By.id("civco")).click();
    driver.findElement(By.id("civco")).sendKeys("3");
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("83045");
    driver.findElement(By.id("iscriviti")).click();
    driver.findElement(By.id("iscriviti")).click();
    driver.findElement(By.id("iscriviti")).click();
  }
  @Test
  public void registrazioneFormatoNomeErrato() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("#testocarrello > #bottone")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("mariorossi@libero.it");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("conferma")).click();
    driver.findElement(By.id("conferma")).sendKeys("qwertyuiop");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.cssSelector("tr:nth-child(4) > td:nth-child(1)")).click();
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("22");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("codice_fiscale")).click();
    driver.findElement(By.id("codice_fiscale")).sendKeys("RSSMMN00C27B678K");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("via dei platani");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).sendKeys("Avellino");
    driver.findElement(By.id("provincia")).click();
    driver.findElement(By.id("provincia")).sendKeys("Avellino");
    driver.findElement(By.id("civco")).click();
    driver.findElement(By.id("civco")).sendKeys("3");
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("83045");
    driver.findElement(By.id("iscriviti")).click();
    assertThat(driver.findElement(By.cssSelector("p:nth-child(2)")).getText(), is("Formato Nome utente errato"));
  }
  @Test
  public void registrazioneFormatoCognomeErrato() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("#testocarrello > #bottone")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("mariorossi@libero.it");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("conferma")).click();
    driver.findElement(By.id("conferma")).sendKeys("qwertyuiop");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).sendKeys("22");
    driver.findElement(By.id("codice_fiscale")).click();
    driver.findElement(By.id("codice_fiscale")).sendKeys("RSSMMN00C27B678K");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("via dei platani");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).sendKeys("Avellino");
    driver.findElement(By.id("provincia")).click();
    driver.findElement(By.id("provincia")).sendKeys("Avellino");
    driver.findElement(By.id("civco")).click();
    driver.findElement(By.id("civco")).sendKeys("3");
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("83045");
    driver.findElement(By.id("iscriviti")).click();
    assertThat(driver.findElement(By.cssSelector("p:nth-child(2)")).getText(), is("Formato Cognome errato"));
  }
  @Test
  public void registrazioneCodiceFiscaleMancante() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("#testocarrello > #bottone")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("mariorossi@libero.it");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("conferma")).click();
    driver.findElement(By.id("conferma")).sendKeys("qwertyuiop");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("via dei platani");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).sendKeys("Avellino");
    driver.findElement(By.id("provincia")).click();
    driver.findElement(By.id("provincia")).sendKeys("Avellino");
    driver.findElement(By.id("civco")).click();
    driver.findElement(By.id("civco")).sendKeys("3");
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("83045");
    driver.findElement(By.id("iscriviti")).click();
    {
    
    }
  }
  @Test
  public void registrazioneCapMancante() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("#testocarrello > #bottone")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("mariorossi@libero.it");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("conferma")).click();
    driver.findElement(By.id("conferma")).sendKeys("qwertyuiop");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("codice_fiscale")).click();
    driver.findElement(By.id("codice_fiscale")).sendKeys("RSSMMN00C27B678K");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("via dei platani");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).sendKeys("Avellino");
    driver.findElement(By.id("provincia")).click();
    driver.findElement(By.id("provincia")).sendKeys("Avellino");
    driver.findElement(By.id("civco")).click();
    driver.findElement(By.id("civco")).sendKeys("2");
    driver.findElement(By.id("iscriviti")).click();
    {
      List<WebElement> elements = driver.findElements(By.id("errorecap"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void registrazioneCittMancante() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("#testocarrello > #bottone")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("mariorossi@libero.it");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("conferma")).click();
    driver.findElement(By.id("conferma")).sendKeys("qwertyuiop");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("codice_fiscale")).click();
    driver.findElement(By.id("codice_fiscale")).sendKeys("RSSMMN00C27B678K");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("via dei platani");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("provincia")).click();
    driver.findElement(By.id("provincia")).sendKeys("Avellino");
    driver.findElement(By.id("civco")).click();
    driver.findElement(By.id("civco")).sendKeys("3");
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("83045");
    driver.findElement(By.id("iscriviti")).click();
    driver.findElement(By.id("iscriviti")).click();
    {
      List<WebElement> elements = driver.findElements(By.id("citta"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void registrazioneCivicoMancante() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("#testocarrello > #bottone")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("mariorossi@libero.it");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("conferma")).click();
    driver.findElement(By.id("conferma")).sendKeys("qwertyuiop");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("codice_fiscale")).click();
    driver.findElement(By.id("codice_fiscale")).sendKeys("RSSMMN00C27B678K");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("via dei platani");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).sendKeys("Avellino");
    driver.findElement(By.id("provincia")).click();
    driver.findElement(By.id("provincia")).sendKeys("Avellino");
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("83045");
    driver.findElement(By.id("iscriviti")).click();
    driver.findElement(By.id("iscriviti")).click();
    {
      List<WebElement> elements = driver.findElements(By.id("errorecivico"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void registrazioneCorretta() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("#testocarrello > #bottone")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("mariorossi@libero.it");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("conferma")).click();
    driver.findElement(By.id("conferma")).sendKeys("qwertyuiop");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("codice_fiscale")).click();
    driver.findElement(By.id("codice_fiscale")).sendKeys("RSSMMN00C27B678K");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("via dei platani");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).sendKeys("Avellino");
    driver.findElement(By.id("provincia")).click();
    driver.findElement(By.id("provincia")).sendKeys("Avellino");
    driver.findElement(By.id("civco")).click();
    driver.findElement(By.id("civco")).sendKeys("3");
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("83045");
    driver.findElement(By.id("iscriviti")).click();
    assertThat(driver.findElement(By.cssSelector("#formreg > p")).getText(), is("Registrato"));
  }
  @Test
  public void registrazioneErroreFormatoCap() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("#testocarrello > #bottone")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("mariorossi@libero.it");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("conferma")).click();
    driver.findElement(By.id("conferma")).sendKeys("qwertyuiop");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("codice_fiscale")).click();
    driver.findElement(By.id("codice_fiscale")).sendKeys("RSSMMN00C27B678K");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("via dei platani");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).sendKeys("Avellino");
    driver.findElement(By.id("provincia")).click();
    driver.findElement(By.id("provincia")).sendKeys("Avellino");
    driver.findElement(By.id("civco")).click();
    driver.findElement(By.id("civco")).sendKeys("3");
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("aa");
    driver.findElement(By.id("iscriviti")).click();
    assertThat(driver.findElement(By.cssSelector("p:nth-child(2)")).getText(), is("Formato Cap errato"));
  }
  @Test
  public void registrazioneFormatoCittaErrato() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("#testocarrello > #bottone")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("mariorossi@libero.it");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("conferma")).click();
    driver.findElement(By.id("conferma")).sendKeys("qwertyuiop");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("codice_fiscale")).click();
    driver.findElement(By.id("codice_fiscale")).sendKeys("RSSMMN00C27B678K");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("via dei platani");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).sendKeys("222");
    driver.findElement(By.id("provincia")).click();
    driver.findElement(By.id("provincia")).sendKeys("Avellino");
    driver.findElement(By.id("civco")).click();
    driver.findElement(By.id("civco")).sendKeys("3");
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("83045");
    driver.findElement(By.id("iscriviti")).click();
    assertThat(driver.findElement(By.cssSelector("p:nth-child(2)")).getText(), is("Formato Città errato"));
  }
  @Test
  public void registrazioneFormatoCivicoErrato() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("#testocarrello > #bottone")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("mariorossi@libero.it");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("conferma")).click();
    driver.findElement(By.id("conferma")).sendKeys("qwertyuiop");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("codice_fiscale")).click();
    driver.findElement(By.id("codice_fiscale")).sendKeys("RSSMMN00C27B678K");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("via dei platani");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).sendKeys("Avellino");
    driver.findElement(By.id("provincia")).click();
    driver.findElement(By.id("provincia")).sendKeys("Avellino");
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("83045");
    driver.findElement(By.id("civco")).click();
    driver.findElement(By.id("civco")).sendKeys("aa");
    driver.findElement(By.id("iscriviti")).click();
    driver.findElement(By.cssSelector("p:nth-child(2)")).click();
    assertThat(driver.findElement(By.cssSelector("p:nth-child(2)")).getText(), is("Formato Civico errato"));
  }
  @Test
  public void registrazioneFormatoCodiceFiscaleErrato() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("#testocarrello > #bottone")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("mariorossi@libero.it");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("conferma")).click();
    driver.findElement(By.id("conferma")).sendKeys("qwertyuiop");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("codice_fiscale")).click();
    driver.findElement(By.id("codice_fiscale")).sendKeys("RS2");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("via dei platani");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).sendKeys("Avellino");
    driver.findElement(By.id("provincia")).click();
    driver.findElement(By.id("provincia")).sendKeys("Avellino");
    driver.findElement(By.id("civco")).click();
    driver.findElement(By.id("civco")).sendKeys("3");
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("83045");
    driver.findElement(By.id("iscriviti")).click();
    assertThat(driver.findElement(By.cssSelector("p:nth-child(2)")).getText(), is("Formato CF errato"));
  }
  @Test
  public void registrazioneFormatoProvinciaErrato() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("#testocarrello > #bottone")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("mariorossi@libero.it");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("conferma")).click();
    driver.findElement(By.id("conferma")).sendKeys("qwertyuiop");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("codice_fiscale")).click();
    driver.findElement(By.id("codice_fiscale")).sendKeys("RSSMMN00C27B678K");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("via dei platani");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).sendKeys("Avellino");
    driver.findElement(By.id("provincia")).click();
    driver.findElement(By.id("provincia")).sendKeys("222");
    driver.findElement(By.id("civco")).click();
    driver.findElement(By.id("civco")).sendKeys("3");
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("83045");
    driver.findElement(By.id("iscriviti")).click();
    assertThat(driver.findElement(By.cssSelector("p:nth-child(2)")).getText(), is("Formato Provincia errato"));
  }
  @Test
  public void registrazioneFormatoViaErrato() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("#testocarrello > #bottone")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("mariorossi@libero.it");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("conferma")).click();
    driver.findElement(By.id("conferma")).sendKeys("qwertyuiop");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("codice_fiscale")).click();
    driver.findElement(By.id("codice_fiscale")).sendKeys("RSSMMN00C27B678K");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).sendKeys("Avellino");
    driver.findElement(By.id("provincia")).click();
    driver.findElement(By.id("provincia")).sendKeys("Avellino");
    driver.findElement(By.id("civco")).click();
    driver.findElement(By.id("civco")).sendKeys("3");
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("83045");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("22");
    {
      List<WebElement> elements = driver.findElements(By.cssSelector("tr:nth-child(8) > td:nth-child(3)"));
      assert(elements.size() > 0);
    }
  }
  @Test
  public void registrazioneProvinciaMancante() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("#testocarrello > #bottone")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("mariorossi@libero.it");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("conferma")).click();
    driver.findElement(By.id("conferma")).sendKeys("qwertyuiop");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("codice_fiscale")).click();
    driver.findElement(By.id("codice_fiscale")).sendKeys("RSSMMN00C27B678K");
    driver.findElement(By.id("indirizzo")).click();
    driver.findElement(By.id("indirizzo")).sendKeys("via dei platani");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).sendKeys("avellino");
    driver.findElement(By.id("provincia")).click();
    driver.findElement(By.id("civco")).click();
    driver.findElement(By.id("civco")).sendKeys("3");
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("83045");
    driver.findElement(By.id("iscriviti")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver,null);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("provincia")));
    }
  }
  @Test
  public void registrazioneViaMancante() {
    driver.get("http://localhost:8080/AgriShop/offerta");
    driver.manage().window().setSize(new Dimension(1229, 1016));
    driver.findElement(By.linkText("Accedi")).click();
    driver.findElement(By.cssSelector("#testocarrello > #bottone")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("mariorossi@libero.it");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("qwertyuiop");
    driver.findElement(By.id("conferma")).click();
    driver.findElement(By.id("conferma")).sendKeys("qwertyuiop");
    driver.findElement(By.id("nome")).click();
    driver.findElement(By.id("nome")).sendKeys("Mario");
    driver.findElement(By.id("cognome")).click();
    driver.findElement(By.id("cognome")).sendKeys("Rossi");
    driver.findElement(By.id("codice_fiscale")).click();
    driver.findElement(By.id("codice_fiscale")).sendKeys("RSSMMN00C27B678K");
    driver.findElement(By.id("citta")).click();
    driver.findElement(By.id("citta")).sendKeys("Avellino");
    driver.findElement(By.id("provincia")).click();
    driver.findElement(By.id("provincia")).sendKeys("Avellino");
    driver.findElement(By.id("civco")).click();
    driver.findElement(By.id("civco")).sendKeys("3");
    driver.findElement(By.id("cap")).click();
    driver.findElement(By.id("cap")).sendKeys("83045");
    driver.findElement(By.id("iscriviti")).click();
    {
      List<WebElement> elements = driver.findElements(By.id("indirizzo"));
      assert(elements.size() > 0);
    }
  }
}
