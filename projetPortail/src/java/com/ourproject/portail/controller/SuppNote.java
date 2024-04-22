/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ourproject.portail.controller;

import com.ourproject.portail.model.entities.NoteCours;
import com.ourproject.portail.service.NoteCourService;
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
public class SuppNote extends HttpServlet {

    NoteCours note;
    NoteCourService service = new NoteCourService();
    ArrayList<NoteCours> lstNote = new ArrayList<>();
    boolean success = false;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        lstNote = (ArrayList)service.afficherTousLesNoteCours();
        
        for (int i = 0; i<lstNote.size(); i++){
            if(lstNote.get(i).getCodeP() == id){
                request.setAttribute("name",lstNote.get(i).getNomNoteCour());
                service.deleteNoteCour(lstNote.get(i).getIdNotecours());
                success = true;
            }
        }
        if (success == true){
            request.setAttribute("result", " : the note de cour, has been deleted with success!");
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
