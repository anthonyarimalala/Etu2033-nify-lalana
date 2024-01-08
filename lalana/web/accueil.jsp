<%-- 
    Document   : accueil
    Created on : Jan 6, 2024, 11:22:18 AM
    Author     : PC
--%>

<%@page import="model.Rn"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    List<Rn> rns = (List<Rn>)request.getAttribute("rns");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        <a href="ajoutRn.jsp">Ajouter Rn</a> <br/>
        <form action="ToModifRnServlet">
            <select name="rn">
                <% for(Rn rn: rns) { %>
                    <option value="<%= rn.getRn() %>"><%= rn.getRn() %></option>
                <% } %>
            </select>
            <button type="submit">Modifier</button>

        </form>
        
        
        <div>
            <h3>Liste des Routes nationales:</h3>
            <ul>
                <% for(Rn rn: rns) { %>
                    <li><a href="ToDetailServlet?rn=<%= rn.getRn() %>"><%= rn.getRn() %></a></li>
                <% } %>
            </ul>
        </div>
    </body>
</html>
