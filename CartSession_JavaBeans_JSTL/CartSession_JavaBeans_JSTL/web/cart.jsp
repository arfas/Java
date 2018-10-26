<%-- 
    Document   : Cart
    Created on : Jul 14, 2014, 11:46:54 PM
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
        <h1>Your cart</h1>
        <table border="1" cellpadding="5">
            <tr>
                <th>Quantity</th>
                <th>Title</th>
                <th>Price</th>
                <th>Amount</th>
            </tr>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <c:forEach var="item" items="${cart.items}">
                <tr valign="top">
                    <td>
                        <form action="<c:url value='/cart' />" method="post">
                            <input type="hidden" name="bookISBN" 
                                   value="${item.book.isbn}">
                            <input type=text size=2 name="quantity" 
                                   value="${item.quantity}">
                            <input type="submit" value="Update">
                        </form>
                    </td>
                    <td>
                        ${item.book.title}
                    </td>
                    <td>
                        ${item.book.priceCurrencyFormat}
                    </td>
                    <td>
                        ${item.totalCurrencyFormat}
                    </td>
                    <td>
                        <form action="<c:url value='/cart' />">
                            <input type="hidden" name="bookISBN" 
                                   value="${item.book.isbn}">
                            <input type="hidden" name="quantity" 
                                   value="0">
                            <input type="submit" value="Remove Item">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="3">
                    <p><b>To change the quantity</b>, enter the new quantity 
                        and click on the Update button.</p>
                </td>
            </tr>
        </table>
        <br>
        <form action="<c:url value='/index.jsp' />" method="post">
            <input type="submit" name="continue" value="Continue Shopping">
        </form>
        <form action="<c:url value='/checkout.jsp' />" method="post">
            <input type="submit" name="checkout" value="Checkout">
        </form>
        <hr>
        <h2>More Examples</h2>
        <c:if test="${cart.count == 1}">
            <p>You have 1 item in your cart.</p>
        </c:if>
        <c:if test="${cart.count > 1}">
            <p>You have ${cart.count} items in your cart.</p>
        </c:if>
        <hr>
        <c:choose>
            <c:when test="${cart.count == 0}">
                <p>Your cart is empty</p>
            </c:when>
            <c:when test="${cart.count == 1}">
                <p>You have 1 item in your cart.</p>
            </c:when>
            <c:otherwise>
                <p>You have ${cart.count} items in your cart.</p>
            </c:otherwise>
        </c:choose>
    </body>
</html>
