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
        //Si l'on fait à nouveau un "request.getSession()", on ne va pas regénérer un nouveau numéro de Session. 
        //  On va juste retrouver notre numéro de Session d'origine.
        //On peut essayer de vérifier en récupérant à nouveau ce numéro de Session
        String numeroSessionPLS = sessionPLS.getId();
        //On récupère le numéro de carte saisi dans le formulaire
        String numeroCarte = request.getParameter("numeroCarte");
        //On récupère ici l'information "id" du livre qui est stockée dans la Session
        //  Cette fois on doit utiliser la méthode "getAttribute()" avec le nom("clé") que l'on a choisi pour stocké cette "valeur".
        String identifiantLivre = (String)sessionPLS.getAttribute("identifiantLivre");
        
        //On ajoute ici la suppression des infos sur le livre sélectionné une fois que le livre soit payé.
        //On peut avoir dfeux manière de réaliser cette suppression.
        //1. On fait "setAttribute()" pour reprendre la "clé" de l'attribut que l'on veut supprimer de la Session:
        //  on reprend la clé de la "sessionPLS" qui est "identifiantLivre", puis on lui affecte la valeur "null".
        /*sessionPLS.setAttribute("identifiantLivre", null);*/
        
        //2. Une façon un peu plus explicite
        sessionPLS.removeAttribute("identifiantLivre");
        
        //On pourrait même dans certains cas décider de supprimer complètement la Session du Serveur.
        //C'est ce qui se passe notamment lorsque sur les sites web, on se déconnecte. On nous demande au début de notre navigation de nous identifier,
        //  puis à la fin, nous appuyons sur un bouton comme "déconnexion". 
        //Dans ce cas-là, on écrirait alors
        sessionPLS.invalidate();
        //A partir de ce "invalidate", la Session disparaît intégralement du Serveur. Cela veut dire que si l'on fait par la suite un "request.getSession", 
        //  et bien on va obtenir une nouvelle Session 
        //Mais que ce passe-t-il si l'on ne fait rien ? Si l'on laisse le navigateur ouvert, on va naviguer sur un autre site, on éteint le navigateur complètement ou 
        //  on éteint l'ordinateur, le Serveur n'en a absolument pas conscience et les informations vont rester stocker sur le Serveur pendant un certain temps. Ce n'est pas 
        //  éternel, parce que là ça va entrer en jeu un délais (ou un "timeout"), au terme duquel le Serveur va décider de supprimer de lui-même notre Session. 
        //Ce délais repart à 0 à chaque fois que l'on contacte le Serveur, à chaque fois que l'on dit au Serveur que l'on continue à travailler avec lui, comme quand l'on y 
        //  met une requête. C'est donc un délai d'inactivité qui va entrer en jeu, ce délais sur Tomcat sera de 30 minutes. Autrement dit, si pendant 30 minutes on ne fait rien,
        //  ou plus précisément si pendant 30 minutes on n'interagit pas avec le Serveur, et bien on perd notre Session. Et si l'on reprend notre activité après 30 minutes,
        //  et bien le Serveur doit initier une nouvelle Session.
        
        //La durée d'inactivité au bout de laquelle une Session se termine peut être modifiée dans l'application elle-même. Dans le descripteur de déploiement "web.xml" plus 
        //  précisément. 
        
        
        PrintWriter out = response.getWriter();
        //On affiche tout simplement le message suivant
        out.print("<html><body>Paiement effectué avec la carte du numéro " + numeroCarte + "<br>");
        //On affiche donc ici l'"id" du livre qui vient d'être acheté afin de confirmer le bon fonctionnement à l'utilisateur
        out.print("Votre achat pour le livre du numéro " + identifiantLivre + " est finalisé avec succès ! <br>" );
        //On affiche ce numéro récupéré ici
        out.print("Le numéro de session est: " + numeroSessionPLS + "<br>");
        out.print("</body><html>");
    }
}
