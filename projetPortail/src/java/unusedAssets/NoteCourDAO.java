/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unusedAssets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nini
 */
public class NoteCourDAO {
    private String url;
    private String nomUtilisateur;
    private String motDePasse;
    
    public NoteCourDAO(String url, String nom_utilisateur, String mot_passe){
        
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
    public NoteCours EnregistrerNoteCours(NoteCours notecours) throws SQLException{
        try{
            Connection connection = DriverManager.getConnection(url,nomUtilisateur, motDePasse);
            PreparedStatement statement = connection.prepareStatement("insert into notecours(nomnote,codecours,auteur,link,codeP) values(?,?,?,?,?);");
            statement.setString(1,notecours.getNomNoteCour());
            statement.setString(2,notecours.getCodeCour());
            statement.setString(3,notecours.getAuteur());
            statement.setString(4,notecours.getLien());
            statement.setInt(5,notecours.getCodeP());

            statement.execute();
            
            System.out.println(notecours.getNomNoteCour()+  " enregistrer dans la BD" );
            return notecours;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Impossible de sauvegarder la note de cour");
            
        }
        return null;    
    }
    //
    public NoteCours getNoteCoursByNom(String nom){
        try{
            Connection connection = DriverManager.getConnection(url, nomUtilisateur, motDePasse);
            PreparedStatement statement = connection.prepareStatement("select * from notecours where nomnote = ?;");
            statement.setString(1, nom);
            ResultSet resultSet = statement.executeQuery();
            
            NoteCours note = new NoteCours();
            
            while (resultSet.next()){
                note.setAuteur(resultSet.getString("auteur"));
                note.setCodeCour(resultSet.getString("codeCours"));
                note.setLien(resultSet.getString("link"));
                note.setNomNoteCour(resultSet.getString("nomnote"));
                note.setCodeP(resultSet.getInt("codeP"));
            }
            return note;
            
        }catch(SQLException e){
            e.getMessage();
            System.out.println( "Impossible d'obtenir la note de cour");
        }
        return null;
    }
    
}
