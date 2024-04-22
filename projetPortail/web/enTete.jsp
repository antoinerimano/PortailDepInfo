<%-- 
    Document   : enTete
    Created on : 2023-03-28, 23:23:18
    Author     : Nini
--%>
<%-- 
    Document   : enTete
    Created on : 2 avr. 2023, 00 h 41 min 19 s
    Author     : 15146
--%>
<%
    //HttpSession session = request.getSession(false);
    boolean isConnected = (session != null && session.getAttribute("type") != null);
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>En tete</title>
        <style>
        body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
        .w3-bar,h1,button {font-family: "Montserrat", sans-serif}
        .fa-anchor,.fa-coffee {font-size:200px}
        .right{
            float:right;
        }
        </style>
    </head>
    <body>
        <!-- Navbar -->
        <div class="w3-top">
          <div class="w3-bar w3-blue w3-card w3-left-align w3-large">
            <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-text-white" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
            <a href="accueil.jsp" class="w3-bar-item w3-button w3-padding-large w3-white">Accueil</a>
            <a href="ProjetController?selectedValue=1" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Projet</a>
            <a href="NoteController" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Notes</a>
            
            <% if (isConnected) { %>
            <a href="ProfileController" class="w3-button w3-hide-small w3-padding-large w3-hover-white right">Mon profile</a>
            <a href="DeconnexionController" class="w3-button w3-hide-small w3-padding-large w3-hover-white right">Deconnexion</a>
            <% } else { %>
            <a href="connexion.jsp" class="w3-button w3-hide-small w3-padding-large w3-hover-white right">Connexion</a>
            <a href="inscription.jsp" class="w3-bar-item w3-button w3-padding-large">S'inscrire</a>
             <% } %>
            
            <a href="admin.jsp" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Admin</a>
            <a href ="search.jsp" class="w3-bar-item w3-button w3-padding-large">Rechercher</a>
          </div>

          <!-- Navbar on small screens -->
          <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
            <a href="accueil.jsp" class="w3-bar-item w3-button w3-padding-large">Accueil</a>
            <a href="ProjetController?selectedValue=1" class="w3-bar-item w3-button w3-padding-large">Projet</a>
            <a href="NoteController" class="w3-bar-item w3-button w3-padding-large">Notes</a>
            
            <% if (isConnected) { %>
            <a href="DeconnexionController" class="w3-bar-item w3-button w3-padding-large">Deconnexion</a>
            <% } else { %>
            <a href="connexion.jsp" class="w3-bar-item w3-button w3-padding-large">Connexion</a>
            <a href="inscription.jsp" class="w3-bar-item w3-button w3-padding-large">S'inscrire</a>
            <% } %>
            
            <a href="admin.jsp" class="w3-bar-item w3-button w3-padding-large">Admin</a>
            <a href ="search.jsp" class="w3-bar-item w3-button w3-padding-large">Rechercher</a>
          </div>
        </div>
    </body>
</html>
