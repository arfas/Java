<%-- 
    Document   : footer
    Created on : Jul 13, 2014, 11:23:37 PM
    Author     : ken
--%>
<%@ page import="java.util.*" %>
<%
    // initialize the current year that's used in the copyright notice
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
%>
<p>
    <small>
        &copy; Copyright <%= currentYear%> NPU, All rights reserved
    </small>
</p>
</body>
</html>

