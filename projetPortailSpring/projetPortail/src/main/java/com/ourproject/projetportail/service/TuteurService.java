package com.ourproject.projetportail.service;

import com.ourproject.projetportail.entities.Tuteur;
import com.ourproject.projetportail.repos.TuteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TuteurService {
    @Autowired
    TuteurRepository tuteurRepository;

    public List<Tuteur> getAllTuteur(){
        return (List<Tuteur>) tuteurRepository.findAll();
    }

}
