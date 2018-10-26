<%-- 
    Document   : index
    Created on : Aug 5, 2014, 12:26:29 AM
    Author     : ken
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Index Page</title>
    </head>
    <body>
        <h1>Welcome to the Admin page</h1>
        <form action="requests.jsp" method="post">
            <input type="submit" value="Process Requests">
        </form>
        <form action="tracking.jsp" method="post">
            <input type="submit" value="Tracking">
        </form>
    </body>
</html>
