<%-- 
    Document   : login
    Created on : Sep 28, 2021, 1:04:08 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>

        <form action="MainController" method="POST">
            User ID<input type="text" name="userID"/><br/>
            Password<input type="password" name="password"><br/>
            <input type="submit" name="action" value="Login">
            <input type="reset" value="Reset"/>
        </form>
        <a href="createUser.jsp">Create new user</a></br>
        <a href="shopping.jsp">Shopping</a>
        ${requestScope.ERROR}
    </body>
</html>
