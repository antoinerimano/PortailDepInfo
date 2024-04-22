/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourproject.portail.service;

import com.ourproject.portail.model.dao.EtudiantDAO;
import com.ourproject.portail.model.entities.Etudiant;
import java.util.List;

/**
 *
 * @author Nini
 */
public class EtudiantService {
    private List<Etudiant> listeEtudiants;
    Etudiant etudiant = new Etudiant();
    boolean retour = false;
    EtudiantDAO daoEtud = new EtudiantDAO();
    
    //DAO shortcut functions
    public List<Etudiant> afficherTousLesEtudiants(){
        listeEtudiants = daoEtud.findAllEtudiant();
        return listeEtudiants;
    }
    
    public List<Etudiant> chercherEtudiantParNom(String nom){
        listeEtudiants = daoEtud.findEtudiantByNom(nom);
        return listeEtudiants;
    }
    public Etudiant chercherEtudiantParCodeP(int code){
        etudiant = daoEtud.findEtudiantByCodeP(code);
        return etudiant;
    }
    
    public boolean creerEtudiant(Etudiant etu){
        retour = daoEtud.createEtudiant(etu);
        return retour;
    }
    
    public boolean deleteEtudiant(int code){
        retour = daoEtud.deleteEtudiant(code);
        return retour;
    }
    
}
