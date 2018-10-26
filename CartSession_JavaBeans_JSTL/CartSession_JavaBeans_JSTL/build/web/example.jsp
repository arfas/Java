<%-- 
    Document   : example
    Created on : Jul 29, 2014, 12:29:43 PM
    Author     : kcheung
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Examples of JSTL!</h1>
        <p>Numbers<br>
            <c:forEach items="${numbers}" var="number" begin="0" end="9" step="1" varStatus="status">
                <li>${number} | First: ${status.first} | Last: ${staus.last} | Index: ${status.index} | Index: ${status.count} </li>
            </c:forEach>
        </p>
        <hr>
        
    </body>
</html>
