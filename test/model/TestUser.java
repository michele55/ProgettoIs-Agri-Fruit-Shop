package model;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Database.DBConnectionPool;
import gestioneAccount.LoginModelDS;
import gestioneAccount.Utente;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUser {
	  private Connection db;
	    private LoginModelDS userDAO;
	    private Utente utenteEsistente;
	    private Utente utenteNonEsistente;
	    private Utente utente3;
	   
	    public TestUser() {}
	    
	    @Before
	    public void setUp() throws SQLException {
	        try {
	            db = DBConnectionPool.getConnection();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        userDAO = new LoginModelDS(db);
	      
	       utente3=new Utente();
	       
	       
	       
	       
	       
	        utenteEsistente = new Utente();
	        
	        utenteEsistente.setNome("Giuseppe");
	        utenteEsistente.setCognome("Ross");
	        utenteEsistente.setIndirizzo("Via Roma");
	        utenteEsistente.setCivico("4");
	        utenteEsistente.setCap("84084");
	        utenteEsistente.setCodice_fiscale("RSSGPP58T04B415H");
	        utenteEsistente.setEmail("russo45@gmail.com");
	        utenteEsistente.setPwd("fuckyou1");
	      //  utenteEsistente.setRuolo("Utente");
	        
	        userDAO.doSave(utenteEsistente);

	    }

	    
	    @Test
	   public void Test1_GetFindUserByEmailExisting() throws SQLException  {
	    	Utente ottenuto=userDAO.doRetrieveByKey(utenteEsistente.getEmail());
	    	 assertEquals("russo45@gmail.com",ottenuto.getEmail());
	    }
	    

	    @Test
	    public void Test2_InsertUserNotExisting () throws SQLException {
	    	 utenteNonEsistente = new Utente();
	    	 utenteNonEsistente.setNome("Giuseppe");
		        utenteNonEsistente.setCognome("Ross");
		        utenteNonEsistente.setIndirizzo("Via Roma");
		        utenteNonEsistente.setCivico("4");
		        utenteNonEsistente.setCap("84084");
		        utenteNonEsistente.setCodice_fiscale("RSSGPP58T04B415S");
		        utenteNonEsistente.setEmail("russo465@gmail.com");
		        utenteNonEsistente.setPwd("fuckyou1");
		     //   utenteNonEsistente.setRuolo("Utente");
	        assertEquals(true,userDAO.doSave(utenteNonEsistente));
	       
	      
	        assertEquals(true,userDAO.doDelete(utenteNonEsistente.getEmail()));
	    }
	    
	    @Test
		   public void Test3_GetFindUserbyNameExisting() throws SQLException {
			   Utente ottenuto=userDAO.doRetrieveByNome(utenteEsistente.getNome());
			  
		    	 assertEquals("Giuseppe",ottenuto.getNome());
		    	
			   
		   }
	    @Test
	    public void Test4_UpdateUserExisting() throws SQLException{
	    	
	    	 utenteEsistente.setNome("Mario");
		        utenteEsistente.setCognome("Cicoira");
		        utenteEsistente.setIndirizzo("Via Umberto Saba");
		        utenteEsistente.setCivico("9");
		        utenteEsistente.setCap("83045");
		        utenteEsistente.setCodice_fiscale("RSSGPP58T04B415H");
		        utenteEsistente.setEmail("russo45@gmail.com");
		        utenteEsistente.setPwd("fuckyou1");
	    	
	    	assertEquals(true,userDAO.doUpdate(utenteEsistente));
	    	
	    }
	    @Test
	    public void Test5_UpdateUserNotExisting() throws  SQLException{
	    	
	   Utente utenteNot=new Utente();
	   assertEquals(false,userDAO.doUpdate(utenteNot));
	   
	    	
	    }
	    @Test
	    public void Test6_DeleteUserExisting () throws SQLException {
	        assertEquals(true,userDAO.doDelete(utenteEsistente.getEmail()));
	        assertEquals(true,userDAO.doSave(utenteEsistente));
	       // utenteEsistente = userDAO.getUserByUsername("SampleUsername");
	       // assertNotEquals(-1, utenteEsistente.getId());
	    }
	 
	    
	   
}
