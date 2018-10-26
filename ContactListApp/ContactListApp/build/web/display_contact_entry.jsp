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
        <%
            // get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String emailAddress = request.getParameter("emailAddress");
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
    </body>
</html>
