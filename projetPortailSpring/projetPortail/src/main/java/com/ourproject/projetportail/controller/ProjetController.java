package com.ourproject.projetportail.controller;

import com.ourproject.projetportail.entities.Cour;
import com.ourproject.projetportail.entities.Utilisateur;
import com.ourproject.projetportail.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.ourproject.projetportail.entities.Projet;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProjetController {
    @Autowired
    private ProjetService projetService;

    @Autowired
    CourService courService;

    @Autowired
    EvaluationService evaluationService;

    @GetMapping("/projet")
    public String afficherProjets(Model model){

        List<Projet> listeProjets = projetService.listAll();
        Projet projet = new Projet();
        model.addAttribute("projet",projet);
        model.addAttribute("listeProjets",listeProjets);
        return "projet";
    }

    @GetMapping("/projet/delete/{id}")
    public String supprimerProjet(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes){
        try{
            evaluationService.deleteEvaluationByIdProjet(id);

            projetService.deleteById(id);
            redirectAttributes.addFlashAttribute("messageDel","le projet : "+id+" a ete supprime.");
        }catch(Exception e){
            redirectAttributes.addFlashAttribute("messageDel","le projet : "+id+" n'a pas ete trouve.");
        }
        System.out.println("Projet "+id+" supp!");
        return "redirect:/adminPanel/two";
    }

    @GetMapping("/projet/edit/{id}")
    public String afficherFormulaireEditProjet(@PathVariable("id") Integer id, Model model){

        Projet projet = projetService.findById(id);

        List<Cour> lstC = courService.findAllCour();

        model.addAttribute("listeCours",lstC);

        model.addAttribute("Projet", projet);

        model.addAttribute("pageTitle","Edit un projet");

        return "projet_edit_form";
    }

    @PostMapping("/projet/edit")
    public String editProjet(Projet projet, RedirectAttributes redirectAttributes,@RequestParam("fileImage") MultipartFile file){

        try{
            System.out.println("AHHHH:"+projet.getCodeP());

            String chemin =  file.getOriginalFilename();
            String typeContenu =  file.getContentType();
            System.out.println("chemin : " + chemin);
            System.out.println("typeContenu : " + typeContenu);
            //Nettegoe du nom fichier en cas des séquences indésirable.
            String fileName = StringUtils.cleanPath(chemin);

            projet.setLienImg(fileName);

            projetService.editProjet(projet);

            redirectAttributes.addFlashAttribute("messageMod","Le projet : "+projet.getNomProjet()+" a ete modifie.");
        }catch(ProjetEditException e){
            redirectAttributes.addFlashAttribute("messageMod","Le projet : "+projet.getNomProjet()+" n'a pas ete modifie.");

        }
        return "redirect:/adminPanel/two";
    }


}
