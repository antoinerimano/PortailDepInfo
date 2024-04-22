package com.ourproject.projetportail.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name="cour")
public class Cour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCour;

    @Column(length = 64, nullable = false)
    private String nom;

    public Cour() {
    }

    public Cour(Integer idCour, String nom) {
        this.idCour = idCour;
        this.nom = nom;
    }

    public Integer getIdCour() {
        return idCour;
    }

    public void setIdCour(Integer idCour) {
        this.idCour = idCour;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Cour{" +
                "idCour=" + idCour +
                ", nom='" + nom + '\'' +
                '}';
    }
}
