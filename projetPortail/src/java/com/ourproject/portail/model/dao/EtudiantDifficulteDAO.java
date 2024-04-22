package com.ourproject.portail.model.dao;

import com.ourproject.portail.model.entities.Etudiant;
import com.ourproject.portail.model.entities.EtudiantDifficulte;
import com.ourproject.portail.model.singleton.ConnexionBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EtudiantDifficulteDAO {
    private static final String SQL_SELECT_ALL_STUDENTDIFFICULTE = "select * from EtudiantDifficulte";
    private static final String SQL_SELECT_STUDENT_BY_CODE = "select * from EtudiantDifficulte where codeP = ?";
    private static final String SQL_SELECT_ALL_STUDENT_BY_COUR = "select * from EtudiantDifficulte where cour = ?";
    private static final String SQL_CREATE_STUDENT = "insert into EtudiantDifficulte (codeP,cour,typeRencontre,disponibilite,description) values (?,?,?,?,?)";
        private static final String DELETE_ETUDIANTDIFFICULTE_BY_CODEP = "delete from EtudiantDifficulte where codeP = ?";

    public boolean createEtudiantDifficulte(EtudiantDifficulte etudD){
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try{
            ps = ConnexionBD.getConnection().prepareStatement(SQL_CREATE_STUDENT);
            System.out.println("result(create user): "+ps.toString());

            ps.setInt(1, etudD.getCodeP());
            ps.setString(2,etudD.getCour());
            ps.setString(2,etudD.getTypeRencontre());
            ps.setString(4, etudD.getDisponibilite());
            ps.setString(5,etudD.getDescription());



            nbLigne = ps.executeUpdate();

        }catch(SQLException ex){
            System.out.println("Erreur dans createEtudiantDIFFICULTE() [EtudiantDifficulteDAO.java]: "+ex.getMessage());
            Logger.getLogger(EtudiantDifficulteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;

    }
    public boolean deleteEtudiant(int codeP) {
        boolean retour = false;
        int nbLigne = 0;



        PreparedStatement ps;


        try {


            ps = ConnexionBD.getConnection().prepareStatement(DELETE_ETUDIANTDIFFICULTE_BY_CODEP);





            // Supprimer la ligne parente
            ps.setInt(1, codeP);
            nbLigne = ps.executeUpdate();




            System.out.println(" nbLigne : " + nbLigne);
        } catch (SQLException ex) {
            System.out.println("ERROR WHEN DELETING ETUDIANTDIFFICULTE: "+ex.getMessage());
            Logger.getLogger(EtudiantDifficulteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }
    public List<EtudiantDifficulte> findAllEtudiantDifficulte() {
        List<EtudiantDifficulte> lstEtudiant = null;
        try{
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ALL_STUDENTDIFFICULTE);
            System.out.println("result(find all student): "+ps.toString());

            ResultSet res = ps.executeQuery();

            lstEtudiant = new ArrayList<>();

            while (res.next()){
                EtudiantDifficulte etudiantD = new EtudiantDifficulte();

                etudiantD.setIdEtudiantDifficulte(res.getInt("idEtudiantDifficulte"));
                etudiantD.setCodeP(res.getInt("codeP"));
                etudiantD.setCour(res.getString("cour"));
                etudiantD.setTypeRencontre(res.getString("typeRencontre"));
                etudiantD.setDisponibilite(res.getString("disponibilite"));
                etudiantD.setDescription(res.getString("description"));



                lstEtudiant.add(etudiantD);
            }

        }catch(SQLException ex){
            System.out.println("Erreur dans findAllEtudiantDifficulte() [EtudiantDIFFICULTEDAO.java]: "+ex.getMessage());
            Logger.getLogger(EtudiantDifficulteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();

        return lstEtudiant;
    }
    public EtudiantDifficulte findEtudiantDifficulteByCodeP(int code){
        EtudiantDifficulte etudiantD = null;

        try{
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_STUDENT_BY_CODE);
            System.out.println("result(find student by code): "+ps.toString());

            ps.setInt(1, code);

            ResultSet res = ps.executeQuery();

            etudiantD = new EtudiantDifficulte();

            etudiantD.setIdEtudiantDifficulte(res.getInt("idEtudiantDifficulte"));
            etudiantD.setCodeP(res.getInt("codeP"));
            etudiantD.setCour(res.getString("cour"));
            etudiantD.setTypeRencontre(res.getString("typeRencontre"));
            etudiantD.setDisponibilite(res.getString("disponibilite"));
            etudiantD.setDescription(res.getString("description"));
            //ancien not set, already set automatically in the constructors to false

        }catch(SQLException ex){
            System.out.println("Erreur dans findEtudiantDifficulteByCodeP(int code) [EtudiantDifficulteDAO.java]: "+ex.getMessage());
            Logger.getLogger(EtudiantDifficulteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();

        return etudiantD;

    }

    public ArrayList<EtudiantDifficulte> findEtudiantDifficulteByNom(String cour){
        ArrayList<EtudiantDifficulte> lstEtudiants = null;

        try{
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ALL_STUDENT_BY_COUR);
            System.out.println("result(find ALL student by name): "+ps.toString());

            ps.setString(1, cour);

            ResultSet res = ps.executeQuery();

            lstEtudiants = new ArrayList<>();

            while (res.next()){
                EtudiantDifficulte etudiantD = new EtudiantDifficulte();

                etudiantD.setIdEtudiantDifficulte(res.getInt("idEtudiantDifficulte"));
                etudiantD.setCodeP(res.getInt("codeP"));
                etudiantD.setCour(res.getString("cour"));
                etudiantD.setTypeRencontre(res.getString("typeRencontre"));
                etudiantD.setDisponibilite(res.getString("disponibilite"));
                etudiantD.setDescription(res.getString("description"));
                //ancien not set, already set automatically in the constructors to false

                lstEtudiants.add(etudiantD);
            }

        }catch(SQLException ex){
            System.out.println("Erreur dans findEtudiantDifficulteByNom(string nom) [EtudiantDifficulteDAO.java]: "+ex.getMessage());
            Logger.getLogger(EtudiantDifficulteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();

        return lstEtudiants;

    }

}
