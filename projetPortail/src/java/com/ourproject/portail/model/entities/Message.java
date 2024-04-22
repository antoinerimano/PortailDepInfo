/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourproject.portail.model.entities;

/**
 *
 * @author Nini
 */
public class Message {
    //declaration of variables
    private int idMessage;
    private int idEtudiantDifficulte;
    private int idTuteur;
    private String msg;
    
    //constructs

    public Message() {
    }

    public Message(int idMessage, int idEtudiantDifficulte, int idTuteur, String msg) {
        this.idMessage = idMessage;
        this.idEtudiantDifficulte = idEtudiantDifficulte;
        this.idTuteur = idTuteur;
        this.msg = msg;
    }
    //get

    public int getIdMessage() {
        return idMessage;
    }

    public int getIdEtudiantDifficulte() {
        return idEtudiantDifficulte;
    }

    public int getIdTuteur() {
        return idTuteur;
    }

    public String getMsg() {
        return msg;
    }
    
    //set

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public void setIdEtudiantDifficulte(int idEtudiantDifficulte) {
        this.idEtudiantDifficulte = idEtudiantDifficulte;
    }

    public void setIdTuteur(int idTuteur) {
        this.idTuteur = idTuteur;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    //to string
    
    public String toStringMsg(){
        String msg = "MSG ID: "+this.idMessage+" id of the student in difficulty: "+this.idEtudiantDifficulte+" id tuteur: "+idTuteur+" MSG: "+this.msg+" \n";
        return msg;
    }
    
}
