package com.ourproject.projetportail.repos;

import com.ourproject.projetportail.entities.Cour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourRepository extends CrudRepository<Cour, Integer> {

}
