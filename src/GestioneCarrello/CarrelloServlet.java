package GestioneCarrello;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
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
		String nome = request.getParameter("nome");
		int valoreritorno=0;
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
		String nomenegozio=(String) request.getSession().getAttribute("nome");
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
				neg=(model2.doRetrieveByNome(nomenegozio));
				System.out.print(neg.getEmail());
			}catch (SQLException e) {
				
				response.sendRedirect("homepage.jsp");		
			}
			
		}
		
		if (carrello == null) {
			carrello = new Carrello<prodotto>();
			request.getSession().setAttribute("carrello", carrello);
		}
		
		String action = request.getParameter("action");
		
		if(carrello != null) {
			
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
				//	ordine.setNumero(numeroordine);
				//	request.getSession().setAttribute("ordine", numeroordine);

				
				try {
					valoreritorno=modelordine.doSave(ordine);
					
					request.getSession().setAttribute("ordine",valoreritorno);
					
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
					System.out.println(valoreritorno);
					
					try {
						modelcomposto.doSave(composto);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
					
				
				}
				++numeroordine;
				}
			
				 if (action.equals("deleteCart")) {
					 indirizzo="carrello.jsp";
						prodotto bean = model.doRetrieveByNome(nome);
						if (bean != null && !bean.isEmpty()) {
								carrello.deleteOggetto(bean);
								request.getSession().setAttribute("carrello", carrello);	
									
								}	
				 	}
										
				if (action.equals("clearCart")) {
					carrello.deleteOggetto();
					indirizzo="carrello.jsp";
				
				}
							
				if (action.equals("aggiungi")) {	
					int qnt=Integer.parseInt(quantita);
					prodotto bean = (prodotto) model.doRetrieveByNome(nome);
					indirizzo="prodotti?scelta="+bean.getCategoria()+"";
					if (bean != null && !bean.isEmpty()) {		
						if(carrello.getOggetto().isEmpty()) {
							if(bean.getQuantita()>=(bean.getDispcarrello()+qnt)) {
							bean.setDispcarrello(qnt);
							carrello.addOggetto(bean);
							}else {
								bean.setDispcarrello(bean.getQuantita());
								carrello.addOggetto(bean);
								request.getSession().setAttribute("quantitaerr", "erroredisponibilita");
							
							}
							}else {

						for(int i=0;i<carrello.getOggetto().size();i++) {
							if(carrello.getOggetto().get(i).getNome().equals(bean.getNome())){
								int valore=carrello.getOggetto().get(i).getDispcarrello();
								int disponibilita=carrello.getOggetto().get(i).getQuantita();
							
								if(disponibilita>=(valore+qnt)) {
								carrello.getOggetto().get(i).setDispcarrello(valore+qnt);
								controllo=true;
								}
								else {
									bean.setDispcarrello(bean.getQuantita());
						
									request.getSession().setAttribute("quantitaerr", "erroredisponibilita");
									controllo=true;
								}
							}}
							if(controllo==false) {
								if(bean.getQuantita()>=(bean.getDispcarrello()+qnt)) {
								bean.setDispcarrello(qnt);
								carrello.addOggetto(bean);
								}else {
									bean.setDispcarrello(bean.getQuantita());
									carrello.addOggetto(bean);
									request.getSession().setAttribute("quantitaerr", "erroredisponibilita");
								
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

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/"+indirizzo+"");
		dispatcher.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
