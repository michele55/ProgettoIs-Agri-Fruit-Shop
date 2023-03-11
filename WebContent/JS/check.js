/**
 * 
 */

function test() {

  
  var xhttp = new XMLHttpRequest();
	console.log("bb");
	 var nomeInput = document.getElementById("nomeInput");
 var nomeInput3 = document.getElementById("nomeInput3");
  var nomeValue = nomeInput.value;
 var nomeValue3 = nomeInput3.value;
var url = "carrello?action=aggiungi&NomeProd=" + encodeURIComponent(nomeValue);
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      // Analizza la risposta della servlet
      var response = xhttp.responseText;

      if (nomeValue3=="Aggiunta avvenuta correttamente") {

        // Gli attributi  sono presenti
        window.alert("Gli attributi sono stati settati correttamente. "+ response);
      } else {
        // Gli attributi  non sono presenti
        window.alert("Gli attributi non sono stati settati correttamente.");
      }
    }
  };
  xhttp.open("POST", url,true);
  xhttp.send();
}

	function redirect () {
         setTimeout(myURL, 5000);
         var result = document.getElementById("result");
         result.innerHTML = "<b> The page will redirect after delay of 5 seconds";
      }

      function myURL() {
         document.location.href = '/AgriShop/homepage.jsp';
      }
