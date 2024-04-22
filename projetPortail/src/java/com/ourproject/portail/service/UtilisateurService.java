/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourproject.portail.service;

import com.ourproject.portail.model.dao.UtilisateurDAO;
import com.ourproject.portail.model.entities.Utilisateur;
import java.util.List;

/**
 *
 * @author Nini
 */
public class UtilisateurService {
    
    private List<Utilisateur> listeUtilisateurs;
    Utilisateur utilisateur = new Utilisateur();
    boolean retour = false;
    UtilisateurDAO daoUser = new UtilisateurDAO();
    
    //DAO shortcut functions
    public List<Utilisateur> afficherTousLesUtilisateurs(){
        listeUtilisateurs = daoUser.findAllUtilisateur();
        return listeUtilisateurs;
    }
    
    public List<Utilisateur> chercherUtilisateurParUsername(String username){
        listeUtilisateurs = daoUser.findAllUtilisateurByUsername(username);
        return listeUtilisateurs;
    }
    
    public Utilisateur chercherUtilisateurParCodeP(int code){
        utilisateur = daoUser.findAllUtilisateurByCodeP(code);
        return utilisateur;
    }
    
    public boolean creerUtilisateur(Utilisateur user){
        retour = daoUser.createUtilisateur(user);
        return retour;
    }
    
    public boolean deleteUtilisateur(int code){
        retour = daoUser.deleteUtilisateur(code);
        return retour;
    }
    
    public boolean updateUtilisateur(Utilisateur user){
        retour = daoUser.updateUtilisateur(user);
        return retour;
    }
    
    public Utilisateur verifierCodePMotDePasse(int codeP, String motDePasse){
        utilisateur = daoUser.existsByCodePAndPassword(codeP, motDePasse);
        return utilisateur;
    }
    
}
