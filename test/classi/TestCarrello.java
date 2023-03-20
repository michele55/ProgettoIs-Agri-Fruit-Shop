package classi;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import GestioneCarrello.Carrello;
import GestioneProdotti.prodotto;
import gestioneAcquisti.ordine;

public class TestCarrello {
	@Test
	   public <T> void getItems() {
		List<prodotto> items=new ArrayList<>();
		items.add(new prodotto());
	
	 Carrello o = new Carrello( items,50);
	assertNotNull(o.getOggetto());

	  }
	
	@Test
	   public void setItems() {
		
	 Carrello o = new Carrello();
	 prodotto prod=new prodotto();
	 prod.setNome("Prod1");
	o.addOggetto(prod);
	    assertNotNull(o.getOggetto().get(0));
	  }
	@Test
	   public <T> void getValoreCarr() {
		List<prodotto> items=new ArrayList<>();
		items.add(new prodotto());
	
	 Carrello o = new Carrello( items,50);
assertEquals(50, o.getValorecarrello(), 0);

	  }
	@Test
	   public void setValoreCarr() {
		
	 Carrello o = new Carrello();
	 o.setValorecarrello(40);

	   assertEquals(40, o.getValorecarrello(), 0);
	  }
	@Test
	   public void deleteOggetto() {
		
	 Carrello o = new Carrello();
	 prodotto prod=new prodotto();
	 prod.setNome("Prod1");
	o.addOggetto(prod);
	    assertNotNull(o.getOggetto().get(0));
	    
	    o.deleteOggetto(prod.getNome());
	assertEquals("", o.getOggetto());
	  }
	
}
