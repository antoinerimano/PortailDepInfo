package com.ourproject.projetportail.service;

import com.ourproject.projetportail.entities.Evaluation;
import com.ourproject.projetportail.repos.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationService {

    @Autowired
    EvaluationRepository repo;

    public void deleteEvaluationByIdProjet(Integer id){
        List<Evaluation> lst = (List<Evaluation>) repo.findAll();

        for (Evaluation eval:lst){
            if (eval.getProjet().getIdProjet()==id){
                repo.deleteById(eval.getIdEvaluation());
            }
        }
    }

}
