<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<script src="https://kit.fontawesome.com/bc28bc6ecb.js"></script>
		<link rel="stylesheet" type="text/css" href="resources/css/Homepage.css">
		<title>Homepage</title>
		<style type="text/css">
			form { 
				display: inline-block;
				padding: 5px;
			}
		</style>
	</head>
	<body>
		<div align="center">
			<h1>Leap Academy Certifications</h1>
			<form action="HomepageLoginServlet" method="post">
				<button class="btn" type="submit" name="login" value="Login"><i class="fa-solid fa-right-to-bracket"></i> Login</button>
			</form>
			
			<form action="HomepageSignupServlet" method="post">
				<button class="btn" type="submit" name="signup" value="SignUp"><i class="fa-solid fa-user-plus"></i> Sign Up</button>
			</form>
		</div>
	</body>
</html>