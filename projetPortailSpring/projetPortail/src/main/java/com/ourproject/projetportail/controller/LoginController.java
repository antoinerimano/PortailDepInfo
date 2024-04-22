package com.ourproject.projetportail.controller;

import com.ourproject.projetportail.entities.Utilisateur;
import com.ourproject.projetportail.service.UtilisateurService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/utilisateur/connexion")
    public String showLoginForm() {
        return "connexion";
    }

    @GetMapping("/utilisateur/connexion/success")
    public String login(@RequestParam("codeP") Integer codeP,
                        @RequestParam("password") String password, HttpSession session,
                        RedirectAttributes redirectAttributes) {
        Utilisateur user = utilisateurService.chercherUtilisateurParCodeP(codeP);
        if (user != null && user.getPassword().equals(password)) {
            String msg="Bienvenue utilisateur "+codeP+" vous etes maintenant connecte.";
            redirectAttributes.addFlashAttribute("successLogin", msg);
            session.setAttribute("codeP", codeP);

            System.out.println(user);
            return "redirect:/accueil";
        } else {
            redirectAttributes.addFlashAttribute("error", "Saisies invalides.");
            return "redirect:/utilisateur/connexion";
        }
    }

    @GetMapping("/accueil")
    public String accueil(Model model) {
        return "accueil";
    }

    @GetMapping("/deconnexion")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/accueil";
    }
}
