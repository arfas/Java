<%-- 
    Document   : remove_cookies
    Created on : Jul 20, 2014, 11:58:51 PM
    Author     : ken
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remove Cookies Page</title>
    </head>
    <body>
        <h1>Cookies</h1>

        <p>All persistent cookies have been removed from this browser.</p>

        <p><a href="<%= response.encodeURL("index.jsp")%>">
                Display list of courses</a>.</p>

        <p><a href="<%= response.encodeURL("display_cookies.jsp")%>">
                Display all cookies</a>.</p>
    </body>
</html>
