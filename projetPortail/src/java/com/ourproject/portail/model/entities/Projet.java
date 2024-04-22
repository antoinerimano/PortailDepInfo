/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourproject.portail.model.entities;

import java.util.ArrayList;

/**
 *
 * @author Nini
 */
public class Projet {
    //déclaration des attributs (à être modifié)
    private int idProjet;
    private String nomProjet;
    private String nomCour;
    private String description;
    private String dateDeCreation;
    private String profilProgramme;
    private String professeurSuperviseur;
    private String lien;
    private String lienImg;
    private String etudiantsParticipants;
    private int note;
    private int codeP;
    
    //déclaration des méthodes
    
    public Projet() {    
    }
    //has the bare minimum i think -->date format is: [year]-[month]-[day]
    public Projet(String nomCour, String nomProjet, String description, String dateDeCreation, String profilProgramme, String professeurSuperviseur, String lien) {
        this.nomCour = nomCour;
        this.nomProjet = nomProjet;
        this.description = description;
        this.dateDeCreation = dateDeCreation;
        this.profilProgramme = profilProgramme;
        this.professeurSuperviseur = professeurSuperviseur;
        this.lien = lien;
       
        
    }

    //this one adds the imglink
    public Projet(String nomCour, String nomProjet, String description, String dateDeCreation, String profilProgramme, String professeurSuperviseur, String lien, String lienImg, String etudiant, int note) {
        this.nomCour = nomCour;
        this.nomProjet = nomProjet;
        this.description = description;
        this.dateDeCreation = dateDeCreation;
        this.profilProgramme = profilProgramme;
        this.professeurSuperviseur = professeurSuperviseur;
        this.lien = lien;
        this.lienImg = lienImg;
        this.etudiantsParticipants =etudiant;
        this.note = note;
        
    }
    //has EVERYTHING

    public Projet(String nomCour, String nomProjet, String description, String dateDeCreation, String profilProgramme, String professeurSuperviseur, String lien, String lienImg,int note, int codeP) {
        this.nomCour = nomCour;
        this.nomProjet = nomProjet;
        this.description = description;
        this.dateDeCreation = dateDeCreation;
        this.profilProgramme = profilProgramme;
        this.professeurSuperviseur = professeurSuperviseur;
        this.lien = lien;
        this.lienImg = lienImg;
        
        this.note = note;
        this.codeP = codeP;
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

    public int getCodeP() {
        return codeP;
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

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }

    public void setCodeP(int codeP) {
        this.codeP = codeP;
    }
    
    
    //---
    public String __toString(){
        
        String msg = "codeP owner: "+codeP+"Projet: "+nomProjet+" Cour: "+nomCour+" Description: "+description+" \nProfil de programme: "+profilProgramme+" Superviseur: "+professeurSuperviseur+" Lien: "+lien+" Etudiants participants: "+etudiantsParticipants+" Note attribue: "+note+"\n";
        return msg;
    }
    public String __COMPLETEtoString(){
        
        String msg = "codeP owner: "+codeP+"Id du projet: "+idProjet+" Projet: "+nomProjet+" Cour: "+nomCour+" Description: "+description+" \nProfil de programme: "+profilProgramme+" Superviseur: "+professeurSuperviseur+" Lien: "+lien+" Etudiants participants: "+etudiantsParticipants+" Note attribue: "+note+"\n";
        return msg;
    }
    
    
    
    
}
