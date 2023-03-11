package servlet;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import Database.DBConnectionPool;
import GestioneCarrello.Carrello;
import GestioneCarrello.CarrelloServlet;
import GestioneProdotti.ProductModelDS;
import GestioneProdotti.prodotto;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCarrello {
	 private MockHttpServletRequest request;
	    private MockHttpServletResponse response;
		private Connection db;
		 ProductModelDS dao;
	    
	    private MockMvc mockMvc;
	    
	    @InjectMocks
	    private CarrelloServlet servlet;
	 
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
	    public void CarrelloNonEsistente_Test1 () throws ServletException, IOException  {
	   

	        servlet.doPost(request, response);
	        assertEquals("Il carrello è vuoto",request.getSession().getAttribute("carrelloVuoto"));
	   
	    }
	    
	    @Test
	    public void CarrelloEsistente_Test2 () throws ServletException, IOException  {
	   
	    	 Carrello<prodotto> carrello;
	    		carrello = new Carrello<prodotto>();
				request.getSession().setAttribute("carrello", carrello);

	        servlet.doPost(request, response);
	        assertEquals("Il carrello non è null",request.getSession().getAttribute("carrelloEsistente"));
	   
	    }
	    
	    
	    
	    
	    @Test
	    public void CarrelloEsistenteConActionTotale_Test3 () throws ServletException, IOException, SQLException  {
	   
	    	 Carrello<prodotto> carrello;
	    	 prodotto prod=new prodotto(5,"Funghi","Funghi porcini in busta","Fun80",5,"Ortaggi","1",2);
	    	    dao=new ProductModelDS(db);
	    	    dao.doSave(prod);
	    		carrello = new Carrello<prodotto>();
	    		carrello.setValorecarrello(35);
	    		carrello.addOggetto(prod);
				request.getSession().setAttribute("carrello", carrello);
				request.getSession().setAttribute("nome", "alex@gmail.com");
				request.setParameter("action", "totale");
				request.setParameter("quantità", "5");
				request.getSession().setAttribute("test", "test");
	        servlet.doPost(request, response);
	        assertEquals("Il carrello non è null",request.getSession().getAttribute("carrelloEsistente"));
	        assertEquals("L'ordine è stato registrato correttamente",request.getSession().getAttribute("Ordineok"));
	        assertEquals("Inserimento in composto Ok",request.getSession().getAttribute("CompostoOk"));
	        
	        
	       // carrello.deleteOggetto(prod);
	        dao.doDelete(prod);
	    }

	    
	    @Test
	    public void CarrelloEsistenteConActionDelete_Test4() throws ServletException, IOException, SQLException  {
	     	 Carrello<prodotto> carrello;
	    	 prodotto prod=new prodotto(5,"Funghi","Funghi porcini in busta","Fun80",5,"Ortaggi","1",2);
	    	    dao=new ProductModelDS(db);
	    	    dao.doSave(prod);
	    		carrello = new Carrello<prodotto>();
	    		carrello.setValorecarrello(35);
	    		carrello.addOggetto(prod);
				request.getSession().setAttribute("carrello", carrello);
				request.getSession().setAttribute("nome", "alex@gmail.com");
				request.setParameter("action", "deleteCart");
				request.setParameter("quantità", "5");
				request.setParameter("NomeProd", prod.getNome());
				  request.getSession().setAttribute("test", "test");
				 servlet.doPost(request, response);
				  assertEquals("Cart deleted",request.getSession().getAttribute("deleteCart"));
				
				  dao.doDelete(prod);
	    	
	    }
	    
	    @Test
	    public void CarrelloEsistenteConActionAggiungi_Test5 () throws ServletException, IOException, SQLException  {
	    	 Carrello<prodotto> carrello;
	    	 prodotto prod=new prodotto(5,"Funghi","Funghi porcini in busta","Fun80",5,"Ortaggi","1",2);
	    	   dao=new ProductModelDS(db);
	    	    dao.doSave(prod);
	    		carrello = new Carrello<prodotto>();
	    	//	carrello.setValorecarrello(35);
	    	//	carrello.addOggetto(prod);
				request.getSession().setAttribute("carrello", carrello);
				request.getSession().setAttribute("nome", "alex@gmail.com");
				request.setParameter("action", "aggiungi");
				request.setParameter("NomeProd", prod.getNome());
				request.setParameter("quantita","2");
				servlet.doPost(request, response);
				assertEquals("Aggiunta avvenuta correttamente",request.getSession().getAttribute("AggiuntaCarrello"));
				  dao.doDelete(prod);
	    	
	    }
	    
	    
	    @Test
	    public void CarrelloEsistActionAggQuantNonDisp_Test6 () throws ServletException, IOException, SQLException  {
	    	 Carrello<prodotto> carrello;
	    	 prodotto prod=new prodotto(5,"Funghi","Funghi porcini in busta","Fun80",5,"Ortaggi","1",2);
	    	   dao=new ProductModelDS(db);
	    	    dao.doSave(prod);
	    		carrello = new Carrello<prodotto>();
	    	//	carrello.setValorecarrello(35);
	    	//	carrello.addOggetto(prod);
				request.getSession().setAttribute("carrello", carrello);
				request.getSession().setAttribute("nome", "alex@gmail.com");
				request.setParameter("action", "aggiungi");
				request.setParameter("NomeProd", prod.getNome());
				request.setParameter("quantita","20");
				servlet.doPost(request, response);
				assertEquals("Errore disponibilità, aggiunta non effettuata",request.getSession().getAttribute("AggiuntaNonEffettuata"));
				dao.doDelete(prod);
	    	
	    }
	    
}
