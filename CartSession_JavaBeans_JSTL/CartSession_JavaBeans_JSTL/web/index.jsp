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
            <tr valign="top">
                <td>Programming in Java</td>
                <td>$54.95</td>
                <td><a href="<c:url value='cart?bookISBN=1234567890'/>">Add To Cart</a></td>
            </tr>
            <tr valign="top">
                <td>Programming in C#</td>
                <td>$42.95</td>
                <td><a href="<c:url value='cart?bookISBN=2234567890'/>">Add To Cart</a></td>
            </tr>
            <tr valign="top">
                <td>Programming in C++</td>
                <td>$64.95</td>
                <td><a href="<c:url value='cart?bookISBN=3234567890'/>">Add To Cart</a></td>
            </tr>
            <tr valign="top">
                <td>Programming in PHP</td>
                <td>$34.95</td>
                <td><a href="<c:url value='cart?bookISBN=4234567890'/>">Add To Cart</a></td>
            </tr>
        </table>
    </body>
</html>
