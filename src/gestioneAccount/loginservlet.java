
package gestioneAccount;

import java.io.IOException;
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

import java.sql.Connection;
import utils.SHA1;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet(description = "/login", urlPatterns = { "/login" })



public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	
	}	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
		LoginModelDS model= new LoginModelDS(db);
		Utente neg=new Utente();
		
		
		HttpSession ssn=request.getSession();
		if (ssn==null) {
			System.out.println("Bah � Nullo");
		}
		
		else if(ssn!=null) {
			//System.out.println(ssn.getId());
		}
ssn.setMaxInactiveInterval(60);
	ssn.setAttribute("nome", null);
	
		testMessage="Login";
		request.setAttribute("testMessage",testMessage);
		
		if(username.equals("admin")&&password.equals("admin")){
		//	testMessage="Login";
			//request.setAttribute("testMessage",testMessage);
			ssn.setAttribute("nome","admin");
			ssn.setAttribute("neg", "admin");
			
			
			response.sendRedirect("homepage.jsp");
			
		}
					
		try {
			neg=(model.doRetrieveByKey(username));
	
			if((neg.equals(null))|| (neg.isEmpty())) {
				System.out.println("errorequi1");
				request.setAttribute("erroreaccount",errore);	
				request.setAttribute("erroreParametri","Parametri Sbagliati");
			}
				
			
			if((neg.getPwd()==null||neg.getEmail()==null)||(neg.getPwd()==null && neg.getEmail()==null)) {
				System.out.println("Email o Password Nulli, o entrambi nulli");
				request.setAttribute("erroreaccount",errore);	
				request.setAttribute("Campi nulli", "Errori campi email/pwd uno dei due � nullo o entrambi nulli");
			
			} else if(neg!=null) {
	if((neg.getPwd().equals(password))&&(neg.getEmail().equals(username))&& (neg.getRuolo().equals("Utente"))) {
					
					System.out.println("Controllo avvenuto correttamente, login effettuato");
					
						ssn.setAttribute("nome",neg.getNome());
						ssn.setAttribute("emailutente", neg.getEmail());
						ssn.setAttribute("neg", neg);
						ssn.setAttribute("presente",true);
						request.setAttribute("login", "Login avvenuto correttamente");
						response.sendRedirect("homepage.jsp");
				} else if(neg.getPwd()!=password){
					
					System.out.println("Errore di password ");
						request.setAttribute("passerrore",errore);		
						request.setAttribute("passerrore","Errore Password");	
				}
					
				}
				
				
				
				
			
				
		} catch (SQLException e) {
			System.out.println("Errore generico");
			request.getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response); 
					//response.sendRedirect("homepage.jsp");		
		}
	
		
		RequestDispatcher dispacher=this.getServletContext().getRequestDispatcher("/Login.jsp");
	
			
			dispacher.include(request, response);
	
		
	}

}
