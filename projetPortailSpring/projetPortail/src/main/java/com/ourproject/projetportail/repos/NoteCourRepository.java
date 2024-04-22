package com.ourproject.projetportail.repos;

import com.ourproject.projetportail.entities.Cour;
import com.ourproject.projetportail.entities.NoteCour;
import com.ourproject.projetportail.entities.Projet;
import com.ourproject.projetportail.entities.Utilisateur;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteCourRepository extends CrudRepository<NoteCour,Integer> {
    @Modifying
    @Query("UPDATE NoteCour u SET u.cour = ?2,u.nomNoteCour= ?3,u.dateDeCreation= ?4,u.lien= ?5 WHERE u.idNotecours=?1")
    //@Param est utilisé pour lier le paramètre method au paramètre Query.
    public void updateNoteCour(Integer id, Cour code, String nom, String date, String lien);

    @Query("SELECT u FROM NoteCour u WHERE u.nomNoteCour LIKE %?1% OR u.cour.nom  LIKE %?1% OR u.lien LIKE %?1%")
    public List<NoteCour> findAllWhereKeywordMatch(String keyword);

    @Query("SELECT u FROM NoteCour u WHERE u.codeP = :codeP")
    public NoteCour getNoteCourByCodeP(@Param("codeP") Integer codeP);
}
