<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="GestioneProdotti.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="style/visualizzaprodotto.css" rel="stylesheet" type="text/css">
<script src="JS/jsprodotti.js"></script>
<%
String prodotto=(String)request.getParameter("nomeprodotto");
String controlloutente=(String)request.getSession().getAttribute("nome");
prodotto prodotti=(prodotto)request.getAttribute("prodotti");


if(prodotti==null){
	response.sendRedirect(response.encodeRedirectURL(".././visualizzaprodotto?nomeprodotto="+prodotto+""));
}
%>
</head>

<body>
<%@ include file="../Header.jsp"%>

<% if(prodotti!=null){
%>
<div id="contenitore">
<div id="foto">
<img src="immagini/<%=prodotti.getIdfoto()%>.png">
</div>

<div id="visualizzaprodotto">

<form id="form" action="carrello?action=aggiungi" method="POST">


<div id="nome">
<p>Prodotto: </p>
<span><input type="text" id="" name="nome" value="<%=prodotti.getNome() %>"  readonly ></span>
</div>

<div id="descrizione">
<p>Descrizione: </p>
<span id="desc"><input type="text" id="" value="<%=prodotti.getDescrizione() %>" name="<%=prodotti.getDescrizione() %>" readonly></span>
</div>

<%if(controlloutente!=null){ %>




<div id="quantita">
<p>Quantità: </p>
<span id="qnt"><input type="number" id="quantita" name="quantita" step="1"></span>
</div>


<div id="prezzo">
<label>Prezzo: </label>
<span><%=prodotti.getPrezzo() %></span>
<span><img width="20px" src="immagini/euro.png"></span>
</div>
<%}%>

<div id="categoria">
<label>Categoria: </label>
<span><%=prodotti.getCategoria() %></span>
</div>




<div id="addcarrello">
<input type="submit" value="Aggiungi">
</div>
</form>

<% }%>
</div>
</div>
<div class="banner clearfix">



<a href="home.html" class="home"><img src="immagini/home.png" alt="home" class="home"></a>
<a href="" class="home"><img src="immagini/shop.png" alt="home" class="home"></a>
<a href="" class="home"><img src="immagini/shopping-cart.png" alt="home" class="home"></a>
<a href="" class="home"><img src="immagini/user.png" alt="home" class="menu__mobile"></a>

</div>


	<%@ include file="../foother.jsp"%>
</body>
</html>