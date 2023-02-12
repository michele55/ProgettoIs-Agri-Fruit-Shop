



function tastoPremuto(){

var parola=document.getElementById("input_ricerca").value;
if(parola.length>=2){

var http=new XMLHttpRequest();

http.onreadystatechange=function(){
	if(http.readyState==4 && http.status==200){
	document.getElementById("ris__ricerca").style.display="inline";
		document.getElementById("ris__ricerca").innerHTML=http.responseText;	
		
	};
	}
	http.open("GET","ricerca?parametro="+parola+"",true);
	http.send();

}else{
document.getElementById("ris__ricerca").style.display="none";

}

}




