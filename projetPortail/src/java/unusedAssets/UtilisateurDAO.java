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
import java.sql.*;

/**
 *
 * @author Nini
 */
public class UtilisateurDAO {
    
    private String url;
    private String nomUtilisateur;
    private String motDePasse;
    
    public UtilisateurDAO(String url, String nom_utilisateur, String mot_passe){
        
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
    //ENREGISTRER OU UPDATE L'UTILISATEUR
    public Utilisateur EnregistrerUtilisateur(Utilisateur utilisateur) throws SQLException{
        try{
            Connection connection = DriverManager.getConnection(url,nomUtilisateur, motDePasse);

            PreparedStatement statement = connection.prepareStatement("insert into utilisateur(username,password,type) values(?,?,?);");
            statement.setString(1,utilisateur.getNomUtilisateur());
            statement.setString(2,utilisateur.getMotDePasse());
            statement.setString(3,utilisateur.getType());
            statement.execute();
            
            System.out.println(utilisateur.getNomUtilisateur()+  " enregistrer dans la BD" );
            return utilisateur;
            
        }catch(SQLException e){
            e.getMessage();
            System.out.println(e.getMessage());
            System.out.println("Impossible de sauvegarder le produit");
            
        }
        return null;    
    }
    
    public Utilisateur getUtilisateurById(int id){
        try{
            Connection connection = DriverManager.getConnection(url, nomUtilisateur, motDePasse);
            PreparedStatement statement = connection.prepareStatement("select * from utilisateur where idUtilisateur = ?;");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            Utilisateur utilisateur = new Utilisateur();
            
            while (resultSet.next()){
                utilisateur.setNomUtilisateur(resultSet.getString("username"));
                utilisateur.setMotDePasse(resultSet.getString("password"));
                utilisateur.setType(resultSet.getString("type"));
            }
            return utilisateur;
            
        }catch(SQLException e){
            e.getMessage();
            System.out.println( "Impossible d'obtenir l'utilisateur");
        }
        return null;
    }
    //NOUS DEVRONS AUSSI FAIRE UN GET USER BY USERNAME ET TYPE
    
    
    
}
