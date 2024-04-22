/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ourproject.portail.controller;

import com.ourproject.portail.model.dao.ProjetDAO;
import com.ourproject.portail.model.entities.Projet;
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
public class AddProject extends HttpServlet {
ProjetDAO projetDAO=new ProjetDAO();
List<Projet> listeProjet;
  

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String nom = request.getParameter("nomProjet");
        String cours = request.getParameter("coursProjet");
        String description = request.getParameter("description");
        String dateCreation = request.getParameter("dateCreation");
        String programme = request.getParameter("programme");
        String superviseur = request.getParameter("superviseur");
        String lienGit = request.getParameter("lienGitProjet");
        String lienImg = request.getParameter("lienImg");
        int note = Integer.parseInt(request.getParameter("note"));
        int codeP = Integer.parseInt(request.getParameter("codepProjet"));
        Projet projet = new Projet(cours, nom, description, dateCreation, programme,superviseur, lienGit);
        projetDAO.createProjet(projet);

        
        request.getRequestDispatcher("adminMenu.jsp").forward(request, response);
        
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
