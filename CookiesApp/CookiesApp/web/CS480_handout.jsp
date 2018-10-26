<%-- 
    Document   : CS480_handout
    Created on : Jul 20, 2014, 11:35:48 PM
    Author     : ken
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CS480 Handout Page</title>
    </head>
    <body>
        <%
            String courseNo = (String) session.getAttribute("courseNo");
        %>

        <h1>Handouts</h1>

        <table cellpadding="5" border="1">
            <tr><td colspan="2"><b>Programming in Java</b></td>
            </tr>
            <tr><td width="200"><b>Week No</b></td>
                <td width="150"><b>File</b></td>
            </tr>
            <tr><td>Week 1</td>
                <td><a href="/courses/cs408/<%=courseNo%>/week1.pdf">Handout for Week1</a></td>
            </tr>
            <tr><td>Week 2</td>
                <td><a href="/courses/cs408/<%=courseNo%>/week2.pdf">Handout for Week2</a></td>
            </tr>
        </table>

        <p><a href="<%= response.encodeURL("index.jsp")%>">
                Display list of courses</a>.</p>

        <p><a href="<%= response.encodeURL("display_cookies.jsp")%>">
                Display all cookies</a>.</p>

    </body>
</html>
