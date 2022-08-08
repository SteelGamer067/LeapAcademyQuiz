<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<script src="https://kit.fontawesome.com/bc28bc6ecb.js"></script>
		<link rel="stylesheet" type="text/css" href="resources/css/Style.css">
		<title>Your Score</title>
	</head>
	<body>
	<div class="container" align="center">
		<label>Total Score: </label>
		<c:out value="${score}"/>
		
		<form action="ExamSelectServlet" method="post">
				<c:set var="uname" value="${username}"></c:set>
				<input type="hidden" name="username" value="<% out.println(pageContext.getAttribute("uname").toString()); %>">
				
    			<button class="btn" type="submit" name="giveexam" value="GiveExam"><i class="fa-solid fa-pen"></i> Give Another Exam</button>
    		</form>
		
		<form action="CandidateSignoutServlet" method="post">
    			<button class="btn" type="submit" name="signout" value="SignOut"><i class="fa-solid fa-right-from-bracket"></i> Sign Out</button>
    	</form>
	</div>
	</body>
</html>