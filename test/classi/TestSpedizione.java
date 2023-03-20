package classi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gestioneAcquisti.spedizione;



public class TestSpedizione {
	
	@Test
	   public void getId() {
	 spedizione o = new spedizione(1,3,"SDA","Calitri","Via Umberto Saba","Avellino",3,83045,8);
	
	    assertEquals(1, o.getId());
	  }
	
	@Test
	   public void setId() {
	spedizione o = new spedizione();
o.setId(2);
	    assertEquals(2, o.getId());
	  }
	@Test
	   public void getNumOrdine() {
	 spedizione o = new spedizione(1,3,"SDA","Calitri","Via Umberto Saba","Avellino",3,83045,8);
	
	    assertEquals(3, o.getNumeroordine());
	  }
	
	@Test
	   public void setNumOrdine() {
	spedizione o = new spedizione();
o.setNumeroordine(4);
	    assertEquals(4, o.getNumeroordine());
	  }
	
	
	@Test
	   public void getModSpedizione() {
	 spedizione o = new spedizione(1,3,"SDA","Calitri","Via Umberto Saba","Avellino",3,83045,8);
	
	    assertEquals("SDA", o.getModalitaspedizione());
	  }
	
	@Test
	   public void setModSpedizione() {
	spedizione o = new spedizione();
o.setModalitaspedizione("BRT");
	    assertEquals("BRT", o.getModalitaspedizione());
	  }
	
	@Test
	   public void getCosto() {
	 spedizione o = new spedizione(1,3,"SDA","Calitri","Via Umberto Saba","Avellino",3,83045,8);
	
	    assertEquals(8, o.getCostospedizione());
	  }
	
	@Test
	   public void setCosto() {
	spedizione o = new spedizione();
	o.setCostospedizione(8);
	    assertEquals(8, o.getCostospedizione());
	  }

}
