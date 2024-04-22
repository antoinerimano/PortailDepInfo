package com.ourproject.projetportail.controller;

import com.ourproject.projetportail.entities.Cour;
import com.ourproject.projetportail.entities.Projet;
import com.ourproject.projetportail.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.ourproject.projetportail.entities.NoteCour;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class NoteCourController {
    @Autowired
    private NoteCourService noteCourService;

    @Autowired
    CourService courService;

    @Autowired
    ExperienceService experienceService;

    @GetMapping("/noteCour")
    public String afficherNoteCours(Model model){

        List<NoteCour> listeNoteCours = noteCourService.listAll();
        NoteCour noteCour = new NoteCour();
        model.addAttribute("NoteCour",noteCour);
        model.addAttribute("listeNoteCours",listeNoteCours);
        return "notes";
    }
    @PostMapping("/noteCour/save")
    public String ajouterNoteCour(NoteCour noteCour){

        noteCourService.save(noteCour);
        return "redirect:/noteCour";
    }

    @GetMapping("/noteCour/delete/{id}")
    public String supprimerUtilisateur(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes){
        try{
            System.out.println("THE ID OF THE NOTE BEING DELETED IS : "+id);
            experienceService.deleteExperienceByIdNote(id);
            noteCourService.deleteById(id);
            redirectAttributes.addFlashAttribute("messageDel","Note de cour : "+id+" a ete supprime.");
        }catch(Exception e){
            redirectAttributes.addFlashAttribute("messageDel","Note de cour : "+id+" n'a pas ete trouve.");
        }
        System.out.println("Note de cour "+id+" supp!");
        return "redirect:/adminPanel/three";
    }

    @GetMapping("/noteCour/edit/{id}")
    public String afficherFormulaireEditUser(@PathVariable("id") Integer id, Model model){

        NoteCour noteCour = noteCourService.findById(id);

        List<Cour> lstC = courService.findAllCour();

        model.addAttribute("listeCours",lstC);

        model.addAttribute("NoteCour", noteCour);

        model.addAttribute("pageTitle","Edit une note de cour");

        return "noteCour_edit_form";
    }

    @PostMapping("/noteCour/edit")
    public String editNoteCour(NoteCour noteCour, RedirectAttributes redirectAttributes){

        try{
            System.out.println("AHHHH:"+noteCour.getCodeP());

            noteCourService.editNoteCour(noteCour);

            redirectAttributes.addFlashAttribute("messageMod","La note de cour : "+noteCour.getNomNoteCour()+" a ete modifie.");
        }catch(NoteEditException e){
            redirectAttributes.addFlashAttribute("messageMod","La note de cour : "+noteCour.getNomNoteCour()+" n'a pas ete modifie.");

        }
        return "redirect:/adminPanel/three";
    }

}
