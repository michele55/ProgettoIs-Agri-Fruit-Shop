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

import org.junit.platform.commons.function.Try;

import Database.DBConnectionPool;
import utils.utility;

/**
 * Servlet implementation class Modificaprofilo
 */
@WebServlet("/Modificaprofilo")
public class Modificaprofilo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getAttribute("bool")!=null) {
			Connection ds=null;
			try {
				ds=DBConnectionPool.getConnection();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
			LoginModelDS model= new LoginModelDS( ds);
			String tt= request.getParameter("neg");
			Utente neg=new Utente();
			neg.setEmail(tt);
			try {
				neg = model.doRetrieveByKey(neg.getEmail());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		//	String user= request.getParameter("user");
			String password=request.getParameter("password");
			String conferma=request.getParameter("conferma");
			String indirizzo= request.getParameter("indirizzo");
			String citta= request.getParameter("citta");
			String provincia= request.getParameter("provincia");
			String codice_fiscale=request.getParameter("codice_fiscale");
			String cap=request.getParameter("cap");
			String civico=request.getParameter("ncivico");
			int count=0;
			int countcap=0;
			int countcivico=0;
			int countindirizzo=0;
			int countcitta=0;
			int countprovincia=0;
			if(cap!=null) {	
				for(int i=0;i<cap.length();i++) {
					
					if(Character.isLetter(cap.charAt(i))) {
						countcap++;
					}
			}
				if(countcap==0) {
					neg.setCap(cap);
				}
				else {
					request.getSession().setAttribute("errCap", "Errore");	
				}
				
			}
				
				
				
				
				
			
				
				
			
			
				if(civico!=null) {			
					
					for(int i=0;i<civico.length();i++) {
						
						if(Character.isLetter(civico.charAt(i))) {
							countcivico++;
						}
				}
					if(countcap==0) {
						neg.setCivico(civico);
					}
					else {
						request.getSession().setAttribute("errCivico", "Errore");	
					}	
						
					}
				
				if(citta!=null) {
	for(int i=0;i<citta.length();i++) {
						
						if(Character.isDigit(citta.charAt(i))) {
							countcitta++;
						}
				}
					if(countcitta==0) {
					neg.setCitta(citta);
					}
					else {
						request.getSession().setAttribute("errCitta", "Errore");	
					}	
						
					
				}
				
				
				
				
				if(provincia!=null) {
					for(int i=0;i<provincia.length();i++) {
										
										if(Character.isDigit(provincia.charAt(i))) {
											countprovincia++;
										}
								}
									if(countprovincia==0) {
									neg.setProvincia(provincia);
									}
									else {
										request.getSession().setAttribute("errProvincia", "Errore");	
									}	
										
									
								}
			
		/*	if(user!=null) {			
			if(!user.equals("")) {
				neg.setNome(user);
				count++;
			}
			}*/
			if(indirizzo!=null) {
				for(int i=0;i<indirizzo.length();i++) {
					
					if(Character.isDigit(indirizzo.charAt(i))) {
						countindirizzo++;
					}
			}
				if(countindirizzo==0) {
					neg.setIndirizzo(indirizzo);
				}
				else {
					request.getSession().setAttribute("errIndirizzo", "Errore");	
				}
			
			}
			
			if(codice_fiscale!=null&& codice_fiscale.length()==16) {
			if(!codice_fiscale.equals("")) {
				neg.setCodice_fiscale(codice_fiscale);
				count++;
			}}
			
			if(!password.equals("")&&password.equals(conferma)&& password.length()==8 && password!=null) {
				neg.setPwd(password);
				count++;
			}
			
			if (count==4) {
				request.setAttribute("Cambio dati", "Cambio dati avvenuto correttamente");
			}
			if(count <5) {
				System.out.println(count);
				System.out.println(tt);
			}
		
			
			
			if( (citta!=null && citta!="") && (provincia!=null && provincia!="") && (codice_fiscale!=null && codice_fiscale!="") && (civico!=null && civico !="") 
					&& (cap!=null && cap!="") && (password!=null && password!="") && (indirizzo!=null && indirizzo!="")) {
				
			
			
			try {
				 model.doUpdate(neg);
				
			} catch (SQLException e) {
				utility.print(e);
				
				request.setAttribute("error", e.getMessage());
			}
			
			
			
			}	
			if(request.getSession() !=null) {
				request.getSession().invalidate();
			}
			
			request.getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response); 
			
		}
		else if(request.getAttribute("bool")==null) {
			
			HttpSession ssn=request.getSession();
			
			Connection da2=null;
			try {
				da2=DBConnectionPool.getConnection();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			//DataSource ds= (DataSource) getServletContext().getAttribute("DataSource");
			
		
		
		
		LoginModelDS model= new LoginModelDS(da2);
			Utente neg= (Utente) ssn.getAttribute("neg");
			String user= request.getParameter("user");
			String password=request.getParameter("password");
			String conferma=request.getParameter("conferma");
			String indirizzo= request.getParameter("indirizzo");
			String codice_fiscale=request.getParameter("codice_fiscale");
			String cap=request.getParameter("cap");
			String civico=request.getParameter("ncivico");
			int count=0;
			int countcap=0;
			int countcivico=0;
			int countindirizzo=0;
			int countcitta=0;
			int countprovincia=0;
			if(cap!=null) {			
for(int i=0;i<cap.length();i++) {
					
					if(Character.isLetter(cap.charAt(i))) {
						countcap++;
					}
			}
				if(countcap==0) {
					neg.setCap(cap);
				}
				else {
					request.getSession().setAttribute("errCap", "Errore");	
				}
				}
			
				if(civico!=null) {			
					if(!civico.equals("")) {
						neg.setCivico(civico);
						count++;
					}}
			
			if(user!=null) {			
			if(!user.equals("")) {
				neg.setNome(user);
				count++;
			}
			}
			if(indirizzo!=null) {
			if(!indirizzo.equals("")){
				neg.setIndirizzo(indirizzo);;
				count++;
			}}
			
			if(codice_fiscale!=null) {
			if(!codice_fiscale.equals("")) {
				neg.setCodice_fiscale(codice_fiscale);
				count++;
			}}
			
			if(!password.equals("")&&password.equals(conferma)) {
				neg.setPwd(password);
				count++;
			}
			
			if (count==4) {
				request.setAttribute("Cambio dati", "Cambio dati avvenuto correttamente");
			}
			if(count <5) {
				System.out.println(count);
				
			}
		
			try {
				 model.doUpdate(neg);
				
			} catch (SQLException e) {
				utility.print(e);
				
				request.setAttribute("error", e.getMessage());
			}
			
			if(request.getSession() !=null) {
				request.getSession().invalidate();
			}
			
			request.getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response); 
		}
		
		
	
	
		
	//	RequestDispatcher dispacher=this.getServletContext().getRequestDispatcher("/Login.jsp");
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
