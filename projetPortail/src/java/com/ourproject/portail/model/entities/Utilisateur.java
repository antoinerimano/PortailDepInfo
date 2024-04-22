/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourproject.portail.model.entities;

/**
 *
 * @author Nini
 */
public class Utilisateur {
    //déclaration des attributs (à être modifié)
    private int id;
    private String nomUtilisateur;
    private String motDePasse;
    private String type;//this has to be modified, i do not think that String is the appropriate type, but i do not know hwo to make it more uhh good?
    private int codeP;
    //déclaration des méthodes
    
    public Utilisateur() {
    }
    
    public Utilisateur(String nomUtilisateur, String motDePasse, String type, int code) {
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
        this.type = type;
        this.codeP = code;
    }
    
    //this constructor down there should prbs never be used?? cuz i put auto increment in the utilisateurId element in the utilisateur tab
    public Utilisateur(int id, String nomUtilisateur, String motDePasse, String type, int code) {
        this.id = id;
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
        this.type = type;
        this.codeP = code;
    }
    //---
    public int getId(){
        return id;
    }
    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getType() {
        return type;
    }
    public int getCodeP(){
        return codeP;
    }
    //---
    public void setId(int id){
        this.id = id;
    }
    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void setCodeP(int code){
        this.codeP = code;
    }
    //---
    public String __toString(){
        String msg = "Nom d'utilisateur: "+nomUtilisateur+" Mot de passe: "+motDePasse+" Type d'utilisateur: "+type+" CodePerm: "+codeP+" \n";
        return msg;
    }
    public String __COMPLETEtoString(){
        String msg = "ID: "+id+" Nom d'utilisateur: "+nomUtilisateur+" Mot de passe: "+motDePasse+" Type d'utilisateur: "+type+" CodePerm: "+codeP+" \n";
        return msg;
    }
    
    
    
    
}
