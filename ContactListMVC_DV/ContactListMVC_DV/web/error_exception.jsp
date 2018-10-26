<%-- 
    Document   : error_exception
    Created on : Jul 14, 2014, 12:02:53 PM
    Author     : ken
--%>
<%@ include file="/include/header.jsp" %>
<%@ page isErrorPage="true" %>
<h1>Java Exception</h1>
<p>Sorry, Java has thrown an exception.</p>
<p>To continue, click the Back button.</p>
<br>
<h2>Details</h2>
<p>
    Type: <%= exception.getClass()%><br>
    Message: <%= exception.getMessage()%><br>
</p>
<%@ include file="/include/footer.jsp" %>
