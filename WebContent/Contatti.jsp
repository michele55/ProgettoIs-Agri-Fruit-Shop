<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="style/contatti.css" rel="stylesheet" type="text/css">
<title>Contatti</title>
</head>
<body>

<%@ include file="Header.jsp"%>

<div class="menu">
	
		<section id="main"></section>
	  <header class="page-header">
	  
      <h1 style="text-align:center;"><strong><em><span style="color:#7cd320;">Cerchi aiuto per i tuoi ordini?</span></em></strong></h1>
<form id="chiediaiuto" action="mailto:alexferrara74@gmail.com" method="post">
<div class="contatto">
<div class="nome">
<label>Nome </label><br>
<span class="ciao"><input type="text" name="name" value="" size="40"  aria-required="true" aria-invalid="false"></span>
</div>
</div>
<div class="contatto">
<div class="email">
<label>Email </label><br>
<span class="ciao"><input type="email" name="email" value="" size="40"  aria-required="true" aria-invalid="false"></span>
</div>
</div>
<div class="contatto">
<div class="numero">
<label>Numero Ordine </label><br>
<span class="ciao"><input type="text" name="subject" value="" size="40"  aria-invalid="false"></span>
</div>
<div class="telefono">
<label>Telefono </label><br>
<span class="ciao"><input type="text" name="phone" value="" size="40" aria-invalid="false"></span>
</div>
</div>
<div class="contatto">
<div class="messaggio">
<label>Messaggio </label><br>
<span class="ciao"><textarea id="textarea"name="body" cols="45" rows="10"></textarea></span>
<input type="submit" value="Invia" class="ciao" aria-invalid="false">
</div>
</div>
</form>

<div class="banner clearfix">



<a href="home.html" class="home"><img src="immagini/home.png" alt="home" class="home"></a>
<a href="" class="home"><img src="immagini/shop.png" alt="home" class="home"></a>
<a href="" class="home"><img src="immagini/shopping-cart.png" alt="home" class="home"></a>
<a href="" class="home"><img src="immagini/user.png" alt="home" class="menu__mobile"></a>

</div>

<div id="foother">
<%@ include file="foother.jsp"%>
</div>



</body>
</html>