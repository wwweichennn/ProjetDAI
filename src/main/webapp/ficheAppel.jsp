<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fiche d'Appel</title>
<link rel="stylesheet" type="text/css" href="css/ficheAppel.css">

</head>
<body>
<div class="element">
<br/>
<h1 class="titre">Fiche d'appel pour le cours DAI</h1>
<ul class="appel">
  <li class="appel-item">

    <img src="imgStudent/1.jpg" alt="Photo de l'étudiant 1" class="imge" id="img1">
  
    <h3>Nom de l'étudiant 1</h3>
    <span class="formation">FA</span>
    <span class="present" id="text1">n'a pas été appelé</span>
  </li>
  <li class="appel-item">

    <img src="imgStudent/2.jpg" alt="Photo de l'étudiant 2" class="imge" id="img2">
  
    <h3>Nom de l'étudiant 2</h3>
    <span class="formation">FA</span>
    <span class="present" id="text2">n'a pas été appelé</span>
  </li>
  <li class="appel-item">

    <img src="imgStudent/3.jpg" alt="Photo de l'étudiant 3" class="imge" id="img3">
   
    <h3>Nom de l'étudiant 3</h3>
    <span class="formation">FI</span>
    <span class="present" id="text3">n'a pas été appelé</span>
  </li>
    <li class="appel-item">

    <img src="imgStudent/4.jpg" alt="Photo de l'étudiant 1" class="imge" id="img4">
  
    <h3>Nom de l'étudiant 4</h3>
    <span class="formation">FI</span>
    <span class="present" id="text4">n'a pas été appelé</span>
  </li>
    <li class="appel-item">

    <img src="imgStudent/5.jpg" alt="Photo de l'étudiant 1" class="imge" id="img5">

    <h3>Nom de l'étudiant 5</h3>
    <span class="formation">FI</span>
    <span class="present" id="text5">n'a pas été appelé</span>
  </li>
    <li class="appel-item">
  
    <img src="imgStudent/6.jpg" alt="Photo de l'étudiant 1" class="imge" id="img6">
  
    <h3>Nom de l'étudiant 6</h3>
    <span class="formation">FA</span>
    <span class="present" id="text6">n'a pas été appelé</span>
  </li>
    <li class="appel-item">
  
    <img src="imgStudent/7.jpg" alt="Photo de l'étudiant 1" class="imge" id="img7">
   
    <h3>Nom de l'étudiant 7</h3>
    <span class="formation">FA</span>
    <span class="present" id="text7">n'a pas été appelé</span>
  </li>
    <li class="appel-item">
  
    <img src="imgStudent/8.png" alt="Photo de l'étudiant 1" class="imge" id="img8">

    <h3>Nom de l'étudiant 8</h3>
    <span class="formation">FA</span>
    <span class="present" id="text8">n'a pas été appelé</span>
  </li>
    <li class="appel-item">
  
    <img src="imgStudent/9.jpg" alt="Photo de l'étudiant 1" class="imge" id="img9">
     
    <h3>Nom de l'étudiant 9</h3>
    <span class="formation">FI</span>
    <span class="present" id="text9">n'a pas été appelé</span>
  </li>
      <li class="appel-item">
    <img src="imgStudent/10.jpg" alt="Photo de l'étudiant 10" class="imge" id="img10">
    <h3>Nom de l'étudiant 10</h3>
    <span class="formation">FI</span>
    <span class="present" id="text10">n'a pas été appelé</span>
  </li>
</ul>
<input type="submit" class="btn" value="Enregistrer">
<input type="submit" class="btn" value="Valider">
<br/>
</div>
<script>
const data = [
	  { imageId: "img1", textId: "text1" },
	  { imageId: "img2", textId: "text2" },
	  { imageId: "img3", textId: "text3" },
	  { imageId: "img4", textId: "text4" },
	  { imageId: "img5", textId: "text5" },
	  { imageId: "img6", textId: "text6" },
	  { imageId: "img7", textId: "text7" },
	  { imageId: "img8", textId: "text8" },
	  { imageId: "img9", textId: "text9" },
	  { imageId: "img10", textId: "text10" }
	]; 

	data.forEach(function(item) {
	  const image = document.getElementById(item.imageId); 
	  const text = document.getElementById(item.textId); 
	  let index = 0;
	  const colors = ["green","red","orange"]; 
	  const captions = ["Present", "Absent", "Retard"]; 

	  image.addEventListener("click", function() {
	    image.style.borderColor = colors[index % colors.length]; 
	    text.innerHTML = captions[index % captions.length];
	    index++; 
	  });
	});
</script>
</body>
</html>