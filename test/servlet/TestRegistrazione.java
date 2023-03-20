package servlet;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import gestioneAccount.LoginModelDS;
import gestioneAccount.Utente;
import gestioneAccount.registrazione;
import Database.DBConnectionPool;




public class TestRegistrazione extends Mockito {
	Connection db;
	
	private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    
   
    
    @InjectMocks
    private registrazione servlet;
    
    
    @SuppressWarnings("deprecation")
	@BeforeEach
    void setUp() throws Exception {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        MockitoAnnotations.initMocks(this);
    }
    
   @Test
    public void TestNuovaRegistrazione() throws ServletException, IOException, SQLException {
	   try {
   		db = DBConnectionPool.getConnection();
   	} catch (SQLException e) {
   		e.printStackTrace();
   	}
	   request.setParameter("email", "mariarossi@gmail.com");
	   request.setParameter("password", "maria");
	   request.setParameter("conferma", "maria");
	   request.setParameter("nome", "Maria");
        request.setParameter("cognome", "Rossi");
        request.setParameter("codice_fiscale", "rssnnm00b19a079k");
        request.setParameter("indirizzo", "Via dei palazzi");
        request.setParameter("citta", "Calitri");
        request.setParameter("provincia", "Avellino");
        request.setParameter("cap", "83045");
        request.setParameter("civico", "3");
   
      
        servlet.doPost(request, response);
        assertNull(request.getAttribute("presente"));
		LoginModelDS daoP = new LoginModelDS(db);
       	Utente p = daoP.doRetrieveByKey("m.rossi");
       // daoP.doDelete(p.getEmail());
    }
       
    @Test
    public void TestRegistrazioneUsernameEsistente() throws ServletException, IOException {
 	   request.setParameter("email", "mariarossi@gmail.com");
 	   request.setParameter("password", "maria");
 	   request.setParameter("conferma", "maria");
 	   request.setParameter("nome", "Maria");
         request.setParameter("cognome", "Rossi");
         request.setParameter("codice_fiscale", "rssnnm00b19a079k");
         request.setParameter("indirizzo", "Via dei palazzi");
         request.setParameter("citta", "Calitri");
         request.setParameter("provincia", "Avellino");
         request.setParameter("cap", "83045");
         request.setParameter("civico", "3");
        servlet.doPost(request, response);
        assertEquals(true, request.getAttribute("presente"));
       
    }
    
    @AfterEach
    void tearDown() throws Exception {
    	try {
    		db = DBConnectionPool.getConnection();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	 LoginModelDS daoA = new LoginModelDS(db);
    	 daoA.doDelete("m.rossi");
 
        request=null;
        response=null;
    }
}