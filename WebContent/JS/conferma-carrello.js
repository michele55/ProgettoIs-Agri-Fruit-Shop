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
		document.getElementById("buttonconferma").disabled=true;
		if (sped.value==null){
				
		document.getElementById("dati_spedizione1").style.display="none";
		document.getElementById("dati_spedizione2").style.display="none";
		}
	
		
		if(sped.value=="GLS")
		{
			document.getElementById("sped1").style.display="inline";
			document.getElementById("spednuova1").style.display="inline";
		
		 }
		if(sped.value=="SDA")
		{
		document.getElementById("sped2").style.display="inline";
			document.getElementById("spednuova2").style.display="inline";
		
		 }
	
			if(sped.value=="RITIRO")
		{
		document.getElementById("dati_spedizione1").style.display="none";
		document.getElementById("dati_spedizione2").style.display="none";
	
		
		 }
	
		
		
	}
	
		function spedizione3(sped){
		document.getElementById("buttonconferma").disabled=true;
	
	
		document.getElementById("dati_indirizzoesistente").style.display="inline";
		
		document.getElementById("dati_spedizione1").style.display="none";
		document.getElementById("dati_spedizione2").style.display="none";
	
		
		 
	
		
		
	}
	
			function spedizione4(sped){
		document.getElementById("buttonconferma").disabled=true;
	
	
		document.getElementById("dati_indirizzoesistente2").style.display="inline";
		
		document.getElementById("dati_spedizione1").style.display="none";
		document.getElementById("dati_spedizione2").style.display="none";
	
		
		 
	
		
		
	}
	
	
	function spedizionenuova(sped){
		document.getElementById("dati_spedizione1").style.display="inline";
	}
	function spedizionenuova2(sped){
		document.getElementById("dati_spedizione2").style.display="inline";
	}
	
		function spedizione2(){
		document.getElementById("dati_spedizione").style.display="none";
		
		var citta=document.getElementById("citta").value;
		var provincia=document.getElementById("provincia").value;
		var via=document.getElementById("via").value;
		var cap=document.getElementById("cap").value;
		var civico=document.getElementById("civico").value;
		 var xhr = new XMLHttpRequest();
   		 xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
           
        	}
   	 }
   		 xhr.open('GET', 'totaleordine?citta='+citta+'', true);
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
function disabilitaoff() {
	document.getElementById("buttonconferma").disabled=false;
		
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
	
	function bloccaForm() {
  // seleziona il form
document.getElementsByClassName("form").disabled=true;
document.getElementById("dati_spedizione1").disabled=true;
document.getElementById('citta').disabled=true;
document.getElementById('citta').setAttribute('disabled','disabled');
document.getElementById("modalita_spedizione").disabled=true;
document.getElementById("form").disabled=true;

}
	
	
		
		
	
	
	