var maj_cpt = new Event("majcpt");

function affiche_seances ()
	{

	// Objet XMLHttpRequest.
	var xhr = new XMLHttpRequest();
	
    var param = "id=" + encodeURIComponent(document.getElementById("ide").value);

	// Requête au serveur avec les paramètres éventuels.
	xhr.open("GET","ServletAuteur");

	// On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
	xhr.onload = function()
		{
		// Si la requête http s'est bien passée.
		if (xhr.status === 200)
			{
			// Réponse du serveur. On récupère la liste des noeuds <nom>.
			var l_cours = xhr.responseXML.getElementsByTagName("cours");
			

			}
		};

	// Envoi de la requête.
	xhr.send();
	}

function afficher(){
	
	// Objet XMLHttpRequest.
	var xhr = new XMLHttpRequest();
	
    var param = "id=" + encodeURIComponent(document.getElementById("ide").innerHTML);
    var url = "ServletPlanning";
	// Requête au serveur avec les paramètres éventuels.
	xhr.open("POST",url);

	// On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
	xhr.onload = function()
		{
		// Si la requête http s'est bien passée.
		if (xhr.status === 200)
			{
			// Réponse du serveur. On récupère la liste des noeuds <nom>.
			//var l_cours = xhr.responseXML.getElementsByTagName("cours");
			var l_salles = xhr.responseXML.getElementsByTagName("salle");
			var l_dates = xhr.responseXML.getElementsByTagName("date");
		
		    document.getElementById("d1").innerHTML=l_salles[0].firstChild.nodeValue;

			var jour;
			for (var i=0;i<6;i++){
				var date =new Date(document.getElementById("jour"+i).innerHTML);
				for(var j=0; j<l_dates.length; j++){
					var dateacheck=new Date(l_dates[j].firstChild.nodeValue);
					if(dateacheck.getTime()==date.getTime()){
						document.getElementById("d1").innerHTML="reussi";
					}
				}
			}
			}
		};

	// Envoi de la requête.
	xhr.send(param);
	
}


document.addEventListener("DOMContentLoaded", () => {

	document.getElementById("afficher").addEventListener("click",afficher);


	

});