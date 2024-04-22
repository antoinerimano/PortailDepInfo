package com.ourproject.projetportail.repos;

import com.ourproject.projetportail.entities.Evaluation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository extends CrudRepository<Evaluation,Integer> {
}
