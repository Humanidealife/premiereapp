/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.travauxpratiques.premiereapp.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
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
@WebServlet(name = "PdfServlet", urlPatterns = {"/pdf"})
public class PdfServlet extends HttpServlet {

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
    //La Servlet « PdfServlet » répond en « doGet », cela tombe bien, car notre Servlet « Somme » répond également en « doGEt ». 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        
        //La génération d'un fichier PDF peut générer des erreurs, alors on va faire un 
        //  gors bloc "try" "catch"
        try {
            //"Document" est une Class de la librairie que l'on doit importer, c'est le package "com.itextpdf.text"
            Document documentPdf1 = new Document ();
            //Puis on va utiliser une Class "PdfWriter" et sa méthode statique "getInstance".
            //Cette méthode prend 2 paramètres :
            //  1. Le docuemnt source 
            //  2. le flux dans lequel on veut écrire ce document source, 
            //     en l'occurence ici ce sera la réponse envoyé au 
            //     On ne va pas écrire du texte, on veut envoyer un docuement PDF,
            //     On ne va pas faire un "response.getWriter", 
            //     On va plutôt faire un "response.getOutputStream" est "le flux de sortie"
            PdfWriter.getInstance(documentPdf1, response.getOutputStream());
            //Puis on va écrire dans notre ducumentPdf1
            documentPdf1.open();
            //On va d'abord vérifier s'il s'agit pas d'écrire autre chose.
            //Les attributs stockés dans les "scopes" sont stockés sous forme d'Objet grâce à l'auto-boxing "int" est devenu "Integer"
            //On va créer une varaible de type Integer et 
            //  on est le seul à savoir que la "valeur" "somme" dans la "request" est un Integer
            Integer somme = (Integer)request.getAttribute("somme");
            //On va créer une variable de type String
            String message;
            //On va dire que si la somme existe,
            
            if (somme != null ){
                message = "La somme des deux nombres est "+ somme;
            }
            else{
                message = "Bonjour, ceci est une page en format PDF.";
            }
            //Dedans on peut écrire ce que l'on veut, avec la Class "Paragraph" importée
            documentPdf1.add(new Paragraph(message));
            //Puis il suffit de terminer par
            documentPdf1.close();
        } catch (Exception e) {
            //On va ajouter un "prinStackTrace" dans le cas une erreur surviendrait
            e.printStackTrace();
        }
    }

}
