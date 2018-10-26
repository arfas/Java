<%-- 
    Document   : index
    Created on : Jul 20, 2014, 9:41:40 PM
    Author     : ken
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Page</title>
    </head>
    <body>
        <h1>List of Courses</h1>
        <p>
            <a href="<%=response.encodeURL("validateUser?courseNo=CS480")%>">
                Programming in Java
            </a><br>

            <a href="<%=response.encodeURL("validateUser?courseNo=CS360")%>">
                Programming in C++
            </a><br>

            <a href="<%= response.encodeURL("validateUser?courseNo=CS527")%>">
                Programming in C#
            </a><br>

            <a href="<%= response.encodeURL("validateUser?courseNo=CS204")%>">
                Programming in C
            </a>
        </p>

    </body>
</html>
