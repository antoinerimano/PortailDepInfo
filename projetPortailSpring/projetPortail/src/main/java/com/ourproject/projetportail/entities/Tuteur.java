package com.ourproject.projetportail.entities;

import jakarta.persistence.*;

@Entity
@Table(name="tuteur")
public class Tuteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTuteur;
    @Column(nullable=false)
    private int codeP;
    @Column(length = 100, nullable = false)
    private String cour;
    @Column(length = 100, nullable = false)
    private String typeRencontre;
    @Column(length = 100, nullable = false)
    private String disponibilite;
    @Column(nullable=false)
    private boolean visibilite;

    @Column(nullable = true)
    private int choix;//le codeP de l'etudiant en difficulte qu'il ont choisi

    //CONSTRUCTOR

    public Tuteur() {
    }
    public Tuteur(int codeP, String cour, String typeRencontre, String disponibilite, boolean visibilite) {
        this.codeP = codeP;
        this.cour = cour;
        this.typeRencontre = typeRencontre;
        this.disponibilite = disponibilite;
        this.visibilite = visibilite;
        this.choix = 0;
    }

    public Tuteur(int codeP, String cour, String typeRencontre, String disponibilite, boolean visibilite, int choix) {
        this.codeP = codeP;
        this.cour = cour;
        this.typeRencontre = typeRencontre;
        this.disponibilite = disponibilite;
        this.visibilite = visibilite;
        this.choix = choix;
    }

    //GET SET

    public int getIdTuteur() {
        return idTuteur;
    }

    public void setIdTuteur(int idTuteur) {
        this.idTuteur = idTuteur;
    }

    public int getCodeP() {
        return codeP;
    }

    public void setCodeP(int codeP) {
        this.codeP = codeP;
    }

    public String getCour() {
        return cour;
    }

    public void setCour(String cour) {
        this.cour = cour;
    }

    public String getTypeRencontre() {
        return typeRencontre;
    }

    public void setTypeRencontre(String typeRencontre) {
        this.typeRencontre = typeRencontre;
    }

    public String getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(String disponibilite) {
        this.disponibilite = disponibilite;
    }

    public boolean isVisibilite() {
        return visibilite;
    }

    public void setVisibilite(boolean visibilite) {
        this.visibilite = visibilite;
    }

    public int getChoix() {
        return choix;
    }

    public void setChoix(int choix) {
        this.choix = choix;
    }

    //TO STRING


    @Override
    public String toString() {
        return "Tuteur{" +
                "idTuteur=" + idTuteur +
                ", codeP=" + codeP +
                ", cour='" + cour + '\'' +
                ", typeRencontre='" + typeRencontre + '\'' +
                ", disponibilite='" + disponibilite + '\'' +
                ", visibilite=" + visibilite +
                ", choix=" + choix +
                '}';
    }
}
