package com.ourproject.projetportail.controller;

import com.ourproject.projetportail.entities.Cour;
import com.ourproject.projetportail.entities.Tuteur;
import com.ourproject.projetportail.entities.Utilisateur;
import com.ourproject.projetportail.service.CourService;
import com.ourproject.projetportail.service.EtudiantDifficulteService;
import com.ourproject.projetportail.service.TuteurService;
import com.ourproject.projetportail.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TutoratController {


    @Autowired
    CourService courService;

    @Autowired
    TuteurService tuteurService;

    @Autowired
    EtudiantDifficulteService etudiantDifficulteService;

    @Autowired
    UtilisateurService utilisateurService;


    @GetMapping("/tutorat/accueil")
    public String tutoratAccueil() {

        return "tutorat";
    }

    @GetMapping("/tutorat/liste-cours-offerts")
    public String tutoratShowCours(Model model, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("COURS","true");
        List<Cour> lstCours = courService.findAllCour();
        if(lstCours.isEmpty()){
            System.out.println("IS EMPTY");
        }
        model.addAttribute("listeCours",lstCours);

        return "liste_cours";
    }

    @GetMapping("/tutorat/liste-tuteurs-par-programme")
    public String tutoratShowTuteurs(Model model, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("TUTEURS","true");
        List<Utilisateur> lstUser = utilisateurService.chercherUtilisateurParTypeEtudiant("tuteur");
        /*
        List<Utilisateur> lstStudent = null;
        List<Utilisateur> lstProf = null;
        for(Utilisateur user : lstUser){
            if(user.getType().trim().toLowerCase().equals("etudiant")){
                lstStudent.add(user);
            }else if (user.getType().trim().toLowerCase().equals("professeur")){
                lstProf.add(user);
            }
        }
         */
        List<Tuteur> lstTuteurs = tuteurService.getAllTuteur();
        if(lstTuteurs.isEmpty()){
            System.out.println("EMPTY BITCH");
        }
        model.addAttribute("lstTuteurs",lstTuteurs);
        model.addAttribute("listeUtilisateurTuteur",lstUser);

        return "liste_tuteurs";
    }

    @GetMapping("/tutorat/liste-etudiant-en-difficulte")
    public String tutoratShowEtudiantDiff(Model model){
        return "tutorat";
    }



}
