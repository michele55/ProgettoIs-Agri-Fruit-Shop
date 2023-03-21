package GestioneProdotti;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import Database.DBConnectionPool;
import utils.utility;

/**
 * Servlet implementation class scegliprodotto
 */
@WebServlet("/scegliprodotto")
public class scegliprodotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String categoria=request.getParameter("categoria");
		String nomeprodotto=request.getParameter("nomeprodotto");
		String error1m=(String)request.getSession().getAttribute("errNomeMod");
		String error2m=(String)request.getSession().getAttribute("errDispMod");
		String error3m=(String)request.getSession().getAttribute("errPrezzoMod");
		String error4m=(String)request.getSession().getAttribute("errSSNMod");
		String error5m=(String)request.getSession().getAttribute("errDescrMod");
	//	String error6m=(String)request.getSession().getAttribute("errCategMod");
		String error7m=(String)request.getSession().getAttribute("errIdFotoMod");
		request.getSession().setAttribute("mod", "mod");
		//DataSource ds= (DataSource) getServletContext().getAttribute("DataSource");
		Connection db = null;
		try {
			db = DBConnectionPool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		ProductModelDS model= new ProductModelDS(db);
		prodotto prod=new prodotto();
	
		System.out.print(nomeprodotto);
	
		Collection <prodotto> prodotto= new LinkedList<prodotto>(); 
		StringBuffer risposta=new StringBuffer();
		StringBuffer rispostaprodotto=new StringBuffer();
		
	if(categoria!=null) {
		
		try {
			prodotto=model.doRetrieveByKey(categoria);
			if(!prodotto.isEmpty()) {
				request.getSession().setAttribute("risultato","ok");
				risposta.append("<option></option>");
				Iterator<?> it=prodotto.iterator();
				while(it.hasNext()){
					prodotto beans=(prodotto)it.next();
					
					risposta.append("<option value="+beans.getNome()+">");
					risposta.append(beans.getNome());
					risposta.append("</option>");}
			}
			else {
				request.getSession().setAttribute("risultato","Not Ok");
			}
		
			
			
		} catch (SQLException e) {
			utility.print(e);
			
			request.setAttribute("error", e.getMessage());
			
		}
		
	}
	
	


	if(nomeprodotto!=null) {
			System.out.print(nomeprodotto);
			try {		
				
				prod=model.doRetrieveByNome(nomeprodotto);
				if(!prod.isEmpty()) {
					rispostaprodotto.append("<input type=text name=nome placeholder="+prod.getNome()+">");
					if(error1m!=null && error1m!=""){ 
						rispostaprodotto.append("<p>Errore Formato Modifica nome </p>");
						error1m=""; 
						} 
							
					rispostaprodotto.append("<input type=text name=Ssn placeholder="+prod.getSsn()+">");
					if(error4m!=null && error4m!=""){ 
						rispostaprodotto.append("<p>Errore Formato Modifica SSN </p>");
						error4m=""; 
						} 
					rispostaprodotto.append("<input type=text name=disponibilita placeholder="+prod.getQuantita()+">");
					if(error2m!=null && error2m!=""){ 
						rispostaprodotto.append("<p>Errore Formato Modifica Disponibilità </p>");
						error2m=""; 
						} 
					rispostaprodotto.append("<input type=text name=prezzo placeholder="+prod.getPrezzo()+">");
					if(error3m!=null && error3m!=""){ 
						rispostaprodotto.append("<p>Errore Formato Modifica Prezzo </p>");
						error3m=""; 
						} 
					rispostaprodotto.append("<input type=text name=descrizione placeholder="+prod.getDescrizione()+">");
					if(error5m!=null && error5m!=""){ 
						rispostaprodotto.append("<p>Errore Formato Modifica Descrizione </p>");
						error5m=""; 
						} 
					rispostaprodotto.append("<input type=text name=idfoto placeholder="+prod.getIdfoto()+">");
					if(error7m!=null && error7m!=""){ 
						rispostaprodotto.append("<p>Errore Formato Modifica IdFoto</p>");
						error7m=""; 
						} 
					rispostaprodotto.append("<input type= submit value=conferma>");
					request.getSession().setAttribute("risultatoNomeProdotto","Nome prodotto Ok");
				}
				else {
					request.getSession().setAttribute("risultatoNomeProdotto","Nome prodotto non esistente");
				}
			
				
				
				
				
			} catch (SQLException e) {
				utility.print(e);
				
				request.setAttribute("error", e.getMessage());
				
			}
			
		}

	
	response.getWriter().write(rispostaprodotto.toString());
		response.getWriter().write(risposta.toString());
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
