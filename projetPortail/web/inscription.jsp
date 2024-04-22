<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
<head>
<title>Inscription</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="../style/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
.w3-bar,h1,button {font-family: "Montserrat", sans-serif}
.fa-anchor,.fa-coffee {font-size:200px}
</style>
</head>
<body>

<jsp:include page = "enTete.jsp"/>
<!-- Header -->
<header class="mainimage" style="padding:128px 16px">
  <h1 class="w3-margin w3-jumbo">Inscription</h1>
</header>

<!-- First Grid -->
<div>
    <form id = "inscriptionForm" action="InscriptionServlet" method="post" style="margin: 0 auto; text-align: center;">
        <label>Username:</label><br>
        <input type="text" name="username" required><br>
        <label>Code permanent:</label><br>
        <input type="text" name="codep" required><br>
        <label>Password:</label><br>
        <input type="password" name="password" required><br>
        <label>Confirm Password:</label><br>
        <input type="password" name="confirmPassword" required><br>
        <label>Type de compte:</label><br>
        <select name="typeOfUser">
            <option value="TYPE" selected disabled hidden>Type</option>
            <option value="etudiant" name = "etudiant">Etudiant</option>
            <option value="professeur" name = "professeur">Professeur</option>
        </select><br>
        <div id="etudiant" style="display:none;">
            <label>Nom:</label><br>
            <input type="text" name="nomEtudiant" required><br>
            <label>Prénom:</label><br>
            <input type="text" name="prenomEtudiant" required><br>
            <label>Date de naissance:</label><br>
            <input type="date" name="dateNaissanceEtudiant" required><br>
            <label>Programme: </label><br>
            <select id="program" name = "studentProgram">
                <option value="programmation" name = "programmation">programmation</option>
                <option value="reseautique" name = "reseautique">reseautique</option>
            </select><br>
            <label>Type etudiant: </label><br>
            <select id="typeStudent" name = "studentType">
                <option value="normal" name = "normal">normal</option>
                <option value="tuteur" name = "tuteur">tuteur</option>
                <option value="difficulte" name = "difficulte">difficulte</option>
            </select><br>
            <label>Ancien: </label><br>
            <select id="ancient" name = "ancientOrNot">
                <option value="non" name = "non">non</option>
            </select><br>
        </div>
        <div id="professeur" style="display:none;">
            <label>Nom:</label><br>
            <input type="text" name="nomProf" required><br>
            <label>Prénom:</label><br>
            <input type="text" name="prenomProf" required><br>
            <label>Date de naissance:</label><br>
            <input type="date" name="dateNaissanceProf" required><br>
        </div>
        <div id = "showBtn" >
            <button type="submit" onclick="submitForms()"> S'inscrire </button>
        </div>
    </form>



</div>
    
   


    <script>
        let typeUtilisateur = document.getElementsByName("typeOfUser")[0];
        let etudiantDiv = document.getElementById("etudiant");
        let professeurDiv = document.getElementById("professeur");

        typeUtilisateur.addEventListener("change", function() {
            if (typeUtilisateur.value === "etudiant") {
                etudiantDiv.style.display = "block";
                professeurDiv.style.display = "none";
            } else if (typeUtilisateur.value === "professeur") {
                etudiantDiv.style.display = "none";
                professeurDiv.style.display = "block";
            } else {
                etudiantDiv.style.display = "none";
                professeurDiv.style.display = "none";
            }
        });
        
        submitForms = function(){
            document.getElementById("inscriptionForm").submit();

        };
    </script>

<!-- Footer -->
<jsp:include page = "footer.jsp"/>

<script>
// Used to toggle the menu on small screens when clicking on the menu button
function myFunction() {
  var x = document.getElementById("navDemo");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else { 
    x.className = x.className.replace(" w3-show", "");
  }
}
</script>

</body>
</html>