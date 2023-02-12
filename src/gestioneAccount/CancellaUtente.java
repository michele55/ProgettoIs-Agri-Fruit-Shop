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
 * Servlet implementation class CancellaUtente
 */
@WebServlet("/CancellaUtente")
public class CancellaUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancellaUtente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	DataSource ds= (DataSource) getServletContext().getAttribute("DataSource");
Connection ds = null;
		
		try {
			ds = DBConnectionPool.getConnection();
			
			
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		LoginModelDS model= new LoginModelDS(ds);
		
		Utente neg= new Utente();
		
		
		String Nome=request.getParameter("Nome Utente");
		
		

	
		
		if(Nome!=null) {			
		if(!Nome.equals("")) {
			neg.setNome(Nome);;
		}
		}
	
	
		try {
			 model.doDelete(neg.getEmail());
			
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
