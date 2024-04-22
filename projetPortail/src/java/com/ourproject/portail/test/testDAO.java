/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourproject.portail.test;

import com.ourproject.portail.model.entities.Utilisateur;
import com.ourproject.portail.service.UtilisateurService;

/**
 *
 * @author Nini
 */
public class testDAO {
    public static void main(String[] args){
        try{
            //UTILISATEUR DAO TEST
    
            UtilisateurService userServ = new UtilisateurService();
            
            //create utilisateur
            System.out.println("INSERTION UTILISATEURS");
            /*
            Utilisateur utilisateur = new Utilisateur("Wekxtelios","pass123","Professeur",0276);
            userServ.creerUtilisateur(utilisateur);
            
            utilisateur = new Utilisateur("SmithBismuth","1234","Professeur",3245);
            userServ.creerUtilisateur(utilisateur);
            
            utilisateur = new Utilisateur("Porelino","password","Etudiant",1239456);
            userServ.creerUtilisateur(utilisateur);
            */
            //deleteutilisateur
            System.out.println("SUPPRIMER UTILISATEURS");
            Utilisateur utilisateur = new Utilisateur("toBeGone","123","Professeur",1034);
            userServ.deleteUtilisateur(1034);
            System.out.println("delete toBeGone success");
            
            //update Utilisateur
            utilisateur = userServ.chercherUtilisateurParCodeP(8450124);
            System.out.println(utilisateur.getNomUtilisateur());
            //userServ.creerUtilisateur(utilisateur);
            utilisateur.setNomUtilisateur("WhoAsked");
            System.out.println(utilisateur.getNomUtilisateur());
            System.out.println(utilisateur.getId());
            userServ.updateUtilisateur(utilisateur);
            
            
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    
    }
    
    
    
    
    
    
    
}
