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
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nini
 */
public class SearchController extends HttpServlet {

    private ArrayList<Utilisateur> lstUtilisateurs;
    Utilisateur utilisateurRecherche = null;
    boolean userSearchReturn = false;
    UtilisateurService service = new UtilisateurService();
    /*
    private ArrayList<Etudiant> lstEtudiants;
    Etudiant etu = null;
    boolean etuSearchReturn = false;
    EtudiantService serviceE = new EtudiantService();
    
    private ArrayList<Professeur> lstProfesseurs;
    Professeur prof = null;
    boolean profSearchReturn = false;
    ProfesseurService serviceP = new ProfesseurService();
    */
    
    private ArrayList<Projet> lstProjets;
    Projet projetRecherche = null;
    boolean projetSearchReturn = false;
    ProjetService serviceP = new ProjetService();
    
    private ArrayList<NoteCours> lstNoteCours;
    NoteCours noteRecherche = null;
    boolean noteSearchReturn = false;
    NoteCourService serviceN = new NoteCourService();
    
    private ArrayList<Utilisateur> foundUser = new ArrayList<>();
    private ArrayList<Projet> foundProjet = new ArrayList<>();
    private ArrayList<NoteCours> foundNote = new ArrayList<>();

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String resultat = request.getParameter("result");
        System.out.println(resultat);
        
        if(resultat != null){
            foundUser.clear();
            foundProjet.clear();
            foundNote.clear();
            
            System.out.println("Size of list: "+foundUser.size());
            
            lstUtilisateurs = (ArrayList)service.afficherTousLesUtilisateurs();
            lstProjets = (ArrayList)serviceP.afficherTousLesProjets();
            lstNoteCours = (ArrayList)serviceN.afficherTousLesNoteCours();
            //---------------------------------
           
            if (resultat.toLowerCase().equals("etudiant") || resultat.toLowerCase().equals("professeur")){
                for (int i = 0 ; i < lstUtilisateurs.size();i++){
                    //System.out.println(lstUtilisateurs.get(i).getNomUtilisateur());
                    if(lstUtilisateurs.get(i).getType().toLowerCase().equals(resultat.toLowerCase())){
                        userSearchReturn = true;
                        System.out.println(lstUtilisateurs.get(i).getType());
                        foundUser.add(lstUtilisateurs.get(i));

                    }
                }
                if (userSearchReturn == true){
                    request.setAttribute("typeRetour","user");
                    request.setAttribute("resultatRetour", foundUser);   
                    request.getRequestDispatcher("resultSearch.jsp").forward(request, response);
                }
            }else if (Pattern.matches("[a-zA-Z]+", resultat) == false && resultat.length() > 2) {
                int code = Integer.parseInt(resultat);
                for (int i = 0 ; i < lstUtilisateurs.size();i++){
                    if(lstUtilisateurs.get(i).getCodeP() == Integer.parseInt(resultat)){
                        userSearchReturn = true;
                        foundUser.add(lstUtilisateurs.get(i));

                    }
                }
                if (userSearchReturn == true){
                    request.setAttribute("typeRetour","user");
                    request.setAttribute("resultatRetour", foundUser);   
                    request.getRequestDispatcher("resultSearch.jsp").forward(request, response);
                }
            }else{
            //--------------------------
                for (int i = 0 ; i < lstUtilisateurs.size();i++){
                    if(lstUtilisateurs.get(i).getNomUtilisateur().toLowerCase().equals(resultat.toLowerCase())){
                        userSearchReturn = true;
                        foundUser.add(lstUtilisateurs.get(i));

                    }
                }
                if (userSearchReturn == true && !foundUser.isEmpty()){
                    request.setAttribute("typeRetour","user");
                    System.out.println("OHHHHHHHH");
                    request.setAttribute("resultatRetour", foundUser);   
                    request.getRequestDispatcher("resultSearch.jsp").forward(request, response);
                }
                
            }
            //-------proceeds here if none of the requirements up there are met (will start searching projects and then notes)
            if (userSearchReturn==false){
                for (int i=0; i<lstProjets.size();i++){
                    if (lstProjets.get(i).getNomProjet().toLowerCase().contains(resultat.toLowerCase()) == true){
                        projetSearchReturn = true;
                        foundProjet.add(lstProjets.get(i));
                    }
                }
                if (projetSearchReturn==true && !foundProjet.isEmpty()){
                    request.setAttribute("typeRetour","projet");
                    request.setAttribute("resultatRetour", foundProjet);   
                    request.getRequestDispatcher("resultSearch.jsp").forward(request, response);
                }
                
                for (int i=0; i<lstProjets.size();i++){
                    if (lstProjets.get(i).getNomCour().toLowerCase().contains(resultat.toLowerCase()) == true){
                        projetSearchReturn = true;
                        foundProjet.add(lstProjets.get(i));
                    }
                }
                if (projetSearchReturn==true && !foundProjet.isEmpty()){
                    request.setAttribute("typeRetour","projet");
                    request.setAttribute("resultatRetour", foundProjet);   
                    request.getRequestDispatcher("resultSearch.jsp").forward(request, response);
                }
                //////
                for (int i=0; i<lstNoteCours.size();i++){
                    if (lstNoteCours.get(i).getNomNoteCour().toLowerCase().contains(resultat.toLowerCase()) == true){
                        noteSearchReturn = true;
                        foundNote.add(lstNoteCours.get(i));
                    }
                }
                if (noteSearchReturn==true && !foundNote.isEmpty()){
                    request.setAttribute("typeRetour","note");
                    request.setAttribute("resultatRetour", foundNote);   
                    request.getRequestDispatcher("resultSearch.jsp").forward(request, response);
                }
                
                for (int i=0; i<lstNoteCours.size();i++){
                    if (lstNoteCours.get(i).getCodeCour().toLowerCase().contains(resultat.toLowerCase()) == true){
                        noteSearchReturn = true;
                        foundNote.add(lstNoteCours.get(i));
                    }
                }
                if (noteSearchReturn==true && !foundNote.isEmpty()){
                    request.setAttribute("typeRetour","note");
                    request.setAttribute("resultatRetour", foundNote);   
                    request.getRequestDispatcher("resultSearch.jsp").forward(request, response);
                }
                
            }
            response.sendRedirect("search.jsp");
            
            
            //--------------------
            
        }else{
            
            response.sendRedirect("search.jsp");
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
