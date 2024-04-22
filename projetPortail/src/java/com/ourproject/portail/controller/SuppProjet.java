/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ourproject.portail.controller;

import com.ourproject.portail.model.entities.Projet;
import com.ourproject.portail.service.ProjetService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nini
 */
public class SuppProjet extends HttpServlet {
    Projet projet;
    ProjetService service = new ProjetService();
    ArrayList<Projet> lstProj = new ArrayList<>();
    boolean success = false;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        lstProj = (ArrayList)service.afficherTousLesProjets();
        
        for (int i = 0; i<lstProj.size(); i++){
            if(lstProj.get(i).getCodeP() == id){
                request.setAttribute("name",lstProj.get(i).getNomProjet());
                service.deleteProjet(lstProj.get(i).getIdProjet());
                success = true;
            }
        }
        if (success == true){
            request.setAttribute("result", " : the project, has been deleted with success!");
            request.getRequestDispatcher("adminMenu.jsp").forward(request, response);
        }else{
           response.sendRedirect("adminMenu.jsp"); 
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
