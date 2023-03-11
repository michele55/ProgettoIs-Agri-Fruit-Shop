package gestioneAccount;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import utils.utility;

/**
 * Servlet implementation class passwordpersa
 */
@WebServlet("/passwordpersa")
public class passwordpersa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public passwordpersa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataSource ds= (DataSource) getServletContext().getAttribute("DataSource");
		PwdModelDS model= new PwdModelDS(ds);
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String errore="errorelogin";
		Utente neg = new Utente();
		HttpSession ssn=request.getSession();
		ssn.setMaxInactiveInterval(-1);
		ssn.setAttribute("nome", null);
		
		
		
		
		
		
		
		
		try {
			neg = (model.doRetrieveByKey(email));
			if(neg.isEmpty()) {
				request.setAttribute("erroreaccount",errore);	
			}
			if(neg.getEmail().equals(email)) {
				ssn.setAttribute("neg", neg);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		if(neg!=null) {
			neg.setPwd(password);
			
		}
		
		try {
			
			
		
				
			
			 model.doUpdate(neg);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
	
	
		
		
	
		
		if(request.getSession() !=null) {
			request.getSession().invalidate();
		}
		request.getServletContext().getRequestDispatcher("/homepage.jsp").forward(request, response); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
