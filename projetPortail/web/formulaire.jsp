<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <title>Inscription</title>
  <!-- liens vers CSS -->
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./style/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  <!-- A implementer plus tard -->
</head>
<body>
  <jsp:include page = "enTete.jsp"/>
  <header class="mainimage" style="padding:128px 16px">
  <h1 class="w3-margin w3-jumbo">Inscription</h1>
</header>
  <div class="container">
    <form action="inscription.php" method="POST">
      <div class="form-group">
        <label for="username">Nom d'utilisateur</label>
        <input type="text" class="form-control" id="username" name="username" required>
      </div>
      <div class="form-group">
        <label for="password">Mot de passe</label>
        <input type="password" class="form-control" id="password" name="password" required>
      </div>
      <div class="form-group">
        <label for="type">Type d'utilisateur</label>
        <select class="form-control" id="type" name="type">
          <option value="etudiant">Etudiant</option>
          <option value="professeur">Professeur</option>
          <option value="administrateur">Administrateur</option>
        </select>
      </div>
      <div class="form-group">
        <label for="codeP">Code Permanent</label>
        <input type="text" class="form-control" id="codeP" name="codeP">
      </div>
      <div class="form-group">
        <label for="nom">Nom</label>
        <input type="text" class="form-control" id="nom" name="nom" required>
      </div>
      <div class="form-group">
        <label for="prenom">Prenom</label>
        <input type="text" class="form-control" id="prenom" name="prenom" required>
      </div>
      <div class="form-group">
        <label for="datenaissance">Date de naissance</label>
        <input type="date" class="form-control" id="datenaissance" name="datenaissance">
      </div>
      <button type="submit" class="btn btn-primary">S'inscrire</button>
    </form>
  </div>
  <jsp:include page = "footer.jsp"/>
  
  <!-- liens vers les fichiers JavaScript -->
  <script src="../validation.js"></script>
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
