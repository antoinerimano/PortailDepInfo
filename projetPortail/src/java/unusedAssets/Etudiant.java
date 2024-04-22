/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unusedAssets;

/**
 *
 * @author Nini
 */
public class Etudiant extends Utilisateur{
    //déclaration des attributs (à être modifié)
    private int idEtudiant;
    private int codePermanent;
    private String nom;
    private String prenom;
    private String dateDeNaissance;
    private String typeDeProgramme;
    private String typeEtudiant;
    //should have a list of projects --> 
    //uml graph
    //diagramme de classe
   
    
    //déclaration des méthodes
    
    public Etudiant() {
    }

    public Etudiant(int codePermanent, String nom, String prenom, String dateDeNaissance, String type, String ty) {
        this.codePermanent = codePermanent;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.typeDeProgramme = type;
        this.typeEtudiant = ty;
    }
    //---

    public String getTypeEtudiant() {
        return typeEtudiant;
    }
    
    
    public int getIdEtudiant() {
        return idEtudiant;
    }

    public int getCodePermanent() {
        return codePermanent;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDateDeNaissance() {
        return dateDeNaissance;
    }

    public String getTypeDeProgramme() {
        return typeDeProgramme;
    }
    
    
    //---
    
    
    public void setTypeEtudiant(String typeEtudiant) {
        this.typeEtudiant = typeEtudiant;
    }

    public void setCodePermanent(int codePermanent) {
        this.codePermanent = codePermanent;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateDeNaissance(String dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public void setTypeDeProgramme(String type) {
        this.typeDeProgramme = type;
    }
    
    //---
    public String __toStringE(){
        String msg = "Code permanent = "+codePermanent+" Nom: "+nom+" Prenom: "+prenom+" Date de naissance: "+dateDeNaissance+" Programme"+typeDeProgramme+" \n";
        return msg;
    }
    public String __COMPLETEtoStringE(){
        String msg = "Id Etudiant"+idEtudiant+"Code permanent = "+codePermanent+" Nom: "+nom+" Prenom: "+prenom+" Date de naissance: "+dateDeNaissance+" Programme"+typeDeProgramme+" Type Etudiant: "+typeEtudiant+" \n";
        return msg;
    }
    

    
    
    
    
    
}
