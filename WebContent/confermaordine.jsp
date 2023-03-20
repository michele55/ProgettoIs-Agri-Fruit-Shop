<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="GestioneProdotti.*" import="java.util.*" import="GestioneCarrello.*" import="gestioneAccount.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="style/stylecarrello.css" rel="stylesheet" type="text/css">
<script src="JS/conferma-carrello.js"></script>
<script src="JS/controllocarta.js"></script>


<%

Carrello <prodotto> carrello=(Carrello<prodotto>)request.getSession().getAttribute("carrello");
Utente utente=(Utente)request.getSession().getAttribute("neg");




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


<label  class="container"><img src="immagini/gls1.png">
<input type="radio" id="contr" name="radiosped" value="GLS" onchange="spedizione(this);" required checked>
  <span class="checkmark"></span>
  </label>


<div style="display:none" id="sped1">

 <input  type="radio" id="contr2" name="radiosped" value="ind" onchange="spedizione3(this);" required checked>
 <label for="contr2">Indirizzo Esistente</label>

</div>

<div style="display:none" id="dati_indirizzoesistente">


<form action="totaleordine" id="form" class="form">

<input type="text" id="citta" name="citta"placeholder=<%=utente.getCitta() %> value="<%=utente.getCitta() %> "readonly  >
<input type="text" name="provincia"placeholder="Provincia"  value="<%=utente.getProvincia() %>"readonly>
<input type="text" name="cap"placeholder="Cap" value="<%=utente.getCap() %>"readonly >
<input type="text" name="via"placeholder="Via"  value="<%=utente.getIndirizzo() %>"readonly>
<input type="text" name="civico"placeholder="Civico" value="<%=utente.getCivico() %>"readonly >
<input type="hidden" id="spedizione" value="GLS" name="spedizione">
   <button type = "submit" value = "Submit" onsubmit="disabilitaoff(),bloccaForm()">Conferma</button>

</form>

</div>

<div style="display:none" id="spednuova1">

 <input  type="radio" id="contr2" name="radiosped" value="ind" onchange="spedizionenuova(this);" required checked>
 <label for="contr2">Nuova Spedizione</label>

</div>





<div style="display:none" id="dati_spedizione1">


<form action="totaleordine" id="form" class="form">

<input type="text" id="citta" name="citta"placeholder="Città"  required>
<input type="text" name="provincia"placeholder="Provincia"  required>
<input type="text" name="cap"placeholder="Cap"  required>
<input type="text" name="via"placeholder="Via"  required>
<input type="text" name="civico"placeholder="Civico"  required>
<input type="hidden" id="spedizione" value="GLS" name="spedizione">
   <button type = "submit" value = "Submit" onsubmit="disabilitaoff(),bloccaForm()">Conferma</button>

</form>

</div>









<label class="container"><img src="immagini/sda.png" >
<input type="radio" id="contr" name="radiosped" value="SDA"  onchange="spedizione(this);" required>
  <span class="checkmark"></span>
</label>



<div style="display:none" id="sped2">

 <input  type="radio" id="contr2" name="radiosped" value="ind" onchange="spedizione4(this);" required checked>
 <label for="contr2">Indirizzo Esistente</label>

</div>

<div style="display:none" id="dati_indirizzoesistente2">


<form action="totaleordine" id="form" class="form">

<input type="text" id="citta" name="citta"placeholder=<%=utente.getCitta() %> value="<%=utente.getCitta() %> "readonly  >
<input type="text" name="provincia"placeholder="Provincia"  value="<%=utente.getProvincia() %>"readonly>
<input type="text" name="cap"placeholder="Cap" value="<%=utente.getCap() %>"readonly >
<input type="text" name="via"placeholder="Via"  value="<%=utente.getIndirizzo() %>"readonly>
<input type="text" name="civico"placeholder="Civico" value="<%=utente.getCivico() %>"readonly >
<input type="hidden" id="spedizione" value="GLS" name="spedizione">
   <button type = "submit" value = "Submit" onsubmit="disabilitaoff(),bloccaForm()">Conferma</button>

</form>

</div>

<div style="display:none" id="spednuova2">

 <input  type="radio" id="contr2" name="radiosped" value="ind" onchange="spedizionenuova2(this);" required checked>
 <label for="contr2">Nuova Spedizione</label>

</div>



<div style="display:none" id="dati_spedizione2">


<form action="totaleordine" >

<input type="text" id="citta" name="citta"placeholder="Città"  required>
<input type="text" name="provincia"placeholder="Provincia"  required>
<input type="text" name="cap"placeholder="Cap"  required>
<input type="text" name="via"placeholder="Via"  required>
<input type="text" name="civico"placeholder="Civico"  required>
<input type="hidden" id="spedizione" value="SDA" name="spedizione">
   <button type = "submit" value = "Submit" onsubmit="disabilitaoff(),bloccaform()">Conferma</button>

</form>

</div>




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

 <button disabled id="buttonconferma" onclick="calcolo(),disabilita()">CONFERMA  </button> 


<div id="foother">
<%@ include file="foother.jsp"%>
</div>
</body>

</html>
