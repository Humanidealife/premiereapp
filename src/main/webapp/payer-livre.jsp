<%-- 
    Document   : payer-livre
    Created on : 23 juil. 2024, 22:41:13
    Author     : wangq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
        <!-- Juste après le numéro de carte,  -->
        Liste des livres payés : <br>
        <!-- On utilise une blise qui s'appelle "c:forEach", il y a plusieurs attributs, mais deux sont essentiels ici.  
        L'attribut "items" qui va nous permettre, au travers d'une expression JSP EL, d'indiquer de quel attribut il s'agit,
          C'est un attribut qui se trouve en Session, on peut écrire "sessionScope", cet attribut est une Collection, on peut
        itérer dessus.
        Deuxième attribut est "var", avec un contenu qui est libre, qui va correspondre au nom de de la variable qui va recevoir
        successivement chacun des éléments de l'itération. 
        -->
        <c:forEach items="${sessionScope.listeLivres}" var="livre">
        <!-- Ce qui nous intéresse c’est un attribut qui s’appelle « livre » dans le « sessionScope ».
        Ce que l’on veut c’est afficher la valeur de sa propriété au format JavaBeans qui s’appelle « numeroLivre ».
        Pour accéder à cette propriété qui dispose d’un « getter », on va simplement utiliser ce que l’on appelle la notation pointée, 
          c’est-à-dire rajouter encore un point et puis écrire « numeroLivre ». 
        Cette ligne suivante c'est ce qui va être affichée à chaque itération.
        A chaque itération, on veut afficher le numéro du livre suivant.
        Le "$<>" va faire référence à l'élément de l'itération qui est le var = "livre"
        -->
        Votre achat pour le livre numéro ${livre.numeroLivre} est finalisé avec succès ! <br>
        </c:forEach>

    </body>
</html>
