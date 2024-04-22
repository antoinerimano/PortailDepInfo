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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 15146
 * @author nini
 */
public class ConnexionController extends HttpServlet {
    
    List<Utilisateur> listUtilisateur;
    Utilisateur utilisateur = null;
    //utilisateurService service = new utilisateurService();
    
    UtilisateurService serv = new UtilisateurService();
    
    
    ProfesseurService serviceP = new ProfesseurService();
    Professeur prof = new Professeur();
    
    EtudiantService serviceE = new EtudiantService();
    Etudiant etudiant = new Etudiant();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try{
            String codePString = request.getParameter("codeP");
        
            int codeP = 0;
            int idUtilisateur;

            codeP= Integer.parseInt(codePString);

            boolean connexion = false;
            System.out.println("codeP: "+codeP);

            String password = request.getParameter("password");
            System.out.println("password: "+password);

            String sauvegarde = request.getParameter("sauvegarde");
            utilisateur = serv.verifierCodePMotDePasse(codeP,password);

            if (utilisateur != null){
                //find the utilisateur if student or prof
                if (codePString.length()==7){
                    Etudiant student = serviceE.chercherEtudiantParCodeP(codeP);
                    String nomE = student.getNom();
                    String prenomE = student.getPrenom();
                    String naissanceE = student.getDateDeNaissance();
                    int codePE = student.getCodeP();
                    String programmeE = student.getTypeDeProgramme();
                    boolean ancienE = student.isAncien();
                    String typeE = student.getTypeEtudiant();

                    System.out.println(utilisateur.__toString());
                    connexion = true;
                    HttpSession session = request.getSession(true);
                    String message = "Connexion reussie pour:  ";

                    //name taken from their student tableau
                    session.setAttribute("codeP", codeP);
                    System.out.println("AHHHHH: "+codeP);
                    session.setAttribute("nom",nomE);
                    session.setAttribute("prenom",prenomE);
                    session.setAttribute("dateNaissance",naissanceE);
                    session.setAttribute("programme",programmeE);
                    session.setAttribute("typeEtudiant",typeE);
                    session.setAttribute("ancien",ancienE);

                    idUtilisateur = utilisateur.getId();
                    session.setAttribute("idUtilisateur", idUtilisateur);

                    String username = utilisateur.getNomUtilisateur();
                    session.setAttribute("username", username);

                    String typeUtilisateur = utilisateur.getType();
                    if (typeUtilisateur != null) {
                        session.setAttribute("type", typeUtilisateur);
                    }

                    System.out.println("test-----------------------------");
                    System.out.println(utilisateur.__toString());
                    System.out.println(student.__toStringE());
                    request.setAttribute("message", message);
                    request.setAttribute("nom", nomE);

                    if (sauvegarde != null){
                        if (sauvegarde.equals("yes")){
                            Cookie monCookie = new Cookie("codeP", codePString);
                            Cookie passwordCookie = new Cookie("password", password);
                            System.out.println("Ajouter des cookies");
                            passwordCookie.setMaxAge(60 * 60);
                            monCookie.setMaxAge(60 * 60);
                            response.addCookie(monCookie);
                            response.addCookie(passwordCookie);
                        }
                    }
                    request.getRequestDispatcher("accueil.jsp").forward(request, response);

                }else if(codePString.length()==4){

                    Professeur teacher = serviceP.chercherProfesseurParCodeP(codeP);
                    String nomP = teacher.getNom();
                    String prenomP = teacher.getPrenom();
                    String naissanceP = teacher.getDateDeNaissance();

                    System.out.println(utilisateur.__toString());
                    connexion = true;
                    HttpSession session = request.getSession(true);
                    String message = "Connexion reussie pour:  ";

                    session.setAttribute("nom",nomP);

                    idUtilisateur = utilisateur.getId();
                    session.setAttribute("idUtilisateur", idUtilisateur);

                    String username = utilisateur.getNomUtilisateur();
                    session.setAttribute("username", username);

                    String typeUtilisateur = utilisateur.getType();
                    if (typeUtilisateur != null) {
                        session.setAttribute("type", typeUtilisateur);
                    }

                    System.out.println("test-----------------------------");
                    System.out.println(utilisateur.__toString());
                    System.out.println(teacher.__toStringP());
                    request.setAttribute("message", message);
                    request.setAttribute("nom", nomP);

                    if (sauvegarde != null){
                        if (sauvegarde.equals("yes")){
                            Cookie monCookie = new Cookie("codeP", codePString);
                            Cookie passwordCookie = new Cookie("password", password);
                            System.out.println("Ajouter des cookies");
                            passwordCookie.setMaxAge(60 * 60);
                            monCookie.setMaxAge(60 * 60);
                            response.addCookie(monCookie);
                            response.addCookie(passwordCookie);
                        }
                    }
                    request.getRequestDispatcher("accueil.jsp").forward(request, response);
                }

            }else if (!connexion) {
                request.setAttribute("invalide", "Le code permanent ou mot de passe est invalide");
                request.getRequestDispatcher("connexion.jsp").forward(request, response);
            }
            
        }catch(IOException | NumberFormatException | ServletException e){
            System.out.println("Erreur dans ConnexionController: "+e.getMessage());
            
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
