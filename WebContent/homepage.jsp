<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*" import="GestioneProdotti.prodotto"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet" href="https://pagecdn.io/lib/normalize/8.0.1/normalize.css">
<link rel="stylesheet" href="style/style.css">
<link rel="stylesheet" href="style/prodotti.css">
<script src="JS/homepage.js"></script>
<%
Collection<?> prodotti=(Collection<?>)request.getAttribute("prodotti");
String controlloutente=(String)request.getSession().getAttribute("nome");
if(controlloutente==null){}
String errore= (String)request.getAttribute("error");
if(prodotti==null&&errore==null){
	response.sendRedirect(response.encodeRedirectURL("./offerta"));
}

%>

</head>

<body>
<%@ include file="Header.jsp"%>

<div class="center">

<div class="slogan">
<h1>Se vuoi veramente saperlo</h1>
<h2>guarda nel biologico</h2>
<img src="immagini/biologico.jpg" alt="biologico">
</div>

<div class="slo">
<h1>Agricoltura biologica</h1>
<h2>fa bene alla natura,fa bene a te</h2>
<img src="immagini/bio.jpeg" alt="slo">
</div>

<div class="immagine">
<img id="imm"src="immagini/azienda(1).jpg" alt="immagine">
<div class="immagine__cerchio"><a href="prodotti?scelta=vino"><img src="immagini/vino.jpg"></a></div>
<div class="immagine__cerchio"><a href="prodotti?scelta=ortaggi"><img src="immagini/ins.jpg"></a></div>
<div class="immagine__cerchio"><a href="prodotti?scelta=olio"><img src="immagini/olio.jpg"></a></div>
<div class="immagine__cerchio"><a href="prodotti?scelta=frutta"><img src="immagini/frutt.jpg"></a></div>

</div>

<div class="offerta"></div>

</div>

<div class="banner clearfix">



<a href="homepage.jsp" class="home"><img src="immagini/home.png" alt="home" class="home"></a>
<a href="prodotti.jsp" class="home"><img src="immagini/shop.png" alt="home" class="home"></a>
<a href="carrello.jsp" class="home"><img src="immagini/shopping-cart.png" alt="home" class="home"></a>
<a href="Login.jsp" class="home"><img src="immagini/user.png" alt="home" class="menu__mobile"></a>

</div>


<div id="contenitore_prodotti">
<%

if(prodotti!=null&&prodotti.size()>0){
	int i=0;
		Iterator<?> it=prodotti.iterator();
		while(it.hasNext()&& i<4){
			prodotto beans=(prodotto)it.next();
			i++;
	%>

	
		 
		<div id="singolohomepage">
		 
		<div id="immagineprodhome">
		<a href="prodotti/visualizzaprodotto.jsp?nomeprodotto=<%=beans.getNome()%>">
		<img src="immagini/<%=beans.getIdfoto()%>.png">
		</a>
		</div>
		
	<div id="descrizionehome">		
		<a href="prodotti/visualizzaprodotto.jsp?nomeprodotto=<%=beans.getNome()%>">
		<%=beans.getDescrizione() %><br>
		</a>
	</div>
	 	<div id="prezzohome">
	 	<%if (controlloutente!=null){ %>  <p><%=(float)beans.getPrezzo()%></p> <p><img width="20px" src="immagini/euro.png"></p> <br><%} %>
	 	</div>
	 	<div id="sceltahome">
		<form action="carrello?action=aggiungi&nome=<%=beans.getNome() %>" method="POST">
		<input type="number" id="quantita" name="quantita" min="1" max="<%=beans.getQuantita()%>"step="1" value="1"> <%if (controlloutente!=null){ %>
														 <button type="submit">AGGIUNGI</button><%}else{ %>
		
															<a href="Login.jsp">Login</a>
					<%} %>
		</form>
		</div>

</div>
<% }
		
	}else{
%>

 <a href="errore.jsp">Errore</a>

<% } %>

</div>


<div id="slogan-bio">
<div class="bio">
<img src="immagini/bio-mondo.jpg" alt="mondo-bio">
</div>

<div class="bio">
<h1>La parola "biologica" deriva da greco "bios" e significa vita.</h1>
<h2>
 Vengono riconosciuti come biologici solo i prodotti sottoposti ad accurati controlli.
 Il nostro shop offre il 100% dei prodotti riconosciuti.
</h2>
</div>

</div>





<div id="foother">
<%@ include file="foother.jsp"%>
</div>




</body>
</html>