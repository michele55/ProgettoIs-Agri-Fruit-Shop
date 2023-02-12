package classi;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import gestioneAccount.Utente;

public class TestUtente {
	@Test
	   public void getNome() {
	   Utente u = new Utente("Mario","Rossi","Via Roma","RSSNNM00B19a509K","mariorossi@gmail.com","MRossi90","3","Utente","83045",1);
	
	    assertEquals("Mario", u.getNome());
	  }
	
	@Test
	  public void setNome() {
	   Utente u = new Utente();
	    u.setNome("Laura");
	    assertEquals("Laura", u.getNome());
	  }
	
	@Test
	   public void getCognome() {
	   Utente u = new Utente("Mario","Rossi","Via Roma","RSSNNM00B19a509K","mariorossi@gmail.com","MRossi90","3","Utente","83045",1);
	  
	    assertEquals("Rossi", u.getCognome());
	  }
	
	@Test
	  public void setCognome() {
	    Utente u = new Utente();
	    u.setCognome("Bianchi");
	    assertEquals("Bianchi", u.getCognome());
	  }
	@Test
	   public void getIndirizzo() {
	   Utente u = new Utente("Mario","Rossi","Via Roma","RSSNNM00B19a509K","mariorossi@gmail.com","MRossi90","3","Utente","83045",1);
	
	    assertEquals("Via Roma", u.getIndirizzo());
	  }
	
	@Test
	  public void setIndirizzo() {
	    Utente u = new Utente();
	    u.setIndirizzo("Via Caselle");;
	    assertEquals("Via Caselle", u.getIndirizzo());
	  }
	@Test
	  public void getCivico() {
	    Utente u = new Utente("Mario","Rossi","Via Roma","RSSNNM00B19a509K","mariorossi@gmail.com","MRossi90","3","Utente","83045",1);
	   
	    assertEquals("3", u.getCivico());
	  }
	@Test
	  public void setCivico() {
	    Utente u = new Utente();
	   u.setCivico("3");
	    assertEquals("3", u.getCivico());
	  }
	@Test
	  public void getCap() {
	    Utente u = new Utente("Mario","Rossi","Via Roma","RSSNNM00B19a509K","mariorossi@gmail.com","MRossi90","3","Utente","83045",1);
	   
	    assertEquals("83045", u.getCap());
	  }
	@Test
	  public void setCap() {
	    Utente u = new Utente();
	   u.setCap("83045");
	    assertEquals("83045", u.getCap());
	  }
	@Test
	  public void getCodiceFiscale() {
	    Utente u = new Utente("Mario","Rossi","Via Roma","RSSNNM00B19a509K","mariorossi@gmail.com","MRossi90","3","Utente","83045",1);
	   
	    assertEquals("RSSNNM00B19a509K", u.getCodice_fiscale());
	  }
	@Test
	  public void setCodiceFiscale() {
	    Utente u = new Utente();
	   u.setCodice_fiscale("RSSNNM00B19B909E");;
	    assertEquals("RSSNNM00B19B909E", u.getCodice_fiscale());
	  }
	@Test
	  public void getEmail() {
	    Utente u = new Utente("Mario","Rossi","Via Roma","RSSNNM00B19a509K","mariorossi@gmail.com","MRossi90","3","Utente","83045",1);
	   
	    assertEquals("mariorossi@gmail.com", u.getEmail());
	  }
	@Test
	  public void setEmail() {
	    Utente u = new Utente();
	 u.setEmail("rossim@gmail.com");
	    assertEquals("rossim@gmail.com", u.getEmail());
	  }
	
	@Test
	  public void getRuolo() {
	    Utente u = new Utente("Mario","Rossi","Via Roma","RSSNNM00B19a509K","mariorossi@gmail.com","MRossi90","3","Utente","83045",1);
	   
	    assertEquals("Utente", u.getRuolo());
	  }
	@Test
	  public void setRuolo() {
	    Utente u = new Utente();
	 u.setRuolo("Utente");
	    assertEquals("Utente", u.getRuolo());
	  }
	@Test
	  public void getPwd() {
	    Utente u = new Utente("Mario","Rossi","Via Roma","RSSNNM00B19a509K","mariorossi@gmail.com","MRossi90","3","Utente","83045",1);
	   
	    assertEquals("MRossi90", u.getPwd());
	  }
	@Test
	  public void setPwd() {
	    Utente u = new Utente();
	 u.setPwd("Rossi90");
	    assertEquals("Rossi90", u.getPwd());
	  }
}
