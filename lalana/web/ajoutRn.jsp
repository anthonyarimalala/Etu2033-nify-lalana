<%-- 
    Document   : ajoutRn
    Created on : Jan 6, 2024, 11:28:47 AM
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
        <h3>Ajout route nationale!</h3>
        
        <form action="AjoutRnServlet">
            <input type="text" name="rn" placeholder="Rn..." required>
            <input type="number" name="nbPk" placeholder="Nombre de pk" required>
            <br/>
            <br/>
            
            <input type="number" step="0.01" value="0" name="enlevement" placeholder="Enlevement"><br/>
            <input type="number" step="0.01" value="0" name="remplacement" placeholder="Remplacement"><br/>
            <input type="number" step="0.01" value="0" name="traitement" placeholder="Traitement"><br/>
            <input type="number" step="0.01" value="0" name="nettoyage" placeholder="Nettoyage"><br/>
            <button type="submit"> Save </button>
            
            
        </form>
        
    </body>
</html>
