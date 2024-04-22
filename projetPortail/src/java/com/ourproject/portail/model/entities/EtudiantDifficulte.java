/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourproject.portail.model.entities;

/**
 *
 * @author Nini
 */
public class EtudiantDifficulte extends Etudiant{
    //declaration of attributes
    private int idEtudiantDifficulte;
    private int codeP;
    private String cour;
    private String typeRencontre;
    private String disponibilite;
    private String description;
    
    //constructors

    public EtudiantDifficulte() {
    }

    public EtudiantDifficulte(int codeP, String cour, String typeRencontre, String disponibilite, String description) {
        this.codeP = codeP;
        this.cour = cour;
        this.typeRencontre = typeRencontre;
        this.disponibilite = disponibilite;
        this.description = description;
    }
    
    //GET

    public int getIdEtudiantDifficulte() {
        return idEtudiantDifficulte;
    }

    public int getCodeP() {
        return codeP;
    }

    public String getCour() {
        return cour;
    }

    public String getTypeRencontre() {
        return typeRencontre;
    }

    public String getDisponibilite() {
        return disponibilite;
    }

    public String getDescription() {
        return description;
    }
    
    //SET

    public void setIdEtudiantDifficulte(int idEtudiantDifficulte) {
        this.idEtudiantDifficulte = idEtudiantDifficulte;
    }

    public void setCodeP(int codeP) {
        this.codeP = codeP;
    }

    public void setCour(String cour) {
        this.cour = cour;
    }

    public void setTypeRencontre(String typeRencontre) {
        this.typeRencontre = typeRencontre;
    }

    public void setDisponibilite(String disponibilite) {
        this.disponibilite = disponibilite;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    //TO STRING
    
    public String toStringDifficulte(){
        String msg = "ID: "+idEtudiantDifficulte+" CodeP: "+codeP+" Cour: "+cour+" Type de rencontre: "+typeRencontre+" Dispo: "+disponibilite+" Description: "+description+" \n";;
        return msg;
    }
    
    
}
