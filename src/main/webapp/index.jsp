<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>login</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
	<script src="https://kit.fontawesome.com/a81368914c.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<%
        String email_Erreur = request.getAttribute("email_error") == null ? "" : (String) request.getAttribute("email_error");
        String password_Erreur = request.getAttribute("password_error") == null ? "" : (String) request.getAttribute("password_error");
        String generale_Erreur = request.getAttribute("generale_error") == null ? "" : (String) request.getAttribute("generale_error");
    %>
	<img class="wave" src="img/wave.png">
	<div class="container">
		<div class="img">
			<img src="img/bg.svg">
		</div>
		<div class="login-content">
			<form method="get" action="centrale">
				<img src="img/ut1.png">
				<h2 class="title">Bienvenue</h2>
           		<div class="input-div one">
           		   <div class="i">
           		   		<i class="fas fa-user"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>Email</h5>
           		   		<input type="email" class="input"  name="email">
           		   </div>
           		</div>
           		<div class="input-div pass">
           		   <div class="i"> 
           		    	<i class="fas fa-lock"></i>
           		   </div>
           		   <div class="div">
           		    	<h5>Password</h5>
           		    	<input type="password" class="input" name="password">
            	   </div>
            	   <%= email_Erreur %>
            	   <%= password_Erreur %>
            	   <%= generale_Erreur %>
            	</div>
            	<br/>
            
      			<br/>
            	<a href="#">forget password?</a>
            	<input type="submit" class="btn" value="login" >
            </form>
        </div>
    </div>
    <script type="text/javascript" src="js/main.js"></script>
</body>
</html>