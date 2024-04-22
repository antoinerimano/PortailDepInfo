package com.ourproject.projetportail.repos;

import com.ourproject.projetportail.entities.NoteCour;
import com.ourproject.projetportail.entities.Tuteur;
import com.ourproject.projetportail.entities.Utilisateur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TuteurRepository extends CrudRepository<Tuteur,Integer> {

}
