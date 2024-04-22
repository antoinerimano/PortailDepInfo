<!DOCTYPE html>

<html lang="en">
<head>
    <title>ADMIN MENU</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="style/jquery-3.6.4.js"></script>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="./style/style.css">
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
  <h1 class="w3-margin w3-jumbo">Admin Menu</h1>
</header>



<% if( request.getAttribute("result")!=null) { %>
    <center><font color=red> <%=request.getAttribute("name")%>  <%=request.getAttribute("result")%> </font></center>
<%}%>


<!-- First Grid -->
<div class="w3-row-padding w3-padding-64 w3-container">
  <div class="w3-content">
      <a href="ShowAllUser?selectedValue=1">  Voir tout les utilisateurs</a>
  </div>
    <div class="w3-content">
      <a href="ShowAllUser?selectedValue=2">  Voir tout les projets</a>
  </div>
    <div class="w3-content">
      <a href="ShowAllUser?selectedValue=3">  Voir tout les notes de cours</a>
  </div>
</div>

<!-- First Grid -->
<div class="w3-row-padding w3-padding-64 w3-container">
  <div class="w3-content">
      <h1>Ajouter un projet</h1>
      <form action="AddProject" method="POST">
      <div class="form-group">
        <label>Nom du projet</label>
        <input type="text" class="form-control"  name="nomProjet" required>
      </div>
            <div class="form-group">
        <label>Nom du cour</label>
        <input type="text" class="form-control"  name="coursProjet" required>
      </div>
            <div class="form-group">
        <label>Description</label>
        <input type="text" class="form-control"  name="description" required>
      </div>
                  <div class="form-group">
        <label>Date Creation</label>
        <input type="text" class="form-control" name="dateCreation" required>
      </div>
                        <div class="form-group">
        <label>Programme</label>
        <input type="text" class="form-control" name="programme" required>
      </div>
                        <div class="form-group">
        <label>Superviseur</label>
        <input type="text" class="form-control" name="superviseur" required>
      </div>
                             <div class="form-group">
        <label>lienGit</label>
        <input type="text" class="form-control"  name="lienGitProjet" required>
      </div>
                                   <div class="form-group">
        <label>lien Image</label>
        <input type="text" class="form-control"  name="lienImg" required>
      </div>
                                         <div class="form-group">
        <label>Note</label>
        <input type="text" class="form-control"  name="note" required>
      </div>
      <div>
        <label>Code Permanent</label>
        <input type="text" class="form-control" name="codepProjet" required>
      </div>
          <div>
    <button type="submit"> Submit </button>
    </div>
    </form>
  </div>
</div>

<!-- Second Grid -->
<div class="w3-row-padding w3-padding-64 w3-container">
  <div class="w3-content">
        <h1>Ajouter une note de cour</h1>
        <form action="AddNoteCour" method="POST">
        <div class="form-group">
          <label>Nom:  </label>
          <input type="text" class="form-control"  name="nomNote" required>
        </div>
        <div class="form-group">
          <label>Cours: </label>
          <input type="text" class="form-control"  name="coursNote" required>
        </div>
        <div class="form-group">
          <label>Lien git: </label>
          <input type="text" class="form-control"  name="lienGitNote" required>
        </div>

        <div class="form-group">
          <label>Code permanent: </label>
          <input type="number" class="form-control" name="codepNote" required>
        </div>
        <div>
            <button type="submit"> Submit </button>
        </div>
    </form>
  </div>
</div>

