/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourproject.portail.service;

import com.ourproject.portail.model.dao.ProjetDAO;
import com.ourproject.portail.model.entities.Projet;
import java.util.List;

/**
 *
 * @author Nini
 */
public class ProjetService {
    
    private List<Projet> listeProjets;
    Projet projet = new Projet();
    boolean retour = false;
    ProjetDAO daoProjet = new ProjetDAO();
    
    //DAO shortcut function
    
    public List<Projet> afficherTousLesProjets(){
        listeProjets = daoProjet.findAllProjet();
        return listeProjets;
    }
    
    public List<Projet> trouverProjetParCodeP(int code){
        listeProjets = daoProjet.findProjetByCodeP(code);
        return listeProjets;
    }
    
    public List<Projet> trouverProjetParNom(String nom){
        listeProjets = daoProjet.findProjetByNom(nom);
        return listeProjets;
    }
    
    //not tested yet (creer et delete trough this)
    public boolean creerProjet(Projet projet){
        retour = daoProjet.createProjet(projet);
        return retour;
    }
    
    public boolean deleteProjet(int id){
        retour = daoProjet.deleteProjet(id);
        return retour;
    }
    
}
