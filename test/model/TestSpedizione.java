package model;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Database.DBConnectionPool;
import gestioneAcquisti.SpedizioneModel;
import gestioneAcquisti.spedizione;

import gestioneAcquisti.*;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSpedizione {
	private Connection db;
	private SpedizioneModel dao;
	private OrdineModel dao2;
	private spedizione sped1,sped2,sped3;
	private ordine ord1;
	

	@Before
    public void setUp() throws SQLException{
	    try {
            db = DBConnectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
       dao=new SpedizioneModel(db);
       dao2=new OrdineModel(db);
    sped1=new spedizione();
     sped2=new spedizione();
 
      ord1=new ordine(1,40.00,"PAGATO","RSSNNM00B19A509K");
      dao2.doSave(ord1);
   sped1.setNumeroordine(1);
      sped1.setModalitaspedizione("SDA");
      sped1.setCostospedizione(6);
      
      
      sped2.setNumeroordine(2);
      sped2.setModalitaspedizione("BRT");
      sped2.setCostospedizione(10);
      
      
      
      

      dao.doSave(sped1);
	}

	  @Test
	  public void Test1_findSpedbyCode() throws SQLException {
		 assertTrue(dao.doRetrieveByNumero("1"));
	  }
	  
	   @Test
	    public void Test2_InsertSped ()  throws Exception {
	        assertNotNull(dao.doSave(sped2));
	       assertEquals(true,dao.doDelete(sped2.getNumeroordine()));
	    }
	   
	   @Test
	    public void Test3_DeleteSped ()  throws Exception {
	       
	       assertEquals(true,dao.doDelete(sped1.getNumeroordine()));
	    }
	
}
