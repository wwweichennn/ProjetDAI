<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="metier.Etudiant" %>
<%@page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <h1>Liste des étudiants non valides de la promotion <%= request.getParameter("type_promo") %></h1>
    
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
                for (Etudiant etudiant : (ArrayList<Etudiant>) request.getAttribute("etudiants")) {
            %>
                <tr>
                    <td><%= etudiant.getNom() %></td>
                    <td><%= etudiant.getPrenom() %></td>
                    <td><%-- <%= etudiant.getJustificatif().getMotif() %> --%></td>
                    <td><button>Valider</button></td>
                </tr>
            <% } %>
        </tbody>
    </table>

</body>
</html>