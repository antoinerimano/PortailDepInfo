package com.ourproject.projetportail.service;

import com.ourproject.projetportail.entities.Cour;
import com.ourproject.projetportail.repos.CourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourService {

    @Autowired
    CourRepository repo;

    public List<Cour> findAllCour(){
        return (List<Cour>) repo.findAll();
    }
}
