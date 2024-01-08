<%-- 
    Document   : modifRn.jsp
    Created on : Jan 6, 2024, 11:29:24 AM
    Author     : PC
--%>

<%@page import="model.PkRn"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<PkRn> pkRns = (List<PkRn>)request.getAttribute("pkRns");
    String rn = (String)request.getAttribute("rn");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Modifier Route nationale! <%= rn %></h3>
        
        
        <form action="ModifRnServlet">
            <input type="text" name="rn" value="<%= rn %>" hidden />
            <% for(PkRn pk: pkRns) { %>
            pk <%= pk.getPk() %>: <input type="number" min=0 max="10" name="<%= pk.getIdPkRn() %>" value="<%= pk.getEtat() %>"><br/>
            <% } %>
            <button type="submit">modifier</button>
        </form>
    </body>
</html>
