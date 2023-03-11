<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, GestioneProdotti.*" session="true"%>

<% 
Collection<?> prodotti=(Collection<?>)request.getAttribute("prodotti");
String controlloutente=(String)request.getSession().getAttribute("nome");
String errorequantita=(String)request.getAttribute("nexquantita");
String errcarrello=null;
String errcarrello2=null;
String aggiunta=null;
boolean var=false;
int count = 0;
if(controlloutente==null){}
String errore= (String)request.getAttribute("error");
if(prodotti==null&&errore==null){
	response.sendRedirect(response.encodeRedirectURL("./prodotti"));
}



	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link href="style/prodotti.css" rel="stylesheet" type="text/css">

<script src="JS/prodotti.js"></script>
<script src="JS/check.js"></script>


</head>


<body>
	<%@ include file="Header.jsp"%><br>



<div id="parametriconfigurazione">

<p>
<form action="prodotti" id="prodaction" >

<div class="img">

<a href="prodotti?scelta=ortaggi"><p>Ortaggi</p><img id="img"src="immagini/ortaggi.png" alt="logof"></a><br>
<br>


<label for="ortaggi"> <a href="prodotti?scelta=frutta"><p>Frutta</p><img id="img"src="immagini/frutta.png" alt="logof"></a></label><br>
<br>
<br>

<label for="ortaggi"> <a href="prodotti?scelta=verdura"><p>Verdura</p><img id="img"src="immagini/verduraa.png" alt="logof"></a></label><br>
<br>


<label for="ortaggi"> <a href="prodotti?scelta=semi"><p>Semi</p><img id="img"src="immagini/semiii.png" alt="logof"></a></label><br>	
<br>

<label for="ortaggi"><a href="prodotti?scelta=fruttasecca"><p>F.Secca</p><img id="img"src="immagini/nocciolinee.png" alt="logof"></a></label><br>
<br>

<label for="ortaggi"><a href="prodotti?scelta=vino"><p>Vino</p><img id="img"src="immagini/vinooo.png" alt="logof"></a></label><br>
<br>
<label for="ortaggi"><a href="prodotti?scelta=olio"><p>Olio</p><img id="img"src="immagini/oliooo.png" alt="logof"></a></label><br>
<br>
<br>
</div>
</form>
 


</div>



<div id="risultato">


<%


if(prodotti!=null&&prodotti.size()>0 ){
	
		Iterator<?> it=prodotti.iterator();
		while(it.hasNext()){
			prodotto beans=(prodotto)it.next();

	%>

	<div id="singolo">
		 
		<div id="immagineprod">
		<a href="prodotti/visualizzaprodotto.jsp?nomeprodotto=<%=beans.getNome()%>">
		<img src="immagini/<%=beans.getIdfoto()%>.png">
		</a>
		</div>

<div id="descrizione">		
<a href="prodotti/visualizzaprodotto.jsp?nomeprodotto=<%=beans.getNome()%>">
<p><%=beans.getDescrizione() %><br></p>

</a>
</div>
	 	<div id="prezzo">
	<%if(controlloutente!=null){ %>
	 	  <p><%=(float)beans.getPrezzo()%></p> <p><img width="20px" src="immagini/euro.png"></p><%} %> <br>
	 	</div>
	 	<div id="scelta">
	 	<%if (controlloutente!=null && beans.getQuantita()==0){ %>
									
									<button type="button">NON DISPONIBILE</button>
									
								<%} %>	
								
	 	<% if(controlloutente!=null && beans.getQuantita()!=0){%>
	 	

	 	
		<form action="carrello?action=aggiungi&NomeProd=<%=beans.getNome() %>"   method="POST">
		
			<input type="number" id="quantita" name="quantita" min="1" max="<%=beans.getQuantita()%>"step="1" value="1" > 
			<input type="hidden" id="nomeInput" value="<%=beans.getNome() %>">
			<input type="hidden" id="nomeInput3" value="<%=(String)request.getSession().getAttribute("AggiuntaCarrello") %>">
									<button type="submit"  name=bt  id="btn1">AGGIUNGI</button>
								
									
							
									<%}else if(controlloutente==null){%>
									<form action="Login.jsp">
									
									<button type="submit">Login</button>
									
									
									</form>
									<%} %>
									
									
						
	
		</form>
		<script>
	
	
		</script>

		
		
		
		
		
		
		
		</div>
		
	</div>

<% }
		
}else{
%>

 <a href="errore.jsp">Error</a>

<% } %>






</div>





<div class="banner clearfix">

<a href="homepage.jsp" class="home"><img src="immagini/home.png" alt="home" class="home"></a>
<a href="prodotti.jsp" class="home"><img src="immagini/shop.png" alt="home" class="home"></a>
<a href="carrello.jsp" class="home"><img src="immagini/shopping-cart.png" alt="home" class="home"></a>
<a href="Login.jsp" class="home"><img src="immagini/user.png" alt="home" class="menu__mobile"></a>


</div>



</body>


</html>