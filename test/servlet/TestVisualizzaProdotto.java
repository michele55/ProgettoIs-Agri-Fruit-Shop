package servlet;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import Database.DBConnectionPool;
import GestioneProdotti.visualizzaprodotto;


public class TestVisualizzaProdotto {
	 private MockHttpServletRequest request;
	    private MockHttpServletResponse response;
		private Connection db;
	
	    @InjectMocks
	    private visualizzaprodotto servlet;
	
	    @BeforeEach
	    void setUp() throws Exception {
	    	try {
				db = DBConnectionPool.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	        request = new MockHttpServletRequest();
	        response = new MockHttpServletResponse(); 
	       response.setContentType("text/html");
	        MockitoAnnotations.initMocks(this);
	    }
	    
	    @Test
	    public void TestVisualizzaProdottoCorretto () throws ServletException, IOException  {
	    	request.setParameter("nomeprodotto", "lattuga");
	    	 servlet.doPost(request, response);
	    	 assertEquals("prodotto ritrovato",request.getSession().getAttribute("prod"));
	    }
	    
	    
	    @Test
	    public void TestVisualizzaProdottoNonCorretto () throws ServletException, IOException  {
	    	request.setParameter("nomeprodotto", "latt");
	    	 servlet.doPost(request, response);
	    	 assertEquals("Prodotto null, errore sulla ricerca,probabile non esistente",request.getSession().getAttribute("prod"));
	    }
}
