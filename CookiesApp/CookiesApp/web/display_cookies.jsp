<%-- 
    Document   : display_cookies
    Created on : Jul 20, 2014, 11:46:30 PM
    Author     : ken
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Cookies Page</title>
    </head>
    <body>
        <h1>Cookies</h1>

        <p>Here's a table with all of the cookies that this <br>
            browser is sending to the current server.</p>

        <table cellpadding="5" border="1">
            <tr>
                <td align="right"><b>Name</b></td>
                <td><b>Value</b></td>
            </tr>
            <%
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie c : cookies) {
            %>
            <tr>
                <td align="right"><%= c.getName()%></td>
                <td><%= c.getValue()%></td>
            </tr>
            <%
                    }
                }
            %>
        </table>

        <p><a href="<%= response.encodeURL("index.jsp")%>">
                Display list of courses</a>.</p>

        <p><a href="<%= response.encodeURL("removeCookies")%>">
                Remove all persistent cookies</a>.</p>

    </body>
</html>
