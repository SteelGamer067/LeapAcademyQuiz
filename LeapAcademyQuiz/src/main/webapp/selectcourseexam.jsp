<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="leapacademyquiz.service.DataListService"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<script src="https://kit.fontawesome.com/bc28bc6ecb.js"></script>
		<link rel="stylesheet" type="text/css" href="resources/css/Homepage.css">
		<title>Select Course</title>
		<style type="text/css">
			form { 
				display: inline-block;
				padding: 5px;
			}
		</style>
	</head>
	<body>
		<div class="container" align="center">	      	
	      	<form action="CourseSelectServlet" method="post">
	      		<select name="courses" id="courses">
		      		<c:forEach var="course" items="${courseList}">
						<option value="${course.courseID}"><c:out value="${course.courseName}"/></option>
					</c:forEach>
				</select>
				<br></br>
				
	      		<button class="btn" type="submit" name="takeexam" value="TakeExam"><i class="fa-solid fa-pen"></i> Go to Exam</button>
	      	</form>
	      	<br></br>
	      	
	      	<form action="CandidateSignoutServlet" method="post">
	    			<button class="btn" type="submit" name="signout" value="SignOut"><i class="fa-solid fa-arrow-pointer"></i> Sign Out</button>
	    	</form>
    	</div>
    </body>
</html>