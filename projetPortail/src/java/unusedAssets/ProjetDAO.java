/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unusedAssets;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nini
 */
public class ProjetDAO {
    private String url;
    private String nomUtilisateur;
    private String motDePasse;
    
    public ProjetDAO(String url, String nom_utilisateur, String mot_passe){
        
        this.url = url;
        this.nomUtilisateur = nom_utilisateur;
        this.motDePasse =  mot_passe;
    }
    public String getUrl() {
        return url;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setNomUtilisateur(String nom_utilisateur) {
        this.nomUtilisateur = nom_utilisateur;
    }

    public void setMotDePasse(String mot_passe) {
        this.motDePasse = mot_passe;
    }
    //---
    //ENREGISTRER NEW PROJET
    public Projet EnregistrerProjet(Projet projet) throws SQLException{
        try{
            Connection connection = DriverManager.getConnection(url,nomUtilisateur, motDePasse);

            PreparedStatement statement = connection.prepareStatement("insert into projet(nomprojet,datecreation,imagelink,profilprogramme,profsuperviseur,nomcours,nometudiants,descriptionprojet,note,gitlablink) values(?,?,?,?,?,?,?,?,?,?);");

            statement.setString(1,projet.getNomProjet());
            statement.setString(2,projet.getDateDeCreation());
            statement.setString(3,projet.getLienImg());
            statement.setString(4,projet.getProfilProgramme());
            statement.setString(5,projet.getProfesseurSuperviseur());
            statement.setString(6,projet.getNomCour());
            statement.setString(7,projet.getEtudiantsParticipants());//debatable, gotta ask teacher or need input on this
            statement.setString(8,projet.getDescription());
            statement.setInt(9,projet.getNote());
            statement.setString(10,projet.getLien());
            
            System.out.println("HERE!! 4");
            statement.execute();
            System.out.println("IT WORKS");

            
            System.out.println(projet.getNomProjet()+  " enregistrer dans la BD" );
            return projet;
            
        }catch(SQLException e){
            e.getMessage();
            System.out.println(e.getMessage());
            System.out.println("Impossible de sauvegarder le projet");
            
        }
        return null;    
    }
    //THIS ONE DOES NOT WORK: NEED TO DISCUSS WETHER LIST ETUDIANT IS AN ARRAY LIST OR JUST A STRING??
    public Projet getProjetByNom(String nom){
        try{
            Connection connection = DriverManager.getConnection(url, nomUtilisateur, motDePasse);
            PreparedStatement statement = connection.prepareStatement("select * from projet where nomprojet = ?;");
            statement.setString(1, nom);
            ResultSet resultSet = statement.executeQuery();
            
            Projet projet = new Projet();
            
            while (resultSet.next()){
                projet.setDateDeCreation(resultSet.getString("datecreation"));
                projet.setDescription(resultSet.getString("descriptionprojet"));
                projet.setEtudiantsParticipants(resultSet.getString("nometudiants"));
                projet.setLien(resultSet.getString("gitlablink"));
                projet.setLienImg(resultSet.getString("imageLink"));
                projet.setNomCour(resultSet.getString("nomcours"));
                projet.setNomProjet(resultSet.getString("nomprojet"));
                projet.setProfesseurSuperviseur(resultSet.getString("profsuperviseur"));
                projet.setNote(resultSet.getInt("note"));
                projet.setProfilProgramme(resultSet.getString("profilprogramme"));
            }
            return projet;
            
        }catch(SQLException e){
            e.getMessage();
            System.out.println( "Impossible d'obtenir le projet");
        }
        return null;
    }
    
    
}
