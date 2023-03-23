<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/EmploiStyle.css">
<script src="js/EmploiDuTempsJS"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Accueil_Enseignant</title>
<script>
	function affiche_seances() {
		// Objet XMLHttpRequest.
		var xhr = new XMLHttpRequest();
		var param = "id="
				+ encodeURIComponent(document.getElementById("ide").value);
		// Requête au serveur avec les paramètres éventuels.
		xhr.open("GET", "ServletAuteur");
		// On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
		xhr.onload = function() {
			// Si la requête http s'est bien passée.
			if (xhr.status === 200) {
				// Réponse du serveur. On récupère la liste des noeuds <nom>.
				var l_cours = xhr.responseXML.getElementsByTagName("cours");
			}
		};
		// Envoi de la requête.
		xhr.send();
	}
	function afficher() {
		document.getElementById("12").innerHTML = "DAI"
	}
	// get today
	var currentDate = new Date();
	// calculer the first day of the week
	var firstDayOfWeek = new Date(currentDate.getFullYear(), currentDate
			.getMonth(), currentDate.getDate() - currentDate.getDay() + 1);
	// afficher
	window.onload = function() {
		for (var i = 0; i < 7; i++) {
			var date = new Date(firstDayOfWeek.getFullYear(), firstDayOfWeek
					.getMonth(), firstDayOfWeek.getDate() + i);
			var dayOfWeek = new Array("Dimanche", "Lundi", "Mardi", "Mercredi",
					"Jeudi", "Vendredi", "Samedi")[date.getDay()];
			document.getElementById("date" + i).innerHTML = "<div > "
					+ dayOfWeek + "</div >" + date.toLocaleDateString();
		}
		afficher();
	}
</script>

</head>
<body>
	<!-- menu -->
<<<<<<< HEAD
	<div class="menu">
		<ul>
			<li><img src="img/logo-ut1.png" class="logo-ut1" /></li>
			<div class="accueil">
				<li><a href="webapp.EmploiDuTemps">Accueil</a>
			</div>
			</li>
			<li class="cours"><a href="#">Mes cours</a>
				<ul>
					<li><a href="CoursAnnee.jsp">2022-2023</a></li>
					<li><a href="">2021-2022</a></li>
				</ul></li>

			<div class="compte">
				<li><a href="#">Mon Compte</a>
					<ul>
						<li><a href="">Mes informations</a></li>
						<li>Déconnextion</li>
					</ul>
			</div>
			</li>
		</ul>
	</div>
	<!-- /menu -->
	<div class="parent">
		<div class="div1">

			<h1>Bienvenue de nouveau,</h1>
			<h2>Mes Emploi du Temps</h2>
			<h3>Semestre 1 week : 20/03/2023-26/03/2023</h3>

		</div>
		<div class="div2">
			<table border="2" align="center" width="90%" cellpadding="2"
				cellspacing="2">

				<thead id="titre">
					<td></td>
					<td id="date0"></td>
					<td id="date1"></td>
					<td id="date2"></td>
					<td id="date3"></td>
					<td id="date4"></td>
					<td id="date5"></td>
					<td id="date6"></td>
				</thead>

				<tbody>

					<%--boucle de seance --%>
					<tr id="h1">
						<td class="heure">8:00-9:30</td>
						<td class=course id="11"><a href="ficheAppel">CM Recueil
								des besoins Agile</a>
							<div class="salle">ME405</div></td>
						<td class=course id="12">CM Données, intégration, analyse</td>
						<td class=course id="13"></td>
						<td class=course id="14">CM Démarche de développement agile</td>
						<td class=course id="15"></td>
						<td></td>
						<td></td>
					</tr>
					<tr id="h2">
						<td class="heure">9:30-11:00</td>
						<td class=course id="21">CM Recueil des besoins Agile</td>
						<td class=course id="22">CM Recueil des besoins Agile</td>
						<td class=course id="23"></td>
						<td class=course id="24"></td>
						<td class=course id="25">Francais</td>
						<td></td>
						<td></td>
					</tr>
					<tr id="h3">
						<td class="heure">11:00-12:30</td>
						<td class=course>CM Recueil des besoins Agile</td>
						<td class=course>CM Recueil des besoins Agile</td>
						<td class=course></td>
						<td class=course>Anglais</td>
						<td class=course></td>
						<td></td>
						<td></td>
					</tr>
					<tr id="h4">
						<td class="heure">12:30-14:00</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr id="h5">
						<td class="heure">14:00-15:30</td>
						<td class=course>CM Données, intégration, analyse MC405</td>
						<td class=course></td>
						<td class=course></td>
						<td class=course>CM Démarche de développement agile</td>
						<td class=course></td>
						<td></td>
						<td></td>
					</tr>
					<tr id="h6">
						<td class="heure">15:30-17:00</td>
						<td class=course></td>
						<td class=course></td>
						<td class=course></td>
						<td class=course>CM Données, intégration, analyse</td>
						<td class=course></td>
						<td></td>
						<td></td>
					</tr>
					<tr id="h7">
						<td class="heure">17:00-18:30</td>
						<td class=course></td>
						<td class=course></td>
						<td class=course></td>
						<td class=course></td>
						<td class=course></td>
						<td></td>
						<td></td>
					</tr>
					<tr id="h8">
						<td class="heure">18:30-20:00</td>
						<td class=course></td>
						<td class=course></td>
						<td class=course></td>
						<td class=course></td>
						<td class=course></td>
						<td></td>
						<td></td>
					</tr>


				</tbody>
			</table>
		</div>

		<div class="div3">
			<button class="button1"
				οnclick=“window.location.href=‘Information.jsp’” type="button"
				id="infos">Informations</button>
		</div>

		<div class="div4">
			<button class="button2"
				οnclick=“window.location.href=‘Recapulatif.jsp’” type="button"
				id="recapulatif">Recapulatif</button>
		</div>
	</div>
