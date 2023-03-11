<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="gestioneAccount.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../style/stylelogreg.css" rel="stylesheet" type="text/css">

<script src="../JS/controllo-pregistrazione.js"></script>

<%

Utente neg=(Utente)request.getSession().getAttribute("neg");
%>

</head>
<body>
 <%@ include file="Header2.jsp"%><br>

<div id="utente">
<fieldset>
<legend>Modifica Dati Personali</legend>
<p>Account di <%=username%></p>

<form class="modprofilo"action="../Modificaprofilo" method="post">

<table>
<tr>
<td><input id="rsociale" type="text" name="user " placeholder="<%=username%>"  readonly="readonly" onblur="uppercase(this)"></td><td><p id=erroreragione></td>
</tr>

<tr>
<td><input id="email" type="text" name="email" placeholder="<%=neg.getEmail()%>" readonly="readonly" ></td>
</tr>
<tr>

<td><input id="cap" type="text" name="cap" placeholder="<%=neg.getCap()%>" onblur="validacap(this)"></td><td><p id=errorecap></td>
</tr>
<tr>

<td><input id="ncivico" type="text" name="ncivico" placeholder="<%=neg.getCivico()%>" onblur="validacivico(this)"></td><td><p id=errorecivico></td>
</tr>
<tr>

<td><input id="indirizzo" type="text" name="indirizzo" placeholder="<%=neg.getIndirizzo()%>" onblur="validaindirizzo(this)"></td><td><p id=erroreindirizzo></td>
</tr>
<tr>
<td><input id="codice_fiscale" type="text" name="codice_fiscale" placeholder="<%=neg.getCodice_fiscale()%>" onblur="validapiva(this)"></td><td><p id=errorepiva></td>
</tr>

<tr>
<td><input id="password" type="password" name="password" placeholder="password" required></td><td><p id=errorepassword></td>
</tr>
<tr>
<td><input id="conferma" type="password" name="conferma" placeholder="conferma password" required></td><td><p id=erroreconferma></td>
</tr>
<tr>
<td>
<input type="submit" value="invio">
</td>
</tr>
</table>
</form>


</fieldset>



<script src="../JS/controllo-registrazione.js"></script>

</div>
<%@ include file="../foother.jsp" %>
</body>
</html>