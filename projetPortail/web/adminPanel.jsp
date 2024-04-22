<%@page import="com.ourproject.portail.model.entities.NoteCours"%>
<%@page import="com.ourproject.portail.model.entities.Projet"%>
<%@page import="com.ourproject.portail.model.entities.Professeur"%>
<%@page import="com.ourproject.portail.model.entities.Etudiant"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ourproject.portail.model.entities.Utilisateur"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
<title>Projets</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<%  
    String choosenVal = (String)request.getAttribute("val");
    
    ArrayList<Utilisateur> listeUtilisateur = (ArrayList)request.getAttribute("listeUtilisateur");
    ArrayList<Projet> lstProjets = (ArrayList)request.getAttribute("listeProjet");
    ArrayList<NoteCours> lstNotes = (ArrayList)request.getAttribute("listeNote");
    
%>
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
  <h1 class="w3-margin w3-jumbo">Admin Panel</h1>
</header>
<!-- return btn-->
<div class="w3-row-padding w3-padding-64 w3-container">
  <div class="w3-content">
        <div class="search-container">
            <form action="adminMenu.jsp">
                <button type="submit">Retour</button>
            </form>
        </div>
  </div>
</div>
<!-- First Grid -->
<div class="w3-row-padding w3-padding-64 w3-container">
    
    <div class="w3-content">
        <table class="w3-table">
        <% if (choosenVal.equals("1")){%>
        <div>
            <form action=SuppUser method="POST">
                <input name="id"> Entrer le code P de la personne à supprimer
                <button type="submit">Submit</button>
            </form>
        </div>
        <br>
        <th>Nom Utilisateur: </th>
        <th>Mot de Passe: </th>
        <th>Type: </th>
        <th>Code P: </th>
        <%
            for (Utilisateur util : listeUtilisateur){%>
            <tr>
            <td> <%=util.getNomUtilisateur() %> </td>
            <td> <%=util.getMotDePasse() %> </td>
            <td> <%=util.getType() %> </td>
            <td> <%=util.getCodeP() %> </td>
            </tr>               
            <%}%>
        <%}else if(choosenVal.equals("2")){%>
        <div>
            <form action=SuppProjet method="POST">
                <input name="id"> Entrer le code P du projet à supprimer
                <button type="submit">Submit</button>
            </form>
        </div>
        <br>
        <th>Nom: </th>
        <th>Cour: </th>
        <th>Description: </th>
        <th>Date Creation: </th>
        <th>Programme: </th>
        <th>Superviseur: </th>
        <th>Lien Git: </th>
        <th>Lien img: </th>
        <th>Note attribue: </th>
        <th>CodeP: </th>
        <%
            for (Projet proj : lstProjets){%>
            <tr>
            <td> <%=proj.getNomProjet()%> </td>
            <td> <%=proj.getNomCour()%> </td>
            <td> <%=proj.getDescription()%> </td>
            <td> <%=proj.getDateDeCreation()%> </td>
            <td> <%=proj.getProfilProgramme()%> </td>
            <td> <%=proj.getProfesseurSuperviseur()%> </td>
            <td> <%=proj.getLien()%> </td>
            <td> <%=proj.getLienImg()%> </td>
            <td> <%=proj.getNote()%> </td>
            <td> <%=proj.getCodeP()%> </td>
            </tr> 
            <%}%>
            
        <%}else if(choosenVal.equals("3")){%>
        <div>
            <form action=SuppNote method="POST">
                <input name="id"> Entrer le code P de la noteCour à supprimer
                <button type="submit">Submit</button>
            </form>
        </div>
        <br>
        <th>Nom: </th>
        <th>Cour: </th>
        <th>Lien Git: </th>
        <th>CodeP: </th>
        <%
            for (NoteCours note : lstNotes){%>
            <tr>
            <td> <%=note.getNomNoteCour()%> </td>
            <td> <%=note.getCodeCour()%> </td>
            <td> <%=note.getLien()%> </td>
            <td> <%=note.getCodeP()%> </td>
            </tr> 
            <%}%>
        
        <%}%>
        </table>
    </div>
        
        
        
</div>

<!-- Second Grid -->

<div class="w3-container w3-black w3-center w3-opacity w3-padding-64">
    <h1 class="w3-margin w3-xlarge">Bienvenue sur la page des projets</h1>
</div>

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
