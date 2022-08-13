<%-- 
    Document   : shopping
    Created on : Oct 9, 2021, 12:56:11 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rainbow Milk Tea</title>
    </head>
    <body>
        <h1>Welcome to farm:</h1>
        <form action="MainController" method="POST">
            Pick me:
            <select name="cmbTea">
                <option value="T01-Pink Tea-30">Pink Tea</option>
                <option value="T02-Peach Tea-40">Peach Tea</option>
                <option value="T03-Apple Tea-60">Apple Tea</option>
                <option value="T04-Macha Tea-10">Macha Tea</option>
            </select>
            <input type="number" name="quantity" value="1" required="" min="1"/>
            <input type="submit" name="action" value="Add"/>
            <input type="submit" name="action" value="View"/>
        </form>
        <%
            String message=(String) request.getAttribute("MESSAGE");
            if(message==null){
                message="";
            }
        %>
        <%= message%>
    </body>
</html>
