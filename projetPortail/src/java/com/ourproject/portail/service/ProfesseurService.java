/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourproject.portail.service;

import com.ourproject.portail.model.dao.ProfesseurDAO;
import com.ourproject.portail.model.entities.Professeur;
import java.util.List;

/**
 *
 * @author Nini
 */
public class ProfesseurService {
    private List<Professeur> listeProfesseurs;
    Professeur professeur = new Professeur();
    boolean retour = false;
    ProfesseurDAO daoProf = new ProfesseurDAO();
    
    //DAO shortcut functions
    public List<Professeur> afficherTousLesProfesseurs(){
        listeProfesseurs = daoProf.findAllProfesseur();
        return listeProfesseurs;
    }
    
    public List<Professeur> chercherProfesseurParNom(String nom){
        listeProfesseurs = daoProf.findProfesseurByNom(nom);
        return listeProfesseurs;
    }
    public Professeur chercherProfesseurParCodeP(int code){
        professeur = daoProf.findProfesseurByCodeP(code);
        return professeur;
    }
    
    public boolean creerProfesseur(Professeur prof){
        retour = daoProf.createProfesseur(prof);
        return retour;
    }
    
    public boolean deleteProfesseur(int code){
        retour = daoProf.deleteProfesseur(code);
        return retour;
    }
    
}
