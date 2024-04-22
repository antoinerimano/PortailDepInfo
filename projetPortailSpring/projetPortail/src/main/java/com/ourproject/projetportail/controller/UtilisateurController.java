package com.ourproject.projetportail.controller;

import com.ourproject.projetportail.entities.Utilisateur;
import com.ourproject.projetportail.service.UtilisateurEditException;
import com.ourproject.projetportail.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UtilisateurController {
    @Autowired
    UtilisateurService service;

    @GetMapping("/utilisateur/delete/{id}")
    public String supprimerUtilisateur(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes){
        try{
            service.supprimerUtilisateurById(id);
            redirectAttributes.addFlashAttribute("messageDel","l'utilisateur : "+id+" a ete supprime.");
        }catch(Exception e){
            redirectAttributes.addFlashAttribute("messageDel","l'utilisateur : "+id+" n'a pas ete trouve.");
        }
        System.out.println("Utilisateur "+id+" supp!");
        return "redirect:/adminPanel/one";
    }

    @GetMapping("/utilisateur/edit/{id}")
    public String afficherFormulaireEditUser(@PathVariable("id") Integer id, Model model){

        Utilisateur utilisateur = service.chercherUtilisateurParId(id);

        model.addAttribute("utilisateur", utilisateur);

        model.addAttribute("pageTitle","Edit un utilisateur");

        return "utilisateur_edit_form";
    }

    @PostMapping("/utilisateur/edit")
    public String editUtilisateur(Utilisateur utilisateur, RedirectAttributes redirectAttributes){

        try{
            System.out.println("AHHHH:"+utilisateur.getIdUtilisateur());

            service.editUtilisateur(utilisateur);

            redirectAttributes.addFlashAttribute("messageMod","l'utilisateur : "+utilisateur.getCodeP()+" a ete modifie.");
        }catch(UtilisateurEditException e){
            redirectAttributes.addFlashAttribute("messageMod","l'utilisateur : "+utilisateur.getCodeP()+" n'a pas ete modifie.");

        }
        return "redirect:/adminPanel/one";
    }

}
