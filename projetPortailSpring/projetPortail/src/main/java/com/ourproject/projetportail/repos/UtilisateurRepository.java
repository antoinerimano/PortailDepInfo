package com.ourproject.projetportail.repos;

import com.ourproject.projetportail.entities.NoteCour;
import com.ourproject.projetportail.entities.Utilisateur;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends CrudRepository<Utilisateur,Integer> {

    @Query("SELECT u FROM Utilisateur u WHERE u.idUtilisateur = :id")
    //@Param est utilisé pour lier le paramètre method au paramètre Query.
    public Utilisateur getUtilisateurById(@Param("id") Integer id);

    @Query("SELECT u FROM Utilisateur u WHERE u.codeP = :codePermanent")
    public Utilisateur getUtilisateurByCodeP(@Param("codePermanent") Integer codePermanent);

    @Query("SELECT u FROM Utilisateur u WHERE u.username = :username")
    public Utilisateur getUtilisateurByUsername(@Param("username") String username);

    @Query("SELECT u FROM Utilisateur u WHERE u.typeEtudiant = :type")
    public List<Utilisateur> getUtilisateurByTypeEtudiant(@Param("type") String type);

    @Query("SELECT u FROM Utilisateur u WHERE u.nom  LIKE %?1% OR u.prenom  LIKE %?1% OR u.username LIKE %?1%")
    public List<Utilisateur> findAllWhereKeywordMatch(String keyword);

    @Query("SELECT u FROM Utilisateur u WHERE u.dateNaissance = :dateNaissance")
    public Utilisateur getUtilisateurByDateNaissance(@Param("dateNaissance") String dateNaissance);

    @Modifying
    @Query("UPDATE Utilisateur u SET u.nom = ?2,u.prenom= ?3,u.username= ?4,u.password= ?5,u.dateNaissance= ?6 WHERE u.idUtilisateur=?1")
    //@Param est utilisé pour lier le paramètre method au paramètre Query.
    public void updateUtilisateur(Integer id, String nom,String prenom, String username, String password, String dateNaissance);

    @Query("SELECT COUNT(u) > 0 FROM Utilisateur u WHERE u.codeP = :codePermanent")
    boolean existsByCodePermanent(Integer codeP);
}
