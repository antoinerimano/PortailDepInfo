/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unusedAssets;

import unusedAssets.EtudiantDAO;
import unusedAssets.NoteCourDAO;
import unusedAssets.ProfesseurDAO;
import unusedAssets.ProjetDAO;
import unusedAssets.UtilisateurDAO;
import unusedAssets.Etudiant;
import unusedAssets.NoteCours;
import unusedAssets.Professeur;
import unusedAssets.Projet;
import unusedAssets.Utilisateur;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nini
 */
//THIS HAS TO BE MODIFIED BCS THE DATABSE WILL BE REMADE I THINK TO ADD MORE DETAILS AND SO FORTH
public class connectionTest {
    public static void main(String[] args){
        try{
            String url = "jdbc:mysql://127.0.0.1:3306/db_portail";//if the conenction aint working, just change the ip address to yours connection
            String user = "root";
            String password = "root";
            
            //TEST: insertion d'un utilisateur
            System.out.println("INSERTION UTILISATEURS");
            Utilisateur utilisateur = new Utilisateur("JohnDoe","doe123456","Professeur");
            
            UtilisateurDAO utilDAO = new UtilisateurDAO(url,user,password);
            utilDAO.EnregistrerUtilisateur(utilisateur);
            
            utilisateur = new Utilisateur("CainLain","cain123456","Etudiant");
            utilDAO.EnregistrerUtilisateur(utilisateur);
            System.out.println("=======================================");
            
            //TEST: insertion d'un professeur
            System.out.println("INSERTION PROFESSEUR");
            Professeur professeur = new Professeur(1223,"Jean","Paulin-Moisson","12-03-1589");
            
            ProfesseurDAO profDAO = new ProfesseurDAO(url,user,password);
            profDAO.EnregistrerProfesseur(professeur);
            
            professeur = new Professeur(2365,"Ahamada","Dini","11-08-1989");
            profDAO.EnregistrerProfesseur(professeur);
            System.out.println("=======================================");
            
            //TEST: insertion d'un etudiant
            System.out.println("INSERTION ETUDIANT");
            Etudiant etudiant = new Etudiant(3670923,"Sada","Sabzeruz","04-23-1990","programmation","tuteur");
            
            EtudiantDAO etuDAO = new EtudiantDAO(url,user,password);
            etuDAO.EnregistrerEtudiant(etudiant);
            
            etudiant = new Etudiant(1236789,"Turo","Lokpalta","04-23-1991","securite","normal");
            etuDAO.EnregistrerEtudiant(etudiant);
            System.out.println("=======================================");
            
            //TEST: insertion projet
            System.out.println("INSERTION PROJET //NE MARCHE PAS");
            Projet projet = new Projet("RO-470-PROGRAMMATION1","Bonhomme pendue","literally hanging a dude","02-27-2023","programmation","Ahamada Dini","www.git.com","test.jpg","jean, paul, maroline, maria",8);
            
            ProjetDAO proDAO = new ProjetDAO(url,user,password);
            proDAO.EnregistrerProjet(projet);
            
            projet = new Projet("FTO-23-SECURITE1","cacapipi","AHHH","02-27-2013","securite","Jean Doe","www.gitPOPO.com","testCACA.jpg","jean, paul, marAline, maria",9);

            proDAO.EnregistrerProjet(projet);
            System.out.println("=======================================");
            
            //TEST: insertion note de cour
            System.out.println("INSERTION NOTE DE COUR");
            NoteCours notecours2 = new NoteCours("Introduction securite web","MOISSON","FTO-23-SECURITE1","www.git.com/notsussylink/fake/defo",1223);
            NoteCourDAO noteDAO2 = new NoteCourDAO(url,user,password);
            noteDAO2.EnregistrerNoteCours(notecours2);
            
            NoteCours notecours = new NoteCours("Introduction aux servlets","Ahamada Dini","RO-470-PROGRAMMATION1","www.git.com/notsussylink/fake",2365);
            
            NoteCourDAO noteDAO = new NoteCourDAO(url,user,password);
            noteDAO.EnregistrerNoteCours(notecours);
           
            System.out.println("=======================================");
            
            //TEST: chercher utilisateur
            System.out.println("chercher utilisateur");
            utilisateur = utilDAO.getUtilisateurById(1);
            System.out.println(utilisateur.__toString());
            System.out.println("=======================================");
            
            //TEST: chercher professeur
            System.out.println("chercher professeur");
            professeur = profDAO.getProfesseurByCodePerm(1223);
            System.out.println(professeur.__toStringP());//VERY CAREFUL, MUST BE THIS EXACT TO STRING
            System.out.println("=======================================");
            
            //TEST: chercher etudiant
            System.out.println("chercher etudiant");
            etudiant = etuDAO.getEtudiantByCodePerm(2567890);
            System.out.println(etudiant.__toStringE());//VERY CAREFUL, MUST BE THIS EXACT TO STRING
            System.out.println("=======================================");
            
            //TEST: chercher projet
            System.out.println("chercher projet");
            projet = proDAO.getProjetByNom("tictactoe");
            System.out.println(projet.__toString());
            System.out.println("=======================================");
            
            //TEST: chercher note
            System.out.println("chercher note de cour");
            notecours = noteDAO.getNoteCoursByNom("Introduction aux servlets");
            System.out.println(notecours.__toString());
            System.out.println("=======================================");
            
        }catch (SQLException ex){
            Logger.getLogger(connectionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
