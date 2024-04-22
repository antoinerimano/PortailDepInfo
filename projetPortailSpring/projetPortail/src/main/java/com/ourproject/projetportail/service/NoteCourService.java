package com.ourproject.projetportail.service;

import com.ourproject.projetportail.entities.Projet;
import com.ourproject.projetportail.entities.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ourproject.projetportail.entities.NoteCour;
import com.ourproject.projetportail.repos.NoteCourRepository;

import java.util.List;

@Service
public class NoteCourService {
    @Autowired
    private NoteCourRepository repo;

    public List<NoteCour> listAll() {
        return (List<NoteCour>) repo.findAll();
    }

    public NoteCour save(NoteCour noteCour) {
        return repo.save(noteCour);
    }

    public NoteCour findById(Integer id) {

        return repo.findById(id).orElse(null);
    }

    public NoteCour findByCodeP(Integer codeP){
        NoteCour note = repo.getNoteCourByCodeP(codeP);
        return note;
    }

    public void deleteById(Integer id){
        repo.deleteById(id);
    }


    public void editNoteCour(NoteCour noteCour) throws NoteEditException{
        repo.save(noteCour);
        //noteCour ver, faulty down there, just gotta add it to noteCour and add it to the repo
        //repo.updateUtilisateur(utilisateur.getId(),utilisateur.isActive(),utilisateur.getEmail(), utilisateur.getNom(), utilisateur.getPassword(), utilisateur.getPhoto(), utilisateur.getPrenom());
    }


    public List<NoteCour> chercherNoteCoursParMotCle(String keyword){
        List<NoteCour> notes;
        try{
            notes = repo.findAllWhereKeywordMatch(keyword);
        }catch(Exception e){
            notes=null;
            return notes;
        }
        return notes;

    }

}

