<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil_Enseignant</title>
</head>
<body>
<h1>Bienvenue de nouveau<s:property value="属性名"/></h1>
	<%
	
	%>
    <%
              ServletContext context = this.getServletContext(); 
             
              //seance
               List<user> listeSeance =new ArrayList<Seance>();
                        
               listeSeance=(List<Seance>)context.getAttribute("CLASSLIST");
              User u=new User();
     %>
     <%--用表单来打印课表信息--%>
<table border="2" align="center" width="90%" cellpadding="2" cellspacing="2">
    <caption><h2><%u.getValuesemeter();%>学期<%u.getValueclasscode(); %>Mes emploi du temps</h2></caption>
    <thead>  
    		<td>      </td>           
            <td>Lundi</td>
            <td>Mardi</td>
            <td>Mercredi</td>
            <td>Jeudi</td>
            <td>Vendredi</td>
            <td>Samedi</td>
            <td>Dimanche</td>
                                   
    </thead>
    <tbody>
    <%for(Seance s:listeSeance){ %>
        <%--boucle de seance --%>
        <tr>
        <td><%=s.getheuredebut() %></td>
        <td><%=s.getOne() %></td>
        <td><%=s.getTwo() %></td>
        <td><%=s.getThree() %></td>
        <td><%=s.getFour() %></td>
        <td><%=s.getFive() %></td>
        <td><%=s.getSix()%></td>
        <td><%=s.getSeven()%></td>
    
        </tr>
    <%} %>
    </tbody>
    </table>
</body>
</html>