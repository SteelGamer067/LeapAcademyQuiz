<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<script src="https://kit.fontawesome.com/bc28bc6ecb.js"></script>
		<link rel="stylesheet" type="text/css" href="resources/css/Style.css">
		<title>Login</title>
	</head>
	<body>
		<h2 align="center">Login For Exam</h2>
		<div class="container" align="center">
			<form method="post" action="LoginServlet">
	   			<label for="uname"><b>Username :</b></label>
	   			<input type="text" placeholder="Enter Username" name="uname" required>
	   			<br></br>
	
	   			<label for="psw"><b>Password :</b></label>
	   			<input type="password" placeholder="Enter Password" name="psw" required>
	   			<br></br>
   				
   				<button class="btn" type="submit" name="stlogin" value="stLogin"><i class="fa-solid fa-right-to-bracket"></i> Login</button>
  			</form>
 		</div>
	</body>
</html>