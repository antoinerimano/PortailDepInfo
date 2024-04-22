/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourproject.portail.model.dao;


import com.ourproject.portail.model.entities.Projet;
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
public class ProjetDAO {
    
    private static final String SQL_CREATE_PROJET = "insert into Projet (nom,cour,description,dateCreation,programme,superviseur,lienGit,lienImg,note,codeP) values (?,?,?,?,?,?,?,?,?,?)";
    private static final String DELETE_PROJET_BY_ID = "delete from Projet where idProjet = ?";
    private static final String DELETE_PROJET_LINKED_ELEM = "delete from listeEtudiantProjet where idProjet = ?";
    
    private static final String SQL_SELECT_ALL_PROJET = "select * from Projet";
    private static final String SQL_SELECT_PROJET_BY_CODE = "select * from Projet where codeP = ?";
    private static final String SQL_SELECT_ALL_PROJET_BY_NAME = "select * from Projet where nom = ?";
    
    //---
    //must be modified bcs we have to find a way to modify a string type to a date type for getDateDeNaissance
    public boolean createProjet(Projet proj){
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try{
            ps = ConnexionBD.getConnection().prepareStatement(SQL_CREATE_PROJET);
            System.out.println("result(create project): "+ps.toString());
            
            ps.setString(1, proj.getNomProjet());
            ps.setString(2, proj.getNomCour());
            ps.setString(3, proj.getDescription());
            ps.setString(4, proj.getDateDeCreation());
            ps.setString(5, proj.getProfilProgramme());
            ps.setString(6, proj.getProfesseurSuperviseur());
            ps.setString(7, proj.getLien());
            ps.setString(8, proj.getLienImg());
            ps.setInt(9, proj.getNote());
            ps.setInt(10, proj.getCodeP());
            
            
            nbLigne = ps.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println("Erreur dans createProjet() [ProjetDAO.java]: "+ex.getMessage());
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
        
    }
    
    //CHECK IF NEEDS TO BE DELETED FROM OTHER TABLES TOO : ex: listeEtudiantProjet
    public boolean deleteProjet(int idProjet) {
        boolean retour = false;
        int nbLigne = 0;

        PreparedStatement ps;
        PreparedStatement ps1;

        try {
            ps1 = ConnexionBD.getConnection().prepareStatement(DELETE_PROJET_LINKED_ELEM);
            
            ps = ConnexionBD.getConnection().prepareStatement(DELETE_PROJET_BY_ID);

            ps1.setInt(1, idProjet);
            ps1.executeUpdate();
            
            ps.setInt(1, idProjet);
            ps.executeUpdate();
            
            System.out.println(" nbLigne : " + nbLigne);
        } catch (SQLException ex) {
            System.out.println("ERROR WHEN DELETING PROJET: "+ex.getMessage());
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }
    
    public List<Projet> findAllProjet() {
        List<Projet> lstProjet = null;
        try{
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ALL_PROJET);
            System.out.println("result(find all student): "+ps.toString());
            
            ResultSet res = ps.executeQuery();
            
            lstProjet = new ArrayList<>();
            
            while (res.next()){
                Projet proj = new Projet();
                
                proj.setIdProjet(res.getInt("idProjet"));
                proj.setNomProjet(res.getString("nom"));
                proj.setNomCour(res.getString("cour"));
                proj.setDescription(res.getString("description"));
                proj.setDateDeCreation((res.getString("dateCreation")));
                proj.setProfilProgramme(res.getString("programme"));
                proj.setProfesseurSuperviseur(res.getString("superviseur"));
                proj.setLien(res.getString("lienGit"));
                proj.setLienImg(res.getString("lienImg"));
                proj.setNote(res.getInt("note"));
                proj.setCodeP(res.getInt("codeP"));
                
                lstProjet.add(proj);
            }
            
        }catch(SQLException ex){
            System.out.println("Erreur dans findAllProjet() [ProjetDAO.java]: "+ex.getMessage());
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        
        return lstProjet;
    }
    
    public ArrayList<Projet> findProjetByCodeP(int code){
        ArrayList<Projet> lstProj = null;
        
        try{
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PROJET_BY_CODE);
            System.out.println("result(find projet by code): "+ps.toString());
            
            ps.setInt(1, code);
            
            ResultSet res = ps.executeQuery();
            
            lstProj = new ArrayList<>();
            
            while(res.next()){
                Projet proj = new Projet();
            
                proj.setIdProjet(res.getInt("idProjet"));
                proj.setNomProjet(res.getString("nom"));
                proj.setNomCour(res.getString("cour"));
                proj.setDescription(res.getString("description"));
                proj.setDateDeCreation((res.getDate("dateCreation")).toString());
                proj.setProfilProgramme(res.getString("programme"));
                proj.setProfesseurSuperviseur(res.getString("superviseur"));
                proj.setLien(res.getString("lienGit"));
                proj.setLienImg(res.getString("lienImg"));
                proj.setNote(res.getInt("note"));
                proj.setCodeP(res.getInt("codeP"));
                
                lstProj.add(proj);
            }
            
            

        }catch(SQLException ex){
            System.out.println("Erreur dans findProjetByCodeP(int code) [ProjetDAO.java]: "+ex.getMessage());
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        
        return lstProj;
        
    }
    
    public ArrayList<Projet> findProjetByNom(String nom){
        ArrayList<Projet> lstProjets = null;
        
        try{
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ALL_PROJET_BY_NAME);
            System.out.println("result(find ALL projet by name): "+ps.toString());
            
            ps.setString(1, nom);
            
            ResultSet res = ps.executeQuery();
            
            lstProjets = new ArrayList<>();
            
            while (res.next()){
                Projet proj = new Projet();
            
                proj.setIdProjet(res.getInt("idProjet"));
                proj.setNomProjet(res.getString("nom"));
                proj.setNomCour(res.getString("cour"));
                proj.setDescription(res.getString("description"));
                proj.setDateDeCreation((res.getDate("dateCreation")).toString());
                proj.setProfilProgramme(res.getString("programme"));
                proj.setProfesseurSuperviseur(res.getString("superviseur"));
                proj.setLien(res.getString("lienGit"));
                proj.setLienImg(res.getString("lienImg"));
                proj.setNote(res.getInt("note"));
                proj.setCodeP(res.getInt("codeP"));
            
                lstProjets.add(proj);
            }

        }catch(SQLException ex){
            System.out.println("Erreur dans findProjetByNom(string nom) [ProjetDAO.java]: "+ex.getMessage());
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        
        return lstProjets;
        
    }
    
    
}
