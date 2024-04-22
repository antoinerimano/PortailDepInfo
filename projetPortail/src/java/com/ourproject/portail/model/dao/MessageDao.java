package com.ourproject.portail.model.dao;

import com.ourproject.portail.model.entities.Message;
import com.ourproject.portail.model.entities.Tuteur;
import com.ourproject.portail.model.singleton.ConnexionBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageDao {
    private static final String SQL_SELECT_ALL_MESSAGE = "select * from Message";
    private static final String SQL_SELECT_MESSAGE_BY_ID = "select * from Message where idMessage = ?";

    private static final String SQL_CREATE_MESSAGE = "insert into Message (idEtudiantDifficulte,idTuteur,msgContent) values (?,?,?)";
    private static final String DELETE_MESSAGE_BY_ID = "delete from Message where idMessage = ?";
    public boolean createMessage (Message msg){
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try{
            ps = ConnexionBD.getConnection().prepareStatement(SQL_CREATE_MESSAGE);
            System.out.println("result(create user): "+ps.toString());

            ps.setInt(1, msg.getIdEtudiantDifficulte());
            ps.setInt(2,msg.getIdTuteur());
            ps.setString(3,msg.getMsg());




            nbLigne = ps.executeUpdate();

        }catch(SQLException ex){
            System.out.println("Erreur dans createMessage() [MessageDAO.java]: "+ex.getMessage());
            Logger.getLogger(MessageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;

    }
    public boolean deleteMessage(int id) {
        boolean retour = false;
        int nbLigne = 0;



        PreparedStatement ps;


        try {


            ps = ConnexionBD.getConnection().prepareStatement(DELETE_MESSAGE_BY_ID);





            // Supprimer la ligne parente
            ps.setInt(1, id);
            nbLigne = ps.executeUpdate();




            System.out.println(" nbLigne : " + nbLigne);
        } catch (SQLException ex) {
            System.out.println("ERROR WHEN DELETING MESSAGE: "+ex.getMessage());
            Logger.getLogger(MessageDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }
    public List<Message> findAllMessage() {
        List<Message> lstMsg = null;
        try{
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_ALL_MESSAGE);
            System.out.println("result(find all student): "+ps.toString());

            ResultSet res = ps.executeQuery();

            lstMsg = new ArrayList<>();

            while (res.next()){
                Message msg = new Message();

                msg.setIdMessage(res.getInt("idMessage"));
                msg.setIdEtudiantDifficulte(res.getInt("idEtudiantDifficulte"));
                msg.setIdTuteur(res.getInt("idTuteur"));
                msg.setMsg(res.getString("msgContent"));




                lstMsg.add(msg);
            }

        }catch(SQLException ex){
            System.out.println("Erreur dans findAllMessage() [MessageDAO.java]: "+ex.getMessage());
            Logger.getLogger(MessageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();

        return lstMsg;
    }
    public Message findMessageByCodeP(int id){
        Message msg = null;

        try{
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_MESSAGE_BY_ID);
            System.out.println("result(find student by code): "+ps.toString());

            ps.setInt(1, id);

            ResultSet res = ps.executeQuery();

            msg = new Message();

            msg.setIdMessage(res.getInt("idMessage"));
            msg.setIdEtudiantDifficulte(res.getInt("idEtudiantDifficulte"));
            msg.setIdTuteur(res.getInt("idTuteur"));
            msg.setMsg(res.getString("msgContent"));
            //ancien not set, already set automatically in the constructors to false

        }catch(SQLException ex){
            System.out.println("Erreur dans findMessageById() [MessageDAO.java]: "+ex.getMessage());
            Logger.getLogger(MessageDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();

        return msg;

    }
}
