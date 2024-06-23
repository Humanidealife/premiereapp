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
@WebServlet(name = "SelectionLivreServlet", urlPatterns = {"/selection-livre"})
public class SelectionLivreServlet extends HttpServlet {

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
    //Cette Servlet dispose d'un "doGet", parce que lorsque l'on clique sur un lien ou lorsque l'on entre une URL dans un navigateur,
    //  dans ces cas-là on est forcément en "GET"
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //On récupère l'id du livre ici avec un "request.getParameter"
        String identifiantLivre = request.getParameter("id");
        PrintWriter out = response.getWriter();
        //On se contente d'afficher l'"id" du livre sélectionné
        out.print("<html><body> Merci d'avoir choisi le livre "+ identifiantLivre + "<br>");
        out.print("<a href=\"payer-livre.html\">Cliquer ici pour payer</a></body><html>");
    }

}
