package com.ourproject.projetportail.entities;

import jakarta.persistence.Entity;

import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name="utilisateur")
public class Utilisateur {
    //DECLARATION ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUtilisateur;

    @Column(nullable = false)
    private Integer codeP;

    @Column(length = 100)
    private String username;

    @Column(length = 100)
    private String password;
    @Column(length = 100)
    private String email;
    @Column(length = 64)
    private String nom;

    @Column(length = 64)
    private String prenom;

    @Column(name = "dateNaissance")
    @Temporal(TemporalType.DATE)
    private String dateNaissance;

    @Column(length=64)
    private String type;

    @Column(length = 100)
    private String programme;

    @Column(length = 100)
    private String typeEtudiant;//normal,tuteur,etudiantDifficulte

    @Column
    private Boolean ancien;






    //CONSTRUCTOR

    public Utilisateur() {
    }


    public Utilisateur(Integer codeP, String username, String password, String email, String nom, String prenom, String dateNaissance, String type, String programme) {
        this.codeP = codeP;
        this.username = username;
        this.password = password;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.type = type;
        this.programme = programme;
    }

    public Utilisateur(Integer codeP, String username, String password, String email, String type, String programme, String typeEtudiant, Boolean ancien) {
        this.codeP = codeP;
        this.username = username;
        this.password = password;
        this.email = email;
        this.type = type;
        this.programme = programme;
        this.typeEtudiant = typeEtudiant;
        this.ancien=ancien;
    }

    public Utilisateur(Integer codeP, String username, String password, String nom, String prenom, String dateNaissance, String email, String type, String programme, String typeEtudiant, Boolean ancien) {
        this.codeP = codeP;
        this.username = username;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.type = type;
        this.programme = programme;
        this.typeEtudiant = typeEtudiant;
        this.ancien=ancien;
    }


    //GET AND SET

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Integer getCodeP() {
        return codeP;
    }

    public void setCodeP(Integer codePermanent) {
        this.codeP = codePermanent;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getType() {
        return type;
    }
    public String getEmail() {
        return email;
    }

    public String getProgramme() {
        return programme;
    }

    public String getTypeEtudiant() {
        return typeEtudiant;
    }

    public Boolean getAncien() {
        return ancien;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public void setTypeEtudiant(String typeEtudiant) {
        this.typeEtudiant = typeEtudiant;
    }

    public void setAncien(Boolean ancien) {
        this.ancien = ancien;
    }


    //---TO STRING

    @Override
    public String toString() {
        return "Utilisateur{" +
                "idUtilisateur=" + idUtilisateur +
                ", codePermanent=" + codeP +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance='" + dateNaissance + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
