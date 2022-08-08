<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<script src="https://kit.fontawesome.com/bc28bc6ecb.js"></script>
		<link rel="stylesheet" type="text/css" href="resources/css/Homepage.css">
		<title>User Homepage</title>
		<style type="text/css">
			form { 
				display: inline-block;
				padding: 5px;
			}
		</style>
	</head>
	<body>
		<div align="center">
			<c:set var="username" value="${username}" scope="application"></c:set>
			<h1><c:out value="Welcome, ${username}"></c:out></h1>
			
			<form action="ExamSelectServlet" method="post">
				<c:set var="uname" value="${username}"></c:set>
				<input type="hidden" name="username" value="<% out.println(pageContext.getAttribute("uname").toString()); %>">
				
    			<button class="btn" type="submit" name="giveexam" value="GiveExam"><i class="fa-solid fa-pen"></i> Give Exam</button>
    		</form>
    		
    		<form action="ExamRegisterServlet" method="post">
    			<button class="btn" type="submit" name="registerexam" value="RegisterExam"><i class="fa-solid fa-pen"></i> Register for Exam</button>
    		</form>
    		
    		<form action="CandidateProfileServlet" method="post">
    			<c:set var="uname" value="${username}"></c:set>
				<input type="hidden" name="username" value="<% out.println(pageContext.getAttribute("uname").toString()); %>">
				
    			<button class="btn" type="submit" name="profile" value="Profile"><i class="fa-solid fa-user"></i> View Profile</button>
    		</form>
    		
    		<form action="CandidateSignoutServlet" method="post">
    			<button class="btn" type="submit" name="signout" value="SignOut"><i class="fa-solid fa-right-from-bracket"></i> Sign Out</button>
    		</form>
    		
		</div>
	</body>
</html>