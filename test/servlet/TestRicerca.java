package servlet;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import GestioneProdotti.ricerca;
import gestioneAccount.CancellaUtente;

public class TestRicerca {
	 private MockHttpServletRequest request;
	    private MockHttpServletResponse response;
	    @InjectMocks
	    private ricerca servlet;
	    
	    @BeforeEach
	    void setUp() throws Exception {
	        request = new MockHttpServletRequest();
	        response = new MockHttpServletResponse(); 
	        MockitoAnnotations.initMocks(this);
	    }
	    
	    @Test
	    public void TestRicercaProdSpecificoCorretta () throws ServletException, IOException  {
		   request.setParameter("parametro", "pomodoro");
	      
	        servlet.doPost(request, response);
	        assertEquals("risultatoEsatto",request.getAttribute("risultato"));
	    }
	    
	    
	    @Test
	    public void TestRicercaProdNonSpecificoCorretta () throws ServletException, IOException  {
		   request.setParameter("parametro", "pomodori");
	      
	        servlet.doPost(request, response);
	        assertEquals("Effettuata ricerca categoria",request.getAttribute("risultatoCateg"));
	    }
	    
	    @Test
	    public void TestRicercaProdNonSpecificoNonCorretto () throws ServletException, IOException  {
		   request.setParameter("parametro", "zucchine dorate");
	      
	        servlet.doPost(request, response);
	        assertEquals("Effettuata ricerca categoria",request.getAttribute("risultatoCateg"));
	    }
	    @Test
	    public void TestRicercaErrore () throws ServletException, IOException  {
		   request.setParameter("", "");
	      
	        servlet.doPost(request, response);
	        assertEquals("errore Ricerca",request.getAttribute("errore"));
	    } 
}
