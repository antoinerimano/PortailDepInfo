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
public interface ProjetRepository extends CrudRepository<Projet,Integer> {

    @Modifying
    @Query("UPDATE Projet u SET u.nomProjet = ?2,u.description= ?3,u.cour= ?4,u.professeurSuperviseur= ?5,u.profilProgramme= ?6,u.dateDeCreation=?7,u.etudiantsParticipants=?8,u.lien=?9,u.lienImg=?10 WHERE u.idProjet=?1")
    //@Param est utilisé pour lier le paramètre method au paramètre Query.
    public void updateProjet(Integer id, String nom, String description, Cour cour, String superviseur, String profil, String date, String participants, String lien, String photo);

    @Query("SELECT u FROM Projet u WHERE u.nomProjet  LIKE %?1% OR u.description  LIKE %?1% OR u.cour.nom LIKE %?1% OR u.profilProgramme LIKE %?1% OR u.lien LIKE %?1% OR u.professeurSuperviseur LIKE %?1%")
    public List<Projet> findAllWhereKeywordMatch(String keyword);

    @Query("SELECT u FROM Projet u WHERE u.codeP = :codeP")
    public Projet getProjetByCodeP(@Param("codeP") Integer codeP);

}
