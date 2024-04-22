package com.ourproject.projetportail.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="projet")
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProjet;

    @Column(length = 100, nullable = false)
    private String nomProjet;

    //@Column(length = 100, nullable = false)
    //private String nomCour;
    @OneToOne(optional = true)
    @JoinColumn(name="cour.idCour",nullable = true)
    private Cour cour;
    @Column(length = 400, nullable = true)
    private String description;
    @Column(name = "dateDeCreation")
    @Temporal(TemporalType.DATE)
    private String dateDeCreation;
    @Column(length = 100, nullable = true)
    private String profilProgramme;
    @Column(length = 100, nullable = true)
    private String professeurSuperviseur;
    @Column(length = 400, nullable = true)
    private String lien;
    @Column(length = 400, nullable = true)
    private String lienImg;

    @Column(length = 100, nullable = true)
    private String etudiantsParticipants;

    @Column(nullable = false)
    private int codeP;



    //CONSTRUCTOR

    public Projet() {
    }

    public Projet(String nomProjet, Cour cour, String description, String dateDeCreation, String profilProgramme, String professeurSuperviseur, String lien, String lienImg, int codeP) {
        this.nomProjet = nomProjet;
        this.cour = cour;
        this.description = description;
        this.dateDeCreation = dateDeCreation;
        this.profilProgramme = profilProgramme;
        this.professeurSuperviseur = professeurSuperviseur;
        this.lien = lien;
        this.lienImg = lienImg;
        this.codeP = codeP;
    }

    public Projet(String nomProjet, Cour cour, String description, String dateDeCreation, String profilProgramme, String professeurSuperviseur, String lien, String lienImg, String etudiantsParticipants, int codeP) {
        this.nomProjet = nomProjet;
        this.cour = cour;
        this.description = description;
        this.dateDeCreation = dateDeCreation;
        this.profilProgramme = profilProgramme;
        this.professeurSuperviseur = professeurSuperviseur;
        this.lien = lien;
        this.lienImg = lienImg;
        this.etudiantsParticipants = etudiantsParticipants;
        this.codeP = codeP;
    }

    //GET SET

    public Integer getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(Integer idProjet) {
        this.idProjet = idProjet;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    /*
    public String getNomCour() {
        return nomCour;
    }

    public void setNomCour(String nomCour) {
        this.nomCour = nomCour;
    }

     */

    public Cour getCour() {
        return cour;
    }

    public void setCour(Cour cour) {
        this.cour = cour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(String dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    public String getProfilProgramme() {
        return profilProgramme;
    }

    public void setProfilProgramme(String profilProgramme) {
        this.profilProgramme = profilProgramme;
    }

    public String getProfesseurSuperviseur() {
        return professeurSuperviseur;
    }

    public void setProfesseurSuperviseur(String professeurSuperviseur) {
        this.professeurSuperviseur = professeurSuperviseur;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getLienImg() {
        return lienImg;
    }

    public void setLienImg(String lienImg) {
        this.lienImg = lienImg;
    }

    public String getEtudiantsParticipants() {
        return etudiantsParticipants;
    }

    public void setEtudiantsParticipants(String etudiantsParticipants) {
        this.etudiantsParticipants = etudiantsParticipants;
    }

    public int getCodeP() {
        return codeP;
    }

    public void setCodeP(int codeP) {
        this.codeP = codeP;
    }

    //TO STRING

    @Override
    public String toString() {
        return "Projet{" +
                "idProjet=" + idProjet +
                ", nomProjet='" + nomProjet + '\'' +
                ", cour=" + cour.toString() +
                ", description='" + description + '\'' +
                ", dateDeCreation='" + dateDeCreation + '\'' +
                ", profilProgramme='" + profilProgramme + '\'' +
                ", professeurSuperviseur='" + professeurSuperviseur + '\'' +
                ", lien='" + lien + '\'' +
                ", lienImg='" + lienImg + '\'' +
                ", etudiantsParticipants='" + etudiantsParticipants + '\'' +

                ", codeP=" + codeP +
                '}';
    }
}
