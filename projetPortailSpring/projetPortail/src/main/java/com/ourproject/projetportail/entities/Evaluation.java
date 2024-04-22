package com.ourproject.projetportail.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name="evaluation")
public class Evaluation {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idEvaluation;

    @OneToOne(optional = true)
    @JoinColumn(name = "projet.idProjet", nullable = true)
    private Projet projet;
    @Column(nullable = false)
    private Integer codePermProf;

    @Column(nullable = false)
    private Integer codePermEtud;

    @Column(nullable = false)
    private Integer note;

    @Column(length = 300)
    private String appreciation;
    @Column(length = 300)
    private String commentaire;

    public Evaluation() {
    }

    public Evaluation(Integer codePermProf, Integer codePermEtud, Integer note) {
        this.codePermProf = codePermProf;
        this.codePermEtud = codePermEtud;
        this.note = note;
    }

    public Evaluation(Integer codePermProf, Integer codePermEtud, Integer note, String appreciation, String commentaire) {
        this.codePermProf = codePermProf;
        this.codePermEtud = codePermEtud;
        this.note = note;
        this.appreciation = appreciation;
        this.commentaire = commentaire;
    }

    public Evaluation(Projet projet, Integer codePermProf, Integer codePermEtud, Integer note, String appreciation, String commentaire) {
        this.projet = projet;
        this.codePermProf = codePermProf;
        this.codePermEtud = codePermEtud;
        this.note = note;
        this.appreciation = appreciation;
        this.commentaire = commentaire;
    }

    public Integer getIdEvaluation() {
        return idEvaluation;
    }

    public void setIdEvaluation(Integer idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public Integer getCodePermProf() {
        return codePermProf;
    }

    public void setCodePermProf(Integer codePermProf) {
        this.codePermProf = codePermProf;
    }

    public Integer getCodePermEtud() {
        return codePermEtud;
    }

    public void setCodePermEtud(Integer codePermEtud) {
        this.codePermEtud = codePermEtud;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "Evaluation{" +
                "idEvaluation=" + idEvaluation +
                ", projet=" + projet +
                ", codePermProf=" + codePermProf +
                ", codePermEtud=" + codePermEtud +
                ", note=" + note +
                ", appreciation='" + appreciation + '\'' +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }
}
