package com.ourproject.projetportail.entities;

import jakarta.persistence.*;

@Entity
@Table(name="experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idExperience;

    @Column(nullable = false)
    private Integer codePermProf;
    @ManyToOne(optional = true)
    @JoinColumn(name = "note.idNotecours", nullable = true)
    private NoteCour note;

    @Column(length = 300, nullable = false)
    private String experience;

    public Experience() {
    }

    public Experience(Integer codePermProf, NoteCour note, String experience) {
        this.codePermProf = codePermProf;
        this.note = note;
        this.experience = experience;
    }

    public Integer getIdExperience() {
        return idExperience;
    }

    public void setIdExperience(Integer idExperience) {
        this.idExperience = idExperience;
    }

    public Integer getCodePermProf() {
        return codePermProf;
    }

    public void setCodePermProf(Integer codePermProf) {
        this.codePermProf = codePermProf;
    }

    public NoteCour getNote() {
        return note;
    }

    public void setNote(NoteCour note) {
        this.note = note;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "idExperience=" + idExperience +
                ", codePermProf=" + codePermProf +
                ", note=" + note +
                ", experience='" + experience + '\'' +
                '}';
    }
}
