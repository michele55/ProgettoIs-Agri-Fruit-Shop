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

import gestioneAccount.CancellaUtente;

public class TestCancellazUtente {
	 private MockHttpServletRequest request;
	    private MockHttpServletResponse response;
	    @InjectMocks
	    private CancellaUtente servlet;
	    
	    @BeforeEach
	    void setUp() throws Exception {
	        request = new MockHttpServletRequest();
	        response = new MockHttpServletResponse(); 
	        MockitoAnnotations.initMocks(this);
	    }
	    
	    
	    @Test
	    public void TestCancUtenteCorretta () throws ServletException, IOException  {
		   request.setParameter("Nome Utente", "alex@gmail.com");
	      
	        servlet.doPost(request, response);
	        assertEquals("Cancellazione effettuata con successo",request.getAttribute("delete"));
	    }
	    
}
