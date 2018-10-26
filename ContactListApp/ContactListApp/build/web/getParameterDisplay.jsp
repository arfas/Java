<%-- 
    Document   : getParameterDisplay
    Created on : Jun 23, 2014, 12:37:11 PM
    Author     : kcheung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <!--A scriptlet that determines if a checkbox is checked ​-->
        <%
            // returns the value or "on" if checked, null otherwise.
            String progCheckBox = request.getParameter("java");
            if (progCheckBox != null) {
        %>
        You checked Java Programming!
        <%
            }
        %>
        <!-- A scriptlet that reads and displays multiple values from a list box. -->
        <%
            // returns the value of the items selected in a list box.
            String[] selectedCountries = request.getParameterValues("country");
            if (selectedCountries != null) {
                for (int i = 0; i < selectedCountries.length; i++) {
        %>
        <%= selectedCountries[i]%><br>
        <%
                }
            }
        %>
        <!-- A scriptlet that reads and displays all request parameters and values.-->
        <%
            Enumeration parameterNames = request.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                String parameterName = (String) parameterNames.nextElement();
                String parameterValue = request.getParameter(parameterName);
        %>
        <%= parameterName%> has value <%= parameterValue%>. <br>
        <%
            }
        %>
    </body>
</html>