=======
	<div class="menu">   
       <ul>    
       	  <li >   
           	   <img src="img/logo-ut1.png" class="logo-ut1"/>   
           </li>     
           <div class="accueil"><li>    
               <a href="webapp.EmploiDuTemps">Accueil</a>     
           </div></li>     
           <li class="cours">
           	 <a href="#">Mes cours</a>    
              <ul>     
                   <li>     
                       <a href="CoursAnnee.jsp">2022-2023</a>     
                   </li>     
                   <li>     
                       <a href="">2021-2022</a>     
                   </li>     
               </ul>           
           </li>  
        
           <div class="compte"><li>
           	 <a href="#">Mon Compte</a>    
              <ul>     
                   <li>     
                       <a href="">Mes informations</a>     
                   </li>     
                   <li>     
                      Déconnextion  
                   </li>     
               </ul>           
           </div></li>     
       </ul>     
   </div>     
   <!-- /menu -->
<div class="parent"> 
	<div class="div1"> 
		
		<h1>Bienvenue de nouveau,</h1>
		<h2>Mes Emploi du Temps</h2>
		<h3>Semestre 1 week : 20/03/2023-26/03/2023</h3>
		
	</div> 
	<div class="div2"> 
		<table border="2" align="center" width="90%" cellpadding="2" cellspacing="2">
  
	    <thead>  
	    		<td>      </td>           
	            <td>Lundi<div class="date">20/03/2023</div></td>
	            <td>Mardi</td>
	            <td>Mercredi</td>
	            <td>Jeudi</td>
	            <td>Vendredi</td>
	            <td>Samedi</td>
	            <td>Dimanche</td>
	                                   
	    </thead>
	    <tbody>
	    
	        <%--boucle de seance --%>
	        <tr>
	          <td class="heure">8:00-9:30</td>
	          <td class=course><a href="url">CM Recueil des besoins Agile</a><div class="salle">ME405</div></td>
	          <td class=course>CM Données, intégration, analyse</td>
	          <td class=course></td>
	          <td class=course>CM Démarche de développement agile</td>
	          <td class=course></td>
	          <td> </td>
	          <td> </td>
	        </tr>
	
			 <tr>
	          <td class="heure">9:30-11:00</td>
	          <td class=course>CM Recueil des besoins Agile</td>
	          <td class=course>CM Recueil des besoins Agile</td>
	          <td class=course></td>
	          <td class=course></td>
	          <td class=course>Francais</td>
	          <td> </td>
	          <td> </td>
	          
	        </tr>
	        
	         <tr>
	          <td class="heure">11:00-12:30</td>
	         <td class=course>CM Recueil des besoins Agile</td>
	          <td class=course>CM Recueil des besoins Agile</td>
	          <td class=course></td>
	          <td class=course>Anglais</td>
	          <td class=course></td>
	          <td> </td>
	          <td> </td>
	        </tr>
	        
	         <tr>
	          <td class="heure">12:30-14:00</td>
	          <td> </td>
	          <td> </td>
	          <td> </td>
	          <td> </td>
	          <td> </td>
	          <td> </td>
	          <td> </td>
	         
	   
	        </tr>
	        
	        <tr>
	          <td class="heure"">14:00-15:30</td>
	          <td class=course>CM Données, intégration, analyse  MC405</td>
	          <td class=course></td>
	          <td class=course></td>
	          <td class=course>CM Démarche de développement agile</td>
	          <td class=course></td>
	          <td> </td>
	          <td> </td>
	        </tr>
	
			 <tr>
	          <td class="heure">15:30-17:00</td>
	          <td class=course></td>
	          <td class=course></td>
	          <td class=course></td>
	          <td class=course>CM Données, intégration, analyse</td>
	          <td class=course></td>
	          <td> </td>
	          <td> </td>
	        </tr>
	        
	         <tr>
	          <td class="heure">17:00-18:30</td>
	          <td class=course></td>
	          <td class=course></td>
	          <td class=course></td>
	          <td class=course></td>
	          <td class=course></td>
	          <td> </td>
	          <td> </td>
	        </tr>
	        
	         <tr>
	          <td class="heure">18:30-20:00</td>
	           <td class=course></td>
	          <td class=course></td>
	          <td class=course></td>
	          <td class=course></td>
	          <td class=course></td>
	          <td> </td>
	          <td> </td>
	          
	        </tr>
	    
	    </tbody>	
    </table>
	</div> 
	
	<div class="div3"> 
		<button class="button1" οnclick=“window.location.href=‘Information.jsp’” type="button" id="infos">Informations</button>
	</div> 
	
	<div class="div4"> 
		<button class="button2" οnclick=“window.location.href=‘Recapulatif.jsp’” type="button" id="recapulatif">Recapulatif</button>
	</div> 
</div>
>>>>>>> branch 'Trinôme' of https://github.com/wwweichennn/ProjetDAI.git
	<%

	%>
	<%
	ServletContext context = this.getServletContext();

	//seance
	//ArrayList<users> listeSeance =new ArrayList<users>();

	//  listeSeance=(List<Seance>)context.getAttribute("CLASSLIST");
	// User u=new User();
	%>
	<%--用表单来打印课表信息--%>
</body>
</html>

