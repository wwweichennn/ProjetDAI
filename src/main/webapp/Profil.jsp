<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta name="description" content="Name of your web site">
<meta name="author" content="Marketify">

<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<title>Resumify | Resume</title>

<link href="https://fonts.googleapis.com/css?family=Lato:300,300i,400,400i,700,700i&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700&display=swap" rel="stylesheet">

<!-- STYLES -->
<link rel="stylesheet" type="text/css" href="css/plugins.css" />
<link rel="stylesheet" type="text/css" href="css/styleprofile.css" />
<title>Insert title here</title>

</head>
<body>
	<!-- WRAPPER ALL -->
	<div class="resumify_tm_leftpart">
		<div class="inner_wrap">
			<div class="bottom_parts">
				<span class="wing"></span>
				<div class="ddd">
					<div class="author_image">
						<div class="image_inner">			
						</div>
						<img src="img/2.jpg">
					</div>
					<div class="details_wrap">
						<div class="details_inner">
							<h3 class="name">Zhibo XIE</h3>
							<div class="short_info">
								<a href="#">zhibo.xie@ut-capitole.fr</a>
								<p>06 73 57 67 32</p>
							</div>
							<div class="resumify_tm_button" data-position="center">
								<a href=""> Retour </a>
							</div>
						</div>
					</div>
				</div>
				<div class="fff"></div>
			</div>
		</div>
	</div>

<div class="resumify_tm_rightpart">
		<!-- /LOADER -->
				<div class="container">
						<div class="resume_wrap">
							<div class="leftpart">
								<div class="info_box_wrap">
									<div class="title">
										<span class="main">Informations personnelles :  </span>
									</div>
									<div class="times_list">
										<ul>
											<li><p><span>Nom : </span>Zhibo</p></li>
											<li><p><span>Prenom : </span>XIE</p></li>
											<li><p><span>sexe : </span>Monsieur</p></li>
											<li><p><span>Date Naissance : </span>04/04/1998</p></li>																
											<li><p><span>Email :</span>zhibo.xie@ut-capitole.fr</p></li>
											<li><p><span>Email supplement : </span>xiezhibo0@gmail.com</p></li>							
										</ul>
											</br>
											<form action="UploadServlet" method="post" enctype="multipart/form-data">	
											<input type="file" name="file" />
											<input type="submit" value="Upload" />							
											</form>
									</div>
								</div>
							</div>
						</div>
				</div>
		</div>
<!-- / WRAPPER ALL -->

<!-- SCRIPTS -->
<script src="js/jquery.js"></script>
<!--[if lt IE 10]> <script type="text/javascript" src="js/ie8.js"></script> <![endif]-->	
<script src="js/plugins.js"></script>
<script src="js/init.js"></script>
<!-- /SCRIPTS -->



</body>
</html>