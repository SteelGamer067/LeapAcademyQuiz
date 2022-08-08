<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="leapacademyquiz.service.DataListService, leapacademyquiz.model.StudentDataModel"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<script src="https://kit.fontawesome.com/bc28bc6ecb.js"></script>
		<link rel="stylesheet" type="text/css" href="resources/css/Style.css">
		<title>Your Profile</title>
	</head>
	<body>
		<h2 align="center">Candidate Profile</h2>
		<div class="container" align="center">
			<c:set var="x" value="${username}"/>
			
			<label>Logged-in as</label>
			<c:out value="${username}"></c:out>
			<br></br>
			
			<c:set var="student" value="${student}"></c:set>
			
    		<label for="firstname"><b>First Name: </b></label>
    		<label><c:out value="${student.firstName}"></c:out></label>
    		<br></br>
    
    		<label for="lastname"><b>First Name: </b></label>
    		<label><c:out value="${student.lastName}"></c:out></label>
    		<br></br>
    		
    		<label for="fathername"><b>Father Name: </b></label>
    		<label><c:out value="${student.fatherName}"></c:out></label>
    		<br></br>
    		
    		<label for="dateofbirth"><b>Date of Birth: </b></label>
    		<label><c:out value="${student.dob}"></c:out></label>
    		<br></br>
    
    		<label for="email"><b>Email Id: </b></label>
    		<label><c:out value="${student.emailID}"></c:out></label>
    		<br></br>
    
    		<label for="address"><b>Address: </b></label>
    		<label><c:out value="${student.address}"></c:out></label>
    		<br></br>
    		
    		<label for="address"><b>City: </b></label>
    		<label><c:out value="${student.city}"></c:out></label>
    		<br></br>
    		
    		<label for="address"><b>State: </b></label>
    		<label><c:out value="${student.state}"></c:out></label>
    		<br></br>
	
			<label for="pincode"><b>Pincode: </b></label>
    		<label><c:out value="${student.pincode}"></c:out></label>
    		<br></br>
    		
    		<form action="CandidateSignoutServlet" method="post">
    			<button class="btn" type="submit" name="signout" value="SignOut"><i class="fa-solid fa-right-from-bracket"></i> Sign Out</button>
    		</form>
	    </div>
	</body>
</html>