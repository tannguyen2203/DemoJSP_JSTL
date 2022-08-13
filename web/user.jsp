<%-- 
    Document   : user
    Created on : Sep 28, 2021, 1:25:23 PM
    Author     : HP
--%>

<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <% 
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !"US".equals(loginUser.getRoleId())) {
                response.sendRedirect("login.jsp");
                return;
            }
        %>
        <h1>This page for user: ${sessionScope.LOGIN_USER.fullName}></h1>
        
    </body>
</html>
