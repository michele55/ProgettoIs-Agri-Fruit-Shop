package servlet;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.AfterEach; 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import gestioneAccount.loginservlet;
import junit.framework.Assert;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.Before;
public class TestLogin extends Mockito{
	 private MockHttpServletRequest request;
	    private MockHttpServletResponse response;
	    
	    @InjectMocks
	    private loginservlet servlet;

	   @BeforeEach
	    void setUp() throws Exception {
	        request = new MockHttpServletRequest();
	        response = new MockHttpServletResponse(); 
	        MockitoAnnotations.initMocks(this);
	    }
	
	
	   @Test
	    public void TestLoginCorretto () throws ServletException, IOException  {
		   request.setParameter("Email", "alex@gmail.com");
	        request.setParameter("password", "cavese12");
	        servlet.doPost(request, response);
	        assertEquals("Login avvenuto correttamente",request.getAttribute("login"));
	    }

	   @Test
	    public void TestLoginNonCorretto () throws ServletException, IOException  {
		   request.setParameter("Email", "ale@gmail.com");
	        request.setParameter("password", "cavese12");
	        servlet.doPost(request, response);
	        assertEquals("Parametri Sbagliati",request.getAttribute("erroreParametri"));
	    }
	   
	   @Test
	    public void TestLoginConPwdNulla () throws ServletException, IOException  {
		   request.setParameter("Email", "alex@gmail.com");
	        request.setParameter("password", "");
	        servlet.doPost(request, response);
	        assertEquals("Errore Password",request.getAttribute("passerrore"));
	    }
	   
	   
	   @Test
	    public void TestLoginConUserNullo () throws ServletException, IOException  {
		   request.setParameter("Email", "");
	        request.setParameter("password", "cavese12");
	        servlet.doPost(request, response);
	        assertEquals("Parametri Sbagliati",request.getAttribute("erroreParametri"));
	     
	    }


}
