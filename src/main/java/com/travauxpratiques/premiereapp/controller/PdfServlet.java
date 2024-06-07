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
            //     en l'occurence ici ce sera la réponse envoyé au navigateur
            //     "getOutputStream" est le flux de srtie
            PdfWriter.getInstance(documentPdf1, response.getOutputStream());
            //Puis on va écrire dans notre ducumentPdf1
            documentPdf1.open();
            //Dedans on peut écrire ce que l'on veut, avec la Class "Paragraph" importée
            documentPdf1.add(new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "));
            //Puis il suffit de terminer par
            documentPdf1.close();
        } catch (Exception e) {
            //On va ajouter un "prinStackTrace" dans le cas une erreur surviendrait
            e.printStackTrace();
        }
    }

}
