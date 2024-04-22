package com.ourproject.projetportail.service;

import com.ourproject.projetportail.entities.Evaluation;
import com.ourproject.projetportail.entities.Experience;
import com.ourproject.projetportail.repos.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository repository;

    public List<Experience> getExperienceByNoteId(Integer noteId){
        return repository.getExperienceByNoteId(noteId);
    }

    public void deleteExperienceByIdNote(Integer id){
        List<Experience> lst = (List<Experience>) repository.findAll();

        for (Experience exp:lst){
            if (exp.getNote().getIdNotecours()==id){
                repository.deleteById(exp.getIdExperience());
            }
        }
    }

}
