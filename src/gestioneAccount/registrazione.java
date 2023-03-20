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
		String citta=request.getParameter("citta");
		String provincia=request.getParameter("provincia");
		String cap=request.getParameter("cap");
		String civico=request.getParameter("civico");
		HttpSession ssn=request.getSession();
		Utente neg= new Utente();
		boolean check=false;
		
		Utente nuovo=new Utente();
		
		
		if(email.contains("@")&& email.contains(".")) {
			
				nuovo.setEmail(email);
			
		}
		else if(email!=null && email!="") {
			request.getSession().setAttribute("FormatoEmailErrore", "FormatoEmailErrore");
		}
		
		
		
		
		if(!(indirizzo.contains("1")||indirizzo.contains("2")||indirizzo.contains("3")||indirizzo.contains("4")||indirizzo.contains("5")
				|| indirizzo.contains("6")|| indirizzo.contains("7")||indirizzo.contains("8")||indirizzo.contains("9")||indirizzo.contains("0") ||indirizzo.contains("@")|| indirizzo.contains("."))) {
			
			nuovo.setIndirizzo(indirizzo);
		}
		else if(indirizzo!="" && indirizzo!=null){
			request.getSession().setAttribute("erroreFormatoVia", "erroreFormatoVia");
		}
		
		
		
		
		
		
		
		
		
		
	
		
		if(!(citta.contains("1")||citta.contains("2")|| citta.contains("3")||citta.contains("4")|| citta.contains("5")
				|| citta.contains("6")|| citta.contains("7")||citta.contains("8")||citta.contains("9")||citta.contains("0") || citta.contains("@")|| citta.contains("."))) {
			nuovo.setCitta(citta);
		}
		else if(citta!="" && citta!=null){
			request.getSession().setAttribute("erroreFormatoCitta", "erroreFormatoCitta");
		}
		
		
		
		
		
		if(!(provincia.contains("1")||provincia.contains("2")|| provincia.contains("3")||provincia.contains("4")|| provincia.contains("5")
				|| provincia.contains("6")|| provincia.contains("7")||provincia.contains("8")||provincia.contains("9")||provincia.contains("0") || provincia.contains("@")|| provincia.contains("."))) {
			nuovo.setProvincia(provincia);
		}
		else if(provincia!="" && provincia!=null){
			request.getSession().setAttribute("erroreFormatoProvincia", "erroreFormatoProvincia");
		}
		
		
	
		
		
		
		
		if(!(codice_fiscale.length()<16 || codice_fiscale.contains("@") || codice_fiscale.contains(".")|| codice_fiscale.contains("!"))) {
			nuovo.setCodice_fiscale(codice_fiscale);
		}
		else {
			request.getSession().setAttribute("erroreCF", "ErroreCF");
		}
		
		if(password.length()>=8) {
			nuovo.setPwd(password);
		}else {
			request.getSession().setAttribute("errorePwd", "Password Corta");
		}
	
		if(!(nome.contains("1")||nome.contains("2")|| nome.contains("3")||nome.contains("4")|| nome.contains("5")
				|| nome.contains("6")|| nome.contains("7")|| nome.contains("8")||nome.contains("9")||nome.contains("0") || nome.contains("@")|| nome.contains("."))) {
			nuovo.setNome(nome);
		}
		else if(nome!="" && nome!=null){
			request.getSession().setAttribute("erroreFormatoNome", "ErroreFormatoNome");
		}
		
		

		if(!(cognome.contains("1")||cognome.contains("2")|| cognome.contains("3")||cognome.contains("4")|| cognome.contains("5")
				|| cognome.contains("6")|| cognome.contains("7")|| cognome.contains("8")||cognome.contains("9")||cognome.contains("0"))) {
			nuovo.setCognome(cognome);
		}
		else if(nome!="" && nome!=null){
			request.getSession().setAttribute("erroreFormatoCognome", "ErroreFormatoCognome");
		}
		
		
		if((civico.contains("1")||civico.contains("2")|| civico.contains("3")||civico.contains("4")|| civico.contains("5")
				|| civico.contains("6")|| civico.contains("7")||civico.contains("8")||civico.contains("9")||civico.contains("0"))) {
			nuovo.setCivico(civico);
		}
		else if(civico!="" && civico!=null){
			request.getSession().setAttribute("erroreFormatoCivico", "ErroreFormatoCivico");
		}
		
	
		if((cap.contains("1")||cap.contains("2")|| cap.contains("3")||cap.contains("4")|| cap.contains("5")
				|| cap.contains("6")||cap.contains("7")||cap.contains("8")||cap.contains("9")||cap.contains("0"))&& (cap.length()==5)) {
			nuovo.setCap(cap);
		}
		else if(cap!="" && cap!=null){
			request.getSession().setAttribute("erroreFormatoCap", "ErroreFormatoCap");
		}
		
	
		
		//DataSource ds= (DataSource) getServletContext().getAttribute("DataSource");
		
		LoginModelDS model= new LoginModelDS(ds);
		
		if((nuovo.getEmail()!=null && nuovo.getEmail()!="") && (nuovo.getPwd()!=null && nuovo.getPwd()!="") && (nuovo.getNome()!=null && nuovo.getNome()!="") && (nuovo.getCognome()!=null && nuovo.getCognome()!="") && (nuovo.getCodice_fiscale()!=null && nuovo.getCodice_fiscale()!="")
				&& (nuovo.getProvincia()!=null && nuovo.getProvincia()!="") && (nuovo.getIndirizzo()!=null && nuovo.getIndirizzo()!="") && (nuovo.getCivico()!=null && nuovo.getCivico()!="")) {
			
			
			
			
		
		
			try {
				neg=(model.doRetrieveByKey(email));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			if(neg.getEmail().equals(email)) {
				request.getSession().setAttribute("error", "falso");	
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
						request.getSession().setAttribute("error", "falso");	
						request.setAttribute("presente", true);
						check=true;
					}
			
			if(check==false) {
			if(password.equals(conferma)) {
				try {
					
					model.doSave(nuovo);
					request.getSession().setAttribute("registrato","Registrato");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				request.getSession().setAttribute("error", "vero");}
			else
			{
				
				request.getSession().setAttribute("passdiversa", "falso");
			
			}
					}
		
		}
		else {
	
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
