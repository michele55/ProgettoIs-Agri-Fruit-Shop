package servlet;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import gestioneAcquisti.ordiniclienti;
public class TestOrdiniClienti {
	 private MockHttpServletRequest request;
	    private MockHttpServletResponse response;
	  
	    
	    private MockMvc mockMvc;
	    
	    @InjectMocks
	    private ordiniclienti servlet;
	 
	    @BeforeEach
	    void setUp() throws Exception {
	        request = new MockHttpServletRequest();
	        response = new MockHttpServletResponse(); 
	       response.setContentType("text/html");
	        MockitoAnnotations.initMocks(this);
	    }
	    
	    
	    
	
	    @Test
	    public void TestOrdiniClientiCorretto () throws ServletException, IOException  {
	    	 HttpSession currentsession = request.getSession();
	    	 
	    	 currentsession.setAttribute("emailutente","alex@gmail.com");
		  
		
	
	      
	        servlet.doPost(request, response);
	        assertEquals("Ordine ritrovato",request.getAttribute("ord"));
	    }

	    
	    
	    @Test
	    public void TestOrdiniClientiNonEsistente () throws ServletException, IOException  {
	    	 HttpSession currentsession = request.getSession();
	    	 
	    	 currentsession.setAttribute("emailutente","alexr@gmail.com");
		  
		
	
	      
	        servlet.doPost(request, response);
	        assertEquals("Ordine Inesistente",request.getAttribute("ordInesistente"));
	    }
	    
	    
}
