/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourproject.portail.model.dao;

import com.ourproject.portail.model.entities.Etudiant;
import com.ourproject.portail.model.singleton.ConnexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nini
 */
public class EtudiantDAO {
    
    private static final String SQL_SELECT_ALL_STUDENT = "select * from Etudiant";
    private static final String SQL_SELECT_STUDENT_BY_CODE = "select * from Etudiant where codeP = ?";
    private static final String SQL_SELECT_ALL_STUDENT_BY_NAME = "select * from Etudiant where nom = ?";
    private static final String SQL_CREATE_STUDENT = "insert into Etudiant (codeP,nom,prenom,dateNaissance,programme,typeEtudiant) values (?,?,?,?,?,?)";
            
    private static final String DELETE_ETUDIANT_TUTEUR_BY_CODEP = "delete from Tuteur where codeP = ?";
    private static final String DELETE_ETUDIANT_DIFFICULTE_BY_CODEP = "delete from EtudiantDifficulte where codeP = ?";
    private static final String DELETE_ETUDIANT_BY_CODEP = "delete from Etudiant where codeP = ?";
    private static final String DELETE_UTILISATEUR_BY_CODEP = "delete from Utilisateur where codeP = ?";
    
    //---
    //must be modified bcs we have to find a way to modify a string type to a date type for getDateDeNaissance
    public boolean createEtudiant(Etudiant etud){
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try{
            ps = ConnexionBD.getConnection().prepareStatement(SQL_CREATE_STUDENT);
            System.out.println("result(create user): "+ps.toString());
            
            ps.setInt(1, etud.getCodePermanent());
            ps.setString(2,etud.getNom());
            ps.setString(3,etud.getPrenom());
            ps.setString(4, etud.getDateDeNaissance());
            ps.setString(5,etud.getTypeDeProgramme());
            ps.setString(6,etud.getTypeEtudiant());
            
            
            
            nbLigne = ps.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println("Erreur dans createEtudiant() [EtudiantDAO.java]: "+ex.getMessage());
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
        
    }
   
    //FOR HERE, IT NEEDS TO BE MODIFIED SO THE PROJET, LISTE AND TUTEUR/DIFFICULTE ASSOCIE ARE ALSO DELETED
    public boolean deleteEtudiant(int codeP) {
        boolean retour = false;
        int nbLigne = 0;

        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        PreparedStatement ps;
        PreparedStatement psFinal;

        try {
            ps1 = ConnexionBD.getConnection().prepareStatement(DELETE_ETUDIANT_TUTEUR_BY_CODEP);
            ps2 = ConnexionBD.getConnection().prepareStatement(DELETE_ETUDIANT_DIFFICULTE_BY_CODEP);

            ps = ConnexionBD.getConnection().prepareStatement(DELETE_ETUDIANT_BY_CODEP);

            psFinal = ConnexionBD.getConnection().prepareStatement(DELETE_UTILISATEUR_BY_CODEP);
            
            // Supprimer les lignes dans la table intermédiaire qui dépendent de la ligne parente
            ps1.setInt(1, codeP);
            ps1.executeUpdate();
            // Supprimer les lignes enfants dans les deux tables qui dépendent de la ligne parente
            ps2.setInt(1, codeP);
            ps2.executeUpdate();

            // Supprimer la ligne parente
            ps.setInt(1, codeP);
            ps.executeUpdate();
            
            psFinal.setInt(1, codeP);
            
            nbLigne = psFinal.executeUpdate();
            System.out.println(" nbLigne : " + nbLigne);
        } catch (SQLException ex) {
            System.out.println("ERROR WHEN DELETING ETUDIANT: "+ex.getMessage());
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    public List<Etudiant> findAllEtudiant() {
        List<Etudiant> lstEtudiant = null;
        try{
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ALL_STUDENT);
            System.out.println("result(find all student): "+ps.toString());
            
            ResultSet res = ps.executeQuery();
            
            lstEtudiant = new ArrayList<>();
            
            while (res.next()){
                Etudiant etudiant = new Etudiant();
                
                etudiant.setIdEtudiant(res.getInt("idEtudiant"));
                etudiant.setCodePermanent(res.getInt("codeP"));
                etudiant.setNom(res.getString("nom"));
                etudiant.setPrenom(res.getString("prenom"));
                etudiant.setDateDeNaissance((res.getDate("dateNaissance")).toString());
                etudiant.setTypeDeProgramme(res.getString("programme"));
                etudiant.setTypeEtudiant(res.getString("typeEtudiant"));
                etudiant.setAncien(res.getBoolean("ancien"));

                
                lstEtudiant.add(etudiant);
            }
            
        }catch(SQLException ex){
            System.out.println("Erreur dans findAllEtudiant() [EtudiantDAO.java]: "+ex.getMessage());
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        
        return lstEtudiant;
    }
    
    public Etudiant findEtudiantByCodeP(int code){
        Etudiant etudiant = null;
        
        try{
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_STUDENT_BY_CODE);
            System.out.println("result(find student by code): "+ps.toString());
            
            ps.setInt(1, code);
            
            ResultSet res = ps.executeQuery();
            
            while (res.next()){
                etudiant = new Etudiant();
            
                etudiant.setIdEtudiant(res.getInt("idEtudiant"));
                etudiant.setCodePermanent(res.getInt("codeP"));
                etudiant.setNom(res.getString("nom"));
                etudiant.setPrenom(res.getString("prenom"));
                etudiant.setDateDeNaissance(res.getString("dateNaissance"));
                etudiant.setTypeDeProgramme(res.getString("programme"));
                etudiant.setTypeEtudiant(res.getString("typeEtudiant"));
                //ancien not set, already set automatically in the constructors to false
                
            }
            
            

        }catch(SQLException ex){
            System.out.println("Erreur dans findEtudiantByCodeP(int code) [EtudiantDAO.java]: "+ex.getMessage());
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        
        return etudiant;
        
    }
    
    public ArrayList<Etudiant> findEtudiantByNom(String nom){
        ArrayList<Etudiant> lstEtudiants = null;
        
        try{
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ALL_STUDENT_BY_NAME);
            System.out.println("result(find ALL student by name): "+ps.toString());
            
            ps.setString(1, nom);
            
            ResultSet res = ps.executeQuery();
            
            lstEtudiants = new ArrayList<>();
            
            while (res.next()){
                Etudiant etudiant = new Etudiant();
            
                etudiant.setIdEtudiant(res.getInt("idEtudiant"));
                etudiant.setCodePermanent(res.getInt("codeP"));
                etudiant.setNom(res.getString("nom"));
                etudiant.setPrenom(res.getString("prenom"));
                etudiant.setDateDeNaissance(res.getString("dateNaissance"));
                etudiant.setTypeDeProgramme(res.getString("programme"));
                etudiant.setTypeEtudiant(res.getString("typeEtudiant"));
                //ancien not set, already set automatically in the constructors to false
            
                lstEtudiants.add(etudiant);
            }

        }catch(SQLException ex){
            System.out.println("Erreur dans findEtudiantByNom(string nom) [EtudiantDAO.java]: "+ex.getMessage());
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        
        return lstEtudiants;
        
    }
    

    
}
