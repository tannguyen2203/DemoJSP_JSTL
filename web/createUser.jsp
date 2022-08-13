<%-- 
    Document   : createUser
    Created on : Oct 5, 2021, 2:06:28 PM
    Author     : ADMIN
--%>

<%@page import="sample.user.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create page</title>
    </head>
    <body>
        <%
            UserError error = (UserError) request.getAttribute("ERROR_USER");
            if (error == null) {
                error = new UserError();
            }
        %>
        <form action="MainController" method="POST">
            User ID<input type="text" name="userID" required=""/>            
            ${requestScope.ERROR_USER.userID}<br>
            Full Name<input type="text" name="fullName" required=""/>
            ${requestScope.ERROR_USER.fullName}<br>   
            Role ID(*)
            <select name="roleID">
                <option value=""></option>>
                <option value="US">US</option>
                <option value="ST">ST</option>
                <option value="GS">GS</option>
            </select>
            ${requestScope.ERROR_USER.roleID}</br>
            PassWord(*)<input type="password" name="password" required=""/>
            ${requestScope.ERROR_USER.password}</br>
            Confirm(*)<input type="pasword" name="confirm" required=""/>
            ${requestScope.ERROR_USER.confirm}</br>
            <input type="submit" name="action" value="Create"/>
            <input type="reset" name="Reset"/><br>
        </form>
    </body>
</html>
