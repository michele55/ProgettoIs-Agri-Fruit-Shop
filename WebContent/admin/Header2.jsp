<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = " java.util.* "  import="GestioneAccount.*"%>
<!DOCTYPE html>

<html>

<head>
<meta charset="ISO-8859-1">
<meta name="description" content="Ingrosso Agricolo">
<meta name="keywords" content="DataSource, Product, Cart, Session">
<meta name="author" content="AgriShop">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="https://pagecdn.io/lib/normalize/8.0.1/normalize.css">
<link rel="stylesheet" href="../style/style.css">
<script src="JS/header.js"></script>

<%
String username= (String)request.getSession().getAttribute("nome");
String amm=(String)request.getSession().getAttribute("amm");
%>

</head>
<body>


<header class="header clearfix" >

<a href="" class="header__logo"><img src="../immagini/LogoOk.png" alt="logo"></a>
	
	<div class="ricerca">
	<form action="" method="POST" name="form">
		<div class="ricerca_testo">
		<input id="input_ricerca" name="input_ricerca" type="text" placeholder="Ricerca" onkeyup="tastoPremuto();">
		</div>
		<div class="ricerca_img">
		<button type="submit"><img id="img_ricerca"src="../immagini/search.png" alt="ricerca" ></button>
		</div>
</form>
	<div id="ris__ricerca">
 	
	</div>
	</div>
	

<div id="carrello">
<a href="carrello.jsp"><img src="immagini/carrello.png"></a>

</div>

<ul class="header__menu">
<li class="header__menu__item"><a href="../homepage.jsp">Home</a></li>
<li class="header__menu__item"><a href="../prodotti.jsp">Prodotti</a></li>

<%if(username==null) {%>
<li class="header__menu__item"><a href="Login.jsp">Accedi</a></li>
</ul>

<div class="accedi__mobile">
<p class="accedi__mobile__item"><a href="Login.jsp"><img src="immagini/enter.png"></a></p>
</div>

<%} else{ %>
<div class="accedi__mobile">
<p class="accedi__mobile__item" ><a href=""><%=username %></a></p>
</div>

<%if (amm=="Amministratore"){ %>
<div class="header__menu__item" id="username">
<a ><%=username %></a>

<div class="header__menu__sotto">
<a href="admin/profilo.jsp">Pannello-Controllo</a>

<a href="/AgriShop/logout">Logout</a>

</div>
</div>


<%} else{ %>
<div class="header__menu__item" id="username">
<a ><%=username %></a>

<div class="header__menu__sotto">
<a href="ordini.jsp">Ordini</a>
<a href="utente/profilo.jsp">Modifica</a>
<a href="carrello.jsp">Carrello</a>
<a href="../logout">Logout</a>

</div>


</div>


<%}} %>
</header>

</body>
<script src="JS/header.js"></script>
</html>
