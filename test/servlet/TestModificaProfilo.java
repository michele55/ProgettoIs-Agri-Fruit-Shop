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

import gestioneAccount.Modificaprofilo;



public class TestModificaProfilo {
	 private MockHttpServletRequest request;
	    private MockHttpServletResponse response;
	    
	    @InjectMocks
	    private Modificaprofilo servlet;

	   @BeforeEach
	    void setUp() throws Exception {
	        request = new MockHttpServletRequest();
	        response = new MockHttpServletResponse(); 
	        MockitoAnnotations.initMocks(this);
	    }
	
	   
	   
	   @Test
	    public void TestModificaProfiloCorretto () throws ServletException, IOException  {
		   request.setAttribute("bool", "si");
		   request.setParameter("neg","alex@gmail.com");
		
	        request.setParameter("password", "cavese20");
	        request.setParameter("password", "cavese20");
	        request.setParameter("indirizzo", "Via bari");
	        request.setParameter("codice_fiscale", "RSSNNMOPA560P");
	        request.setParameter("cap", "80100");
	        request.setParameter("ncivico", "6");
	        servlet.doPost(request, response);
	        assertEquals("Cambio dati avvenuto correttamente",request.getAttribute("Cambio dati"));
	    }


}
