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

<h1>Richiesta Cambio Password</h1>
<h2>Se hai dimenticato la password, non puoi recuperarla, ma solo richiederne una nuova che dovrai obbligatoriamente cambiare al prossimo accesso
La richiesta dovrà essere mandata all'indirizzo assistenzapwd@agrifruitshop.it, allegando un documento d'identità, e la tua email usata per la registrazione.</h2>








</div>






</body>
</html>