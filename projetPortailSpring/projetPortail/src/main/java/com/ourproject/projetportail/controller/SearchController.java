package com.ourproject.projetportail.controller;

import com.ourproject.projetportail.entities.*;
import com.ourproject.projetportail.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;
import java.util.regex.Pattern;

@Controller
public class SearchController {

    @Autowired
    UtilisateurService serviceU;

    @Autowired
    ProjetService serviceP;

    @Autowired
    NoteCourService serviceN;




    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    @GetMapping("/search")
    public String searchPage(){
        return "search";
    }

    @GetMapping("/search/utilisateur")
    public String searchSpecifics(Model model, RedirectAttributes redirectAttributes, @RequestParam("entry") String entry, HttpSession session){
        System.out.println("The user has entered :"+entry);
        String cleanedEntry = entry.trim();

        if(session.getAttribute("codeP")==null){
            List<Projet> projets;
            List<NoteCour> noteCours;


            //if letters
            if (isNumeric(entry.trim().toLowerCase())==false){
                model.addAttribute("typeT","text");
                projets = serviceP.chercherProjetsParMotCle(cleanedEntry);
                if(projets!=null){
                    redirectAttributes.addFlashAttribute("projectPresenceT","true");
                    model.addAttribute("ProjetsT",projets);
                }
            }else{//else will see if codeP or not
                model.addAttribute("typeN","numeric");
                projets = (List<Projet>)serviceP.findByCodeP(Integer.parseInt(cleanedEntry));
                if(projets!=null){
                    redirectAttributes.addFlashAttribute("projectPresenceC","true");
                    model.addAttribute("ProjetsC",projets);
                }
            }

            return "resultSearch";
        }


        List<Projet> projets;
        List<NoteCour> noteCours;


        //if letters
        if (isNumeric(entry.trim().toLowerCase())==false){

            model.addAttribute("typeT","text");

            projets = serviceP.chercherProjetsParMotCle(cleanedEntry);
            noteCours = serviceN.chercherNoteCoursParMotCle(cleanedEntry);
            if(projets!=null){
                redirectAttributes.addFlashAttribute("projectPresenceT","true");
                model.addAttribute("ProjetsT",projets);
            }
            if(noteCours!=null){
                redirectAttributes.addFlashAttribute("notePresenceT","true");
                model.addAttribute("NotesT",noteCours);
            }

        }else{//else will see if codeP or not

            model.addAttribute("typeN","numeric");

            projets = (List<Projet>)serviceP.findByCodeP(Integer.parseInt(cleanedEntry));
            noteCours = (List<NoteCour>)serviceN.findByCodeP(Integer.parseInt(cleanedEntry));

            if(projets!=null){
                redirectAttributes.addFlashAttribute("projectPresenceC","true");
                model.addAttribute("ProjetsC",projets);
            }
            if(noteCours!=null){
                redirectAttributes.addFlashAttribute("notePresenceC","true");
                model.addAttribute("NotesC",noteCours);
            }
        }

        return "resultSearch";
    }


    /*
    @GetMapping("/profile_click/utilisateur/{id}")
    public String goToClickedProfileUtilisateur(Model model, @PathVariable("id") Integer id,RedirectAttributes redirectAttributes){
        Utilisateur user = serviceU.chercherUtilisateurParId(id);
        System.out.println(user.getCodePermanent().toString().trim().length());

        if (user.getCodePermanent().toString().trim().length()==4){
            model.addAttribute("utilisateurP",user);

            return "profile_click_projet";

        }else if(user.getCodePermanent().toString().trim().length()==7){

            model.addAttribute("utilisateurE",user);

            return "profile_click_projet";
        }
        return "redirect:/accueil";
    }
    */

    @GetMapping("/profile_click/projet/{id}")
    public String goToClickedProfileProjet(Model model, @PathVariable("id") Integer id, RedirectAttributes redirectAttributes){
        System.out.println("ID OF THE PROJECT IS "+id);
        Projet proj = serviceP.findById(id);
        Utilisateur user = serviceU.chercherUtilisateurParCodeP(proj.getCodeP());


        if(proj!=null && user!=null) {
            System.out.println(proj.toString());
            model.addAttribute("typeP","projet");
            model.addAttribute("utilisateurP", user);
            model.addAttribute("projet", proj);
        }
        return "profile_click_projet";
    }
    @GetMapping("/profile_click/noteCour/{id}")
    public String goToClickedProfileNoteCour(Model model, @PathVariable("id") Integer id,RedirectAttributes redirectAttributes){
        System.out.println("ID OF THE NOTE IS "+id);
        NoteCour note =serviceN.findById(id);
        Utilisateur user = serviceU.chercherUtilisateurParCodeP(note.getCodeP());

        if(note!=null && user!=null){



            model.addAttribute("typeN","note");
            model.addAttribute("utilisateurN",user);
            model.addAttribute("note",note);
        }
        return "profile_click_note";
    }
}
