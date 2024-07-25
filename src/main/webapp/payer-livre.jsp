<%-- 
    Document   : payer-livre
    Created on : 23 juil. 2024, 22:41:13
    Author     : wangq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livre payé</title>
    </head>
    <body>
        <!-- le "numeroCarte" provient d'un formulaire,cela n'est pas quelque chose qui se trouvait en Session ou en "request".
        Ce "numeroCarte" arrivait avec les paramètres de la requête.
        "identifiantLivre" est un attribut de "scope" Session("identifiantLivre")
        -->
        Paiement effectué avec la carte du numéro <%=request.getParameter("numeroCarte")%><br>
        <!-- Ce qui nous intéresse c’est un attribut qui s’appelle « livre » dans le « sessionScope ».
        Ce que l’on veut c’est afficher la valeur de sa propriété au format JavaBeans qui s’appelle « numeroLivre ».
        Pour accéder à cette propriété qui dispose d’un « getter », on va simplement utiliser ce que l’on appelle la notation pointée, 
          c’est-à-dire rajouter encore un point et puis écrire « numeroLivre ».  -->
        Votre achat pour le livre numéro ${sessionScope.livre.numeroLivre} est finalisé avec succès ! <br>

    </body>
</html>
