package com.ourproject.projetportail.entities;

import jakarta.persistence.*;

@Entity
@Table(name="recommendation")
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRecommendation;
    @Column(nullable = false)
    private Integer codePermProf;
    @Column(length = 64, nullable = false)
    private String nomLivre;
    @Column(length = 300)
    private String lien;
    @Column(length = 300)
    private String img;

    public Recommendation() {
    }

    public Recommendation(Integer codePermProf, String nomLivre) {
        this.codePermProf = codePermProf;
        this.nomLivre = nomLivre;
    }

    public Recommendation(Integer codePermProf, String nomLivre, String lien, String img) {
        this.codePermProf = codePermProf;
        this.nomLivre = nomLivre;
        this.lien = lien;
        this.img = img;
    }

    public Integer getIdRecommendation() {
        return idRecommendation;
    }

    public void setIdRecommendation(Integer idRecommendation) {
        this.idRecommendation = idRecommendation;
    }

    public Integer getCodePermProf() {
        return codePermProf;
    }

    public void setCodePermProf(Integer codePermProf) {
        this.codePermProf = codePermProf;
    }

    public String getNomLivre() {
        return nomLivre;
    }

    public void setNomLivre(String nomLivre) {
        this.nomLivre = nomLivre;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Recommendation{" +
                "idRecommendation=" + idRecommendation +
                ", codePermProf=" + codePermProf +
                ", nomLivre='" + nomLivre + '\'' +
                ", lien='" + lien + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
