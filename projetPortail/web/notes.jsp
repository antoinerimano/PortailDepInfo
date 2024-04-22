<%@page import="com.ourproject.portail.model.entities.NoteCours"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  
    ArrayList<NoteCours> lstNote = (ArrayList)request.getAttribute("listeNote");
    
%>
<html lang="en">
<head>
<title>Notes</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
  <h1 class="w3-margin w3-jumbo">Notes</h1>
</header>

<!-- First Grid -->
<div class="w3-row-padding w3-padding-64 w3-container">
          <table class="w3-table">
          <tr>
            <th>Nom: </th>
            <th>Cour: </th>
            <th>Lien Git: </th>
            <th>CodeP: </th>
            </tr>
            <% for (NoteCours note : lstNote){   %>
               <tr>
        <td> <%=note.getNomNoteCour()%> </td>
        <td> <%=note.getCodeCour()%> </td>
        <td> <%=note.getLien()%> </td>
        <td> <%=note.getCodeP()%> </td>
               </tr>
               
               <%}%>
      </table>
</div>

<!-- Second Grid -->

<div class="w3-container w3-black w3-center w3-opacity w3-padding-64">
    <h1 class="w3-margin w3-xlarge">Bienvenue sur la page des Notes</h1>
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