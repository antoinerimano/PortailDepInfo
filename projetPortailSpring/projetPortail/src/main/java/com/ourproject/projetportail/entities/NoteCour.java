package com.ourproject.projetportail.entities;

import jakarta.persistence.*;

@Entity
@Table(name="notecour")
public class NoteCour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotecours;
    @Column(length = 100, nullable = true)
    private String nomNoteCour;
    //@Column(length = 100, nullable = false)
    //private String codeCour;
    @ManyToOne(optional = true)
    @JoinColumn(name="cour.id",nullable = true)
    private Cour cour;
    @Column(length = 400, nullable = true)
    private String lien;
    @Column(name = "dateDeCreation")
    @Temporal(TemporalType.DATE)
    private String dateDeCreation;
    @Column(nullable = false)
    private int codeP;



    //CONSTRUCTOR

    public NoteCour() {
    }

    public NoteCour(int idNotecours, String nomNoteCour, Cour cour, String lien, String dateDeCreation, int codeP) {
        this.idNotecours = idNotecours;
        this.nomNoteCour = nomNoteCour;
        this.cour = cour;
        this.lien = lien;
        this.dateDeCreation = dateDeCreation;
        this.codeP = codeP;
    }

    public NoteCour(String nomNoteCour, Cour cour, String lien, String dateDeCreation, int codeP) {
        this.nomNoteCour = nomNoteCour;
        this.cour = cour;
        this.lien = lien;
        this.dateDeCreation = dateDeCreation;
        this.codeP = codeP;
    }
    //GET SET

    public int getIdNotecours() {
        return idNotecours;
    }

    public void setIdNotecours(int idNotecours) {
        this.idNotecours = idNotecours;
    }

    public String getNomNoteCour() {
        return nomNoteCour;
    }

    public void setNomNoteCour(String nomNoteCour) {
        this.nomNoteCour = nomNoteCour;
    }

    /*
    public String getCodeCour() {
        return codeCour;
    }

    public void setCodeCour(String codeCour) {
        this.codeCour = codeCour;
    }
    */

    public Cour getCour() {
        return cour;
    }

    public void setCour(Cour cour) {
        this.cour = cour;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public int getCodeP() {
        return codeP;
    }

    public void setCodeP(int codeP) {
        this.codeP = codeP;
    }

    public String getDateDeCreation() {
        return dateDeCreation;
    }

    public void setDateDeCreation(String dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    //TO STRING

    @Override
    public String toString() {
        return "NoteCour{" +
                "idNotecours=" + idNotecours +
                ", nomNoteCour='" + nomNoteCour + '\'' +
                ", cour=" + cour.toString() +
                ", lien='" + lien + '\'' +
                ", dateDeCreation='" + dateDeCreation + '\'' +
                ", codeP=" + codeP +
                '}';
    }
}
