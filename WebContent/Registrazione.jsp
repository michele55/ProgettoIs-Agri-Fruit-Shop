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
<% String report=(String)request.getAttribute("passdiversa"); 
String errore=(String)request.getAttribute("error"); 
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

					<td>Email</td>
					<td><input id="email" type="text" name="email" placeholder="utente@estensione.it" onblur="validamail(this)"  required/></td><td><p id=erroremail>
					<%if(errore!=null&&errore.equals("falso")){ %>

					<p>	Utente Già Registrato</p>


				<% } %>
									
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
					<td><input id="nome" type="text" name="nome" onblur="uppercase()"onblur="validaragione(this)" required /></td><td><p id=erroreragione></td>

				</tr>
				<tr>
					<td>Cognome</td>
					<td><input id="cognome" type="text" name="cognome" onblur="uppercase()"onblur="validaragione(this)" required /></td><td><p id=erroreragione></td>

				</tr>
				<tr>
					<td>Codice Fiscale</td>
					<td><input id="codice_fiscale" type="text" name="codice_fiscale" onblur="validapiva(this)" required /></td><td><p id=errorepiva></td>
				</tr>
				<tr>
					<td>Indirizzo</td>
					<td><input id="indirizzo" type="text" name="indirizzo" onblur="validaindirizzo(this)"  required/></td><td><p id=erroreindirizzo></td>
				</tr>
				
					<tr>
						<td>Civico</td>
					<td><input id="civco" type="text" name="civico" placeholder="Civico" onblur="validacivico(this)"  required/></td><td><p id=errorecivico></td>
					</tr>
				
				<tr>
					<td>Cap</td>
				<td><input id="cap" type="text" name="cap" placeholder="Cap" onblur="validacap(this)" required  /></td><td><p id=errorecap></td>
				</tr>
				
				
			</table>
			<input id="iscriviti" class="iscriviti" type="submit" value="Iscriviti"   />

		</form>
	</div>
</body>

</body>
</html>