package com.ourproject.projetportail.repos;

import com.ourproject.projetportail.entities.EtudiantDifficulte;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantDifficulteRepository extends CrudRepository<EtudiantDifficulte, Integer> {
}
