/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.travauxpratiques.premiereapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wangq
 */
@WebServlet(name = "TestThreadSafeServlet", urlPatterns = {"/testThread"})
public class TestThreadSafeServlet extends HttpServlet {

    //Cette déclaration crée une variable s'instance
    //String montant;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Ici on détermine le montant que l'utilisateur souhaite retirer en récupérant un paramètre nommé "montant"
        //Ici on crée une variable locale qui appartient à la méthode "doGet"
        String montant = request.getParameter("montant");
        //Ce code fait une pause à l'exécution pendant 10 secondes. 
        try {
            //Cela signifie que l'on souhaite que le processus d'exécution courant fasse une pause de 10000 millisecondes = 10 secondes
            //On a créé cette pause pour essayer de lancer cette requête 2 fois en parallèle à destination de la même Servlet
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            //Ici on a un "try catch" parce que cette pause peut lever des execeptions, mais ici on n'entre pas dans le détail. 
            //Il faut importer la CLass "java.util.logging.Level"
            Logger.getLogger(TestThreadSafeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        PrintWriter out = response.getWriter();
        //A la fin de la méthode "doGet" on affiche le String "montant" souhaité. 
        out.print("<html><body>Vous avez retiré " + montant + " euros</body></html>");
    }

}
