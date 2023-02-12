/**
 * 
 */
function validanumero(numero){
	
	document.getElementById("buttonconferma").disabled=true;
	var ck=/^[0-9]{16,16}$/;
	var pas1= numero.value;
	
	if(!ck.test(pas1)){
	
	return false;
	document.getElementById("buttonconferma").disabled=true;
	}
	else{
	document.getElementById("buttonconferma").disabled=false;
	return true;
	}
	
}

function validanome(nome){
	document.getElementById("buttonconferma").disabled=true;
	var nominativo=nome.value;
	var ck=/^[a-zA-Z\s]{4,20}$/;
	
	if(!ck.test(nominativo)){
	
	return false;
	document.getElementById("buttonconferma").disabled=true;
	}
	else{
		document.getElementById("buttonconferma").disabled=false;
	return true;
	
		
	}
}

function validacvv(cvv){
	document.getElementById("buttonconferma").disabled=true;
	var ck=/^[0-9]{3,3}$/;
	var codice=cvv.value;
	
	if(!ck.test(codice)){
		
	return false;
	document.getElementById("buttonconferma").disabled=true;
	}
	else{
		document.getElementById("buttonconferma").disabled=false;
	return true;
	
	
}
}

