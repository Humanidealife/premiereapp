<%-- 
    Document   : affichage-somme
    Created on : 30 juil. 2024, 23:40:57
    Author     : wangq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Somme de nombres</title>
    </head>
    <body>
        <!-- La variable "somme" n'existe pas dans cette page JSP, mais cela est une information dont on dispose dans le Scope
                "request". Il nous suffit d'utiliser les JSP EL. 
            Il est aussi possible de laisser notre JSP rechercher dans tous les Scope où se trouve cet attribut.
        -->
        La somme des deux nombres fournis est ${requestScope.somme} 
    </body>
</html>
