package gestioneAccount;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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
import utils.utility;

/**
 * Servlet implementation class AdminPage
 */
@WebServlet("/AdminPage")
public class AdminPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	DataSource ds= (DataSource) getServletContext().getAttribute("DataSource");
		Connection db = null;
		try {
			db = DBConnectionPool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ProductModelDS model= new ProductModelDS(db);
		prodotto prod= new prodotto();
		
		Float prezzo=(Float.parseFloat(request.getParameter("prezzo")));
		System.out.print(prezzo);
		String nome=request.getParameter("nome");
		String SSN=request.getParameter("Ssn");
		Integer disponibilita= (Integer.parseInt(request.getParameter("disponibilita")));
		String descrizione=request.getParameter("descrizione");
		String categ=request.getParameter("categoria");
		String idfoto=request.getParameter("idfoto");
		
		String action=request.getParameter("action");
		
		
		
		
				if(prezzo!=null)
				prod.setPrezzo(prezzo);
			
		
			if(nome!=null) {			
				if(!nome.equals("")) {
					prod.setNome(nome);
				}}
		
		if(SSN!=null) {			
		if(!SSN.equals("")) {
			prod.setSsn(SSN);
		}
		}
		if(disponibilita!=null) {
			prod.setQuantita(disponibilita);;
		}
		
		if(descrizione!=null) {
		if(!descrizione.equals("")) {
			prod.setDescrizione(descrizione);
		}}
		
		if(!categ.equals("")) {
			prod.setCtegoria(categ);
		}
		
		if(idfoto!=null) {
			if(!idfoto.equals("")){
				prod.setIdfoto(idfoto);;
			}}
	
		if(action!=null&&!action.equals("")) {
			
			try {
				model.doUpdate(prod);
				
			} catch (SQLException e) {
				utility.print(e);
				
				request.setAttribute("error", e.getMessage());
			}
			
			
			
		}
		
		
		try {
			 model.doSave(prod);
			
		} catch (SQLException e) {
			utility.print(e);
			
			request.setAttribute("error", e.getMessage());
		}
		
	
	
		
		RequestDispatcher dispacher=this.getServletContext().getRequestDispatcher("/homepage.jsp");
		dispacher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
