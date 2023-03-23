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
	
	document.getElementById("12").innerHTML="DAI"
	
}
window.onload = function() {
  affiche_seances();
};

document.addEventListener("DOMContentLoaded", () => {

	document.getElementById("titree").addEventListener("majcpt",affiche_nomjour);

	// Déclenche l'évènement.
	document.getElementById("titree").dispatchEvent(maj_cpt);

	

});