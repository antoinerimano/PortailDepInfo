package com.ourproject.portail.model.dao;

import com.ourproject.portail.model.entities.EtudiantDifficulte;
import com.ourproject.portail.model.entities.Tuteur;
import com.ourproject.portail.model.singleton.ConnexionBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TuteurDAO {
    private static final String SQL_SELECT_ALL_TUTEUR = "select * from Tuteur";
    private static final String SQL_SELECT_TUTEUR_BY_CODE = "select * from Tuteur where codeP = ?";

    private static final String SQL_CREATE_TUTEUR = "insert into Tuteur (codeP,cour,typeRencontre,disponibilite,visisbilite) values (?,?,?,?,?)";
    private static final String DELETE_TUTEUR_BY_CODEP = "delete from Tuteur where codeP = ?";
    public boolean createTuteur(Tuteur tuteur){
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try{
            ps = ConnexionBD.getConnection().prepareStatement(SQL_CREATE_TUTEUR);
            System.out.println("result(create user): "+ps.toString());

            ps.setInt(1, tuteur.getCodeP());
            ps.setString(2,tuteur.getCour());
            ps.setString(2,tuteur.getTypeRencontre());
            ps.setString(4, tuteur.getDisponibilite());
            ps.setBoolean(5,tuteur.isVisibilite());



            nbLigne = ps.executeUpdate();

        }catch(SQLException ex){
            System.out.println("Erreur dans createTuteur() [TuteurDAO.java]: "+ex.getMessage());
            Logger.getLogger(TuteurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;

    }
    public boolean deleteTuteur(int codeP) {
        boolean retour = false;
        int nbLigne = 0;



        PreparedStatement ps;


        try {


            ps = ConnexionBD.getConnection().prepareStatement(DELETE_TUTEUR_BY_CODEP);





            // Supprimer la ligne parente
            ps.setInt(1, codeP);
            nbLigne = ps.executeUpdate();




            System.out.println(" nbLigne : " + nbLigne);
        } catch (SQLException ex) {
            System.out.println("ERROR WHEN DELETING TUTEUR: "+ex.getMessage());
            Logger.getLogger(TuteurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }
    public List<Tuteur> findAllTuteur() {
        List<Tuteur> lstTuteur = null;
        try{
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ALL_TUTEUR);
            System.out.println("result(find all student): "+ps.toString());

            ResultSet res = ps.executeQuery();

            lstTuteur = new ArrayList<>();

            while (res.next()){
                Tuteur tuteur = new Tuteur();

                tuteur.setIdTuteur(res.getInt("idTuteur"));
                tuteur.setCodeP(res.getInt("codeP"));
                tuteur.setCour(res.getString("cour"));
                tuteur.setTypeRencontre(res.getString("typeRencontre"));
                tuteur.setDisponibilite(res.getString("disponibilite"));
                tuteur.setVisibilite(res.getBoolean("visibilite"));



                lstTuteur.add(tuteur);
            }

        }catch(SQLException ex){
            System.out.println("Erreur dans findAllTuteur() [TuteurDAO.java]: "+ex.getMessage());
            Logger.getLogger(TuteurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();

        return lstTuteur;
    }
    public Tuteur findTuteurByCodeP(int code){
        Tuteur tuteur = null;

        try{
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_TUTEUR_BY_CODE);
            System.out.println("result(find student by code): "+ps.toString());

            ps.setInt(1, code);

            ResultSet res = ps.executeQuery();

            tuteur = new Tuteur();

            tuteur.setIdTuteur(res.getInt("idTuteur"));
            tuteur.setCodeP(res.getInt("codeP"));
            tuteur.setCour(res.getString("cour"));
            tuteur.setTypeRencontre(res.getString("typeRencontre"));
            tuteur.setDisponibilite(res.getString("disponibilite"));
            tuteur.setVisibilite(res.getBoolean("visibilite"));
            //ancien not set, already set automatically in the constructors to false

        }catch(SQLException ex){
            System.out.println("Erreur dans findTuteurByCodeP(int code) [TuteurDAO.java]: "+ex.getMessage());
            Logger.getLogger(TuteurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();

        return tuteur;

    }

}
