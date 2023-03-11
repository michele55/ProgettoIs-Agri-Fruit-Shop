package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.internal.MethodSorter;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.*;
import Database.DBConnectionPool;
import GestioneProdotti.ProductModelDS;
import GestioneProdotti.prodotto;
import gestioneAcquisti.OrdineModel;
import gestioneAcquisti.ordine;

import org.junit.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestProdotto {


	private Connection db;
	private ProductModelDS daoP;
	private OrdineModel daoOrd;
	private prodotto prod,prod2,prod3,prod4;
	private ordine ord;
	
	@Before
	public void setUp() throws SQLException {
		try {
			db=DBConnectionPool.getConnection();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		daoP=new ProductModelDS(db);
		daoOrd=new OrdineModel(db);
		prod=new prodotto(8,"Patate","Patate in busta","Prod01",5,"Ortaggi","1",4);
		prod2=new prodotto(4,"Mele","Mele In Busta","Prod02",4,"Frutta","2",6);
		prod3=new prodotto(5,"Pomodori","Pomodori per sugo","Prod03",6,"Ortaggi","3",7);
		ord=new ordine();
		
		ord.setStato("Pagato");
		ord.setCodice_fiscale("RSSNNM00b19A509K");
		ord.setTotale(50.00);
		daoP.doSave(prod);
	
		//daoOrd.doSave(ord);
	}
	
	@Test
	public void Test_1_ProdRetrieveAll() throws SQLException {


assertEquals(false,daoP.doRetrieveAll(null).isEmpty());


		
	}
	@Test
	public void Test_2_ProdExistingRetrieveByNome() throws SQLException {
	
//	assertNotNull(daoP.doRetrieveByNome("Patate"));
	
		assertEquals("Patate in busta",daoP.doRetrieveByNome("Patate").getDescrizione());
	}
	
	@Test
	public void Test_3_ProdNotExistingRetrieveByNome() throws SQLException {
	
		assertEquals("", daoP.doRetrieveByNome("Funghi").getNome());


		
	}
	
	@Test
	public void Test_4_AddProdotto() throws SQLException {
	assertTrue(daoP.doSave(prod2));
	daoP.doDelete(prod2);
	}
	
	
	@Test
	public void Test_5_ProdExistingRetrieveByDescrizione() throws SQLException {
	  assertEquals(false,daoP.doRetrieveByparametro("Patate in busta").isEmpty());     
		
	}
	@Test
	public void Test_6_ProdNotExistingRetrieveByDescrizione() throws SQLException {
	
	assertEquals(true,daoP.doRetrieveByparametro("Zucchine in busta").isEmpty());
	}
	
	@Test
	public void Test_7_ProdExistingRetrieveBySSN() throws SQLException {
	
	
		assertEquals("Patate",daoP.doRetrieveBySSN("Prod01").getNome());
	}
	
	@Test
	public void Test_8_deleteProdExisting() throws SQLException {
	daoP.doSave(prod3);
	assertTrue(daoP.doDelete(prod3));
	}
	@Test
	public void Test_9_deleteProdNotExisting() throws SQLException {
	prod4=new prodotto();
	assertEquals(false,daoP.doDelete(prod4));
	}
	  @After
	   public void tearDown() throws Exception {
		   System.out.println("Sono entrato nella tearDown");
		  daoP.doDelete(prod);
	   }
	   
}
