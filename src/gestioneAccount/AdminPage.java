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
		
		String prezzo=request.getParameter("prezzo");
		
		String nome=request.getParameter("nome");
		String SSN=request.getParameter("Ssn");
		System.out.println("SSN"+SSN);
		String disponibilita= request.getParameter("disponibilita");
		String descrizione=request.getParameter("descrizione");
		String categ=request.getParameter("categoria");
		String idfoto=request.getParameter("idfoto");
		String mod=(String)request.getSession().getAttribute("mod");
		int count=0;
		int countprezzo=0;
		int countSSN=0;
		int countidfoto=0;
		int countdescrizione=0;
		int countcateg=0;
		String action=request.getParameter("action");
		

		
				if(prezzo!=null) {

					for(int i=0;i<prezzo.length();i++) {
					
						if(Character.isLetter(prezzo.charAt(i))) {
							countprezzo++;
						}
					
				}
					if(countprezzo==0) {
						prod.setPrezzo(Float.parseFloat(prezzo));
					}
					else if(mod!=null && mod!=""){
						request.getSession().setAttribute("errPrezzoMod", "Errore");
						mod="";
						
					}
					else {
						request.getSession().setAttribute("errPrezzo", "Errore");
					}
				}
				
			
		
			if(nome!=null && !(nome.contains("0")|| nome.contains("1")||(nome.contains("2"))||(nome.contains("3"))
					
					||(nome.contains("4"))||(nome.contains("5"))||(nome.contains("6"))||(nome.contains("7"))||(nome.contains("8"))||(nome.contains("9"))	)) {			
				if(!nome.equals("")) {
					prod.setNome(nome);
				}}
			else if(mod!=null && mod!=""){
				request.getSession().setAttribute("errNomeMod", "Errore");
				mod="";
			}else {
				request.getSession().setAttribute("errNome", "Errore");
			}
			
			
			
		if(SSN!=null && (!SSN.equals("")) ) {
			
			for(int i=0;i<SSN.length();i++) {
				
				if(Character.isLetter(SSN.charAt(i))) {
					countSSN++;
				}
			
		}
			if(countSSN==0) {
					prod.setSsn(SSN);
					
			}
			else if(mod!=null && mod!="") {
				prod.setSsn("0");
				request.getSession().setAttribute("errSSNMod", "ErroreSSNMod");
				mod="";
			}
			else {
				request.getSession().setAttribute("errSSN", "ErroreSSN");
			}
		
		}
		
		
		
		
		if(disponibilita!=null) {
			
			for(int i=0;i<disponibilita.length();i++) {
			
				if(Character.isLetter(disponibilita.charAt(i))) {
					count++;
				}
			}
			if(count==0) {
				prod.setQuantita(Integer.parseInt(disponibilita));;
			}
			else if(mod!=null && mod!=""){
				request.getSession().setAttribute("errDispMod", "ErroreDispMod");
				mod="";
				
			}else {
				request.getSession().setAttribute("errDisp", "ErroreDisp");
			}
			
		}
		
		if(descrizione!=null) {

			for(int i=0;i<descrizione.length();i++) {
			
				if(Character.isDigit(descrizione.charAt(i))) {
					countdescrizione++;
				}
			}
			if(countdescrizione==0) {
				prod.setDescrizione(descrizione);
			}
			else if(mod!=null && mod!="") {
				request.getSession().setAttribute("errDescrMod", "ErroreDescrMod");
				mod="";
			}
			else {
				request.getSession().setAttribute("errDescr", "ErroreDescr");
			}
		}
		
		
		
		
		
		if(categ!=null) {
			for(int i=0;i<categ.length();i++) {
				
				if(Character.isDigit(categ.charAt(i))) {
					countcateg++;
				}
			}
			if(countcateg==0) {
				prod.setCtegoria(categ);
			}
			else if(mod!=null && mod!=""){
				request.getSession().setAttribute("errCategMod", "ErroreCategMod");
				mod="";
			}
			else {
				request.getSession().setAttribute("errCateg", "ErroreCateg");
			}
		}
				
				
			
		
		
		
		
		
		
		
		
		if(idfoto!=null) {
			
			for(int i=0;i<idfoto.length();i++) {
				
				if(Character.isLetter(idfoto.charAt(i))) {
					countidfoto++;
				}
			}
			if(countidfoto==0) {
				prod.setIdfoto(idfoto);;
			}
			else if(mod!=null && mod!=""){
				request.getSession().setAttribute("errIdFotoMod", "ErroreIdFoto");
				mod="";
			}
			else {
				request.getSession().setAttribute("errIdFoto", "ErroreIdFoto");
			}
			
			
			
			
			
			
			
			
				
			}
	
		if(action!=null&&!action.equals("") &&(prod.getNome()!=null && prod.getNome()!="") && (prod.getQuantita()!=0) && (prod.getPrezzo()!=0) &&(prod.getSsn()!=null && prod.getSsn()!="" && prod.getSsn()!="0") &&(prod.getIdfoto()!=null && prod.getIdfoto()!="") 
				&& (prod.getDescrizione()!=null && prod.getDescrizione()!="")&& (prod.getCategoria()!=null && prod.getCategoria()!="")) {
			
			try {
				model.doUpdate(prod);
				
			} catch (SQLException e) {
				utility.print(e);
				
				request.setAttribute("error", e.getMessage());
			}
			
			
			
		}
		
		if((prod.getNome()!=null && prod.getNome()!="") && (prod.getQuantita()!=0) && (prod.getPrezzo()!=0) &&(prod.getSsn()!=null && prod.getSsn()!="" && prod.getSsn()!="0") &&(prod.getIdfoto()!=null && prod.getIdfoto()!="") 
				&& (prod.getDescrizione()!=null && prod.getDescrizione()!="")&& (prod.getCategoria()!=null && prod.getCategoria()!="")) {
			
		
		try {
			 model.doSave(prod);
			request.getSession().setAttribute("prodIn", "prodIn");
			
		} catch (SQLException e) {
			utility.print(e);
			
			request.setAttribute("error", e.getMessage());
		}
		
		}
		response.sendRedirect(request.getContextPath()+"/admin/profilo.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
