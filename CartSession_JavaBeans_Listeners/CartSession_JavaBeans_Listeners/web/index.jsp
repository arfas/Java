<%-- 
    Document   : index
    Created on : Jul 14, 2014, 10:56:53 PM
    Author     : ken
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bookstore Page</title>
    </head>
    <body>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <h1>Book list</h1>
        <table cellpadding="5" border=1>
            <tr valign="bottom">
                <td align="left"><b>Title</b></td>
                <td align="left"><b>Price</b></td>
                <td align="left"></td>
            </tr> 
            <c:forEach var="book" items="${applicationScope.books}">
                <tr valign="top">
                    <td>${book.title}</td>
                    <td>${book.priceCurrencyFormat}</td>
                    <td><a href="<c:url value='cart?bookISBN=${book.isbn}'/>">Add To Cart</a></td>
                </tr>
            </c:forEach>
        </table>
        <p>
            For technical support, please send an email to ${supportEmail}.
        </p>
        <p>
            &copy; Copyright ${currentYear} NPU Bookstore.
            All rights reserved.
        </p>
    </body>
</html>
