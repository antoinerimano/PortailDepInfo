/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ourproject.portail.controller;

import com.ourproject.portail.model.entities.Etudiant;
import com.ourproject.portail.model.entities.NoteCours;
import com.ourproject.portail.model.entities.Professeur;
import com.ourproject.portail.model.entities.Projet;
import com.ourproject.portail.model.entities.Utilisateur;

import com.ourproject.portail.service.EtudiantService;
import com.ourproject.portail.service.NoteCourService;
import com.ourproject.portail.service.ProfesseurService;
import com.ourproject.portail.service.ProjetService;
import com.ourproject.portail.service.UtilisateurService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author antoi
 */
public class ShowAllUser extends HttpServlet {
    List<Utilisateur> listeUtilisateurs;
    UtilisateurService utilisateurService = new UtilisateurService();
    
    /*
    List<Etudiant> listeEtudiants;
    EtudiantService etudiantService = new EtudiantService();
    
    List<Professeur> listeProfesseurs;
    ProfesseurService professeurService = new ProfesseurService();
    */
    private ArrayList<Projet> lstProjets;
    Projet projetRecherche = null;
    boolean projetSearchReturn = false;
    ProjetService serviceP = new ProjetService();
    
    private ArrayList<NoteCours> lstNoteCours;
    NoteCours noteRecherche = null;
    boolean noteSearchReturn = false;
    NoteCourService serviceN = new NoteCourService();
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try{
            String nom = request.getParameter("selectedValue");
            System.out.println(nom);
            if (nom.equals("1")){
                listeUtilisateurs = utilisateurService.afficherTousLesUtilisateurs();
                request.setAttribute("val", nom);
                request.setAttribute("listeUtilisateur", listeUtilisateurs);
                request.getRequestDispatcher("adminPanel.jsp").forward(request, response);

            }else if (nom.equals("2")){
                lstProjets = (ArrayList)serviceP.afficherTousLesProjets();
                request.setAttribute("val",nom);
                request.setAttribute("listeProjet", lstProjets);
                request.getRequestDispatcher("adminPanel.jsp").forward(request, response);
                
            }else if(nom.equals("3")){
                lstNoteCours = (ArrayList)serviceN.afficherTousLesNoteCours();
                request.setAttribute("val",nom);
                request.setAttribute("listeNote", lstNoteCours);
                request.getRequestDispatcher("adminPanel.jsp").forward(request, response);
            }else{
                response.sendRedirect("adminMenu.jsp");
            }
        }catch(IOException | ServletException e){
            System.out.println("Exception dans show all user: "+e.getMessage());
        }
     
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
