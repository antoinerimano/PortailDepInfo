/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourproject.portail.model.dao;
        
import com.ourproject.portail.model.entities.Utilisateur;
import com.ourproject.portail.model.singleton.ConnexionBD;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nini
 */
public class UtilisateurDAO {
    
//Bao's part
    private static final String SQL_CONNEXION_PAR_CODEP_AND_PASSWORD = "select * from projet_portail_db.utilisateur where codeP=? and password=?";
    private static final String SQL_SELECT_ALL_USER = "select * from utilisateur";
    
    private String url;
    private String nomUtilisateur;
    private String motDePasse;
//
    //create utilisateur, delete utilisateur, find by codeP, find by username

    
    private static final String SQL_CREATE_UTILISATEUR = "insert into Utilisateur(username,password,typeUtilisateur,codeP) values(?,?,?,?)";

    //private static final String DELETE_UTILISATEUR_BY_CODEP = "delete all from Utilisateur where codep = ?";
    private static final String SQL_SELECT_ALL_UTILISATEUR = "select * from projet_portail_db.utilisateur";

    private static final String SQL_SELECT_BY_USERNAME = "select * from Utilisateur where username = ?";
    private static final String SQL_UPDATE_UTILISATEUR = "update Utilisateur set username = ?, password = ?, typeUtilisateur = ?, codeP = ? where idUtilisateur = ? ";
    

    private static final String DELETE_UTILISATEUR_BY_CODEP = "delete from Utilisateur where codeP = ?";
    private static final String SQL_SELECT_BY_CODEP = "select * from Utilisateur where codeP = ?";
    //private static final String SQL_SELECT_BY_USERNAME = "select * from Utilisateur where username = ?";
    //private static final String SQL_UPDATE_UTILISATEUR = "update Utilisateur set username = ?, password = ?, typeUtilisateur = ?, codeP = ? where idUtilisateur = ? ";
    
    private static final String DELETE_ETUDIANT_BY_CODEP = "delete from Etudiant where codeP = ?";
    private static final String DELETE_PROFESSEUR_BY_CODEP = "delete from Professeur where codeP = ?";
    
    private static final String DELETE_PROJET_BY_CODEP = "delete from Projet where codeP = ?";
    private static final String DELETE_NOTE_BY_CODEP = "delete from NoteCour where codeP = ?";
    
    
    
    //---
    public boolean createUtilisateur(Utilisateur user){
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try{
            ps = ConnexionBD.getConnection().prepareStatement(SQL_CREATE_UTILISATEUR);
            System.out.println("result (create utilisateur): "+ps.toString());
            
            ps.setString(1, user.getNomUtilisateur());
            ps.setString(2, user.getMotDePasse());
            ps.setString(3, user.getType());
            ps.setInt(4, user.getCodeP());
            
            nbLigne = ps.executeUpdate();

        }catch(SQLException ex){
            System.out.println("Erreur dans createUtilisateur() [UtilisateurDAO.java]: "+ex.getMessage());
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }
    
    
    public boolean updateUtilisateur(Utilisateur user) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;

        try {

            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE_UTILISATEUR);
            
            ps.setString(1, user.getNomUtilisateur());
            ps.setString(2, user.getMotDePasse());

            ps.setString(3, user.getType());
            ps.setInt(4, user.getCodeP());

            ps.setInt(5, user.getId());

            nbLigne = ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erreur dans updateUtilisateur(Utilisateur utilisateur) [UtilisateurDAO.java]: "+ex.getMessage());
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }
    
