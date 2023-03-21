<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="metier.Etudiant" %>    
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vérifier les justificatifs</title>
</head>

<body>
	<!-- Recupérer la liste des etudiants absents -->
	<%List<Etudiant> etudiants = (List<Etudiant>) request.getAttribute("CtrlAfficherEtuAbs"); %>
	<h1>Promotion : <% etudiants.get(0).getParcour(); %></h1>
	<table>
    <thead>
        <tr>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Justificatif</th>
            <th>Decision</th>
        </tr>
    </thead>
    <tbody>
        <% for (Etudiant etu : etudiants) { %>
            <tr>
                <td><%= etu.getNom() %></td>
                <td><%= etu.getPrenom() %></td>
                <td><%=etu.getJustificatifs() %>
                <td> <button>Choix</button> </td>
            </tr>
        <% } %>
    </tbody>
</table>
</body>
</html>