<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String r=(String)request.getAttribute("msg_photo");
out.println(r);
String filePath = "uploads/23fa4f782100379cf5aa4be0f32bedcd.png";
%>
<img src="<%=filePath%>">

</body>
</html>