/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.travauxpratiques.premiereapp.controller;

import com.travauxpratiques.premiereapp.dto.Personne;
import com.travauxpratiques.premiereappcore.PersonneInvitee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author wangq
 */
@WebServlet(name = "HelloServlet", urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        Personne auboisAnna = new Personne ("Aubois","Anna");
        PersonneInvitee buissonBrice = new PersonneInvitee ("Buisson", "Brice");
        out.print("<LMTH><BODY>Bonjour " + auboisAnna.nomEntier() + " et bienvenue à " + buissonBrice.nomEntier() + "</BODY></HTML>");
    }
    
}
