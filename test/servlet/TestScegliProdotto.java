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
import org.springframework.test.web.servlet.MockMvc;

import Database.DBConnectionPool;
import GestioneProdotti.scegliprodotto;
import gestioneAcquisti.ordiniclienti;

public class TestScegliProdotto {
	 private MockHttpServletRequest request;
	    private MockHttpServletResponse response;
   private MockMvc mockMvc;
	private Connection db;
	    @InjectMocks
	    private scegliprodotto servlet;
	    
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
	    public void TestScegliProdottoCorretto () throws ServletException, IOException  {
	    	request.setParameter("categoria", "frutta");
	     	request.setParameter("nomeprodotto", "uva");
	    	 servlet.doPost(request, response);
	    	 assertEquals("ok",request.getSession().getAttribute("risultato"));
	    	 assertEquals("Nome prodotto Ok",request.getSession().getAttribute("risultatoNomeProdotto"));
	    }
	    
	    
	    @Test
	    public void TestScegliProdottoCategNonCorretta () throws ServletException, IOException  {
	    	request.setParameter("categoria", "fru");
	     	request.setParameter("nomeprodotto", "uva");
	    	 servlet.doPost(request, response);
	    	 assertEquals("Not Ok",request.getSession().getAttribute("risultato"));
	    	 assertEquals("Nome prodotto Ok",request.getSession().getAttribute("risultatoNomeProdotto"));
	    }
	    
	    @Test
	    public void TestScegliProdottoNomeProdNonCorretto () throws ServletException, IOException  {
	    	request.setParameter("categoria", "frutta");
	     	request.setParameter("nomeprodotto", "u");
	    	 servlet.doPost(request, response);
	    	 assertEquals("ok",request.getSession().getAttribute("risultato"));
	    	 assertEquals("Nome prodotto non esistente",request.getSession().getAttribute("risultatoNomeProdotto"));
	    }
	    
	    @Test
	    public void TestScegliProdottoNonCorretto () throws ServletException, IOException  {
	    	request.setParameter("categoria", "f");
	     	request.setParameter("nomeprodotto", "u");
	    	 servlet.doPost(request, response);
	    	 assertEquals("Not Ok",request.getSession().getAttribute("risultato"));
	    	 assertEquals("Nome prodotto non esistente",request.getSession().getAttribute("risultatoNomeProdotto"));
	    }
}
