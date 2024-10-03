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

//On trouve cette formule au début de toute application JavaScript cela permet en réalité d'attendre que le navigateur ait chargé
//  tous les fichiers nécessaires au bon fonctionnement de l'application avant que le code qui suit soit traîté. Parce qu'en effet,
//  il est tout à fait possible que le navigateur commence par charger "application.js" sans avoir terminé de télécharger ses inombrables
//  ".html" ou "jquery.min.js" (dans ce cas-là, l'application ne peut pas fonctionner).
// "$(document).ready" va simplmement attendre que tout soit chargé avant d'effectuer ce qui suit (tout ce qui est dans les "ready()").

/*
$(document).ready(function(){
    //La fonction "function" fait quoi ?
    //$('input') signifie : jQuery donne-moi toutes les balise "input" qui se trouve dans le DOM(il y en a plusieurs).
    //Avec le ".last", on demande à jQuery de collecter la dernière balise "input" qui est le button.
    //Le ".on" veut dire que sur ce button, quand l'évènement "click" survient on va exécuter la fonction qui suit.
    $('input').last().on('click',function(){
        //Sur le "click" du button, $.ajax est une fonction dans jQuery qui va nous permettre d'interroger un Serveur selon le protocole "Ajax".
        $.ajax({
          //Et l'URL avec laquelle on veut discuter se trouve ici dans un paramètre que l'on appelle "url".
          url: "somme",
          //Cette ligne c'est ce qui nous permet d'envoyer dans la requête au Serveur les valeurs (nombre1 et nombres2) que l'on a entrées dans les champs de saisie.
          //Ce que fait jQuery, c'est qu'il va ici récupérer le formulaire qui se trouve dans le DOM, puis il va sérialiser le formulaire dans le corps de la requête
          //  les différents éléments (c'est pour cela on utilise la fonction "serialize")
          data: $("form").serialize(),
          //Et lorsque de manière asynchrone, le Serveur retourne un résultat, et bien on va se retrouver dans ce bloc "success" qui est une fonction
          //  qui reçoit en paramètre ce "resultat".
          //C'est-à-dire que quand on appelle l'URL "somme" et lorsque le Serveur nous a répondu, on prend ce que le Serveur nous retourne, puis
          //  on l'ajoute à la balise "form" concernée.
          success: function(result) {
              //On reconnaît cette ligne qui dit "ajouter derrière la balise 'form' le résultat fourni par le Serveur (par affichage-somme.jsp)"
              $("form").after(result);
          }
        });
    });
});
 */

$(document).ready(function(){
    $('input').last().on('click',function(){
        if ($("input[name=format]").prop( "checked")===true){
            $("form").submit();
        }
        else{
            $.ajax({
              url: "somme",
              data: $("form").serialize(),
              success: function(result) {
                  $("p").remove();
                  $("form").after("<p>La somme des deux nombres fournis est <strong>"+ result +"</strong></p>");
              }
            });
        }
    });
});