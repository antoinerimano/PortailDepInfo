<%@page import="com.ourproject.portail.model.entities.Etudiant"%>
<%@page import="com.ourproject.portail.model.entities.NoteCours"%>
<%@page import="com.ourproject.portail.model.entities.Projet"%>
<%@page import="com.ourproject.portail.model.dao.UtilisateurDAO"%>
<%@page import="com.ourproject.portail.model.entities.Utilisateur"%>
<%@page import="java.util.ArrayList" %>
<%
    
   String retour = (String)request.getAttribute("typeRetour");
   
   ArrayList<Utilisateur> result = (ArrayList)request.getAttribute("resultatRetour");
   ArrayList<Projet> resultP = (ArrayList)request.getAttribute("resultatRetour");
   ArrayList<NoteCours> resultN = (ArrayList)request.getAttribute("resultatRetour");
   
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html lang="en">
    <head>
        <title>Recherche</title>
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
          <h1 class="w3-margin w3-jumbo">Rechercher</h1>
        </header>

        <!-- return btn-->
        <div class="w3-row-padding w3-padding-64 w3-container">
          <div class="w3-content">
                <div class="search-container">
                    <form action="SearchController">
                        <button type="submit">Retour</button>
                    </form>
                </div>
          </div>
        </div>
        
        
        <!-- shown result-->
        <div class="w3-row-padding w3-padding-64 w3-container">
          <div class="w3-content">
              <h5>Vous avez cherche quelque chose de type:<%=retour%></h5>
              <%if (retour.equals("user")){%>
                <table>
                  <tr>
                  <th>Username:</th> 
                  <th>Type:</th>
                  <th>CodeP:</th>
                  </tr>
                  <% for (Utilisateur user : result){%>
                <tr>
                    <td><%=user.getNomUtilisateur()%></td>
                    <td><%=user.getType()%></td>
                    <td><%=user.getCodeP()%></td>
                </tr>
                <%}%>
                </table>
                <%}else if(retour.equals("projet")){%>
                    <table>
                      <tr>
                      <th>Titre:</th> 
                      <th>Cour:</th>
                      <th>CodeP:</th>
                      </tr>
                      <% for (Projet proj : resultP){%>
                    <tr>
                        <td><%=proj.getNomProjet()%></td>
                        <td><%=proj.getNomCour()%></td>
                        <td><%=proj.getCodeP()%></td>
                    </tr>
                    <%}%>
                    </table>
                <%}else if(retour.equals("note")){%>
                <table>
                        <tr>
                        <th>Titre:</th> 
                        <th>Cour:</th>
                        <th>CodeP:</th>
                        </tr>
                        <% for (NoteCours note : resultN){%>
                    <tr>
                        <td><%=note.getNomNoteCour()%></td>
                        <td><%=note.getCodeCour()%></td>
                        <td><%=note.getCodeP()%></td>
                    </tr>
                    <%}%>
                    </table>
                <%}%>
                
          </div>
        </div>

        <jsp:include page = "footer.jsp"/>
        
    </body>
</html>
