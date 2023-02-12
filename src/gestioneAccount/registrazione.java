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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import Database.DBConnectionPool;
import utils.utility;

/**
 * Servlet implementation class registrazione
 */
@WebServlet("/registrazione")
public class registrazione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
Connection ds = null;
		
		try {
			ds = DBConnectionPool.getConnection();
			
			
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		String email= request.getParameter("email");
		String password=request.getParameter("password");
		String conferma=request.getParameter("conferma");
		String nome=request.getParameter("nome");
		String cognome=request.getParameter("cognome");
		String codice_fiscale=request.getParameter("codice_fiscale");
		String indirizzo=request.getParameter("indirizzo");
		String cap=request.getParameter("cap");
		String civico=request.getParameter("civico");
		HttpSession ssn=request.getSession();
		Utente neg= new Utente();
		boolean check=false;
		
		Utente nuovo=new Utente();
		nuovo.setEmail(email);
		nuovo.setIndirizzo(indirizzo);
		nuovo.setCodice_fiscale(codice_fiscale);
		nuovo.setPwd(password);
		nuovo.setNome(nome);
		nuovo.setCognome(cognome);
		nuovo.setCivico(civico);
		nuovo.setCap(cap);
		
		//DataSource ds= (DataSource) getServletContext().getAttribute("DataSource");
		
		LoginModelDS model= new LoginModelDS(ds);
		
		
			try {
				neg=(model.doRetrieveByKey(email));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if(neg.getEmail().equals(email)) {
				request.setAttribute("error", "falso");	
				request.setAttribute("presente", true);
				check=true;
			}	
		
				try {
					neg=(model.doRetrieveByNome(nome));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					if(neg.getNome().equals(nome)) {
						request.setAttribute("error", "falso");	
						request.setAttribute("presente", true);
						check=true;
					}
			
			if(check==false) {
			if(password.equals(conferma)) {
				try {
					
					model.doSave(nuovo);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("error", "vero");}
			else
			{
				
				request.setAttribute("passdiversa", "falso");
			
			}
					}
		
		 
		

		
		
	
			request.getServletContext().getRequestDispatcher("/Registrazione.jsp").forward(request, response); 
					
	//	RequestDispatcher dispacher=this.getServletContext().getRequestDispatcher("/Registrazione.jsp");
	//	dispacher.include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
