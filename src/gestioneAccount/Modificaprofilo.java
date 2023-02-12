package gestioneAccount;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.sql.DataSource;

import utils.utility;

/**
 * Servlet implementation class Modificaprofilo
 */
@WebServlet("/Modificaprofilo")
public class Modificaprofilo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataSource ds= (DataSource) getServletContext().getAttribute("DataSource");
	//	LoginModelDS model= new LoginModelDS(ds);
		Utente neg=(Utente) request.getSession().getAttribute("neg");
		
		String user= request.getParameter("user");
		String password=request.getParameter("password");
		String conferma=request.getParameter("conferma");
		String indirizzo= request.getParameter("indirizzo");
		String codice_fiscale=request.getParameter("codice_fiscale");
		String cap=request.getParameter("cap");
		String civico=request.getParameter("ncivico");
		
		if(cap!=null) {			
			if(!cap.equals("")) {
				neg.setCap(cap);
			}}
		
			if(civico!=null) {			
				if(!civico.equals("")) {
					neg.setCivico(civico);
				}}
		
		if(user!=null) {			
		if(!user.equals("")) {
			neg.setNome(user);
		}
		}
		if(indirizzo!=null) {
		if(!indirizzo.equals("")){
			neg.setIndirizzo(indirizzo);;
		}}
		
		if(codice_fiscale!=null) {
		if(!codice_fiscale.equals("")) {
			neg.setCodice_fiscale(codice_fiscale);
		}}
		
		if(!password.equals("")&&password.equals(conferma)) {
			neg.setPwd(password);
		}
		
	
		//try {
		//	 model.doUpdate(neg);
			
		/*} catch (SQLException e) {
			utility.print(e);
			
			request.setAttribute("error", e.getMessage());
		}
		*/
		if(request.getSession() !=null) {
			request.getSession().invalidate();
		}
		
	
		
		RequestDispatcher dispacher=this.getServletContext().getRequestDispatcher("/Login.jsp");
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
