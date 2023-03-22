/**
 * 
 */


function uppercase(){
var x=document.getElementById("rsociale");
x.value=x.value.toUpperCase();


}

function validamail(mail){
var x=mail.value;
mail.value=mail.value.toLowerCase();
var uno= x.indexOf("@");
var due=x.lastIndexOf(".");
if(due<=1||uno<=1){
var p=document.getElementById("erroremail");
p.setAttribute("error","error");
p.style.color="red";
p.innerHTML="X";
mail.focus();
return false;
}	
else
{
var q=document.getElementById("erroremail");
	q.style.color="green";
    q.innerHTML="V";

return true;
}
}


function validapass(password){
	var ck_password = /^[A-Za-z0-9]{8,20}$/;
	var pas1= password.value;
	
	
	if(!ck_password.test(pas1)){
		var p=document.getElementById("errorepassword");
	p.style.color="red";
	p.innerHTML="X";
	password.focus();
	return false;
}	
	else
{
	var q=document.getElementById("errorepassword");
	q.style.color="green";
    q.innerHTML="V";

		return true;
		}
}

function validaconferma(conferma){
	var s=document.getElementById("password").value;
	var ck_password = /^[A-Za-z0-9]{8,20}$/;
	var pas1= conferma.value;

	if(!ck_password.test(pas1)){
		if(s!=pas1 ||(s==null && pas1!=null)){
		var p=document.getElementById("erroreconferma");
	p.style.color="red";
	p.innerHTML="X";
	
conferma.focus();
	return false;
}}	
	else 
{
	var q=document.getElementById("erroreconferma");
	q.style.color="green";
    q.innerHTML="V";

		return true;
		}


}
function validapiva(piva){


	var ck_password=/^[A-Za-z0-9]{16}$/;
	var pas1= piva.value;

	if(!ck_password.test(pas1)){
		var p=document.getElementById("errorecodicefiscale");
	p.style.color="red";
	p.innerHTML="X";
	p.innerHTML="errorecodicefiscale";
	piva.focus();
	return false;
}	
	else 
{
	var q=document.getElementById("errorecodicefiscale");
	q.style.color="green";
    q.innerHTML="V";
		return true;
		}
}

function validaindirizzo(indirizzo){
var ck=/^[a-zA-Z\s]{6,20}$/;


if(!ck.test(indirizzo.value)){


  var p=document.getElementById("erroreindirizzo");
	p.style.color="red";
	p.innerHTML="X";
	p.innerHTML="Formato Via Errato";
indirizzo.focus();
	return false;
}	
	else 
{
	var q=document.getElementById("erroreindirizzo");
	q.style.color="green";
    q.innerHTML="V";

		return true;
		}

}

function validaprovincia(provincia){
var ck=/^[a-zA-Z\s]{5,40}$/;


if(!ck.test(provincia.value)){


  var p=document.getElementById("erroreprovincia");
	p.style.color="red";
	p.innerHTML="X";
	p.innerHTML="Formato Provincia Errato";
indirizzo.focus();
	return false;
}	
	else 
{
	var q=document.getElementById("erroreprovincia");
	q.style.color="green";
    q.innerHTML="V";

		return true;
		}

}

function validacitta(citta){
var ck=/^[a-zA-Z\s]{4,40}$/;


if(!ck.test(citta.value)){


  var p=document.getElementById("errorecitta");
	p.style.color="red";
	p.innerHTML="X";
	p.innerHTML="Formato Citta Errato";
indirizzo.focus();
	return false;
}	
	else 
{
	var q=document.getElementById("errorecitta");
	q.style.color="green";
    q.innerHTML="V";

		return true;
		}

}








function validacivico(civico){

var ck=/^[0-9]{1,3}$/;


if(!ck.test(civico.value)){


  var p=document.getElementById("errorecivico");
	p.style.color="red";
	p.innerHTML="X";
	civico.focus();
	return false;
}	
	else 
{
	var q=document.getElementById("errorecivico");
	q.style.color="green";
    q.innerHTML="V";

		return true;
		}

}

function validacap(cap){

var ck=/^[0-9]{5}$/;


if(!ck.test(cap.value)){


  var p=document.getElementById("errorecap");
	p.style.color="red";
	p.innerHTML="X";
	cap.focus();
	return false;
}	
	else 
{
	var q=document.getElementById("errorecap");
	q.style.color="green";
    q.innerHTML="V";

		return true;
		}

}







