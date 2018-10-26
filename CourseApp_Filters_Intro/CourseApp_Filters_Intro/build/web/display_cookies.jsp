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
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <h1>Cookies</h1>

        <p>Here's a table with all of the cookies that this <br>
            browser is sending to the current server.</p>

        <table cellpadding="5" border="1">
            <tr>
                <td align="right"><b>Name</b></td>
                <td><b>Value</b></td>
            </tr>
            <c:forEach var="ck" items="${requestScope.cookies}"> 
                <tr>
                    <td align="right">${ck.name}</td>
                    <td>${ck.value}</td>
                </tr>
            </c:forEach>

        </table>

        <p><a href="<c:url value='index.jsp' />">
                Display list of courses</a>.</p>

        <p><a href="<c:url value='removeCookies' />">
                Remove all persistent cookies</a>.</p>

    </body>
</html>
