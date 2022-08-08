<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<script src="https://kit.fontawesome.com/bc28bc6ecb.js"></script>
		<link rel="stylesheet" type="text/css" href="resources/css/Style.css">
		<title>Register Course</title>
	</head>
	<body>		
		<div class="container" align="center">			
			<form action="CourseRegisterServlet" method="post">
				<c:set var="username" value="${username}"></c:set>
	      		
	      		<input type="hidden" name="username" value="<% out.println(pageContext.getAttribute("username").toString()); %>">
	      		
				<label><c:out value="Hi, ${username}"></c:out></label>
				<br></br>
				
				<select name="courses" id="courses">
					<c:forEach var="course" items="${courseList}">
						<option value="${course.courseID}"><c:out value="${course.courseName}"/></option>
					</c:forEach>
				</select>
				<br></br>
				
	      		<button class="btn" type="submit" name="register" value="Register"><i class="fa-solid fa-pen"></i> Register</button>
	      		<br></br>
	      	</form>
		</div>
	</body>
</html>