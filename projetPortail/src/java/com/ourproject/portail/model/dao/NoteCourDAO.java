/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourproject.portail.model.dao;

import com.ourproject.portail.model.entities.Etudiant;
import com.ourproject.portail.model.entities.NoteCours;
import com.ourproject.portail.model.singleton.ConnexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nini
 */
public class NoteCourDAO {
    
    private static final String SQL_CREATE_NOTE = "insert into NoteCour (nom,cour,lienGit,codeP) values (?,?,?,?)";
    private static final String SQL_SELECT_ALL_NOTES = "select * from NoteCour";
    private static final String SQL_SELECT_NOTE_BY_CODE = "select * from NoteCour where codeP = ?";
    
    private static final String DELETE_NOTECOUR_BY_ID = "delete from NoteCour where idNoteCour = ?";
    private static final String DELETE_NOTECOUR_LINKED_ELEM = "delete from listeProfesseurNote where idNoteCour = ?";
    
    //---CREATE YER NOTE 
    public boolean createNote(NoteCours note){
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try{
            ps = ConnexionBD.getConnection().prepareStatement(SQL_CREATE_NOTE);
            System.out.println("result(create NOTE): "+ps.toString());
            
            ps.setString(1,note.getNomNoteCour());
            ps.setString(2,note.getCodeCour());
            ps.setString(3, note.getLien());
            ps.setInt(4, note.getCodeP());

            
            nbLigne = ps.executeUpdate();
            
        }catch(SQLException ex){
            System.out.println("Erreur dans createNote() [NoteCourDAO.java]: "+ex.getMessage());
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
        
    }
    
    //WILL PROBABLY BE MODIFIED IF WE ALSO NEED TO DELETE THE NOTE FROM LISTEPROFESSEURNOTE
    public boolean deleteNoteCour(int idNoteCour) {
        boolean retour = false;
        int nbLigne = 0;

        PreparedStatement ps;
        PreparedStatement ps1;

        try {
            ps1 = ConnexionBD.getConnection().prepareStatement(DELETE_NOTECOUR_LINKED_ELEM);
            
            ps = ConnexionBD.getConnection().prepareStatement(DELETE_NOTECOUR_BY_ID);

            ps1.setInt(1, idNoteCour);
            ps1.executeUpdate();
            
            ps.setInt(1, idNoteCour);
            ps.executeUpdate();

            System.out.println(" nbLigne : " + nbLigne);
        } catch (SQLException ex) {
            System.out.println("ERROR WHEN DELETING NOTE: "+ex.getMessage());
            Logger.getLogger(NoteCourDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }
    
    //FIND ALL NOTES
    public List<NoteCours> findAllNote() {
        ArrayList<NoteCours> lstNote = null;
        try{
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ALL_NOTES);
            System.out.println("result(find all note): "+ps.toString());
            
            ResultSet res = ps.executeQuery();
            
            lstNote = new ArrayList<>();
            
            while (res.next()){
                NoteCours note = new NoteCours();
                
                note.setIdNotecours(res.getInt("idNoteCour"));
                note.setCodeP(res.getInt("codeP"));
                note.setCodeCour(res.getString("cour"));
                note.setNomNoteCour(res.getString("nom"));
                note.setLien(res.getString("lienGit"));

                
                lstNote.add(note);
            }
            
        }catch(SQLException ex){
            System.out.println("Erreur dans findAllNote() [NoteCourDAO.java]: "+ex.getMessage());
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        
        return lstNote;
    }
    
    //FIND NOTE BY CODEP
    public ArrayList<NoteCours> findNoteByCodeP(int code){
        ArrayList<NoteCours> lstNote = null;
        
        try{
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_NOTE_BY_CODE);
            System.out.println("result(find NOTE by code): "+ps.toString());
            
            ps.setInt(1, code);
            
            ResultSet res = ps.executeQuery();
            
            lstNote = new ArrayList<>();
            
            while (res.next()){
                NoteCours note = new NoteCours();
                note.setIdNotecours(res.getInt("idNoteCour"));
                note.setCodeP(res.getInt("codeP"));
                note.setCodeCour(res.getString("cour"));
                note.setNomNoteCour(res.getString("nom"));
                note.setLien(res.getString("lienGit"));
                
                lstNote.add(note);
                
            }

        }catch(SQLException ex){
            System.out.println("Erreur dans findNoteByCodeP(int code) [NoteCourDAO.java]: "+ex.getMessage());
            Logger.getLogger(EtudiantDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        
        return lstNote;
        
    }
    
}
