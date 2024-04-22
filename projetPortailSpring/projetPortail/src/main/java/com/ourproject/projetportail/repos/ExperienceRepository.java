package com.ourproject.projetportail.repos;

import com.ourproject.projetportail.entities.Experience;
import com.ourproject.projetportail.entities.Message;
import com.ourproject.projetportail.entities.Projet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends CrudRepository<Experience, Integer> {

    @Query("SELECT u FROM Experience u WHERE u.note.idNotecours = :note")
    public List<Experience> getExperienceByNoteId(@Param("note") Integer note);
}
