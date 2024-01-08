<%-- 
    Document   : modif
    Created on : Jan 8, 2024, 9:57:30 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    int idPersonne = (Integer)request.getAttribute("idPersonne");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <form action="PointPointServlet">
            <input type="text" name="idPersonne" value="<%= idPersonne %>" hidden>
            <input type="text" name="type">
            <input type="text" name="etat">
            <button type="submit">PointPoint</button>
        </form>
             
            
    </body>
</html>
