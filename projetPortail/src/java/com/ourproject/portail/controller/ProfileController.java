
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourproject.portail.controller;

import com.ourproject.portail.model.dao.EtudiantDAO;
import com.ourproject.portail.model.dao.ProfesseurDAO;
import com.ourproject.portail.model.dao.UtilisateurDAO;
import com.ourproject.portail.model.entities.Etudiant;
import com.ourproject.portail.model.entities.Professeur;
import com.ourproject.portail.model.entities.Utilisateur;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 15146
 */
public class ProfileController extends HttpServlet {

    private UtilisateurDAO utilisateurDAO;
    private EtudiantDAO etudiantDAO;
    private ProfesseurDAO professeurDAO;

    public void init() {
        utilisateurDAO = new UtilisateurDAO();
        etudiantDAO = new EtudiantDAO();
        professeurDAO = new ProfesseurDAO();
    }

        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("codeP")!=null){
            int codeP = (int) session.getAttribute("codeP");
            Utilisateur utilisateur = utilisateurDAO.findAllUtilisateurByCodeP(codeP);
            System.out.println(utilisateur.__toString());

            if(utilisateur.getType().toLowerCase().equals("etudiant")){
                Etudiant etudiant = etudiantDAO.findEtudiantByCodeP(utilisateur.getCodeP());
                request.setAttribute("nom", etudiant.getNom());
                request.setAttribute("prenom", etudiant.getPrenom());
                request.setAttribute("codeP", etudiant.getCodeP());
                request.setAttribute("dateNaissance", etudiant.getDateDeNaissance());
                request.setAttribute("programme", etudiant.getTypeDeProgramme());
                request.setAttribute("typeEtudiant", etudiant.getTypeEtudiant());
                request.setAttribute("ancien", etudiant.isAncien());
            }
            else if(utilisateur.getType().toLowerCase().equals("professeur")){
                Professeur professeur = professeurDAO.findProfesseurByCodeP(utilisateur.getCodeP());
                request.setAttribute("nom", professeur.getNom());
                request.setAttribute("prenom", professeur.getPrenom());
                request.setAttribute("codeP", professeur.getCodeP());
                request.setAttribute("dateNaissance", professeur.getDateDeNaissance());
            }
            else{
                request.setAttribute("nom", "N/A");
                request.setAttribute("prenom", "N/A");
                request.setAttribute("dateNaissance", "N/A");
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/profile.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/erreur.jsp");
        }
    }
        
}
/*

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        /*
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
        /*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
        /*
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
*/
