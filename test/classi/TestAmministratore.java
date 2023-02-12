package classi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gestioneAccount.Amministratore;



public class TestAmministratore {
	
	@Test
	   public void getNome() {
	  Amministratore a = new Amministratore("Luigi","Ramundo","mariorossi@gmail.com","MRossi90","Amministratore");
	
	    assertEquals("Luigi", a.getNome());
	  }
	
	@Test
	   public void setNome() {
	  Amministratore a = new Amministratore();
	  a.setNome("Giovanni");
	
	    assertEquals("Giovanni", a.getNome());
	  }
	
	
	
	@Test
	   public void getCognome() {
	  Amministratore a = new Amministratore("Luigi","Ramundo","mariorossi@gmail.com","MRossi90","Amministratore");
	
	    assertEquals("Ramundo", a.getCognome());
	  }
	
	@Test
	   public void setCognome() {
	  Amministratore a = new Amministratore();
	  a.setCognome("Ramundo");
	
	    assertEquals("Ramundo", a.getCognome());
	  }
	@Test
	   public void getEmail() {
	  Amministratore a = new Amministratore("Luigi","Ramundo","mariorossi@gmail.com","MRossi90","Amministratore");
	
	    assertEquals("mariorossi@gmail.com", a.getEmail());
	  }
	
	@Test
	   public void setEmail() {
	  Amministratore a = new Amministratore();
	  a.setEmail("mr890@gmail.com");
	
	    assertEquals("mr890@gmail.com", a.getEmail());
	  }
	
	
	
	@Test
	   public void getPwd() {
	  Amministratore a = new Amministratore("Luigi","Ramundo","mariorossi@gmail.com","MRossi90","Amministratore");
	
	    assertEquals("MRossi90", a.getPwd());
	  }
	
	@Test
	   public void setPwd() {
	  Amministratore a = new Amministratore();
	  a.setPwd("MRossi60");;
	
	    assertEquals("MRossi60", a.getPwd());
	  }
	
	
	@Test
	   public void getRuolo() {
	  Amministratore a = new Amministratore("Luigi","Ramundo","mariorossi@gmail.com","MRossi90","Amministratore");
	
	    assertEquals("Amministratore", a.getRuolo());
	  }
	
	@Test
	   public void setRuolo() {
	  Amministratore a = new Amministratore();
	  a.setRuolo("Amministratore");
	
	    assertEquals("Amministratore", a.getRuolo());
	  }

}
