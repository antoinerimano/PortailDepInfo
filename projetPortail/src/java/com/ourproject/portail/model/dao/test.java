/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourproject.portail.model.dao;

import com.ourproject.portail.model.entities.Projet;
import com.ourproject.portail.model.entities.Utilisateur;
import java.util.List;

/**
 *
 * @author antoi
 */
public class test {
    
             
    
        public static void main(String[] args) {
           ProjetDAO projetDao =new ProjetDAO();
           Projet proj =new Projet("dasdas","sadsa","sadasd","sadasd","dssda","saddsa","das","dsfsd", "dafadafs", 4234);
           projetDao.createProjet(proj);
    }
    
}
