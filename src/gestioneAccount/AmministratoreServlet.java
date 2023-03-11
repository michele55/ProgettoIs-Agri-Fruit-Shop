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

import Database.DBConnectionPool;

/**
 * Servlet implementation class AmministratoreServlet
 */
@WebServlet("/AmministratoreServlet")
public class AmministratoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String testMessage="";
		String username= request.getParameter("Email");
		String password=request.getParameter("password");
		
		password=utils.SHA1.encryptThisString(password);
		String errore="errorelogin";
		
	//	DataSource ds= (DataSource) getServletContext().getAttribute("DataSource");
		
		Connection db = null;
		try {
			db = DBConnectionPool.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	AmmModelDS model= new AmmModelDS(db);
		Amministratore amministratore=new Amministratore();
		
		
		HttpSession ssn=request.getSession();
		if (ssn==null) {
			System.out.println("Bah é Nullo");
		}
		
		else if(ssn!=null) {
			//System.out.println(ssn.getId());
		}
ssn.setMaxInactiveInterval(60);
	ssn.setAttribute("nome", null);
	
		testMessage="Login";
		request.setAttribute("testMessage",testMessage);
		
	/*	if(username.equals("admin")&&password.equals("admin")){
		//	testMessage="Login";
			//request.setAttribute("testMessage",testMessage);
			ssn.setAttribute("nome","admin");
			ssn.setAttribute("neg", "admin");
			
			
			response.sendRedirect("homepage.jsp");
			
		}*/
					
		try {
			amministratore=(model.doRetrieveByKey(username));
	
			if( amministratore==null) {
				System.out.println("errorequi1");
				request.setAttribute("erroreaccount",errore);	
				request.setAttribute("erroreNullo","Parametri nulli");
			}
			
			if(amministratore!=null) {
				if(amministratore.getPwd()==null||amministratore.getEmail()==null) {
					System.out.println("Email e Password Nulli");
					request.setAttribute("erroreaccount",errore);	
					request.setAttribute("erroreaccount","Parametri nulli");	
				
				}
				
				
if((amministratore.getPwd().equals(password))&&(amministratore.getEmail().equals(username))&& (amministratore.getRuolo().equals("Amministratore"))) {
					
					System.out.println("Login Amministratore effettuato con successo");
					ssn.setAttribute("nome",amministratore.getNome());
						ssn.setAttribute("amm", "Amministratore");
						request.setAttribute("Successo", "Login Effettuato con Successo");
						//ssn.setAttribute("neg", neg);
					//	ssn.setAttribute("presente",true);
					//	response.sendRedirect("homepage.jsp");
				}
else {
	
	System.out.println("Errore di password o email");
	System.out.println(amministratore.getPwd());
	System.out.println(amministratore.getEmail());
	System.out.println(amministratore.getRuolo());
		request.setAttribute("passerrore",errore);
		request.setAttribute("errore","Errore di password o email");
}
			}
			
				
				
		} catch (SQLException e) {
			System.out.println("Errore generico");
					response.sendRedirect("homepage.jsp");		
		}
		
		request.getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response); 
		
	//	RequestDispatcher dispacher=this.getServletContext().getRequestDispatcher.forward("/Login.jsp");
		//dispacher.include(request, response);
	}

}
