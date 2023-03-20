package gestioneAcquisti;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import Database.DBConnectionPool;
import GestioneCarrello.Carrello;
import GestioneCarrello.composto;
import GestioneCarrello.compostoModel;
import GestioneProdotti.prodotto;
import gestioneAccount.LoginModelDS;
import gestioneAccount.Utente;

/**
 * Servlet implementation class totaleordine
 */
@WebServlet("/totaleordine")
public class totaleordine extends HttpServlet {
	private static final long serialVersionUID = 1L;
	float cont=0;
	int costospedizione;
	int numeroordine;
	int numerospedizione;
	int idspedizione=1;
	int idpagamento=1;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		//DataSource ds= (DataSource) getServletContext().getAttribute("DataSource");
		Connection db = null;
		try {
			db = DBConnectionPool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String tipopagamento= request.getParameter("pagamento");
		String totale= request.getParameter("action");
		String tipospedizione=request.getParameter("spedizione");
		String nomenegozio=(String) request.getSession().getAttribute("nome");
		String citta=request.getParameter("citta");
		
		System.out.println("Cittaaa: "+citta);
		String cap=request.getParameter("cap");
		String civico=request.getParameter("civico");
		String via=request.getParameter("via");
		String provincia=request.getParameter("provincia");
		System.out.println("Prov: "+provincia);
		
		OrdineModel modelordine= new OrdineModel(db);
		PagamentoModel modelpagamento=new PagamentoModel(db);
		SpedizioneModel modelspedizione= new SpedizioneModel(db);
		LoginModelDS model= new LoginModelDS(db);
		
		Carrello<prodotto> carrello = (Carrello<prodotto>) request.getSession().getAttribute("carrello");
		Utente neg=new Utente();
		
		spedizione spedizione=new spedizione();
		pagamento pagamento=new pagamento();
		ordine ordine=new ordine();

		
		StringBuffer risposta=new StringBuffer();
		
		
		if(nomenegozio!=null) {
			try {
				neg=(model.doRetrieveByNome(nomenegozio));
				System.out.print(neg.getEmail());
			}catch (SQLException e) {
				
				response.sendRedirect("homepage.jsp");		
			}
			
		}
	
			System.out.println(nomenegozio);
		if(carrello!=null) {

			
			
			if(tipospedizione!=null) {
				if(tipospedizione.equals("GLS")) {
					costospedizione=8;
					numeroordine=(int) request.getSession().getAttribute("ordine");
				//	spedizione.setId(idspedizione);
					spedizione.setNumeroordine(numeroordine);
					spedizione.setCostospedizione(costospedizione);
					spedizione.setModalitaspedizione("GLS");
					request.getSession().setAttribute("SceltaSpedizioneOk", "La Scelta della spedizione è stata registrata");
					
				}
				if(tipospedizione.equals("SDA")) {
					costospedizione=6;
					numeroordine=(int) request.getSession().getAttribute("ordine");
					//spedizione.setId(idspedizione);
					
				//	request.getSession().setAttribute("numerospediz", idspedizione);
					spedizione.setNumeroordine(numeroordine);
					spedizione.setCostospedizione(costospedizione);
					spedizione.setModalitaspedizione("SDA");
					request.getSession().setAttribute("SceltaSpedizioneOk", "La Scelta della spedizione è stata registrata");
				}
				if(tipospedizione.equals("MANO")) {
					costospedizione=0;
					numeroordine=(int) request.getSession().getAttribute("ordine");
				//	spedizione.setId(idspedizione);
					spedizione.setNumeroordine(numeroordine);
					spedizione.setCostospedizione(costospedizione);
					spedizione.setModalitaspedizione("RITIRO");
					request.getSession().setAttribute("SceltaSpedizioneOk", "La Scelta della spedizione è stata registrata");
				}
				if((citta!=null & provincia!=null & via!=null & cap!=null & civico !=null) || (spedizione.getModalitaspedizione().equals("RITIRO"))) {
					if(citta!=null & provincia!=null & via!=null & cap!=null & civico !=null) {
						spedizione.setCitta(citta);
						spedizione.setProvincia(provincia);
						spedizione.setVia(via);
						spedizione.setCap(Integer.parseInt(cap));
						spedizione.setCivico(Integer.parseInt(civico));
					}
					
					
					try {
						
						idspedizione=modelspedizione.doSave(spedizione);
						request.getSession().setAttribute("SpedizioneInserita", "La spedizione è stata salvata");
						
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				
			//	++idspedizione;
				request.getSession().setAttribute("numerospediz", idspedizione);
			}
		
			if(tipopagamento!=null) {
				numerospedizione=(int)request.getSession().getAttribute("numerospediz");
				if(tipopagamento.equals("contanti")) {
					pagamento.setId(idpagamento);
					
					pagamento.setNumeropagamento(numerospedizione);
				pagamento.setModalitapagamento("contanti");
				request.getSession().setAttribute("SceltaPagamentoOk", "La Scelta del pagamento è stata registrata");
				
				cont=4;
				}
			
			
				if(tipopagamento.equals("mastercard")) {
				
					pagamento.setNumeropagamento(numerospedizione);
				pagamento.setModalitapagamento("mastercard");
				cont=0;
				request.getSession().setAttribute("SceltaPagamentoOk", "La Scelta del pagamento è stata registrata");
				}
			
	
				if(tipopagamento.equals("paypal")) {
					
					pagamento.setNumeropagamento(numerospedizione);
				pagamento.setModalitapagamento("paypal");
				cont=0;
				request.getSession().setAttribute("SceltaPagamentoOk", "La Scelta del pagamento è stata registrata");
				
			}
				
					ordine.setautoGeneratedID(numeroordine);
				try {
					modelpagamento.doSave(pagamento);
					modelordine.doUpdate(ordine);
					request.getSession().setAttribute("order","Order");
					request.getSession().setAttribute("SalvataggioPagamento", "Il Pagamento è stato salvato correttamente");
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			
			
			
	
		
		}
		
	
		 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/carrello?action=totale");
		 
			    dispatcher.forward(request, response);
			    
			 
		response.getWriter().write(risposta.toString());
		
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
