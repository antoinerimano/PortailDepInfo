/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourproject.portail.service;

import com.ourproject.portail.model.dao.NoteCourDAO;
import com.ourproject.portail.model.entities.NoteCours;
import java.util.List;

/**
 *
 * @author Nini
 */
public class NoteCourService {
    private List<NoteCours> listeNotes;
    NoteCours note = new NoteCours();
    boolean retour = false;
    NoteCourDAO daoNote = new NoteCourDAO();
    
    //DAO shortcut function
    public List<NoteCours> afficherTousLesNoteCours(){
        listeNotes = daoNote.findAllNote();
        return listeNotes;
    }
    
    public List<NoteCours> afficherNoteCoursByCodeP(int code){
        listeNotes = daoNote.findNoteByCodeP(code);
        return listeNotes;
    }
    
    public boolean createNoteCour(NoteCours note){
        retour = daoNote.createNote(note);
        return retour;
    }
    
    public boolean deleteNoteCour(int id){
        retour = daoNote.deleteNoteCour(id);
        return retour;
    }
}
