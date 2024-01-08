<%-- 
    Document   : ajoutClient
    Created on : Jan 3, 2024, 3:49:04 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="RootServlet">Accueil</a>
        <h1>Ajout client:</h1>
        <form action="InsertPersonneServlet">
            <div>
                <input type="text" name="nom" placeholder="Nom">
                <input type="text" name="prenom" placeholder="Prenom">
            </div>
            <div>
                <% for(int i = 1; i<17; i++) { %>
                    <%= i %> : 
                    <input type="number" width="2" value="10" name="<%= i %>" min="0" max="10">
                <% } %>
                <br/>
                <% for(int i = 21; i<37; i++) { %>
                    <%= i %> : 
                    <input type="number" width="2" value="10" name="<%= i %>" min="0" max="10">
                <% } %>
            </div>
            <br/>
            <button>Valider</button>
        </form>
    </body>
</html>
