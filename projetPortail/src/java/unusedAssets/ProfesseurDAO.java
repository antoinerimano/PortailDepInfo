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
public class ProfesseurDAO {
    private String url;
    private String nomUtilisateur;
    private String motDePasse;
    
    public ProfesseurDAO(String url, String nom_utilisateur, String mot_passe){
        
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
    //WONT WORK BCS THE DB AINT EVEN MADE YET, WHICH I HAVE TO DISCUSS BCS HOW ARE WE FORMING THE OVERALL STRUCTURE???
    public Professeur EnregistrerProfesseur(Professeur professeur) throws SQLException{
        try{
            Connection connection = DriverManager.getConnection(url,nomUtilisateur, motDePasse);
            PreparedStatement statement = connection.prepareStatement("insert into professeur(codeP,nom,prenom,datenaissance) values(?,?,?,?);");
            statement.setInt(1,professeur.getCodePermanent());
            statement.setString(2,professeur.getNom());
            statement.setString(3,professeur.getPrenom());
            statement.setString(4,professeur.getDateDeNaissance());

            statement.execute();
            
            System.out.println(professeur.getCodePermanent()+  " enregistrer dans la BD" );
            return professeur;
            
        }catch(SQLException e){
            e.getMessage();
            System.out.println("Impossible de sauvegarder le professeur");
            
        }
        return null;    
    }
    //
    public Professeur getProfesseurByCodePerm(int code){
        try{
            Connection connection = DriverManager.getConnection(url, nomUtilisateur, motDePasse);
            PreparedStatement statement = connection.prepareStatement("select * from professeur where codeP = ?;");
            statement.setInt(1, code);
            ResultSet resultSet = statement.executeQuery();
            
            Professeur prof = new Professeur();
            
            while (resultSet.next()){
                prof.setCodePermanent(resultSet.getInt("codeP"));
                prof.setNom(resultSet.getString("nom"));
                prof.setPrenom(resultSet.getString("prenom"));
                prof.setDateDeNaissance(resultSet.getString("datenaissance"));
                prof.setId(resultSet.getInt("idUtilisateur"));
            }
            return prof;
            
        }catch(SQLException e){
            e.getMessage();
            System.out.println( "Impossible d'obtenir le professeur");
        }
        return null;
    }
    
}
