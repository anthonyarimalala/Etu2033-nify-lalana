
<%@page import="model.Personne"%>
<%@page import="java.util.List"%>
<%
    List<Personne> personnes = (List<Personne>) request.getAttribute("personnes");
    %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <a href="ToAjoutClientServlet">Ajouter client</a>
    
    <form action="ToModifServlet">
        Modifier
            <select name="idPersonne">
                <% for(Personne p: personnes) { %>
                    <option value="<%= p.getIdPersonne() %>"><%= p.getPrenom() %> <%= p.getNom() %></option>
                <% } %>
            </select>
            <button type="submit">Modifier</button>

        </form>
    <p>Liste des Patients: </p>
    <ul>
        <% for(Personne pers: personnes) { %>
        <li><a href="ToDetailServlet?idPersonne=<%= pers.getIdPersonne() %>"><%= pers.getPrenom() %> <%= pers.getNom() %></li>
        <% } %>
    </ul>
</body>
</html>