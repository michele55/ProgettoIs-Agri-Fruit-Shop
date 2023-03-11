package GestioneCarrello;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import Database.DBConnectionPool;
import GestioneProdotti.ProductModelDS;
import GestioneProdotti.prodotto;
import gestioneAccount.LoginModelDS;
import gestioneAccount.Utente;
import gestioneAcquisti.OrdineModel;
import gestioneAcquisti.ordine;
import net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.Response;
import utils.utility;



@WebServlet("/carrello")
public class CarrelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	float cont=0;
	int costospedizione;
	int numeroordine=2;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String quantita=request.getParameter("quantita");
		String indirizzo="";
		String nome = request.getParameter("NomeProd");
		int valoreritorno=0;
		int count = 0;
		System.out.print(nome);
	//	DataSource ds = (DataSource) getServletContext().getAttribute("DataSource");
		Connection db = null;
		try {
			db = DBConnectionPool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ProductModelDS model = new ProductModelDS(db);
		boolean controllo=false;
		
		
		
		
		
		String totale= request.getParameter("action");
		String nomenegozio=(String) request.getSession().getAttribute("emailutente");
		OrdineModel modelordine= new OrdineModel(db);
		compostoModel modelcomposto=new compostoModel(db);
		LoginModelDS model2= new LoginModelDS(db);
		ordine ordine= new ordine();

		composto composto=new composto();
		Utente neg=new Utente();
		StringBuffer risposta=new StringBuffer();
	
		Carrello<prodotto> carrello = (Carrello<prodotto>) request.getSession().getAttribute("carrello");
		
		if(nomenegozio!=null) {
			try {
				neg=(model2.doRetrieveByKey(nomenegozio));
				
			}catch (SQLException e) {
				
				response.sendRedirect("homepage.jsp");		
			}
			
		}
		
		if (carrello==null) {
			
			request.getSession().setAttribute("carrelloVuoto", "Il carrello è vuoto");
			carrello = new Carrello<prodotto>();
			request.getSession().setAttribute("carrello", carrello);
		}
		
		String action = request.getParameter("action");
		
		if(carrello != null) {
			request.getSession().setAttribute("carrelloEsistente", "Il carrello non è null");
			
		}
	
		if(nome==null) {
			
			indirizzo="homepage.jsp";
		}
		
		
		try {
			
			if (action != null) {
				if(action.equals("totale")) {	
					indirizzo="confermaordine.jsp";
					float valore=carrello.getValorecarrello();
					valore=valore+cont+costospedizione;
					carrello.setValorecarrello(valore);
					cont=0;
					costospedizione=0;
					risposta.append(+carrello.getValorecarrello());
					
					ordine.setTotale(valore);
					ordine.setStato("Non Pagato");
					ordine.setCodice_fiscale(neg.getCodice_fiscale());	
					System.out.println("Test1: "+ neg.getIndirizzo());
					
				//	ordine.setNumero(numeroordine);
				//	request.getSession().setAttribute("ordine", numeroordine);

				
				try {
					valoreritorno=modelordine.doSave(ordine);
					
					request.getSession().setAttribute("ordine",valoreritorno);
					if(ordine.getCodice_fiscale()!=null && ordine.getTotale()!=0.0) {
						request.getSession().setAttribute("Ordineok", "L'ordine è stato registrato correttamente");
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					
				for(int i=0;i<carrello.getOggetto().size();i++) {
					prodotto prod= new prodotto();
					prod=carrello.getOggetto().get(i);
				
				composto.setQuantita(prod.getDispcarrello());
			
					composto.setSsn(prod.getSsn());
					composto.setNumero(valoreritorno);
					
				
					try {
						modelcomposto.doSave(composto);
						if(prod.getDispcarrello()!=0 && prod.getSsn()!=null) {
							request.getSession().setAttribute("CompostoOk", "Inserimento in composto Ok");
						}
						
						if(request.getSession().getAttribute("test")!=null) {
							modelcomposto.doDelete(composto);
							
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						count=1;
						e.printStackTrace();
						
					}
					if(count!=1) {
						prod.setQuantita(prod.getQuantita()-prod.getDispcarrello());
						model.doUpdate(prod);
					}
						
					request.getServletContext().getRequestDispatcher("/"+indirizzo+"").forward(request, response);
				
				}
				++numeroordine;
				}
			
				 if (action.equals("deleteCart")) {
					 indirizzo="carrello.jsp";
						prodotto bean = model.doRetrieveByNome(nome);
						if (bean != null && !bean.isEmpty()) {
								carrello.deleteOggetto(bean);
								
								request.getSession().setAttribute("carrello", carrello);	
								request.getSession().setAttribute("deleteCart", "Cart deleted");
								request.getServletContext().getRequestDispatcher("/"+indirizzo+"").forward(request, response);
								}	
				 	}
										
				if (action.equals("clearCart")) {
					carrello.deleteOggetto();
					indirizzo="homepage.jsp";
				//	request.getSession().setAttribute("stato", "true");
					request.getServletContext().getRequestDispatcher("/"+indirizzo+"").forward(request, response);
				}
							
				if (action.equals("aggiungi")) {	
					int qnt=Integer.parseInt(quantita);
					prodotto bean = (prodotto) model.doRetrieveByNome(nome);
					indirizzo="prodotti?scelta="+bean.getCategoria()+"";
					
					if (bean != null && !bean.isEmpty()) {
						System.out.println("Qui funziona");
						if(carrello.getOggetto().isEmpty()) {
							if(bean.getQuantita()>=(bean.getDispcarrello()+qnt)&& (bean.getQuantita()!=0)) {
							bean.setDispcarrello(qnt);
							carrello.addOggetto(bean);
						
							request.getSession().removeAttribute("quantitaerr");
							request.getSession().setAttribute("AggiuntaCarrello", "Aggiunta avvenuta correttamente");
							response.sendRedirect("/AgriShop/AggCarrelloSuccess.jsp");
						
					
							
		
							
							}else {
								if(bean.getQuantita()!=0) {
									request.getSession().removeAttribute("quantitaerr");
									bean.setDispcarrello(bean.getQuantita());
									
									carrello.addOggetto(bean);
									request.getSession().setAttribute("AggiuntaCarrello", "Aggiunta avvenuta correttamente");
									
									
									response.sendRedirect("/AgriShop/AggCarrelloSuccess.jsp");
									PrintWriter out = response.getWriter();
							
								}
							if(bean.getQuantita()==0) {	
							
								
								request.getSession().setAttribute("quantitaerr", "erroredisponibilita");
								request.getSession().setAttribute("AggiuntaNonEffettuata", "Errore disponibilità, aggiunta non effettuata");
								response.sendRedirect("/AgriShop/ErroreAggProdotti.jsp");
							}
							
							}
							}else {
								request.getSession().removeAttribute("quantitaerr");
						for(int i=0;i<carrello.getOggetto().size();i++) {
							if(carrello.getOggetto().get(i).getNome().equals(bean.getNome())){
								int valore=carrello.getOggetto().get(i).getDispcarrello();
								int disponibilita=carrello.getOggetto().get(i).getQuantita();
							
								if(disponibilita>=(valore+qnt)) {
								carrello.getOggetto().get(i).setDispcarrello(valore+qnt);
								response.sendRedirect("/AgriShop/AggCarrelloSuccess.jsp");
								controllo=true;
								}
								else {
									bean.setDispcarrello(bean.getQuantita());
						
									request.getSession().setAttribute("quantitaerr", "erroredisponibilita");
									response.sendRedirect("/AgriShop/ErroreAggProdotti.jsp");
								
									controllo=true;
								}
							}}
							if(controllo==false) {
								if(bean.getQuantita()>=(bean.getDispcarrello()+qnt)) {
								bean.setDispcarrello(qnt);
								carrello.addOggetto(bean);
								response.sendRedirect("/AgriShop/AggCarrelloSuccess.jsp");
							
								request.getSession().removeAttribute("quantitaerr");
								}else {
									if(bean.getQuantita()!=0) {
										request.getSession().removeAttribute("quantitaerr");
										bean.setDispcarrello(bean.getQuantita());
										carrello.addOggetto(bean);
										response.sendRedirect("/AgriShop/AggCarrelloSuccess.jsp");
										
									}
								
									//request.getSession().setAttribute("quantitaerr", "erroredisponibilita");
								
								}
								}
											
						}
									
					}}
				}  
					
			
			
		} catch (SQLException | NumberFormatException e) {
			utility.print(e);
			request.setAttribute("error", e.getMessage());
		}
		
		request.getSession().setAttribute("carrello", carrello);
		request.getSession().setAttribute("nomeprod", nome);
		
	//	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/"+indirizzo+"");
		//dispatcher.include(request, response);
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
