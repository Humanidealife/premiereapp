/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

//On va écrire le code ci-dessous qui signifie : jQuery trouve-moi dans le DOM toutes les balises "form"
//  (dans notre cas, il n'y en a qu'une seule).
//Après cette balise "form", ajoute-moi un nouveau noeud qui s'appelle "x"
//"jQuery" est une fonction particulière de JavaScript qui est fournie par la librairie "jQuery" 
//  (c'est équivalent d'une méthode en Java). En général, on remplace cette fonction par son alias qui est $.
//Il va falloir retrouver le résultat "x" à partir du Serveur. Il faut interroger le Serveur pour obtenir le "x",
//  c'est pour cela, on va utiliser "Ajax".
//Ajax n'est pas une technologie, c'est simplement une technique qui va donner lieu à une manière particulière 
//  d'interagir avec le Serveur. 
//En gros, on va demander au navigateur de contacter une URL sans se préoccuper de ce qui est retourné (plus concrètement
//  ce qui sera retourné par le navigateur ne doit pas remplacer le contenu actuel, il s'agira seulement avec Ajax de mettre
//  à disposition deux JavaScript ce qui est retourné, libre à nous d'en faire ce que l'on veut).
$(document).ready(function(){
    $('input').last().on('click',function(){
        $.ajax({
          url: "somme",
          data: $("form").serialize(),
          success: function(result) {
              $("form").after(result);
          }
        });
    });
});