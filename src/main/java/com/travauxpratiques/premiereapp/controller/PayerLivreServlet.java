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
@WebServlet(name = "PayerLivreServlet", urlPatterns = {"/payer-livre"})
public class PayerLivreServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //On récupère le numéro de carte saisi dans le formulaire
        String numeroCarte = request.getParameter("numeroCarte");
        PrintWriter out = response.getWriter();
        //On affiche tout simplement le message suivant
        out.print("<html><body>Paiement effectué avec la carte du numéro " + numeroCarte + "<br>");
        out.print("</body><html>");
    }
}
