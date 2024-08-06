/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.travauxpratiques.premiereapp.controller;

import com.travauxpratiques.premiereappcore.Livre;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
        //On crée une variable de type "HttpSession" dans laquelle on stocke le résultat de l'appel "request.getSession"
        //  On doit importer la Class "HttpSession"
        HttpSession sessionSLS = request.getSession();
        //On peut ajouter une "session utilisateur" en écrivant tout simplement "request.getSession()" 
        //dans la méthode de Servlet qui nous intéresse. 
        //Là on demande au Serveur de démarrer le suivi de la session utilisateur
        //Pour connaitre le numéro de cette session, on peut faire
        //Après avoir ajouté la variable "sessionSLS" on peut la réutiliser dans notre code ci-dessous
        //  pour remplacer "request.getSession"
        //String numeroSession = sessionSLS.getId();
        //On récupère l'id du livre ici avec un "request.getParameter"
        String identifiantLivre = request.getParameter("id");
        //Après avoir récupérer l'"id" du livre, on peut ajouter 
        //"setAttribute()" va nous permettre d'ajouter un attribut en Session 
        //  avec une "clé"(qui est complètement libre)
        //  et une "valeur"(complètement libre également), ici on reprend la String "identifiantLivre" qui est juste au-dessus
        //Cette information est désormais en Session, on peut la récupérer à tout moment, par exemple dans une ature Servlet
        
        //Plutôt que de stocker l’« identifiantLivre » tel que sous forme de String, en Session on a stocker un Livre.
        //On va créer une instance de livre
        
        //À chaque fois on va recevoir un « identifiantLivre » à ajouter dans notre « pool » de livres à payer, 
        //  plutôt que d’ajouter un livre en Session, on va rajouter une Collection de livres. 
        //La première chose c'est que cette Collection peut déjà exister, il peut s'agir de la deuxième fois que l'on arrive dans
        //  cette Servlet.
        //Donc la première chose à faire c'est de vérifier que cette Collection n'existe pas déjà en Session
        //On va décider d'un nom d'attribut, on va appeler cela "listelivres". 
        //Attention !!! On ne peut pas mettre "-" dans le nom d'attribut ici !!! C'est une norme qui est issue de 
        //  la norme JavaBeans qui nous oblige à identifier nos attributs dans quelque Scope que ce soit, sans tiret "-".
        //On va imaginer que cela nous retourne une "List", on va le caster en "List", une liste de livres. Il faut importer "List" !
        //On va stocker tout cela dans une variable de type de "List" de livres. On appelle cette variable "liste".

        List<Livre> liste = (List<Livre>)sessionSLS.getAttribute("listelivres");
        //S'il s'agit de la première fois que l'on rentre dans cette Servlet, c'est donc le premier livre que l'on a choisi.
        //  Dans cette situation, liste est "null".
        //Dans ce cas-là, il faut créer cette Collection et la mettre en Session
        if (liste==null){
            //Pourquoi pas un "ArrayList" 
            liste=new ArrayList<>();
            //!!! Attention !!! On va donc ici stocker cette liste "listeLivres"
            sessionSLS.setAttribute("listeLivres", liste);
        }
        //Alors à tout les coups, qu'il s'agisse de la première fois ou des fois suivantes, il faut que l'on rajoute dans cette 
        //  Collection le nouveau livre sélectionné ! 
        
        //On va donc toujours faire un "new Livre", auquel on va toujours affecter le numéro en provenance des paramètres de requête.
        
        Livre livre = new Livre();
        livre.setNumeroLivre(Integer.parseInt(identifiantLivre));
        //Mais cette fois on ne va pas stocker en Session ce Livre particulier
        //sessionSLS.setAttribute("livre", livre);
        //Tout ce que l'on va faire, c'est de l'ajouter à la "liste" avec un "add" ce Livre particulier.
        liste.add(livre);
        
        PrintWriter out = response.getWriter();
        //On se contente d'afficher l'"id" du livre sélectionné
        out.print("<html><body> Merci d'avoir choisi le livre "+ identifiantLivre + "<br>");
        //On ajoute une ligne afin d'afficher le numéro de session utilisateur
        //out.print("Le numéro de session utilisateur est : " + numeroSession + "<br>");
        //On rajoute ce lien afin de retourner sur la page "choix-du-livre.html", avec l'idée qu'après avoir choisi un livre, on peut
        //  soit aller payer ce livre, soit en choisir un autre. 
        //A partir de maintenant, on peut passer plusieurs fois dans ce "doGet" de cette Servlet afin d'ajouter plusieurs livres.
        out.print("<a href=\"choix-du-livre.html\">Cliquer ici pour continuer à choisir des livres</a><br>");
        out.print("<a href=\"payer-livre.html\">Cliquer ici pour payer</a></body><html>");
    }

}
