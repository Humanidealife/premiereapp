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

/**
 *
 * @author wangq
 */
@WebServlet(name = "Somme", urlPatterns = {"/somme"})
public class Somme extends HttpServlet {


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
        response.setContentType("text/html");
        
        //On va ouvrir un "PrintWriter" pour écrire dans la réponse
        PrintWriter out = response.getWriter();
        //On va écrire quelque chose
        //Pour récupérer un paramètre, il faut utiliser la "request"(requête)
        //La Class HttpServletRequest bénéficie d'une méthode "getParameter", 
        //  on va passer ici en argument le nom du paramètre
        //Cette méthode "request.getParameter" va systématiquement retourner une String
        //On sait que l'on a mis dans nombre1 et nombre2 des chiffres, mais la méthode "getParameter" ne peut pas le savoir
        //On va stocker la valeur du paramètre dans une variable de type de String 
        String nombre1 = request.getParameter("nombre1");
        String nombre2 = request.getParameter("nombre2");
        //On va devoir convertir ces deux varaibles pour en obtenir la somme
        
        
        //on va créer une variable "somme" et on fait la somme des deux paramètres que l'on reçoit
        int somme = Integer.parseInt(nombre1) + Integer.parseInt(nombre2);
        out.print("<HTML><BODY>La somme des deux nombres fournis est "+ somme +" </BODY></HTML>");
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

}
