package com.ourproject.projetportail.service;

import com.ourproject.projetportail.entities.NoteCour;
import com.ourproject.projetportail.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ourproject.projetportail.entities.Projet;
import com.ourproject.projetportail.repos.ProjetRepository;

import java.util.Date;
import java.util.List;

@Service
public class ProjetService {
    @Autowired
    private ProjetRepository repo;

    public List<Projet> listAll() {
        return (List<Projet>) repo.findAll();
    }

    public Projet save(Projet projet) {

        projet.setDateDeCreation(new Date().toString());

        return repo.save(projet);
    }
    public Projet ajouterProjet(Projet projet){
        return  repo.save(projet);
    }

    public Projet findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public void deleteById(Integer id){
        repo.deleteById(id);
    }

    public void editProjet(Projet projet) throws ProjetEditException{
        repo.save(projet);
        //projet ver, faulty down there, just gotta change it to projet
        //repo.updateUtilisateur(utilisateur.getId(),utilisateur.isActive(),utilisateur.getEmail(), utilisateur.getNom(), utilisateur.getPassword(), utilisateur.getPhoto(), utilisateur.getPrenom());
    }

    public List<Projet> chercherProjetsParMotCle(String keyword){
        List<Projet> projets;
        try{
            projets = repo.findAllWhereKeywordMatch(keyword);
        }catch(Exception e){
            projets=null;
            return projets;
        }
        return projets;

    }

    public Projet findByCodeP(Integer codeP){
        Projet projet = repo.getProjetByCodeP(codeP);
        return projet;
    }
}

