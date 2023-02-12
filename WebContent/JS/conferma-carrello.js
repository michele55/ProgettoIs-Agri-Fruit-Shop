/**
 * 
 */

function pagamento(src) {
	document.getElementById("buttonconferma").disabled=false;
	if(src.value=="mastercard")
		{
		document.getElementById("dati_pagamento").style.display="inline";
		document.getElementById("conferma_paypal").style.display="none";
		
		 }
		
		if(src.value=="contanti")		
		{
		document.getElementById("dati_pagamento").style.display="none";
		document.getElementById("conferma_paypal").style.display="none";
		
		}
		
	if(src.value=="paypal")
		{
		document.getElementById("conferma_paypal").style.display="inline"; 
		document.getElementById("dati_pagamento").style.display="none";

		
		
		}
	
	}
	
	
	function spedizione(sped){
		
		var spedizione=sped.value;
		
		
		 var xhr = new XMLHttpRequest();
   		 xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
           
        	}
   	 }
   		 xhr.open('GET', 'totaleordine?spedizione='+spedizione+'', true);
  		 xhr.send(null);
		
		
	}
	
	
	
	function calcolo(){
		
		document.getElementById("totale__carrello").style.display="inline";
		
		 var xhr = new XMLHttpRequest();
   		 xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
		           
	document.getElementById("totale__carrello").innerHTML=xhr.responseText;
	document.getElementById("loading").style.display="inline";
	window.setTimeout("redirect()", 3000);
	

        	}
   	 }
   		 xhr.open('GET', 'totaleordine?action=totale', true);
  		 xhr.send(null);
		
		
		}
		
		function redirect(){
			window.location.href = "carrello?action=clearCart";
		}
		
		
	function disabilita() {
	document.getElementById("buttonconferma").disabled=true;
		document.getElementById("conferma_ordine").disabled=true;
}
	
	function ordini(){
		
		
		 var xhr = new XMLHttpRequest();
   		 xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
		           
	document.getElementById("ordini-cliente").innerHTML=xhr.responseText;

	

        	}
   	 }
   		 xhr.open('GET', 'ordiniclienti', true);
  		 xhr.send(null);
		
		
	}
	
	
	function costo(costo){
		var tipo=costo.value;
	
		 var xhr = new XMLHttpRequest();
   		 xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
           
        	}
   	 }
   		 xhr.open('GET', 'totaleordine?pagamento='+tipo+'', true);
  		 xhr.send(null);
		
	}
	
	
		
		
	
	
	