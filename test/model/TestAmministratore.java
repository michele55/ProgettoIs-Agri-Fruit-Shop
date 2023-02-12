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
import gestioneAccount.AmmModelDS;
import gestioneAccount.Amministratore;
import gestioneAccount.LoginModelDS;
import gestioneAccount.Utente;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAmministratore {
	private Connection db;
	private AmmModelDS dao;
	private Amministratore ammin1,ammin2;
	
	
	  @Before
	    public void setUp() throws SQLException {
	        try {
	            db = DBConnectionPool.getConnection();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	       dao=new AmmModelDS(db);
	       ammin1=new Amministratore();
	       ammin2=new Amministratore();
	       
	       ammin2.setNome("Elena");
	       ammin2.setCognome("Sansone");
	       ammin2.setEmail("bahadmin@gmail.com");
	       
	       
	      
	       ammin1.setNome("Giovanni");
	       ammin1.setCognome("Rauso");
	       ammin1.setEmail("admin1admin1@gmail.com");
	      
	       ammin1.setPwd("qwertyuiop");
	       ammin1.setRuolo("Amministratore");
	        dao.doSave(ammin1);
	  }
	  
	  @Test
	  public void Test1_FindAmmByNome() throws SQLException {
		  Amministratore ottenuto=dao.doRetrieveByNome(ammin1.getNome());
		  assertEquals("admin1admin1@gmail.com",ottenuto.getEmail());
	  }
@Test
public void Test2_FindAmmByKey() throws SQLException{
	Amministratore ottenuto=dao.doRetrieveByKey(ammin1.getEmail());
	assertEquals("Giovanni",ottenuto.getNome());
	
}
@Test
public void Test3_AmmExisting() throws SQLException{
	assertNotNull(dao.doRetrieveByKey(ammin1.getEmail()));
}
@Test
public void Test4_AmmNotExisting() throws SQLException{
	assertNull(dao.doRetrieveByKey(ammin2.getEmail()));
}
@Test
public void Test5_DeleteAmmExisting() throws SQLException {
	assertEquals(true,dao.doDelete(ammin1.getEmail()));
	assertEquals(true,dao.doSave(ammin1));
}

}
