<%@ page import="java.util.List" %>
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
        <link rel="stylesheet" href="style/style.css">
    <style>
        body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
        .w3-bar,h1,button {font-family: "Montserrat", sans-serif}
        .fa-anchor,.fa-coffee {font-size:200px}
        .search-container{display:flex;flex-direction: row; align-items: center;}
        
    </style>
</head>

    <body>
        <jsp:include page = "enTete.jsp"/>
        <!-- Header -->
        <header class="mainimage" style="padding:128px 16px">
          <h1 class="w3-margin w3-jumbo">Rechercher</h1>
        </header>

        <!-- search bar -->
        
        <div class="w3-row-padding w3-padding-64 w3-container">
          <div class="w3-content">
                <div class="search-container">
                    <form action="SearchController" method="get">
                        <input type="text" name="result" placeholder="Search.." required>
                        <br/>
                        <button type="submit">Rechercher</button>
                    </form>
                </div>
          </div>
        </div>

        <jsp:include page = "footer.jsp"/>
        
    </body>
</html>
