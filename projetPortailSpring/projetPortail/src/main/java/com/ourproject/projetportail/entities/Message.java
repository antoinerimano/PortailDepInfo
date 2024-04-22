package com.ourproject.projetportail.entities;

import jakarta.persistence.*;

@Entity
@Table(name="message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMessage;
    @Column(nullable=false)
    private int idEtudiantDifficulte;
    @Column(nullable=false)
    private int idTuteur;
    @Column(length = 100, nullable = false)
    private String msg;

    //CONSTRUCTOR


    public Message() {
    }

    public Message(int idEtudiantDifficulte, int idTuteur, String msg) {
        this.idEtudiantDifficulte = idEtudiantDifficulte;
        this.idTuteur = idTuteur;
        this.msg = msg;
    }

    //GET SET

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public int getIdEtudiantDifficulte() {
        return idEtudiantDifficulte;
    }

    public void setIdEtudiantDifficulte(int idEtudiantDifficulte) {
        this.idEtudiantDifficulte = idEtudiantDifficulte;
    }

    public int getIdTuteur() {
        return idTuteur;
    }

    public void setIdTuteur(int idTuteur) {
        this.idTuteur = idTuteur;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    //TO STRING


    @Override
    public String toString() {
        return "Message{" +
                "idMessage=" + idMessage +
                ", idEtudiantDifficulte=" + idEtudiantDifficulte +
                ", idTuteur=" + idTuteur +
                ", msg='" + msg + '\'' +
                '}'+"\n";
    }
}
