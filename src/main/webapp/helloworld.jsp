<%-- 
    Document   : helloworld
    Created on : 18 juil. 2024, 13:50:52
    Author     : wangq
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Une page JSP</title>
    </head>
    <body>
        <h1>Bonjour le monde !</h1>
        <!-- On va déclarer une variable
        On va également pouvoir utiliser des structures de contrôle, et on va pouvoir arrêter le bloc de code Java, ici dans 
        une condition, pour ajouter du code HTML conditionnel. On a donc deux sections de code Java
        -->
        <%
            int nombre = 555;
            if (nombre ==555){
                %>
                <!-- En considérant un peu implicitement que « out » est le « PrintWriter » que l’on utilisait dans les Servlet.  -->
                Ce texte est affiché uniquement si ma variable vaut <%out.print(nombre);%>.
                <%
            }
        %>
        
    </body>
</html>
