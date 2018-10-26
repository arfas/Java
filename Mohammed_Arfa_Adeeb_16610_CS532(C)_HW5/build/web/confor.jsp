<%-- 
    Document   : confor
    Created on : Dec 17, 2016, 4:31:34 PM
    Author     : arfas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="stud" scope="request" class="store.conformationpage"/>
        <jsp:setProperty name="stud" property="*"/>
        <jsp:forward page="conformationpage.jsp"/>
    </body>
</html>
