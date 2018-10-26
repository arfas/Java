<%-- 
    Document   : display_contact_entry
    Created on : Jun 22, 2014, 10:26:25 PM
    Author     : ken
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>NPU Student Club</title>
    </head>
    <body>
        <h1>Thanks for joining our contact list</h1>
        <p>Here is the information that you entered:</p>
        <table cellspacing="5" cellpadding="5" border="1">
            <tr>
                <td align="right">First name:</td>
                <td>${user.firstName}</td>
            </tr>
            <tr>
                <td align="right">Last name:</td>
                <td>${user.lastName}</td>
            </tr>
            <tr>
                <td align="right">Email address:</td>
                <td>${user.emailAddress}</td>
            </tr>
        </table>
        <p>To enter another email address, click on the Back <br>
            button in your browser or the Return button shown <br>
            below.</p>
        <form action="join_contact_list_EL.jsp" method="get">
            <input type="submit" value="Return">
        </form>

        <h2>More examples</h2>
        <p>The current date is ${currentDate}</p>

        <p>Hello ${user.firstName}</p>

        <p>The first color is ${colors[0]}<br>
            The second color is ${colors[1]}
        </p>

        <p>The first address on our list is ${users[0].emailAddress}<br>
            The second address on our list is ${users[1].emailAddress}
        </p>

        <p>First name: ${usersMap[emailAddress].firstName}</p>

        <p>First name: ${usersMap[emailAddresses[0]].firstName}</p>

        <p>First name: ${param.firstName}<br>
            Email address 1: ${paramValues.emailAddress[0]}<br>
            Email address 2: ${paramValues.emailAddress[1]}
        </p>

        <p>Browser MIME types: ${header.accept}<br>
            Browser compression types: ${header["accept-encoding"]}
        </p>

        <p>The email cookie: ${cookie.emailCookie.value}</p>

        <p>The context init param: ${initParam.addmissionsEmail}</p>

        <p>HTTP request method: ${pageContext.request.method}<br>
            HTTP response type: ${pageContext.response.contentType}<br>
            HTTP session ID: ${pageContext.session.id}<br>
            HTTP servletContext path: ${pageContext.servletContext.contextPath}<br>
        </p>

        <p>Operator test: ${1 + 1}</p>

    </body>
</html>
