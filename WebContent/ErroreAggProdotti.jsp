<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="gestioneAccount.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="refresh" content="3; url=/AgriShop/prodotti.jsp">
<link href="../style/stylelogreg.css" rel="stylesheet" type="text/css">

<script src="../JS/check.js"></script>


<%
String erroreaccount=(String)request.getAttribute("erroreaccount");
String errorelogin=(String)request.getAttribute("passerrore");
%>

</head>
<body>
 <%@ include file="Header.jsp"%><br>

<div id="utente">
<fieldset>
<legend>Errore</legend>
<p>Account di <%=username%></p>

<h1>Prodotto non aggiunto</h1>
<h2>Redirect automatico tra 3 secondi</h2>


</fieldset>




</div>

<%@ include file="foother.jsp" %>
</body>
</html>