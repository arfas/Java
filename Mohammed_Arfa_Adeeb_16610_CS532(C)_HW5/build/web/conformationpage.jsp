<%-- 
    Document   : conformationpage
    Created on : Dec 8, 2016, 11:47:48 AM
    Author     : arfas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conformation Page</title>
    </head>
    <body>
       <!DOCTYPE html>
<html>
    
    <head>
        <style>
            ul.tab {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    border: 1px solid #ccc;
    background-color: #f1f1f1;
}

/* Float the list items side by side */
ul.tab li {float: left;}

/* Style the links inside the list items */
ul.tab li a {
    display: inline-block;
    color: black;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
    transition: 0.3s;
    font-size: 17px;
}

/* Change background color of links on hover */
ul.tab li a:hover {background-color: #ddd;}

/* Create an active/current tablink class */
ul.tab li a:focus, .active {background-color: #ccc;}

/* Style the tab content */
.tabcontent {
    display: none;
    padding: 6px 12px;
    border: 1px solid #ccc;
    border-top: none;
}
            </style>
            
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online store</title>
    </head>
    <body>
        <h1>Welcome to my online store </h1>
        <ul class="tab">
  <li><a href="javascript:void(0)" class="tablinks" onclick="openCity(event, 'home')">Home</a></li>
  <li><a href="javascript:void(0)" class="tablinks" onclick="openCity(event, 'OrderPage')">Order Page</a></li>
  <li><a href="javascript:void(0)" class="tablinks" onclick="openCity(event, 'checkout')">Checkout</a></li>
  <li><a href="javascript:void(0)" class="tablinks" onclick="openCity(event, 'conformationpage')">Conformation Page</a></li>
</ul>

<div id="home" class="tabcontent">
  <h3>Home</h3>
  <p>Welcome to online store</p>
  <a href="http://localhost:8080/Mohammed_Arfa_Adeeb_16610_CS532_C__HW5/index.jsp">
    <button>Home page</button>
</div>

<div id="OrderPage" class="tabcontent">
  <a href="http://localhost:8080/Mohammed_Arfa_Adeeb_16610_CS532_C__HW5/orderpage.jsp">
    <button>Order Page</button>
</a>
</div>

<div id="checkout" class="tabcontent">
  <a href="http://localhost:8080/Mohammed_Arfa_Adeeb_16610_CS532_C__HW5/checkout.jsp">
    <button>Checkout Page</button>
</div>
        <div id="conformationpage" class="tabcontent">
  <a href="http://localhost:8080/Mohammed_Arfa_Adeeb_16610_CS532_C__HW5/conformationpage.jsp">
      <button>conformation page</button></a>
</div>
        
    </body>
    <script>
        function openCity(evt, cityName) {
    // Declare all variables
    var i, tabcontent, tablinks;

    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    // Show the current tab, and add an "active" class to the link that opened the tab
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}
        </script>
        
</html>

<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
<jsp:useBean id="stud" scope="request" class="store.conformationpage"/>
Name:<jsp:getProperty name="stud" property="name"/>
email:<jsp:getProperty name="stud" property="email"/>
<% String Items=request.getParameter("iname");
String Quantities=request.getParameter("iqty");
%>
<table>
    
  <tr>
       <th>
       Items 
    </th>
    
    <th>
    Quantities    
                </th>
                </tr>
                <tr>
    <td>
        pens
    </td>
    <td>
        10
                </td>
    
                </tr>
</table>
</form>
    </body>
</html>
