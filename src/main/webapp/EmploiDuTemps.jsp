<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/EmploiStyle.css">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Accueil_Enseignant</title>
</head>
<body>
	<!-- menu -->
	<div class="menu">   
       <ul>    
       	  <li >   
           	   <img src="img/logo-ut1.png" class="logo-ut1"/>   
           </li>     
           <div class="accueil"><li>    
               <a href="webapp.EmploiDuTemps">Accueil</a>     
           </div></li>     
           <li class="cours">
           	 <a href="#">Mes cours</a>    
              <ul>     
                   <li>     
                       <a href="">2022-2023</a>     
                   </li>     
                   <li>     
                       <a href="">2021-2022</a>     
                   </li>     
               </ul>           
           </li>  
        
           <div class="compte"><li>
           	 <a href="#">Mon Compte</a>    
              <ul>     
                   <li>     
                       <a href="">Mes informations</a>     
                   </li>     
                   <li>     
                      Déconnextion  
                   </li>     
               </ul>           
           </div></li>     
       </ul>     
   </div>     
   <!-- /menu -->
<div class="parent"> 
	<div class="div1"> 
		
		<h1>Bienvenue de nouveau,</h1>
		<h2>Mes Emploi du Temps</h2>
		<h3>Semestre 1 week : 20/03/2023-26/03/2023</h3>
	</div> 
	
	<div class="div2"> 
		<table border="2" align="center" width="90%" cellpadding="2" cellspacing="2">
  
	    <thead>  
	    		<td>      </td>           
	            <td>Lundi<div class="date">20/03/2023</div></td>
	            <td>Mardi</td>
	            <td>Mercredi</td>
	            <td>Jeudi</td>
	            <td>Vendredi</td>
	            <td>Samedi</td>
	            <td>Dimanche</td>
	                                   
	    </thead>
	    <tbody>
	    
	        <%--boucle de seance --%>
	        <tr>
	          <td class="heure">8:00-9:30</td>
	          <td class=course><a href="url">CM Recueil des besoins Agile</a><div class="salle">ME405</div></td>
	          <td class=course>CM Données, intégration, analyse</td>
	          <td class=course></td>
	          <td class=course>CM Démarche de développement agile</td>
	          <td class=course></td>
	          <td> </td>
	          <td> </td>
	        </tr>
	
			 <tr>
	          <td class="heure">9:30-11:00</td>
	          <td class=course>CM Recueil des besoins Agile</td>
	          <td class=course>CM Recueil des besoins Agile</td>
	          <td class=course></td>
	          <td class=course></td>
	          <td class=course>Francais</td>
	          <td> </td>
	          <td> </td>
	          
	        </tr>
	        
	         <tr>
	          <td class="heure">11:00-12:30</td>
	         <td class=course>CM Recueil des besoins Agile</td>
	          <td class=course>CM Recueil des besoins Agile</td>
	          <td class=course></td>
	          <td class=course>Anglais</td>
	          <td class=course></td>
	          <td> </td>
	          <td> </td>
	        </tr>
	        
	         <tr>
	          <td class="heure">12:30-14:00</td>
	          <td> </td>
	          <td> </td>
	          <td> </td>
	          <td> </td>
	          <td> </td>
	          <td> </td>
	          <td> </td>
	         
	   
	        </tr>
	        
	        <tr>
	          <td class="heure"">14:00-15:30</td>
	          <td class=course>CM Données, intégration, analyse  MC405</td>
	          <td class=course></td>
	          <td class=course></td>
	          <td class=course>CM Démarche de développement agile</td>
	          <td class=course></td>
	          <td> </td>
	          <td> </td>
	        </tr>
	
			 <tr>
	          <td class="heure">15:30-17:00</td>
	          <td class=course></td>
	          <td class=course></td>
	          <td class=course></td>
	          <td class=course>CM Données, intégration, analyse</td>
	          <td class=course></td>
	          <td> </td>
	          <td> </td>
	        </tr>
	        
	         <tr>
	          <td class="heure">17:00-18:30</td>
	          <td class=course></td>
	          <td class=course></td>
	          <td class=course></td>
	          <td class=course></td>
	          <td class=course></td>
	          <td> </td>
	          <td> </td>
	        </tr>
	        
	         <tr>
	          <td class="heure">18:30-20:00</td>
	           <td class=course></td>
	          <td class=course></td>
	          <td class=course></td>
	          <td class=course></td>
	          <td class=course></td>
	          <td> </td>
	          <td> </td>
	          
	        </tr>
	    
	    </tbody>	
    </table>
	</div> 
	
	<div class="div3"> 
		<button class="button1" οnclick=“window.location.href=‘Information.jsp’” type="button" id="infos">Informations</button>
	</div> 
	
	<div class="div4"> 
		<button class="button2" οnclick=“window.location.href=‘Recapulatif.jsp’” type="button" id="recapulatif">Recapulatif</button>
	</div> 
</div>
	<%
	
	%>
    <%
              ServletContext context = this.getServletContext(); 
             
              //seance
               //ArrayList<users> listeSeance =new ArrayList<users>();
                        
             //  listeSeance=(List<Seance>)context.getAttribute("CLASSLIST");
             // User u=new User();
     %>
     <%--用表单来打印课表信息--%>


</body>
</html>