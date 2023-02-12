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
			risposta.append("<option></option>");
			Iterator<?> it=prodotto.iterator();
			while(it.hasNext()){
				prodotto beans=(prodotto)it.next();
				
				risposta.append("<option value="+beans.getNome()+">");
				risposta.append(beans.getNome());
				risposta.append("</option>");}
			
			
		} catch (SQLException e) {
			utility.print(e);
			
			request.setAttribute("error", e.getMessage());
			
		}
		
	}
	
	

	
	if(nomeprodotto!=null) {
			System.out.print(nomeprodotto);
			try {		
				
				prod=model.doRetrieveByNome(nomeprodotto);
				
				rispostaprodotto.append("<input type=text name=nome placeholder="+prod.getNome()+">");
				rispostaprodotto.append("<input type=text name=Ssn placeholder="+prod.getSsn()+">");
				rispostaprodotto.append("<input type=text name=disponibilita placeholder="+prod.getQuantita()+">");
				rispostaprodotto.append("<input type=text name=prezzo placeholder="+prod.getPrezzo()+">");
				rispostaprodotto.append("<input type=text name=descrizione placeholder="+prod.getDescrizione()+">");
				rispostaprodotto.append("<input type=text name=idfoto placeholder="+prod.getIdfoto()+">");
				rispostaprodotto.append("<input type= submit value=conferma>");
				
				
				
				
				
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
