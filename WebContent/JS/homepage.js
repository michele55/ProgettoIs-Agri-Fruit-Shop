/**
 * 
 */






var numero=1;
var myVar = setInterval(mySlide, 4000);


function mySlide(){
		numero++;
		if(numero>6)
			numero=1;
		document.getElementById("imm").src="./immagini/azienda("+numero+").jpg";
	
	
	
}

