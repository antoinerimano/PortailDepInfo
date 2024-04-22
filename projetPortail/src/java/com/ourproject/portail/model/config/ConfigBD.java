/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ourproject.portail.model.config;

/**
 *
 * @author Nini
 */
public class ConfigBD {
    //  Définir l’url de connexion avec le nom de la base donnée
    //the link of the db is not yet confirmed, it wont work 
    public final static String URL = "jdbc:mysql://127.0.0.1:3306/projet_portail_db?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
    //utilisateur de la bd
    public final static String USER ="root";
    //mot de passe de la bd
    public final static String PASSWORD ="root";
    // le driver mysql
    public final static String DRIVER="com.mysql.cj.jdbc.Driver";
    
    //BAO's connection (bao, when u connect, just comment upstair connection, when ur done, uncomment it if possible)
    /*
    //  Définir l’url de connexion avec le nom de la base donnée
    //the link of the db is not yet confirmed, it wont work 
    public final static String URL = "jdbc:mysql://localhost:8080/projet_portail_db";
    //utilisateur de la bd
    public final static String USER ="root";
    //mot de passe de la bd
    public final static String PASSWORD ="1234";
    // le driver mysql
    public final static String DRIVER="com.mysql.cj.jdbc.Driver";
    */
    
}
