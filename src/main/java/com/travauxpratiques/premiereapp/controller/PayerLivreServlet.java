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
import jakarta.servlet.http.HttpSession;

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
        //La variable "sessionSLS" et la variable "sessionPLS" ont la même valeur, puisque c'est toujours le même Objet de type
        //  HttpSession qui est en question. 
        HttpSession sessionPLS = request.getSession();
        //Si l'on fait anouveau un "request.getSession()", on ne va pas regénérer un nouveau numéro de Session. 
        //  On va juste retrouver notre numéro de Session d'origine.
        //On peut essayer de vérifier en récupérant à nouveau ce numéro de Session
        String numeroSessionPLS = sessionPLS.getId();
        //On récupère le numéro de carte saisi dans le formulaire
        String numeroCarte = request.getParameter("numeroCarte");
        //On récupère ici l'information "id" du livre qui est stockée dans la Session
        //  Cette fois on doit utiliser la méthode "getAttribute()" avec le nom("clé") que l'on a choisi pour stocké cette "valeur".
        String identifiantLivre = (String)sessionPLS.getAttribute("identifiantLivre");
        PrintWriter out = response.getWriter();
        //On affiche tout simplement le message suivant
        out.print("<html><body>Paiement effectué avec la carte du numéro " + numeroCarte + "<br>");
        //On affiche donc ici l'"id" du livre qui vient d'être acheté afin de confirmer le bon fonctionnement à l'utilisateur
        out.print("Votre achat pour le livre du numéro " + identifiantLivre + " est finalisé avec succès ! <br>" );
        //On affiche ce numéro récuéré ici
        out.print("Le numéro de session est: " + numeroSessionPLS + "<br>");
        out.print("</body><html>");
    }
}
