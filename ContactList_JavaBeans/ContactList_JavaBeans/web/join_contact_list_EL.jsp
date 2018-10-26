<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>NPU Student Club</title>
    </head>
    <body>
        <h1>Join our contact list</h1>
        <p>To join our contact list, enter your name and
            email address below. <br>
            Then, click on the Submit button.</p>
        <form action="addToContactList" method="post">
            <table cellspacing="5" border="0">
                <tr>
                    <td align="right">First name:</td>
                    <td><input type="text" name="firstName" value="${user.firstName}"></td>
                </tr>
                <tr>
                    <td align="right">Last name:</td>
                    <td><input type="text" name="lastName" value="${user.lastName}"></td>
                </tr>
                <tr>
                    <td align="right">Email address:</td>
                    <td><input type="text" name="emailAddress" value="${user.emailAddress}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><br><input type="submit" value="Submit"></td>
                </tr>
            </table>
            <hr>
            <p><a href="addToContactList?firstName=Lily&&lastName=Li&&emailAddress=lily@yahoo.com">
                    Display Contact Entry
                </a>
            </p>           
        </form>
    </body>
</html>
