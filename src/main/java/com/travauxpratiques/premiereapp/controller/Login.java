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
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {


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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Pour récupérer les informatiosn comme "login" et "mot de passe", on va effectuer un "request.getParameter"
        //  comme cela aurait été le cas s'il avait sagit d'un "doGet"
        String login = request.getParameter("login");
        String password = request.getParameter("password");
         try (PrintWriter out = response.getWriter()){
            String htmlReponse = """
                <!DOCTYPE html>
                <!--
                Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
                Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
                -->
                <html>
                    <head>
                        <!-- cette balise "title" correspond au title qui va s'affichier dans le navigateur pour cette page -->
                        <title>Ėtat de connexion</title>
                        <meta charset="UTF-8">
                        <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    </head>
                    <body>
                        <!-- On va afficher à l'utilisteur  -->
                         Vous êtes bien connecté(e) avec l'identifiant "%s" et le mot de passe "%s" ! <br>
                        <a href="home">Cliquer ici pour retourner à la page d'accueil</a>
                    </body>
                </html>
                                 """.formatted(login, password);
            out.println(htmlReponse);
        }
    }

}
