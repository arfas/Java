<%@ include file="/include/header.jsp" %>
<script language="JavaScript">
    function validate(form)
    {
        if (form.firstName.value == "")
        {
            alert("Please fill in your first name");
            form.firstName.focus();
        }
        else if (form.lastName.value == "")
        {
            alert("Please fill in your last name");
            form.lastName.focus();
        }
        else if (form.emailAddress.value == "")
        {
            alert("Please fill in your email address");
            form.emailAddress.focus();
        }
        else
        {
            form.submit();
        }
    }
</script>
<%@ page import="business.User" %>
<%
    // get attributes from the request
    User user = (User) request.getAttribute("user");
    String message = (String) request.getAttribute("message");

    // handle null values
    if (user == null) {
        user = new User();
    }
    if (message == null) {
        message = "";
    }
%>
<h1>Join our contact list</h1>
<p>To join our contact list, enter your name and
    email address below. <br>
    Then, click on the Submit button.</p>
<p><i><%= message %></i></p>
<form action="addToContactList" method="post">
    <table cellspacing="5" border="0">
        <tr>
            <td align="right">First name:</td>
            <td><input type="text" name="firstName" 
                       value="<%= user.getFirstName()%>"></td>
        </tr>
        <tr>
            <td align="right">Last name:</td>
            <td><input type="text" name="lastName" 
                       value="<%= user.getLastName()%>"></td>
        </tr>
        <tr>
            <td align="right">Email address:</td>
            <td><input type="text" name="emailAddress" 
                       value="<%= user.getEmailAddress()%>"></td>
        </tr>
        <tr>
            <td></td>
            <td><br><input type="button" value="Submit" onClick="validate(this.form)" ></td>
        </tr>
    </table>
    <hr>
    <p><a href="addToContactList?firstName=Lily&&lastName=Li&&emailAddress=lily@yahoo.com">
            Display Contact Entry
        </a>
    </p>           
</form>
<%@ include file="/include/footer.jsp" %>