    public boolean deleteUtilisateur(int codeP){
        boolean retour = false;
        int nbLigne = 0;

        PreparedStatement ps;
        PreparedStatement ps1;
        PreparedStatement ps2;
        
        String code = Integer.toString(codeP);

        try{
            ps = ConnexionBD.getConnection().prepareStatement(DELETE_UTILISATEUR_BY_CODEP);
            
            /*
            if (code.length()==7){
                ps1 = ConnexionBD.getConnection().prepareStatement(DELETE_ETUDIANT_BY_CODEP);
                ps2 = ConnexionBD.getConnection().prepareStatement(DELETE_PROJET_BY_CODEP);
                
                ps1.setInt(1, codeP);
                ps1.executeUpdate();
                
                ps2.setInt(1, codeP);
                ps2.executeUpdate();
                
            }else if(code.length()==4){
                ps1 = ConnexionBD.getConnection().prepareStatement(DELETE_PROFESSEUR_BY_CODEP);
                ps2 = ConnexionBD.getConnection().prepareStatement(DELETE_NOTE_BY_CODEP);
                
                ps1.setInt(1, codeP);
                ps1.executeUpdate();
                
                ps2.setInt(1, codeP);
                ps2.executeUpdate();
                
            }
            */
            ps.setInt(1, codeP);
            nbLigne = ps.executeUpdate();
            
            System.out.println(" nbLigne : " + nbLigne);
            
        }catch(SQLException ex){
            System.out.println("ERROR WHEN DELETING USER: "+ex.getMessage());
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
        
    }
    
    public List<Utilisateur> findAllUtilisateur() {
        List<Utilisateur> lstUser = null;
        try{
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ALL_UTILISATEUR);
            
            System.out.println("result(find all utilisateur): "+ps.toString());
            
            ResultSet res = ps.executeQuery();
            
            lstUser = new ArrayList<>();
            
            while (res.next()){
                Utilisateur user = new Utilisateur();
                
                user.setCodeP(res.getInt("codeP"));
                user.setId(res.getInt("IdUtilisateur"));
                user.setNomUtilisateur(res.getString("username"));
                user.setMotDePasse(res.getString("password"));
                user.setType(res.getString("typeUtilisateur"));

                
                lstUser.add(user);
            }
            
        }catch(SQLException ex){
            System.out.println("Erreur dans findAllUtilisateur() [UtilisateurDAO.java]: "+ex.getMessage());
            Logger.getLogger(ProfesseurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        
        return lstUser;
    }
    
    public List<Utilisateur> findAllUtilisateurByUsername(String username) {
        List<Utilisateur> lstUser = null;
        try{
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_BY_USERNAME);
            ps.setString(1, username);
            System.out.println("result(find UTILISATEUR by username): "+ps.toString());
            
            ResultSet res = ps.executeQuery();
            
            lstUser = new ArrayList<>();
            
            while (res.next()){
                Utilisateur user = new Utilisateur();
                
                user.setCodeP(res.getInt("codeP"));
                user.setId(res.getInt("utilisateurId"));
                user.setNomUtilisateur(res.getString("username"));
                user.setMotDePasse(res.getString("password"));
                user.setType(res.getString("typeUtilisateur"));

                
                lstUser.add(user);
            }
            
        }catch(SQLException ex){
            System.out.println("Erreur dans findAllUtilisateurByUsername(String username) [UtilisateurDAO.java]: "+ex.getMessage());
            Logger.getLogger(ProfesseurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        
        return lstUser;
    }
    
    public Utilisateur findAllUtilisateurByCodeP(int code) {
        Utilisateur user = null;
        try{
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_BY_CODEP);
            ps.setInt(1, code);
            System.out.println("result(find UTILISATEUR by codeP): "+ps.toString());
            
            ResultSet res = ps.executeQuery();
            
            user = new Utilisateur();
            
            while (res.next()){
                
                user.setId(res.getInt("idUtilisateur"));
                user.setNomUtilisateur(res.getString("username"));
                user.setMotDePasse(res.getString("password"));
                user.setType(res.getString("typeUtilisateur"));
                user.setCodeP(res.getInt("codeP"));
                
            }
            
        }catch(SQLException ex){
            System.out.println("Erreur dans findAllUtilisateurByCodeP(int code) [UtilisateurDAO.java]: "+ex.getMessage());
            Logger.getLogger(ProfesseurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        
        return user;
    }
    
    
   // CONNEXION
   public Utilisateur existsByCodePAndPassword(int codeP, String motDePasse) {
        Utilisateur util = null;
        try {
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_CONNEXION_PAR_CODEP_AND_PASSWORD);
            ps.setInt(1, codeP);
            ps.setString(2, motDePasse);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                util = new Utilisateur();
                util.setCodeP(result.getInt("codeP"));
                util.setMotDePasse(result.getString("password"));
                util.setNomUtilisateur(result.getString("username"));
                util.setType(result.getString("typeUtilisateur"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        ConnexionBD.closeConnection();
        return util;
    }
        
        
}
