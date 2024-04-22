package com.ourproject.projetportail.entities;

import jakarta.persistence.*;

@Entity
@Table(name="etudiantDifficulte")
public class EtudiantDifficulte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtudiantDifficulte;
    @Column(nullable=false)
    private int codeP;
    @Column(length = 100, nullable = false)
    private String cour;
    @Column(length = 100, nullable = false)
    private String typeRencontre;
    @Column(length = 100, nullable = false)
    private String disponibilite;
    @Column(length = 400, nullable = false)
    private String description;

    @Column(nullable = true)
    private int choix;//le codeP du tuteur qu'il ont choisi

    //CONSTRUCTOR

    public EtudiantDifficulte() {
    }

    public EtudiantDifficulte(int codeP, String cour, String typeRencontre, String disponibilite, String description, int choix) {
        this.codeP = codeP;
        this.cour = cour;
        this.typeRencontre = typeRencontre;
        this.disponibilite = disponibilite;
        this.description = description;
        this.choix = choix;
    }

    //GET SET

    public int getIdEtudiantDifficulte() {
        return idEtudiantDifficulte;
    }

    public void setIdEtudiantDifficulte(int idEtudiantDifficulte) {
        this.idEtudiantDifficulte = idEtudiantDifficulte;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return "EtudiantDifficulte{" +
                "idEtudiantDifficulte=" + idEtudiantDifficulte +
                ", codeP=" + codeP +
                ", cour='" + cour + '\'' +
                ", typeRencontre='" + typeRencontre + '\'' +
                ", disponibilite='" + disponibilite + '\'' +
                ", description='" + description + '\'' +
                ", choix=" + choix +
                '}';
    }
}
