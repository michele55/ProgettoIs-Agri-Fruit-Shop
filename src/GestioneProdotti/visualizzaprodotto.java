package GestioneProdotti;

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
import utils.utility;

/**
 * Servlet implementation class visualizzaprodotto
 */
@WebServlet("/visualizzaprodotto")
public class visualizzaprodotto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		//DataSource ds= (DataSource) getServletContext().getAttribute("DataSource");
		Connection db = null;
		try {
			db = DBConnectionPool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ProductModelDS model= new ProductModelDS(db);
		String dato=(String)request.getParameter("nomeprodotto");
		prodotto p=new prodotto();
			
		try {
			p= model.doRetrieveByscelta(dato);
			
			request.setAttribute("prodotti", p);
			if(p.getNome()!="") {
				request.getSession().setAttribute("prod", "prodotto ritrovato");
			}
			else {
				request.getSession().setAttribute("prod", "Prodotto null, errore sulla ricerca,probabile non esistente");
			}
			
		} catch (SQLException e) {
			utility.print(e);
			
			request.setAttribute("error", e.getMessage());
			
			
		}
		request.getServletContext().getRequestDispatcher("/prodotti/visualizzaprodotto.jsp").forward(request, response);
	//RequestDispatcher dispacher=this.getServletContext().getRequestDispatcher("/prodotti/visualizzaprodotto.jsp");
	//dispacher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
