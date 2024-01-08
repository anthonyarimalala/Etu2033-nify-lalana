<%@page import="model.V_Dentition"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<V_Dentition> dentitions = (List<V_Dentition>) request.getAttribute("dentitions");
    out.println(dentitions.size());
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
                
        <div>
            <form action="ToTraitementServlet">
                <% if(dentitions.size()!=0) { %>
                <h2><%= dentitions.get(0).getPrenom() %> <%= dentitions.get(0).getNom() %></h2>
                <input type="hidden" name="idPersonne" value="<%= dentitions.get(0).getIdPersonne() %>">
                <% } %>
            <div>
                <table border="1">
                    <tr>
                        <% for(int i=0; i<dentitions.size()/2; i++) { %>
                        <td width="15" style="background-color: <%= dentitions.get(i).getCouleur() %>"><center><%= dentitions.get(i).getIdDent() %></center></td>
                        <% } %>
                    </tr>
                    <tr>
                        <% for(int i=dentitions.size()/2; i<dentitions.size(); i++) { %>
                        <td width="15" style="background-color: <%= dentitions.get(i).getCouleur() %>"><center><%= dentitions.get(i).getIdDent() %></center></td>
                        <% } %>
                    </tr>
                </table>
            </div>    
                    
            
            <p>
                Choix: <select name="option">
                    <option value="beaute">Beauté</option>
                    <option value="sante">Santé</option>
                </select>
                <br/>
                Argent: <input type="number" name="argent" value="100000" min="0" step="0.01" required> 
                <br/>
                <button>Valider</button>
            </p>
            </form>
        </div>        
                
    </body>
</html>
