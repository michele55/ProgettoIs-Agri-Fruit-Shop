<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="GestioneProdotti.*" import="java.util.*" import="GestioneCarrello.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="style/stylecarrello.css" rel="stylesheet" type="text/css">
<script src="JS/conferma-carrello.js"></script>
<script src="JS/controllocarta.js"></script>


<%

Carrello <prodotto> carrello=(Carrello<prodotto>)request.getSession().getAttribute("carrello");


%>
</head>
<body>
<%@ include file="Header.jsp"%><br>

<%if(carrello!=null&&carrello.getOggetto().size()>0){

List<prodotto> prodcarrello=carrello.getOggetto(); %>

<%for(int i=0;i<prodcarrello.size();i++){ %>

<% prodotto p=prodcarrello.get(i);


%>

<div id="test"></div>




<div class="riepilogo__prodotti__carrello">
<span id="nomeprod"><input type="text"  name="nome" value="<%=p.getDescrizione() %>"  readonly ></span>
<span id="quantita"><input type="text" value="<%=p.getDispcarrello() %>"></span>
<span id="prezzo">EUR <%=p.getPrezzo()*p.getDispcarrello() %></span>


</div>



<%}} %>



<div id="totale__spesa">

<% if(carrello!=null) {%>
<p>Totale Carrello: <%= carrello.getValorecarrello()%>
<%} %>
</div>












<div id="modalita_spedizione">
<p style="text-align:center;">SPEDIZIONE:</p>
<label class="container"><img src="immagini/gls1.png">
<input type="radio" id="contr" name="radiosped" value="GLS" onchange="spedizione(this);" required>
  <span class="checkmark"></span>
</label>
<label class="container"><img src="immagini/sda.png" >
<input type="radio" id="contr" name="radiosped" value="SDA"  onchange="spedizione(this);" required>
  <span class="checkmark"></span>
</label>
<label class="container"><img src="immagini/ritiroamano.png">
<input type="radio" id="contr" name="radiosped" value="MANO"  onchange="spedizione(this);" required>
  <span class="checkmark"></span>
</label>
</div>



<img id="loading" src="immagini/loading.png" alt="errore">
<div id="totale__carrello">



</div>


<div id="modalita_pagamento">
<p style="text-align:center;">PAGAMENTO:</p>
 <label class="container" ><img src="immagini/paypal.png">
  <input type="radio"  name="radio" value="paypal" onchange="pagamento(this), costo(this);" required>
  <span class="checkmark"></span>
</label>

<div id="conferma_paypal">
<h1>Effettuare pagamento a:</h1>
<h1>agrishop@gmail.com</h1>

</div>

<label class="container"><img src="immagini/mastercard.png">
  <input type="radio" name="radio" value="mastercard" onchange="pagamento(this), costo(this);" required>
  <span class="checkmark"></span>
</label>

<div id="dati_pagamento">



<input type="text" name="numerocarta"placeholder="Numero Carta" onblur="validanumero(this)" required>
<input type="text" name="titolare" placeholder="Titolare Carta" onblur="validanome(this)" required>
<input type="date" name="scadenza" placeholder="Scadenza" onblur="validascadenza(this)"required>
<input type="text" name="cvv" placeholder="CVV" onblur="validacvv(this)" required>



</div>

<label class="container"><img src="immagini/contrassegno.png">
  <input type="radio" id="contr" name="radio" value="contanti"  onchange="pagamento(this),costo(this);" required>
  <span class="checkmark"></span>
</label>


</div>

 <button id="buttonconferma" onclick="calcolo(),disabilita()">CONFERMA  </button> 


<div id="foother">
<%@ include file="foother.jsp"%>
</div>
</body>

</html>
