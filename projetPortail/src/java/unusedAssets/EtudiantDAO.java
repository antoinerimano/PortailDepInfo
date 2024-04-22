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
public class EtudiantDAO {
    private String url;
    private String nomUtilisateur;
    private String motDePasse;
    
    public EtudiantDAO(String url, String nom_utilisateur, String mot_passe){
        
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
    public Etudiant EnregistrerEtudiant(Etudiant etudiant) throws SQLException{
        try{
            Connection connection = DriverManager.getConnection(url,nomUtilisateur, motDePasse);
            PreparedStatement statement = connection.prepareStatement("insert into etudiant(codeP,nom,prenom,datenaissance,programme,typeEtudiant) values(?,?,?,?,?,?);");
            statement.setInt(1,etudiant.getCodePermanent());
            statement.setString(2,etudiant.getNom());
            statement.setString(3,etudiant.getPrenom());
            statement.setString(4,etudiant.getDateDeNaissance());
            statement.setString(5,etudiant.getTypeDeProgramme());
            statement.setString(6,etudiant.getTypeEtudiant());
            
            statement.execute();
            
            System.out.println(etudiant.getCodePermanent()+  " enregistrer dans la BD" );
            return etudiant;
            
        }catch(SQLException e){
            e.getMessage();
            System.out.println("Impossible de sauvegarder L'etudiant");
            
        }
        return null;    
    }
    //
    public Etudiant getEtudiantByCodePerm(int code){
        try{
            Connection connection = DriverManager.getConnection(url, nomUtilisateur, motDePasse);
            PreparedStatement statement = connection.prepareStatement("select * from etudiant where codeP = ?;");
            statement.setInt(1, code);
            ResultSet resultSet = statement.executeQuery();
            
            Etudiant etudiant = new Etudiant();
            
            while (resultSet.next()){
                etudiant.setCodePermanent(resultSet.getInt("codeP"));
                etudiant.setNom(resultSet.getString("nom"));
                etudiant.setPrenom(resultSet.getString("prenom"));
                etudiant.setDateDeNaissance(resultSet.getString("datenaissance"));
                etudiant.setTypeDeProgramme(resultSet.getString("programme"));
                etudiant.setId(resultSet.getInt("idUtilisateur"));
                etudiant.setTypeEtudiant(resultSet.getString("typeEtudiant"));
            }
            return etudiant;
            
        }catch(SQLException e){
            e.getMessage();
            System.out.println( "Impossible d'obtenir l'etudiant");
        }
        return null;
    }
    
}
