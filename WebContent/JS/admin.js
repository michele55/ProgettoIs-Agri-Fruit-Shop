/**
 * 
 */
document.getElementById('categ').addEventListener('input',

function categoria(){

var categoria=document.getElementById("categ").value;

var http=new XMLHttpRequest();

http.onreadystatechange=function(){
	if(http.readyState==4 && http.status==200){
		
		document.getElementById("seleziona_opzione").innerHTML=http.responseText;	
		
	};
	}
	http.open("GET","../scegliprodotto?categoria="+categoria+"",true);
	http.send();


}

);
document.getElementById('seleziona_opzione').addEventListener('input',
function seleziona(){
	
	var prodotto=document.getElementById('seleziona_opzione').value;

	var http=new XMLHttpRequest();

http.onreadystatechange=function(){
	if(http.readyState==4 && http.status==200){
		
		document.getElementById("risposta_prodotto").innerHTML=http.responseText;	
		
	};
	}
	http.open("GET","../scegliprodotto?nomeprodotto="+prodotto+"",true);
	http.send();



	
	}
	
	);
