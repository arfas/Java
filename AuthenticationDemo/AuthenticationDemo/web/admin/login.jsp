<%-- 
    Document   : login
    Created on : Aug 5, 2014, 12:29:47 AM
    Author     : ken
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Admin Login Page</h1>
        <p>Please enter your username and password</p>
        <table>
            <form action="j_security_check" method="get">
                <tr>
                    <td align="right">Username</td>
                    <td><input type="text" name="j_username"></td>
                </tr>
                <tr>
                    <td align="right">Password</td>
                    <td><input type="password" name="j_password"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login"></td>
                </tr>
            </form>
        </table>
    </body>
</html>
