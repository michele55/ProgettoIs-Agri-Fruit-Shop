<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="gestioneAccount.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione</title>
<link href="style/stylelogreg.css" rel="stylesheet" type="text/css">
<script src="JS/controllo-registrazione.js"></script>

<%@ include file="Header.jsp"%>
<% String report=(String)request.getSession().getAttribute("passdiversa"); 
String errore=(String)request.getSession().getAttribute("error"); 
String errore2=(String)request.getSession().getAttribute("FormatoEmailErrore");
String errore3=(String)request.getSession().getAttribute("errorePwd");
String errore4=(String)request.getSession().getAttribute("erroreFormatoNome");
String errore5=(String)request.getSession().getAttribute("erroreFormatoCognome");
String errore6=(String)request.getSession().getAttribute("erroreCF");
String errore7=(String)request.getSession().getAttribute("erroreFormatoCitta");
String errore8=(String)request.getSession().getAttribute("erroreFormatoProvincia");
String errore9=(String)request.getSession().getAttribute("erroreFormatoVia");
String errore10=(String)request.getSession().getAttribute("erroreFormatoCivico");
String errore11=(String)request.getSession().getAttribute("erroreFormatoCap");
String registrato=(String)request.getSession().getAttribute("registrato");
if(report!=null){
if(report.equals("falso")){

%>


<p>errore

<%} }%>
</head>
<body>


	<div class="registrazione">

		<form id="formreg" action="\AgriShop\registrazione" name="formreg" method="post" >
			<table style="with: 50%">

				<tr>

						<%if(registrato!=null && registrato!=""){%>
					<p>Registrato </p>
					<% registrato="";%>
					<%request.getSession().removeAttribute("registrato"); %>
				<%}%>
					<td>Email</td>
					<td><input id="email" type="text" name="email" placeholder="utente@estensione.it" onblur="validamail(this)"  required/></td><td><p id=erroremail>
					<%if(errore!=null&&errore.equals("falso")){ %>

					<p>	Utente Già Registrato</p>


				<% } %>
				<%if(errore2!=null && errore2!=""){%>
					<p>Formato Email utente errato </p>
				<%}%>
									
					</td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input id="password"type="password" name="password" placeholder="8 caratteri " onblur="validapass(this)"  required/></td><td><p id=errorepassword></td>
				</tr>
				<tr>
					<td>Conferma Password</td>
					<td><input id="conferma" type="password" name="conferma" onblur="validaconferma(this)" required /></td><td><p id=erroreconferma></td>
				</tr>
				<tr>
					<td>Nome</td>
					<td><input id="nome" type="text" name="nome" onblur="uppercase()"onblur="validaragione(this)" required /></td><td><p id=erroreragione>	<%if(errore4!=null && errore4!=""){%>
					<p>Formato Nome utente errato </p>
					<% errore4="";%>
					<%request.getSession().removeAttribute("erroreFormatoNome"); %>
				<%}%>	</td>
					
				</tr>
				<tr>
					<td>Cognome</td>
					<td><input id="cognome" type="text" name="cognome" onblur="uppercase()"onblur="validaragione(this)" required /></td><td><p id=erroreragione><%if(errore5!=null && errore5!=""){%>
					<p>Formato Cognome errato </p>
					<% errore5="";%>
					<%request.getSession().removeAttribute("erroreFormatoCognome"); %>
				<%}%></td>

				</tr>
				<tr>
					<td>Codice Fiscale</td>
					<td><input id="codice_fiscale" type="text" name="codice_fiscale" onblur="validapiva(this)" required /></td><td><p id=errorepiva>
					<%if(errore6!=null && errore6!=""){%>
					<p>Formato CF errato </p>
					<% errore6="";%>
					<%request.getSession().removeAttribute("erroreCF"); %>
				<%}%>
					
					</td>
				</tr>
				<tr>
					<td>Via</td>
					<td><input id="indirizzo" type="text" name="indirizzo" onblur="validaindirizzo(this)"  required/></td><td><p id=erroreindirizzo>
					
					<%if(errore7!=null && errore7!=""){%>
					<p>Formato Via errato </p>
					<% errore8="";%>
					<%request.getSession().removeAttribute("erroreFormatoVia"); %>
				<%}%>
					
					
					
					</td>
				</tr>
				<tr>
					<td>Città</td>
					<td><input id="citta" type="text" name="citta"  required/></td><td><p id=errorecittà>
					<%if(errore7!=null && errore7!=""){%>
					<p>Formato Città errato </p>
					<% errore7="";%>
					<%request.getSession().removeAttribute("erroreFormatoCitta"); %>
				<%}%>
					
					
					</td>
				</tr>
				
				<tr>
					<td>Provincia</td>
					<td><input id="provincia" type="text" name="provincia"   required/></td><td><p id=erroreprovincia>
					
					<%if(errore8!=null && errore8!=""){%>
					<p>Formato Provincia errato </p>
					<% errore8="";%>
					<%request.getSession().removeAttribute("erroreFormatoProvincia"); %>
				<%}%>
					
					
					
					</td>
				</tr>
				
					<tr>
						<td>Civico</td>
					<td><input id="civco" type="text" name="civico" placeholder="Civico" onblur="validacivico(this)"  required/></td><td><p id=errorecivico>
					
						<%if(errore10!=null && errore10!=""){%>
					<p>Formato Civico errato </p>
					<% errore10="";%>
					<%request.getSession().removeAttribute("erroreFormatoCivico"); %>
				<%}%>
					
					
					
					
					
					
					</td>
					</tr>
				
				<tr>
					<td>Cap</td>
				<td><input id="cap" type="text" name="cap" placeholder="Cap" onblur="validacap(this)" required  /></td><td><p id=errorecap>
				
				
						<%if(errore11!=null && errore11!=""){%>
					<p>Formato Cap errato </p>
					<% errore11="";%>
					<%request.getSession().removeAttribute("erroreFormatoCap"); %>
				<%}%>
				
				
				</td>
				</tr>
				
				
			</table>
			<input id="iscriviti" class="iscriviti" type="submit" value="Iscriviti"   />

		</form>
	</div>
	<%if(errore3!=null && errore3!=""){%>
					<p>Formato Password utente errato </p>
				<%}%>
			
</body>

</body>
</html>