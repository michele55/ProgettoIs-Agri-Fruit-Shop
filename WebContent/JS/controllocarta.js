/**
 * 
 */
function validanumero(numero){
	
	document.getElementById("submit").disabled=true;
	var el=document.getElementById("numerocarta");
	var ck=/^[0-9]{16,16}$/;
	var pas1= numero.value;
	
	if(!ck.test(pas1)){
		
	document.getElementById("submit").disabled=true;

	
	return false;
	
	}
	else{
	document.getElementById("submit").disabled=false;
	return true;
	}
	
}

function validanome(nome){
	document.getElementById("submit").disabled=true;
	var nominativo=nome.value;
	var ck=/^[a-zA-Z\s]{4,50}$/;
	
	if(!ck.test(nominativo)){
	document.getElementById("submit").disabled=true;
	return false;
	
	}
	else{
		document.getElementById("submit").disabled=false;
	return true;
	
		
	}
}
function validascadenza(nome){
	document.getElementById("submit").disabled=true;
	var nominativo=nome.value;
	var ck=/^[a-zA-Z\s]{4,20}$/;
	var date=new Date();
	if(!ck.test(nominativo)<date||nominativo==null){
	document.getElementById("submit").disabled=true;
	return false;
	
	}
	else{
		document.getElementById("submit").disabled=false;
	return true;
	
		
	}
}
function validacvv(cvv){
	document.getElementById("submit").disabled=true;
	var ck=/^[0-9]{3,3}$/;
	var codice=cvv.value;
	
	if(!ck.test(codice)){
		document.getElementById("submit").disabled=true;
	return false;
	
	}
	else{
		document.getElementById("submit").disabled=false;
	return true;
	
	
}
}

