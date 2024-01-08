<%-- 
    Document   : traitement
    Created on : Jan 6, 2024, 9:31:59 PM
    Author     : PC
--%>

<%@page import="model.VPkRn"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<VPkRn> pkRns = (List<VPkRn>) request.getAttribute("pkRns");
    double argent = (Double) request.getAttribute("argent");
    double prixTotal = (Double) request.getAttribute("total");
    double reste = (Double) request.getAttribute("reste");
    String option = (String) request.getAttribute("option");
    String rn = (String) request.getAttribute("rn");

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Propositions <%= option %></h1>
        <h3>Budget: <%= argent %></h3>
        
        <table border="1">
            <tr>
                <th>Numero</th>
                <th>Pk</th>
                <th>Cout remplacement</th>
                <th>Cout traitement</th>
                <th>Cout nettoyage</th>
                <th>Total</th>
            </tr>
            
            <% for(VPkRn pk: pkRns) { %>
                <tr>
                    <th><%= pk.getRn() %></th>
                    <th><%= pk.getPk() %></th>
                        <td>
                            <center>
                                <% if(pk.getRemplacement()!=0) { %> <%= pk.getRemplacement() %> <% } %>
                            </center>
                        </td>
                        <td>
                            <center>
                                <% if(pk.getTraitement()!=0) { %> <%= pk.getTraitement() %> <% } %>
                            </center>
                        </td>
                        <td>
                            <center>
                                <% if(pk.getNettoyage()!=0) { %> <%= pk.getNettoyage() %> <% } %>
                            </center>
                        </td>
                        <td>
                            <center>
                                <%= pk.getTotal() %>
                            </center>
                        </td>
                </tr>
            <% } %>
        </table>
        <p><strong>Total: </strong><%= prixTotal %></p>
        <p><strong>Reste: </strong><%= reste %></p>
        <br/>
        
        <form action="TraitementServlet">
            <input type="text" name="rn" value="<%= rn %>" hidden>
            <input type="text" name="argent" value="<%= argent %>" hidden>
            <input type="text" name="option" value="<%= option %>" hidden>
            <button type="submit">Valider</button>
        </form>
        
    </body>
</html>
