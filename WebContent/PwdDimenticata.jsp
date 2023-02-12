<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="gestioneAccount.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="style/stylelogreg.css" rel="stylesheet" type="text/css">
<script src="JS/controllo-registrazione.js"></script>


<%@ include file="Header.jsp"%>
<%

Utente neg=(Utente)request.getSession().getAttribute("neg");

%>
</head>
<body>

<div class="recuperopwd">

<form id="formrecuperopwd" action="passwordpersa" name="formrecuperopwd" method="post" >
			<table style="with: 50%">

				<tr>

					<td>Email</td>
					<td><input id="email" type="text" name="email" placeholder="utente@estensione.it" onblur="validamail(this)"  required/></td><td><p id=erroremail>
				
					</td>
					
					<td>Password</td>
					<td><input id="password" type="password" name="password" placeholder="Minimo 8 caratteri" onblur="validaconferma(this)"  required/></td><td><p id=erroremail>
				
					</td>
				</tr>
				
				
				</table>
				<input id="iscriviti" class="iscriviti" type="submit" value="Reimposta Password"   />
				
				</form>









</div>






</body>
</html>