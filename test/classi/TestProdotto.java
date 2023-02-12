package classi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import GestioneProdotti.prodotto;


public class TestProdotto {
	
	@Test
	   public void getPrezzo() {
	 prodotto p = new prodotto(8,"Patate","Patate in sacco","Pat01",5,"Ortaggi","2",0);
	
	assertEquals(8, p.getPrezzo(), 0);
	    
	  }
	
	@Test
	   public void setPrezzo() {
	 prodotto p = new prodotto();
	 p.setPrezzo(9);
	
	assertEquals(9, p.getPrezzo(), 0);
	    
	  }
	
	
	@Test
	   public void getNome() {
	 prodotto p = new prodotto(8,"Patate","Patate in sacco","Pat01",5,"Ortaggi","2",0);
	
	assertEquals("Patate", p.getNome());
	    
	  }
	
	@Test
	   public void setNome() {
	 prodotto p = new prodotto();
	 p.setNome("Patata");
	
	assertEquals("Patata", p.getNome());
	    
	  }
	@Test
	   public void getDescrizione() {
	 prodotto p = new prodotto(8,"Patate","Patate in sacco","Pat01",5,"Ortaggi","2",0);
	
	assertEquals("Patate in sacco", p.getDescrizione());
	    
	  }
	
	@Test
	   public void setDescrizione() {
	 prodotto p = new prodotto();
	p.setDescrizione("Patate in sacco");
	
	assertEquals("Patate in sacco", p.getDescrizione());
	    
	  }
	@Test
	   public void getSSN() {
	 prodotto p = new prodotto(8,"Patate","Patate in sacco","Pat01",5,"Ortaggi","2",0);
	
	assertEquals("Pat01", p.getSsn());
	    
	  }
	
	@Test
	   public void setSSN() {
	 prodotto p = new prodotto();
	p.setSsn("Patate01");
	
	assertEquals("Patate01", p.getSsn());
	    
	  }
	@Test
	   public void getQuantità() {
	 prodotto p = new prodotto(8,"Patate","Patate in sacco","Pat01",5,"Ortaggi","2",0);
	
	assertEquals(5, p.getQuantita());
	    
	  }
	
	@Test
	   public void setQuantità() {
	 prodotto p = new prodotto();
	p.setQuantita(10);
	
	assertEquals(10, p.getQuantita());
	    
	  }
	@Test
	   public void getCategoria() {
	 prodotto p = new prodotto(8,"Patate","Patate in sacco","Pat01",5,"Ortaggi","2",0);
	
	assertEquals("Ortaggi", p.getCategoria());
	    
	  }
	
	@Test
	   public void setCategoria() {
	 prodotto p = new prodotto();
	p.setCtegoria("Frutta");
	
	assertEquals("Frutta", p.getCategoria());
	    
	  }
	
	@Test
	   public void getIdFoto() {
	 prodotto p = new prodotto(8,"Patate","Patate in sacco","Pat01",5,"Ortaggi","2",0);
	
	assertEquals("2", p.getIdfoto());
	    
	  }
	
	@Test
	   public void setIdFoto() {
	 prodotto p = new prodotto();
	p.setIdfoto("3");
	
	assertEquals("3", p.getIdfoto());
	    
	  }
	
	@Test
	   public void getDispCarrello() {
	 prodotto p = new prodotto(8,"Patate","Patate in sacco","Pat01",5,"Ortaggi","2",0);
	
	assertEquals(0, p.getDispcarrello());
	    
	  }
	
	@Test
	   public void setDispCarrello() {
	 prodotto p = new prodotto();
	p.setDispcarrello(8);
	
	assertEquals(8, p.getDispcarrello());
	    
	  }
}
