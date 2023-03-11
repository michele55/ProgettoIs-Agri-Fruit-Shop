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
import GestioneCarrello.Carrello;
import GestioneProdotti.ProductModelDS;
import GestioneProdotti.prodotto;
import gestioneAccount.LoginModelDS;
import gestioneAcquisti.OrdineModel;
import gestioneAcquisti.PagamentoModel;
import gestioneAcquisti.SpedizioneModel;
import gestioneAcquisti.ordine;
import gestioneAcquisti.spedizione;
import gestioneAcquisti.totaleordine;

public class TestTotaleOrdini {
	 private MockHttpServletRequest request;
	    private MockHttpServletResponse response;
	    private Connection db;
		 ProductModelDS dao;
	    private MockMvc mockMvc;
	   	OrdineModel modelordine;
		PagamentoModel modelpagamento;
		SpedizioneModel modelspedizione;
		LoginModelDS model;
	    
	    @InjectMocks
	    private totaleordine servlet;
	 
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
	       modelordine= new OrdineModel(db);
	       modelpagamento=new PagamentoModel(db);
	       modelspedizione= new SpedizioneModel(db);
	       model= new LoginModelDS(db);
	        MockitoAnnotations.initMocks(this);
	    }
	    
	    
	    @Test
	    public void totaleOrdineCompleto_1 () throws ServletException, IOException, SQLException  {
	    	 Carrello<prodotto> carrello;
	    	 ordine ord=new ordine();
	    	
	    	 
	    	 int id;
	    	 ord.setCodice_fiscale("RSSNNM00b19A509K");
	    	 ord.setStato("Non_Pagato");
	    	 ord.setTotale(35.00);
	    	id=modelordine.doSave(ord);
	    		carrello = new Carrello<prodotto>();
	    		 prodotto prod=new prodotto(5,"Funghi","Funghi porcini in busta","Fun80",5,"Ortaggi","1",2);
	    	 	    dao=new ProductModelDS(db);
	    	 	    dao.doSave(prod);
	    		carrello.addOggetto(prod);
				request.getSession().setAttribute("carrello", carrello);
				request.getSession().setAttribute("nome", "alex@gmail.com");
				request.setParameter("spedizione", "SDA");
				request.getSession().setAttribute("ordine", id);
				request.getSession().setAttribute("spedizione", "5");
				request.setParameter("pagamento", "mastercard");
				
				  servlet.doPost(request, response);
				  assertEquals("La Scelta della spedizione è stata registrata",request.getSession().getAttribute("SceltaSpedizioneOk"));
				  assertEquals("La spedizione è stata salvata",request.getSession().getAttribute("SpedizioneInserita"));
				  assertEquals("La Scelta della spedizione è stata registrata",request.getSession().getAttribute("SceltaSpedizioneOk"));
				  assertEquals("La Scelta del pagamento è stata registrata",request.getSession().getAttribute("SceltaPagamentoOk"));
				  assertEquals("Il Pagamento è stato salvato correttamente",request.getSession().getAttribute("SalvataggioPagamento"));
	    }

}























