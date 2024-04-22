package com.ourproject.projetportail.service;

import com.ourproject.projetportail.entities.Utilisateur;
import com.ourproject.projetportail.repos.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    UtilisateurRepository repos;

    public List<Utilisateur> afficherTousLesUtilisateurs(){
        return (List<Utilisateur>) repos.findAll();
    }

    public Utilisateur chercherUtilisateurParId(int id){
        Utilisateur user;
        user = repos.getUtilisateurById(id);
        return user;

    }

    public List<Utilisateur> chercherUtilisateurParTypeEtudiant(String type){
        List<Utilisateur> users;
        users = repos.getUtilisateurByTypeEtudiant(type);
        return users;
    }
    public Utilisateur chercherUtilisateurParCodeP(int codeP){
        Utilisateur user;
        try{
            user = repos.getUtilisateurByCodeP(codeP);
        }catch(Exception e){
            user=null;
            return user;
        }
        return user;

    }
    public Utilisateur chercherUtilisateurParUsername(String username){
        Utilisateur user;
        try{
            user = repos.getUtilisateurByUsername(username);
        }catch(Exception e){
            user=null;
            return user;
        }
        return user;

    }
    public Utilisateur chercherUtilisateurParDate(String date){
        Utilisateur user;
        try{
            user = repos.getUtilisateurByDateNaissance(date);
        }catch(Exception e){
            user=null;
            return user;
        }
        return user;

    }
    public List<Utilisateur> chercherUtilisateursParMotCle(String keyword){
        List<Utilisateur> users;
        try{
            users = repos.findAllWhereKeywordMatch(keyword);
        }catch(Exception e){
            users=null;
            return users;
        }
        return users;

    }
    public Utilisateur ajouterUtilisateur(Utilisateur user) {return repos.save(user);}

    public void supprimerUtilisateurById(int id){
        repos.deleteById(id);
    }

    public void editUtilisateur(Utilisateur utilisateur) throws UtilisateurEditException{
        repos.save(utilisateur);
        //repo.updateUtilisateur(utilisateur.getId(),utilisateur.isActive(),utilisateur.getEmail(), utilisateur.getNom(), utilisateur.getPassword(), utilisateur.getPhoto(), utilisateur.getPrenom());
    }

}
