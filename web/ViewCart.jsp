<%-- 
    Document   : ViewCartController
    Created on : Oct 9, 2021, 1:25:40 PM
    Author     : ADMIN
--%>

<%@page import="sample.shopping.Tea"%>
<%@page import="sample.shopping.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your shopping cart Page</title>
    </head>
    <body>
        <h1>Your Selected Tea</h1>
        <%
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart != null) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    double total = 0;
                    for (Tea tea : cart.getCart().values()) {
                        total += tea.getPrice() * tea.getQuantity();

                %>
            <form action="MainController" method="POST">

                <tr>
                    <td><%= count++%></td>                 
                    <td>
                        <%= tea.getId()%>
                        <input type="hidden" name="id" value="<%= tea.getId()%>" />
                    </td>
                    <td><%= tea.getName()%></td>
                    <td><%= tea.getPrice()%></td>
                    <td>
                        <input type="number" name="quantity" value="<%= tea.getQuantity() %>" min="1" required="">
                    </td>>
                    <td><%= tea.getQuantity()%></td>
                    <td><%= tea.getPrice() * tea.getQuantity()%></td>
                    <td>
                        <input type="submit" name="action" value="Remove"/>
                        
                    </td>
                    <td>
                        <input type="submit" name="action" value="Edit"/>
                    </td>
                </tr>
            </form>

            <%
                }
            %>
        </tbody>
    </table>
    <h1>Total: <%= total%>$</h1>
    <%
        }
    %>
    <a href="shopping.jsp">Add more</a>
</body>
</html>
