/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unusedAssets;

import java.util.ArrayList;

/**
 *
 * @author Nini
 */
public class Projet {
    //déclaration des attributs (à être modifié)
    private int idProjet;
    private String nomCour;
    private String nomProjet;
    private String description;
    //private String anneeSession;
    private String dateDeCreation;
    private String profilProgramme;
    private String professeurSuperviseur;
    private String lien;
    private String lienImg;
    private String etudiantsParticipants;//this one should be a list of type etudiant?edit: i made it into a arraylist, criticism and judgment input needed to know if right decision
    private int note;
    
    //déclaration des méthodes

    //il faut voir si on aura besoins d<autant d'element pour le constructeur--> temporaire, input needed on this
    //probs need a few more less heavy constructor
    
    public Projet() {    
    }
    //has the bare minimum i think ALSO, how do we deal with DATE elements, wont it cause problem since the date here is a string and not a uhh date attribute??
    public Projet(String nomCour, String nomProjet, String description, String dateDeCreation, String profilProgramme, String professeurSuperviseur, String lien, String etudiantsParticipants) {
        this.nomCour = nomCour;
        this.nomProjet = nomProjet;
        this.description = description;
        this.dateDeCreation = dateDeCreation;
        this.profilProgramme = profilProgramme;
        this.professeurSuperviseur = professeurSuperviseur;
        this.lien = lien;
        this.etudiantsParticipants = etudiantsParticipants;
    }

    //this one adds the imglink
    public Projet(String nomCour, String nomProjet, String description, String dateDeCreation, String profilProgramme, String professeurSuperviseur, String lien, String lienImg, String etudiantsParticipants) {
        this.nomCour = nomCour;
        this.nomProjet = nomProjet;
        this.description = description;
        this.dateDeCreation = dateDeCreation;
        this.profilProgramme = profilProgramme;
        this.professeurSuperviseur = professeurSuperviseur;
        this.lien = lien;
        this.lienImg = lienImg;
        this.etudiantsParticipants = etudiantsParticipants;
    }
    //has EVERYTHING

    public Projet(String nomCour, String nomProjet, String description, String dateDeCreation, String profilProgramme, String professeurSuperviseur, String lien, String lienImg, String etudiantsParticipants,int note) {
        this.nomCour = nomCour;
        this.nomProjet = nomProjet;
        this.description = description;
        this.dateDeCreation = dateDeCreation;
        this.profilProgramme = profilProgramme;
        this.professeurSuperviseur = professeurSuperviseur;
        this.lien = lien;
        this.lienImg = lienImg;
        this.etudiantsParticipants = etudiantsParticipants;
        this.note = note;
    }
    
    //---

    public int getIdProjet() {
        return idProjet;
    }
    
    public String getNomCour() {
        return nomCour;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public String getDescription() {
        return description;
    }

    public String getDateDeCreation() {
        return dateDeCreation;
    }

    public String getProfilProgramme() {
        return profilProgramme;
    }

    public String getProfesseurSuperviseur() {
        return professeurSuperviseur;
    }

    public String getLien() {
        return lien;
    }

    public String getLienImg() {
        return lienImg;
    }

    public String getEtudiantsParticipants() {
        return etudiantsParticipants;
    }

    public int getNote() {
        return note;
    }

    
    //---

    public void setNomCour(String nomCour) {
        this.nomCour = nomCour;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateDeCreation(String dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    public void setProfilProgramme(String profilProgramme) {
        this.profilProgramme = profilProgramme;
    }

    public void setProfesseurSuperviseur(String professeurSuperviseur) {
        this.professeurSuperviseur = professeurSuperviseur;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public void setLienImg(String lienImg) {
        this.lienImg = lienImg;
    }

    public void setEtudiantsParticipants(String etudiantsParticipants) {
        this.etudiantsParticipants = etudiantsParticipants;
    }

    public void setNote(int note) {
        this.note = note;
    }
    
    
    //---
    public String __toString(){
        
        String msg = "Projet: "+nomProjet+" Cour: "+nomCour+" Description: "+description+" \nProfil de programme: "+profilProgramme+" Superviseur: "+professeurSuperviseur+" Lien: "+lien+" Etudiants participants: "+etudiantsParticipants+" Note attribue: "+note+"\n";
        return msg;
    }
    public String __COMPLETEtoString(){
        
        String msg = "Id du projet: "+idProjet+" Projet: "+nomProjet+" Cour: "+nomCour+" Description: "+description+" \nProfil de programme: "+profilProgramme+" Superviseur: "+professeurSuperviseur+" Lien: "+lien+" Etudiants participants: "+etudiantsParticipants+" Note attribue: "+note+"\n";
        return msg;
    }
    
    
    
    
}
