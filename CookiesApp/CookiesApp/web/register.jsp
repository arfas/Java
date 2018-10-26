<%-- 
    Document   : register
    Created on : Jul 20, 2014, 11:52:47 PM
    Author     : ken
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course Registration Page</title>
    </head>
    <body>
        <h1>Course registration</h1>

        <p>To register for our courses, enter your name and email <br>
            address below. Then, click on the Submit button.</p>

        <form action="<%= response.encodeURL("registerUser")%>" 
              method="post">

            <table cellspacing="5" border="0">
                <tr>
                    <td align="right">First name:</td>
                    <td><input type="text" name="firstName"></td>
                </tr>
                <tr>
                    <td align="right">Last name:</td>
                    <td><input type="text" name="lastName"></td>
                </tr>
                <tr>
                    <td align="right">Email address:</td>
                    <td><input type="text" name="emailAddress"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Submit"></td>
                </tr>
            </table>

        </form>
    </body>
</html>
