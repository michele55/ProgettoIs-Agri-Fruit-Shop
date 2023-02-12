<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="gestioneAccount.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../style/stylelogreg.css" rel="stylesheet" type="text/css">



</head>
<body>
<%@ include file="Header2.jsp"%>

<div class="utente-container">
<fieldset>
<legend>Pagina di amministratore</legend>
<div class="utente-figlio1">


<p>Account di <%=username%></p>

<form class="AdminPage"action="../AdminPage" method="post">
<h2>Inserimento prodotto</h2>
<table>




<tr>
<td><input type="text" name="nome" placeholder="Nome" required></td>
</tr>

<tr>
<td><input type="text" name="prezzo" placeholder="Prezzo" required></td>
</tr>

<tr>

<td><input type="text" name="Ssn" placeholder="Ssn" required></td>
</tr>
<tr>

<td><input type="text" name="disponibilita" placeholder="disponibilità" required></td>
</tr>

<tr>
<td><input type="text" name="descrizione" placeholder="Descrizione" required></td>
</tr>

<tr>
<td><select name="categoria"  required>
	<option value= "ortaggi">Ortaggi</option>
	<option value="frutta">Frutta</option>
	<option value="verdura">Verdura </option>
	<option value="semi">Semi</option>
	<option value= "FruttaSecca">Frutta Secca</option>
	<option value="vino">Vino </option>
	<option value="olio">Olio</option>
	
	</select>
	

</td>
</tr>

<tr>
<td><input type="text" name="idfoto" placeholder="nomefoto" required></td>
</tr>

<tr>
<td>
<input type="submit" value="invio">
</td>
</tr>

</table>
</form>
</div>

<div class="utente-figlio2">

<form class="AggiornaProdotto" action="../AdminPage?action=modifica" method="post">
<h2>Modifica Prodotto</h2>
<table>


<tr>
<td><select id="categ" name="categoria"  required>

	<option  value= "Ortaggi">Ortaggi</option>
	<option value="Frutta"  >Frutta</option>
	<option value="Verdura" >Verdura </option>
	<option value="Semi">Semi</option>
	<option value= "Frutta Secca">Frutta Secca</option>
	<option value="Vino">Vino </option>
	<option value="Olio">Olio</option>
	
	</select>
	
</td>
</tr>

<tr>
<td >
<select id="seleziona_opzione" name="categoria"  required>

</select>
</td>
</tr>

<tr>
<td id="risposta_prodotto">


</td>
</tr>


</table>
</form>
</div>


<div class="utente-figlio3">


<form class="CancellaProdotto"action="../CancellaProdotto" method="post">
<h2>Cancellazione prodotto</h2>
<table>




<tr>

<td><input type="text" name="Nome Prodotto" placeholder="Nome Prodotto" required></td>
</tr>






<tr>
<td>
<input type="submit" value="invio">
</td>
</tr>
</table>
</form>

<form class="CancellaUtente" action="../CancellaUtente" method="post">
<h2>Cancellazione Utente</h2>

<table>




<tr>

<td><input type="text" name="Nome Utente" placeholder="Nome Utente" required></td>
</tr>






<tr>
<td>
<input type="submit" value="invio">
</td>
</tr>
</table>







</form>












</div>
</fieldset>





</div>



</body>
<script src="../JS/admin.js"></script>

</html>