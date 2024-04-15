<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<style>
body {
    background:url("./mrngimg.jpg") no-repeat;
    background-size: cover;
    background-color:aqua;
    display:flex;
    justify-content:center;
    align-items:center;
    height:100vh;
}
h1 {
    display:flex;
    justify-content:center;
    align-items:center;
    color:green;
}
.welcome{
margin:25% auto;
  background-color: rgba(255, 255, 255, 0.512);
    height: auto;
    width:600px;
    padding:5rem;
    text-align:center;
    border-radius:5%;
}
.welcome a{
color: rgba(255, 68, 0, 0.731);
text-decoration:none;
font-size:1.3rem;
font-weight:800;
}
</style>
</head>
<body>
<% 
    String nm = request.getParameter("name");
    System.out.println("Received parameter 'name': " + nm);
    if (nm != null && !nm.isEmpty()) {
%>
<div class="welcome">
    <h1>Welcome...! <%= nm %> you have Registered Succesfully</h1>
    <h2>
        A mini project using java  Login and Registration was developed by me using html , css , javascript , servlets ,jsp and mysql.
    </h2>
    <a href="signin.jsp">LOGOUT</a>
</div>
<%
} else {
%>
   <div class="welcome">
       <h1>Welcome to Dynamic world...!</h1>
       <h2>You logged in Successfully</h2>
        <a href="signin.jsp">LOGOUT</a>
   </div>
<%
}
%>

</body>
</html>
