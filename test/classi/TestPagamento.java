package classi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gestioneAcquisti.pagamento;



public class TestPagamento {
	
	@Test
	   public void getId() {
	 pagamento p = new pagamento(1,2,"Contanti");
	
	    assertEquals(1, p.getId());
	  }
	
	@Test
	   public void setId() {
	 pagamento p = new pagamento();
p.setId(2);
	    assertEquals(2,p.getId());
	  }
	
	@Test
	   public void getNumPag() {
	 pagamento p = new pagamento(1,2,"Contanti");
	
	    assertEquals(2, p.getNumeropagamento());
	  }
	
	@Test
	   public void setNumPag() {
	 pagamento p = new pagamento();
p.setNumeropagamento(3);
	    assertEquals(3,p.getNumeropagamento());
	  }
	
	@Test
	   public void getModPagamento() {
	 pagamento p = new pagamento(1,2,"Contanti");
	
	    assertEquals("Contanti", p.getModalitapagamento());
	  }
	
	@Test
	   public void setModPagamento() {
	 pagamento p = new pagamento();
p.setModalitapagamento("Carta");
	    assertEquals("Carta",p.getModalitapagamento());
	  }
	
	
	

}
