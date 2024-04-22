/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourproject.portail.model.dao;


import com.ourproject.portail.model.entities.Professeur;
import com.ourproject.portail.model.singleton.ConnexionBD;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nini
 */
public class ProfesseurDAO {
    
    private static final String SQL_CREATE_TEACHER = "insert into Professeur(codeP,nom,prenom,dateNaissance) values(?,?,?,?)";
    private static final String DELETE_PROFESSEUR_BY_CODEP = "delete from Professeur where codeP = ?";
    private static final String SQL_SELECT_ALL_PROFESSEUR = "select * from Professeur";
    private static final String SQL_SELECT_PROFESSEUR_BY_CODE = "select * from Professeur where codeP = ?";
    private static final String SQL_SELECT_ALL_PROFESSEUR_BY_NAME = "select * from Professeur where nom = ?";
    
    private static final String SQL_UPDATE_PROFESSEUR = "update Professeur set codeP = ?, nom = ?, prenom = ?, dateNaissance = ? where idProfesseur = ? ";
            
    //---
    public boolean createProfesseur(Professeur prof){
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try{
            ps = ConnexionBD.getConnection().prepareStatement(SQL_CREATE_TEACHER);
            System.out.println("result(create teacher): "+ps.toString());
            
            ps.setInt(1, prof.getCodePermanent());
            ps.setString(2,prof.getNom());
            ps.setString(3,prof.getPrenom());
            ps.setString(4, prof.getDateDeNaissance());
            
            nbLigne = ps.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println("Erreur dans createProfesseur() [ProfesseurDAO.java]: "+ex.getMessage());
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
        
    }
    
    public boolean updateProfesseur (Professeur prof){
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try{
            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE_PROFESSEUR);
            System.out.println("result (update Professeur): "+ps.toString());
            
            ps.setInt(1, prof.getCodePermanent());
            ps.setString(2, prof.getNom());
            ps.setString(3, prof.getPrenom());
            ps.setString(4, prof.getDateDeNaissance());
            ps.setInt(5, prof.getIdProfesseur());
            
            nbLigne = ps.executeUpdate();
            
            
        }catch(SQLException ex){
            System.out.println("Erreur dans updateProfesseur(Professeur prof) [ProfesseurDAO.java]: "+ex.getMessage());
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }
   
    //WILL PROBABLY BE MODIFIED IF WE ALSO NEED TO DELETE THE NOTE FROM LISTEPROFESSEURNOTE
    public boolean deleteProfesseur(int codeP) {
        boolean retour = false;
        int nbLigne = 0;

        PreparedStatement ps;


        try {

            ps = ConnexionBD.getConnection().prepareStatement(DELETE_PROFESSEUR_BY_CODEP);

            ps.setInt(1, codeP);
            ps.executeUpdate();
 
            System.out.println(" nbLigne : " + nbLigne);
        } catch (SQLException ex) {
            System.out.println("ERROR WHEN DELETING PROF: "+ex.getMessage());
            Logger.getLogger(ProfesseurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    public List<Professeur> findAllProfesseur() {
        List<Professeur> lstProf = null;
        try{
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ALL_PROFESSEUR);
            System.out.println("result(find all professeur): "+ps.toString());
            
            ResultSet res = ps.executeQuery();
            
            lstProf = new ArrayList<>();
            
            while (res.next()){
                Professeur prof = new Professeur();
                
                prof.setIdProfesseur(res.getInt("idProfesseur"));
                prof.setCodePermanent(res.getInt("codeP"));
                prof.setNom(res.getString("nom"));
                prof.setPrenom(res.getString("prenom"));
                prof.setDateDeNaissance(res.getString("dateNaissance"));

                
                lstProf.add(prof);
            }
            
        }catch(SQLException ex){
            System.out.println("Erreur dans findAllProfesseur() [ProfesseurDAO.java]: "+ex.getMessage());
            Logger.getLogger(ProfesseurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        
        return lstProf;
    }
    
    public Professeur findProfesseurByCodeP(int code){
        Professeur prof = null;
        
        try{
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PROFESSEUR_BY_CODE);
            System.out.println("result(find teacher by code): "+ps.toString());
            
            ps.setInt(1, code);
            
            ResultSet res = ps.executeQuery();
            
            while (res.next()){
                prof = new Professeur();

                prof.setIdProfesseur(res.getInt("idEtudiant"));
                prof.setCodePermanent(res.getInt("codeP"));
                prof.setNom(res.getString("nom"));
                prof.setPrenom(res.getString("prenom"));
                prof.setDateDeNaissance((res.getDate("dateNaissance")).toString());
            
            }


        }catch(SQLException ex){
            System.out.println("Erreur dans findProfesseurByCodeP(int code) [ProfesseurDAO.java]: "+ex.getMessage());
            Logger.getLogger(ProfesseurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        
        return prof;
        
    }
    
    public ArrayList<Professeur> findProfesseurByNom(String nom){
        ArrayList<Professeur> lstProfs = null;
        
        try{
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ALL_PROFESSEUR_BY_NAME);
            System.out.println("result(find ALL prof by name): "+ps.toString());
            
            ps.setString(1, nom);
            
            ResultSet res = ps.executeQuery();
            
            lstProfs = new ArrayList<>();
            
            while (res.next()){
                Professeur prof = new Professeur();
            
                prof.setIdProfesseur(res.getInt("idEtudiant"));
                prof.setCodePermanent(res.getInt("codeP"));
                prof.setNom(res.getString("nom"));
                prof.setPrenom(res.getString("prenom"));
                prof.setDateDeNaissance((res.getDate("dateNaissance")).toString());
            
                lstProfs.add(prof);
            }

        }catch(SQLException ex){
            System.out.println("Erreur dans findProfesseurByNom(String nom) [EtudiantDAO.java]: "+ex.getMessage());
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        
        return lstProfs;
        
    }
    
}
