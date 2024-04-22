package com.ourproject.projetportail.controller;

import com.ourproject.projetportail.repos.UtilisateurRepository;
import com.ourproject.projetportail.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.ourproject.projetportail.entities.Utilisateur;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class InscriptionController {

    @Autowired
    UtilisateurService utilisateurService;
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @GetMapping("/utilisateur/inscription")
    public String showInscriptionForm(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "inscription";
    }

    @GetMapping("/utilisateur/inscription_etudiant")
    public String showInscriptionFormEtudiant(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "inscription_etudiant";
    }

    @GetMapping("/utilisateur/inscription_professeur")
    public String showInscriptionFormProfesseur(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "inscription_professeur";
    }

    @PostMapping("/utilisateur/save")
    public String enregistrerUtilisateur(Utilisateur utilisateur, RedirectAttributes redirect) {
        utilisateurService.ajouterUtilisateur(utilisateur);
        redirect.addFlashAttribute("utilisateur", new Utilisateur());
        redirect.addFlashAttribute("message", "L'utilisateur est enregistré avec succès.");
        return "redirect:/accueil";
    }

    @PostMapping("/newUser/save")
    public String ajouterUser(Utilisateur user, RedirectAttributes redirectAttributes){

        String msg = "Bonjour "+user.getNom()+", votre compte est cree, vous pouvez maintenant vous connecter!";
        redirectAttributes.addFlashAttribute("newUserSuccess",msg);

        utilisateurService.ajouterUtilisateur(user);
        return "redirect:/utilisateur/connexion";
    }


}
