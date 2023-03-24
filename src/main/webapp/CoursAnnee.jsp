<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/CoursAnneeStyle.css">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Cours par Année_Enseignant</title>
</head>
<body>
	<div class="menu">
		<ul>
			<li><img src="img/logo-ut1.png" class="logo-ut1" /></li>
			<div class="accueil">
				<li><a href="webapp.EmploiDuTemps.jsp">Accueil</a>
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
   <h1>Mes cours  2022-2023</h1>
    <div class="wrapper">
        <div class="search">
            <input type="text" class="inp" placeholder="Rechercher">
            <ul class="btn-list">
                <li class="active" annee='all'>All</li>
                <li semestre='s1'>Semestre 1</li>
                <li semestre='s2'>Semestre 2</li>
            </ul>
        </div> 
        
	    <div class="cours">
	     <ul>
	         <li><a href="InfosCours.jsp">Agile</a></li>
	         <li><a href="">BPMN</a></li>
	         <li><a href="">Anglais</a></li>
	         
	     </ul>
		</div>
	</div>
   
</body>
</html>