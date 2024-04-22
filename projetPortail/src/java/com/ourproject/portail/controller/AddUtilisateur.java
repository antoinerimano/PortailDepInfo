/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ourproject.portail.controller;

import com.ourproject.portail.model.entities.Etudiant;
import com.ourproject.portail.model.entities.Professeur;
import com.ourproject.portail.model.entities.Utilisateur;
import com.ourproject.portail.service.EtudiantService;
import com.ourproject.portail.service.ProfesseurService;
import com.ourproject.portail.service.UtilisateurService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nini
 */
public class AddUtilisateur extends HttpServlet {

    UtilisateurService service = new UtilisateurService();
    Utilisateur user = new Utilisateur();
    
    ProfesseurService serviceP = new ProfesseurService();
    Professeur prof = new Professeur();
    
    EtudiantService serviceE = new EtudiantService();
    Etudiant etudiant = new Etudiant();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try{
            //------
            String username = request.getParameter("username");
            System.out.println("the username is: "+username);

            String motdepasse = request.getParameter("password");
            System.out.println("the pwd is: "+motdepasse);

            String type = request.getParameter("typeOfUser");
            System.out.println("the type is: "+type);

            String code = request.getParameter("codep");
            System.out.println("the code is(its length): "+code.length());

            int codeConvert = Integer.parseInt(code);
            //ETUDIANT
            String nom = request.getParameter("nomEtudiant");
            String prenom = request.getParameter("prenomEtudiant");
            System.out.println("the prenom etudiant: "+prenom);
            String naissance = request.getParameter("dateNaissanceEtudiant");
            System.out.println("the date etudiant: "+naissance);
            String program = request.getParameter("studentProgram");
            String typeEtudiant = request.getParameter("studentType");
            String ancient = request.getParameter("ancientOrNot");

            //PROFESSEUR
            String nomP = request.getParameter("nomProf");
            String prenomP = request.getParameter("prenomProf");
            String naissanceP = request.getParameter("dateNaissanceProf");
                
            
            //------
                
            
            System.out.println("the length of it is: "+codeConvert);

            user = new Utilisateur(username,motdepasse,type,codeConvert);

            service.creerUtilisateur(user);

            //-----Now onto create either prof or student (for ancient, 0 is false, any non-zero value is considered true)
            if (type.equals("etudiant") && code.length()>6){
                

                boolean ancienVal = false;
                if (ancient.equals("oui")){
                    ancienVal = true;
                }else if(ancient.equals("non")){
                    ancienVal = false;
                }
                
                etudiant = new Etudiant(codeConvert,nom,prenom,naissance,program,typeEtudiant,ancienVal);
                
                serviceE.creerEtudiant(etudiant);
                
                request.getRequestDispatcher("adminMenu.jsp").forward(request, response);

            }else{
                
                prof = new Professeur(codeConvert,nomP,prenomP,naissanceP);
                
                serviceP.creerProfesseur(prof);
                
                request.getRequestDispatcher("adminMenu.jsp").forward(request, response);

            }


            response.sendRedirect("admin.jsp");
            
        }catch(IOException | NumberFormatException | ServletException e){
            System.out.println(e.getMessage());
            response.sendRedirect("admin.jsp");
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
