<?php

// Récupération des données envoyées par le formulaire
$username = $_POST['username'];
$password = $_POST['password'];
$type = $_POST['type'];

// Vérification que tous les champs ont été remplis
if (empty($username) || empty($password) || empty($type)) {
  // Si un champ est vide, on redirige l'utilisateur vers le formulaire avec un message d'erreur
  header('Location: registration_form.php?error=missing_fields');
  exit();
}

// Connexion à la base de données
$db_host = 'localhost';
$db_name = 'db_portail';
$db_user = 'root';
$db_password = 'root';

try {
  $db = new PDO("mysql:host=$db_host;dbname=$db_name", $db_user, $db_password);
  $db->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
  // Si la connexion échoue, on redirige l'utilisateur vers le formulaire avec un message d'erreur
  header('Location: registration_form.php?error=db_connection');
  exit();
}

// Insertion de l'utilisateur dans la table "utilisateur"
$insert_user_query = "INSERT INTO utilisateur (username, password, type) VALUES (:username, :password, :type)";
$insert_user_statement = $db->prepare($insert_user_query);
$insert_user_statement->bindParam(':username', $username);
$insert_user_statement->bindParam(':password', $password);
$insert_user_statement->bindParam(':type', $type);
$insert_user_statement->execute();

// Récupération de l'ID de l'utilisateur inséré
$user_id = $db->lastInsertId();

// Insertion de l'étudiant ou du professeur dans la table correspondante, en fonction de son type
if ($type == 'etudiant') {
  $codeP = $_POST['codeP'];
  $nom = $_POST['nom'];
  $prenom = $_POST['prenom'];
  $datenaissance = $_POST['datenaissance'];

  // Insertion de l'étudiant dans la table "etudiant"
$insert_etudiant_query = "INSERT INTO etudiant (codeP, nom, prenom, datenaissance, idUtilisateur) VALUES (:codeP, :nom, :prenom, :datenaissance, :idUtilisateur)";
$insert_etudiant_statement = $db->prepare($insert_etudiant_query);
$insert_etudiant_statement->bindParam(':codeP', $codeP);
$insert_etudiant_statement->bindParam(':nom', $nom);
$insert_etudiant_statement->bindParam(':prenom', $prenom);
$insert_etudiant_statement->bindParam(':datenaissance', $datenaissance);
$insert_etudiant_statement->bindParam(':idUtilisateur', $user_id);
$insert_etudiant_statement->execute();

} else if ($type == 'professeur') {
$codeP = $_POST['codeP'];
$nom = $_POST['nom'];
$prenom = $_POST['prenom'];
$datenaissance = $_POST['datenaissance'];

// Insertion du professeur dans la table "professeur"
$insert_professeur_query = "INSERT INTO professeur (codeP, nom, prenom, datenaissance, idUtilisateur) VALUES (:codeP, :nom, :prenom, :datenaissance, :idUtilisateur)";
$insert_professeur_statement = $db->prepare($insert_professeur_query);
$insert_professeur_statement->bindParam(':codeP', $codeP);
$insert_professeur_statement->bindParam(':nom', $nom);
$insert_professeur_statement->bindParam(':prenom', $prenom);
$insert_professeur_statement->bindParam(':datenaissance', $datenaissance);
$insert_professeur_statement->bindParam(':idUtilisateur', $user_id);
$insert_professeur_statement->execute();
}

?>