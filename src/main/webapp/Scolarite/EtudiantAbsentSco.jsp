<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="metier.Utilisateurs"  %>
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Etudiants absents</title>
</head>
<body>
	<h1>Etudiants absents</h1>
	
	<%List<Utilisateurs> etudiants =  (List<Utilisateurs>)request.getAttribute("CtrlAfficherEtuAbs");  %>
	
	<table>
		<thead>
			<tr> 
				<th> <h1>Titre du parcours : <%= etudiants.get(0).getId() %> </h1></tr>
			<tr>
				<th> Nom</th>
				<th> Prénom</th>
				<th> Justificatif </th>
				<th> Justificatif </th>
				<th> Choix </th> <!-- Le choix sera un bouton où, comme les photos pour les présences, change lorsque l'on clique dessus -->
			</tr>
		</thead>
		<tbody>
			<tr>
			<% for (Utilisateurs etu : etudiants) { %>
				<td><%= etu.getNom() %></td>
				<td><%= etu.getPrenom() %></td>
				<td> </td>
				<td><button>Décision</button> </td>
			</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>