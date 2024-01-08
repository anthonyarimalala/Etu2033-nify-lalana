<%-- 
    Document   : detail
    Created on : Jan 6, 2024, 5:34:47 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    String rn = (String) request.getAttribute("rn");
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
                <h3><%= rn %></h3>
            <p>
                Choix: <select name="option">
                    <option value="beaute">Beauté</option>
                    <option value="sante">Santé</option>
                </select>
                <input type="text" name="rn" value="<%= rn %>" hidden>
                <br/>
                Argent: <input type="number" name="argent" value="100000" min="0" step="0.01" required> 
                <br/>
                <button>Valider</button>
            </p>
            </form>
        </div>  
    </body>
</html>
