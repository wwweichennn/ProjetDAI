<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="metier.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>
		Etudiants de 
		<%= request.getParameter("type_promo") %></h1>

	<table border="1">
		<thead>
			<tr>
				<th>Nom</th>
				<th>Prénom</th>
				<th>Motif d'absence</th>
				<th>Valider</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<Object> listeAbs = (List<Object>) request.getAttribute("listeAbs");
			            for (Object obj : listeAbs) {
			                    if (obj instanceof Users) {
			                    	 Users etudiant = (Users) obj;
			                    	
			//                 for (Utilisateurs etudiant : (ArrayList<Utilisateurs>) request.getAttribute("listeAbs"))
			%>
			<tr>
				<td><%= etudiant.getNom() %></td>
				<td><%= etudiant.getPrenom() %></td>
				<td>
					<%-- <%= etudiant.getJustificatif().getMotif() %> --%>
				</td>
				<td><button>Valider</button></td>
			</tr>
			<% } }%>
		</tbody>
	</table>

</body>
</html>