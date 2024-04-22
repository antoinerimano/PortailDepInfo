/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unusedAssets;

/**
 *
 * @author Nini
 */
public class Professeur extends Utilisateur{
    //déclaration des attributs (à être modifié)
    private int idProfesseur;
    private int codePermanent;
    private String nom;
    private String prenom;
    private String dateDeNaissance;
    
    //déclaration des méthodes

    public Professeur() {
    }

    
    public Professeur(int codePermanent, String nom, String prenom, String dateDeNaissance) {
        
        this.codePermanent = codePermanent;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
    }
    //---

    public int getIdProfesseur() {
        return idProfesseur;
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
    
    //---

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
    
    //---
    public String __toStringP(){
        String msg = "Code permanent: "+codePermanent+" Nom: "+nom+" Prenom: "+prenom+" Date de naissance: "+dateDeNaissance+" \n";
        return msg;
    }
    public String __COMPLETEtoStringP(){
        String msg = "Id professeur: "+idProfesseur+"Code permanent: "+codePermanent+" Nom: "+nom+" Prenom: "+prenom+" Date de naissance: "+dateDeNaissance+" \n";
        return msg;
    }
    
}
