/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourproject.portail.model.entities;

/**
 *
 * @author Nini
 */
public class Tuteur extends Etudiant{
    //attributes declaration
    private int idTuteur;
    private int codeP;
    private String cour;
    private String typeRencontre;
    private String disponibilite;
    private boolean visibilite;
    
    //constructors

    public Tuteur() {
        this.visibilite = false;
    }

    public Tuteur(int codeP, String cour, String typeRencontre, String disponibilite) {
        this.codeP = codeP;
        this.cour = cour;
        this.typeRencontre = typeRencontre;
        this.disponibilite = disponibilite;
        this.visibilite = false;
    }
    
    //GET
    public int getIdTuteur() {
        return idTuteur;
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

    public boolean isVisibilite() {
        return visibilite;
    }
    
    //SET
    public void setIdTuteur(int idTuteur) {
        this.idTuteur = idTuteur;
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

    public void setVisibilite(boolean visibilite) {
        this.visibilite = visibilite;
    }
    
    //TO STRING
    
    public String toStringTuteur(){
        String msg = "ID: "+idTuteur+" CodeP: "+codeP+" Cour: "+cour+" Type de rencontre: "+typeRencontre+" Dispo: "+disponibilite+" Visibilite: "+visibilite+" \n";
        return msg;
    }
    
    
    
    
}
