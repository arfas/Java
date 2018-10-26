<%-- 
    Document   : display_contact_entry
    Created on : Jun 22, 2014, 10:26:25 PM
    Author     : ken
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>NPU Student Club</title>
    </head>
    <body>
        <!-- import packages and classes needed by the scripts -->
        <%@ page import="business.*, data.*, java.util.Date" %>
        <%
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String emailAddress = request.getParameter("emailAddress");

            // get a relative file name
            ServletContext sc = this.getServletContext();
            String path = sc.getRealPath("/WEB-INF/ContactList.txt");

            // use regular Java objects
            User user = new User(firstName, lastName, emailAddress);
            UserIO.add(user, path);
        %>
        <h1>Thanks for joining our contact list</h1>
        <p>Here is the information that you entered:</p>
        <table cellspacing="5" cellpadding="5" border="1">
            <tr>
                <td align="right">First name:</td>
                <td><%= firstName%></td>
            </tr>
            <tr>
                <td align="right">Last name:</td>
                <td><%= lastName%></td>
            </tr>
            <tr>
                <td align="right">Email address:</td>
                <td><%= emailAddress%></td>
            </tr>
        </table>
        <p>To enter another email address, click on the Back <br>
            button in your browser or the Return button shown <br>
            below.</p>
        <form action="join_contact_list.html" method="get">
            <input type="submit" value="Return">
        </form>
        <p>This email address was added to our list on <%= new Date() %></p>
    </body>
</html>
