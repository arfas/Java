<%-- 
    Document   : loginerror
    Created on : Aug 5, 2014, 12:32:48 AM
    Author     : ken
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Error Page</title>
    </head>
    <body>
        <h1>Login Error</h1>
        <p>Failed to login.</p>
        <p>Please check your username and password and try again.</p>
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
