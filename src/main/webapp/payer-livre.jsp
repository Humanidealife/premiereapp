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
        Paiement effectué avec la carte du numéro <%=request.getParameter("numeroCarte");%><br>
        Votre achat pour le livre du numéro ${sessionScope.identifiantLivre} est finalisé avec succès ! <br>

    </body>
</html>
