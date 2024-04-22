package com.ourproject.projetportail.controller;


import com.ourproject.projetportail.entities.*;

import com.ourproject.projetportail.service.CourService;
import com.ourproject.projetportail.service.NoteCourService;
import com.ourproject.projetportail.service.ProjetService;
import com.ourproject.projetportail.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    UtilisateurService utilisateurService;
    @Autowired
    ProjetService projetService;
    @Autowired
    NoteCourService noteservice;
    @Autowired
    UtilisateurService userservice;
    @Autowired
    NoteCourService noteCourService;

    @Autowired
    CourService courService;




    ///================ADMIN
    @GetMapping("admin/login")
    public String afficherAdminLoginPage(){
        return "admin";
    }

    @PostMapping("/admin/check")
    public String afficherAdminMainPageAfterCheck(@RequestParam("password")String password, RedirectAttributes redirectAttributes){
        if(password.equals("pass12345")){

            return "redirect:/creation/new";
        }else{
            return "admin";
        }
    }
    @GetMapping("/adminMenu")
    public String afficherAdminMainPage(){



        return "adminMenu";
    }


    ///=================ADMIN MENU

    ///=================ADMIN MENU AND PANEL
    @GetMapping("/adminPanel/one")
    public String allUser(Model model){
        List<Utilisateur> lst = utilisateurService.afficherTousLesUtilisateurs();
        model.addAttribute("utilisateurs",lst);
        model.addAttribute("panel",1);
        return "adminPanel";

    }
    @GetMapping("/adminPanel/two")
    public String allProjects(Model model){
        List<Projet> lst = projetService.listAll();
        model.addAttribute("projets",lst);
        model.addAttribute("panel",2);
        return "adminPanel";

    }
    @GetMapping("/adminPanel/three")
    public String allNotes(Model model){
        List<NoteCour> lst = noteCourService.listAll();
        model.addAttribute("notes",lst);
        model.addAttribute("panel",3);
        return "adminPanel";

    }
    @GetMapping("/creation/new")
    public String creation(Model model){
        Projet projet = new Projet();
        NoteCour note = new NoteCour();

        List<Cour> cours = courService.findAllCour();
        Cour cour = new Cour();

        Utilisateur user = new Utilisateur();

        projet.setCour(cour);
        note.setCour(cour);

        model.addAttribute("cours",cours);
        model.addAttribute("cour",cour);

        model.addAttribute("user", user);

        model.addAttribute("projet", projet);
        model.addAttribute("note", note);
        return "adminMenu";
    }
    @PostMapping("/projet/save")
    public String ajouterProjet(Projet projet, RedirectAttributes redirectAttributes){

        String msg = "Le projet"+projet.getNomProjet()+" a ete cree!";
        redirectAttributes.addFlashAttribute("projetSucces",msg);

        projetService.save(projet);
        return "redirect:/creation/new";
    }
    @PostMapping("/note/save")
    public String ajouterNotes(NoteCour note, RedirectAttributes redirectAttributes){

        String msg = "Le note de cour "+note.getNomNoteCour()+" a ete cree!";
        redirectAttributes.addFlashAttribute("noteSucces",msg);

        noteCourService.save(note);
        return "redirect:/creation/new";
}
    @PostMapping("/user/save")
    public String ajouterUser(Utilisateur user, RedirectAttributes redirectAttributes){

        String msg = "L'utilisateur  "+user.getNom()+" a ete cree!";
        redirectAttributes.addFlashAttribute("userSucces",msg);

        utilisateurService.ajouterUtilisateur(user);
        return "redirect:/creation/new";
    }





}