<div>
<!-- Third Grid -->
<div class="w3-row-padding w3-padding-64 w3-container">
    <div class="w3-content">
        <h1>Ajouter un Utilisateur</h1>        
            <div>
                <p> Choisir quel type d'utilisateur</p><br />
                <input id='Etudiant' name='selectType' type='radio' value="etudiant" />etudiant
                <br />
                <input id='Professeur' name='selectType' type='radio' value="professeur" />professeur
            </div>
            <!--===========================-->
            <div id = "showEtudiant" style='display:none'>
            <h2>Type etudiant...</h2>
                <form action="AddUtilisateur" method="POST" id = "studentForm">
                    <div class="form-group" >
                        <label>Username: </label>
                        <input type="text" class="form-control"  name="username" required>
                    </div>
                    <div class="form-group">
                        <label>Mot de passe: </label>
                        <input type="password" class="form-control"  name="password" required>
                    </div>

                    <div class="form-group">
                        <label>Type d'utilisateur: </label>
                        <select id="type" name = "typeOfUser">
                            <option value="etudiant" name = "etudiant">Etudiant</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Code permanent: </label>
                        <input type="number" class="form-control" name="codep" required>
                    </div>

                    <!-- Fourth Grid -->
                    <div class="form-group">
                      <label>Nom: </label>
                      <input type="text" class="form-control"  name="nomEtudiant" required>
                    </div>
                    <div class="form-group">
                      <label>Prenom: </label>
                      <input type="text" class="form-control"  name="prenomEtudiant" required>
                    </div>
                    <div class="form-group">
                      <label>Date naissance: </label>
                      <input type="date" name="dateNaissanceEtudiant" required>
                    </div>
                    <div class="form-group">
                        <label>Programme: </label>
                        <select id="program" name = "studentProgram">
                            <option value="programmation" name = "programmation">programmation</option>
                            <option value="reseautique" name = "reseautique">reseautique</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Type etudiant: </label>
                        <select id="typeStudent" name = "studentType">
                            <option value="normal" name = "normal">normal</option>
                            <option value="tuteur" name = "tuteur">tuteur</option>
                            <option value="difficulte" name = "difficulte">difficulte</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Ancien: </label>
                        <select id="ancient" name = "ancientOrNot">
                            <option value="oui" name = "oui">oui</option>
                            <option value="non" name = "non">non</option>
                        </select>
                    </div>
                </form>
            </div>
<!--===========================-->
        <!-- Fifth Grid -->
            <div id = "showProf" style='display:none'>

                <h2>Type professeur...</h2>
                <form action="AddUtilisateur" method="POST" id="profForm">

                    <div class="form-group" >
                        <label>Username: </label>
                        <input type="text" class="form-control"  name="username" required>
                    </div>
                    <div class="form-group">
                        <label>Mot de passe: </label>
                        <input type="password" class="form-control"  name="password" required>
                    </div>

                    <div class="form-group">
                        <label>Type d'utilisateur: </label>
                        <select id="type" name = "typeOfUser">
                            <option value="professeur" name = "professeur">Professeur</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Code permanent: </label>
                        <input type="number" class="form-control" name="codep" required>
                    </div>

                    <div class="form-group">
                      <label>Nom: </label>
                      <input type="text" class="form-control"  name="nomProf" required>
                    </div>
                    <div class="form-group">
                      <label>Prenom: </label>
                      <input type="text" class="form-control"  name="prenomProf" required>
                    </div>
                    <div class="form-group">
                      <label>Date naissance: </label>
                      <input type="date" id="dateNaissance" name="dateNaissanceProf" required>
                    </div>
                </form>
            </div>
            
            <div id = "showBtn" style='display:none'>
                <button type="submit" onclick="submitForms()"> Submit </button>
            </div>
        </div>      
    </div>
</div>



<jsp:include page = "footer.jsp"/>

<script>
    /*
window.onload = function() {
    if (window.jQuery) {  
        // jQuery is loaded  
        alert("Yeah!");
    } else {
        // jQuery is not loaded
        alert("Doesn't Work");
    }
};
*/
</script>
<script>
// Used to toggle the menu on small screens when clicking on the menu button
function myFunction() {
  var x = document.getElementById("navDemo");
  if (x.className.indexOf("w3-show") === -1) {
    x.className += " w3-show";
  } else { 
    x.className = x.className.replace(" w3-show", "");
  }
}

</script>
<script>
$("input[name='selectType']").click(function () {
    $('#showEtudiant').css('display', ($(this).val() === 'etudiant')? 'block':'none');
    $('#showProf').css('display', ($(this).val() === 'professeur')? 'block':'none');
    $('#showBtn').css('display', (($(this).val() === 'professeur')||($(this).val() === 'etudiant'))? 'block':'none');
});
submitForms = function(){
    alert("TEST TO SEE IF EVEN REGISTERED!");
    
    if (document.getElementById('Etudiant').checked) {
        alert("ETUDIANT CHOISI!");
        document.getElementById("studentForm").submit();
    }else if(document.getElementById('Professeur').checked){
        alert("PROFESSEUR CHOISI!");
        document.getElementById("profForm").submit();
    }
};
</script>

</body>
</html>