package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import Database.DBConnectionPool;
import gestioneAccount.AmmModelDS;
import gestioneAccount.Amministratore;
import gestioneAcquisti.PagamentoModel;
import gestioneAcquisti.pagamento;

public class TestPagamento {
	private Connection db;
	private PagamentoModel dao;
	private pagamento pag1,pag2;
	
	
	@Before
    public void setUp() throws SQLException{
	    try {
            db = DBConnectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
       dao=new PagamentoModel(db);
       pag1=new pagamento();
      pag2=new pagamento();
      
      pag1.setId(1);
      pag1.setNumeropagamento(1);
      pag1.setModalitapagamento("Contanti");
      dao.doSave(pag1);
	}

	
	
	  @Test
	  public void Test1_PagExisting() throws SQLException {
		 assertTrue(dao.doRetrieveById("1"));
	  }
	  
	  @Test
	  public void Test1_PagNotExisting() throws SQLException {
		 assertFalse(dao.doRetrieveById("10"));
	  }
}
