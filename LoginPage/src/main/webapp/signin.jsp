<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet"  href="style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<div class="form-container">
  <div>
    <h1>Login page</h1>
  </div>
  <form action="LoginServlet" method="post">
    <input type="text" placeholder="Enter Your UserName" name="name" required><br>
    <div class="password-wrapper">
      <input class="passwordss" type="password" placeholder="Enter Your password" name="password" required>
      <span><i class="fa-regular fa-eye-slash"></i></span> 
    </div>
    <button>SignIn</button>
    <div class="anchor-tags">
      <a href="index.html">Home</a>
      <a href="signin.jsp">Forget password?</a>
    </div>
  </form>
</div>
<script src="app.js"></script>
</body>
</html>
