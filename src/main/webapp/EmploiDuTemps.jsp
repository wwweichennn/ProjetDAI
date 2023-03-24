<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/EmploiStyle.css">
<script type="text/JavaScript" src="js/Fct_planning.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Accueil_Enseignant</title>
<script>
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
			document.getElementById("date" + i).innerHTML = dayOfWeek ;
			document.getElementById("jour" + i).innerHTML =date.toLocaleDateString();
		}
	}
</script>

</head>
<body>
	<%

	%>
	<!-- menu -->
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

			<h1>Bienvenue de nouveau, ${requestScope.nom}</h1>
			<h2 id="ide">${requestScope.id}</h2>

			<h2>Mes Emploi du Temps</h2>
			<h3>Semestre :<span id="dee"></span> - <span id="aa"></span></h3>

		</div>
		<div class="div2">
			<table border="2" align="center" width="90%" cellpadding="2"
				cellspacing="2">

				<thead>
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
<tr>
<td></td>

					<td id="jour0"><div></div></td>
					<td id="jour1"><div></div></td>
					<td id="jour2"><div></div></td>
					<td id="jour3"><div></div></td>
					<td id="jour4"><div></div></td>
					<td id="jour5"><div></div></td>
					<td id="jour6"><div></div></td>

</tr>
					<%--boucle de seance --%>
					<tr>
						<td class="heure" id="h1">8:00-9:30</td>
						<%
						for (int i = 0; i < 7; i++) {
							out.println("<td class=course id='d" + i + "'></td>");
						}
						%>

					</tr>
					<tr >
						<td class="heure" id="h2">9:30-11:00</td>
						<%
						for (int i = 0; i < 7; i++) {
							out.println("<td class=course id='d" + i + "'></td>");
						}
						%>
					</tr>
					<tr >
						<td class="heure" id="h3">11:00-12:30</td>
						<%
						for (int i = 0; i < 7; i++) {
							out.println("<td class=course id='d" + i + "'></td>");
						}
						%>
					</tr>
					<tr>
						<td class="heure" id="h4">12:30-14:00</td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td class="heure" id="h5">14:00-15:30</td>
						<%
						for (int i = 0; i < 7; i++) {
							out.println("<td class=course id='d" + i + "'></td>");
						}
						%>
					</tr>
					<tr>
						<td class="heure" id="h6">15:30-17:00</td>
						<%
						for (int i = 0; i < 7; i++) {
							out.println("<td class=course id='d" + i + "'></td>");
						}
						%>
					</tr>
					<tr>
						<td class="heure" id="h7">17:00-18:30</td>
						<%
						for (int i = 0; i < 7; i++) {
							out.println("<td class=course id='d" + i + "'></td>");
						}
						%>
					</tr>
					<tr>
						<td class="heure" id="h8">18:30-20:00</td>
						<%
						for (int i = 0; i < 7; i++) {
							out.println("<td class=course id='d" + i + "'></td>");
						}
						%>
					</tr>


				</tbody>
			</table>
		</div>

		<div class="div3">
			<button class="button1"
				οnclick=“window.location.href=‘Information.jsp’” type="button"
				id="infos">Informations</button>
		</div>
		
	<div class="div3">
			<button class="button1"
				οnclick="afficher()" type="button"
				id="afficher">afficher</button>
		</div>

		<div class="div4">
			<button class="button2"
				οnclick=“window.location.href=‘Recapulatif.jsp’” type="button"
				id="recapulatif">Recapulatif</button>
		</div>
	</div>

</body>
</html>