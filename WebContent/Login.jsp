<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="gestioneAccount.* " import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="style/stylelogreg.css" rel="stylesheet" type="text/css">

<%
String erroreaccount=(String)request.getAttribute("erroreaccount");
String errorelogin=(String)request.getAttribute("passerrore");
%>

</head>
<body>

 <%@ include file="Header.jsp"%><br>

	<div class="login">
		<form action="login" method="POST">
			<table style="with: 50%">

				<tr>
					
					<td><input type="text" name="Email" placeholder="Email" required/></td>
				</tr>
				<tr>
					
					<td><input type="password" name="password" placeholder="Password" required/></td>
				</tr>
			</table>
			<input id="bottone" type="submit" value="Accedi" />
		</form>
	
			<a href="Registrazione.jsp" id="testocarrello">
			<input id="bottone" type="submit" value="Registrati"></a>
			
			
			<a href="admin/PannelloControlloAmm.jsp" id="testocarrello">
			<input id="bottoneAmm" type="submit" value="Accedi alla pagina di accesso per amministratore"></a>
			<a id="pwdDimenticata" href="PwdDimenticata.jsp">Hai Dimenticato la password? Schiaccia qui..</a>
			
			
			
</div>
	
<%if(erroreaccount!=null&&erroreaccount.equals("errorelogin")|| (errorelogin!=null&&errorelogin.equals("errorelogin")) ){ %>	
	<div id="errorelogin">
	<h2>Errore Login, email o password errati</h2>
	<a><img src="immagini/error.png" width="200" height="200"></a>
	
	</div>
<%}%>




<div class="banner clearfix">



<a href="homepage.jsp" class="home"><img src="immagini/home.png" alt="home" class="home"></a>
<a href="prodotti.jsp" class="home"><img src="immagini/shop.png" alt="home" class="home"></a>
<a href="carrello.jsp" class="home"><img src="immagini/shopping-cart.png" alt="home" class="home"></a>
<a href="Login.jsp" class="home"><img src="immagini/user.png" alt="home" class="menu__mobile"></a>

</div>

</body>
</html>