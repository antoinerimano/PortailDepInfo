package com.ourproject.projetportail.entities;

import jakarta.persistence.*;

@Entity
@Table(name="lienUtile")
public class lienUtile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLienUtile;

    @Column(nullable = false)
    private Integer codePermProf;

    @Column(length = 400, nullable = false)
    private String lien;

    public lienUtile() {
    }

    public lienUtile(Integer codePermProf, String lien) {
        this.codePermProf = codePermProf;
        this.lien = lien;
    }

    public Integer getIdLienUtile() {
        return idLienUtile;
    }

    public void setIdLienUtile(Integer idLienUtile) {
        this.idLienUtile = idLienUtile;
    }

    public Integer getCodePermProf() {
        return codePermProf;
    }

    public void setCodePermProf(Integer codePermProf) {
        this.codePermProf = codePermProf;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    @Override
    public String toString() {
        return "lienUtile{" +
                "idLienUtile=" + idLienUtile +
                ", codePermProf=" + codePermProf +
                ", lien='" + lien + '\'' +
                '}';
    }
}
