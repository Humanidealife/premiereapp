/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.travauxpratiques.premiereapp.controller;

import jakarta.servlet.RequestDispatcher;
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
        
        
        //on va créer une variable "Somme" et on fait la somme des deux paramètres que l'on reçoit
        
        //On va intercepter des erreurs de conversion. L'erreur va être générée lorsque "Integer.parseInt" reçoit ici
        //  le "nombre1" ou le "nombre2" qui n'est pas convertible en numérique.
        //On va mettre un grand bloc de "try" "catch" autours de cette partie
        
        try{
            int somme = Integer.parseInt(nombre1) + Integer.parseInt(nombre2);
            //Avant de faire tout, on doit vérifier si l'on a reçu ou pas le paramètre "format".
            String format = request.getParameter("format");
            
            //Pour appliquer le principe MVC, on met le Scope juste au-dessu de la condition "if" pour que cette opération de 
            //  stockage dans le Serveur soit faite das tous les cas (PDF ou HTML).
            request.setAttribute("somme", somme);
            if (format!=null && format.equals("pdf")){
                //Dans ce cas-là, on va faire un "forward" vers la Servlet "PdfServlet" qui a l'URL pour "/pdf"
                //La "portée" "request" c'est aussi l'Objet "request" que l'on connaissait déjà.
                //  On appelle cet attribut avec la clé "somme" également, dans lequel on va stocker 
                //      le résultat de la variable "int"somme
                //Attention ! Ne pas confondre un attribut et un paramètre ! 
                //  Un attribut est donc ce qui est stocké sur le Serveur associé à l'Objet "request".
                //  Un paramètre est ce qui est envoyé du Navigateur à notre Serveur
                //Voilà, on a fait un "setAttribut" dans la première Servlet
                
                RequestDispatcher dispPdf = request.getRequestDispatcher("/pdf");
                dispPdf.forward(request, response);
            }
            //Mais dans le cas contraire, lorsque le format ne vaut pas "pdf", on va écrire la somme en format HTML
            else{
                RequestDispatcher dispPdf = request.getRequestDispatcher("/WEB-INF/affichage-somme.jsp");
                dispPdf.forward(request, response);
                //response.setContentType("text/html;charset=UTF-8");
                //On va ouvrir un "PrintWriter" pour écrire dans la réponse
                //PrintWriter out = response.getWriter();
                //out.print("<HTML><BODY>La somme des deux nombres fournis est "+ somme +" </BODY></HTML>");
            }
        }
        //Il va s'agir d'attraper une erreur de type "NumberFormatException"
        catch(NumberFormatException nfe){
            //Maintenant pour passer la main à une autre ressource, on va utiliser une nouvelle Class qui s'appelle : "RequestDispatcher"(à importer).
            //Pour obtenir cette "RequestDispatcher" on va utiliser "request.getRequestDispatcher"
            //Ce que l'on va mettre entre parenthèses correspond au chemin de la Ressource vers laquelle on veut aller.
            //Cela commence généralement par un "/" qui positionne à la racine des Ressources que l'on sert juste après le "context path", 
            //  c'est-à-dire juste après "premiereapp"
            RequestDispatcher disp = request.getRequestDispatcher("/unexpected-error");
            //Pour réellement se déplacer vers cette Ressource, on va invoquer la méthode "forward" de cette Class "RequestDispatcher",
            //  "forward" prend en paramètres "request" et "response" qui vont correspondre à l'Objet de type "request" et l'Objet de type "response",
            //  que le Moteur de Servlet a fournis à notre Servlet.
            disp.forward(request, response);
        }
        //Si les entrées dans les champs de saisie ne sont pas des "integer", on va passer la main à une autre ressource
        //  qui va se contenter d'afficher le message générique "Erreur inattendue, opération annulée" et on va commencer à utiliser
        //  une page HTML pour ceci. 
        
    }

}
