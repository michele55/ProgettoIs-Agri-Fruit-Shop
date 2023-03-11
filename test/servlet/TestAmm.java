package servlet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import gestioneAccount.AmministratoreServlet;



public class TestAmm extends Mockito {
	
	 private MockHttpServletRequest request;
	    private MockHttpServletResponse response;
	    @InjectMocks
	    private AmministratoreServlet servlet;
	    
	    
	    @BeforeEach
	    void setUp() throws Exception {
	        request = new MockHttpServletRequest();
	        response = new MockHttpServletResponse(); 
	        MockitoAnnotations.initMocks(this);
	    }
	    @Test
	    public void TestLoginAmmCorretto () throws ServletException, IOException  {
		   request.setParameter("Email", "amm1mario@gmail.com");
	        request.setParameter("password", "admin");
	        servlet.doPost(request, response);
	        assertEquals("Login Effettuato con Successo",request.getAttribute("Successo"));
	    }
	    @Test
	    public void TestLoginAmmUserNonCorretto () throws ServletException, IOException  {
		   request.setParameter("Email", "amm1mario99@gmail.com");
	        request.setParameter("password", "admin");
	        servlet.doPost(request, response);
	        
	        assertEquals("Parametri nulli",request.getAttribute("erroreNullo"));
	    }
	    
	    @Test
	    public void TestLoginAmmPwdNonCorretta () throws ServletException, IOException  {
		   request.setParameter("Email", "amm1mario@gmail.com");
	        request.setParameter("password", "admin56");
	        servlet.doPost(request, response);
	        
	        assertEquals("Errore di password o email",request.getAttribute("errore"));
	    }
	    
	    
	    
	    @Test
	    public void TestLoginParametriNulli () throws ServletException, IOException  {
		   request.setParameter("Email", "");
	        request.setParameter("password", "");
	        servlet.doPost(request, response);
	        
	        assertEquals("Parametri nulli",request.getAttribute("erroreNullo"));
	    }
	    
}
