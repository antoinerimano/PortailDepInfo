/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unusedAssets;

/**
 *
 * @author Nini
 */
public class NoteCours {
    //I AM ASSUMING THIS ALSO MEANS MATERIEL, FOR THE TEACHER SIDE
    //déclaration des attributs (à être modifié)
    private int idNotecours;
    private String nomNoteCour;
    private String auteur;
    private String codeCour;
    private String lien;
    private int codeP;
    
    
    //---
    public NoteCours() {
    }
    
    //déclaration des méthodes
    //arguably, all the consctructors i am creating rn are debatable, they must be modified, input needed
    public NoteCours(String nomNoteCour, String auteur, String codeCour, String lien,int codePermanent) {
        this.nomNoteCour = nomNoteCour;
        this.auteur = auteur;
        this.codeCour = codeCour;
        this.lien = lien;
        this.codeP = codePermanent;
    }
    //---

    public int getIdNotecours() {
        return idNotecours;
    }

    public int getCodeP() {
        return codeP;
    }

    public String getNomNoteCour() {
        return nomNoteCour;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getCodeCour() {
        return codeCour;
    }

    public String getLien() {
        return lien;
    }
    
    
    //---
    
    public void setCodeP(int codeP) {
        this.codeP = codeP;
    }

    public void setNomNoteCour(String nomNoteCour) {
        this.nomNoteCour = nomNoteCour;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setCodeCour(String nomCour) {
        this.codeCour = nomCour;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }
    
    //---
    public String __toString(){
        String msg = " Nom de la note du formulaire: "+nomNoteCour+" Auteur: "+auteur+" Nom du cour: "+codeCour+" Code permanent associe: "+codeP+" \n";
        return msg;
    }
    public String __COMPLETEtoString(){
        String msg = "Id de la note: "+idNotecours+" Nom de la note du formulaire: "+nomNoteCour+" Auteur: "+auteur+" Nom du cour: "+codeCour+" Code permanent associe: "+codeP+" \n";
        return msg;
    }
    
    
}
