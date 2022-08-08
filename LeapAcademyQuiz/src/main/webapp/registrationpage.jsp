<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="leapacademyquiz.service.DataListService"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="resources/css/Style.css">
		<title>Registration Form</title>
	</head>
	<body>
		<h2 align="center">Registration Form</h2>
		<div class="container" align="center">			
			<form method="post" action="RegistrationServlet">
				<c:set var="uname" value="${username}"/>
				<label><c:out value="User: ${username}"></c:out></label>
				
				<input type="hidden" name="username" value="<% out.println(pageContext.getAttribute("uname").toString()); %>">
				<br></br>
				
		   		<label for="fname"><b>First Name :</b></label>
		   		<input type="text" placeholder="First Name" name="fname" required>
		   		<br></br>
		   
		   		<label for="lname"><b>Last Name :</b></label>
		   		<input type="text" placeholder="Last Name" name="lname" required>
		   		<br></br>
		   
		  		<label for="faname"><b>Father Name :</b></label>
		   		<input type="text" placeholder="Father Name" name="faname" required>
		   		<br></br>
		   
		   		<label for="email"><b>Email Id :</b></label>
		   		<input type="text" placeholder="Email Id" name="email" required>
		   		<br></br>
		   		
		   		<table>
		    		<tr>
		    			<td><b>Date of Birth :</b></td>
		    			<td><input type="date" name="dob"></td>				
		    		</tr>
		    	</table>
		   		<br></br>
		   
		   		<label for="address"><b>Address :</b></label>
		   		<input type="text" placeholder="Address" name="address" required>
		   		<br></br>
		   		
		   		<%	DataListService dataCon = new DataListService();
		   			ArrayList<String> cityList = dataCon.getCities();
		   			ArrayList<String> stateList = dataCon.getStates();
		   			int i;
		   		%>
		   		<label for="lblcity"><b>City :</b></label>
				<select name="city" id="city">
					<% for(i = 0; i < cityList.size(); i++){ %>
						<option value="<% out.println(cityList.get(i)); %>"><% out.println(cityList.get(i)); %></option>
					<% } %>
					
		      		</select>
		      		<br></br>
		   
		   		<label for="lblState"><b>State :</b></label>
				<select id="state" name="state">
		   			<% for(i = 0; i < stateList.size(); i++){ %>
						<option value="<% out.println(stateList.get(i)); %>"><% out.println(stateList.get(i)); %></option>
					<% } %>
				</select>
				<br></br>
		
				<label for="pin"><b>Pincode :</b></label>
		   		<input type="text" placeholder="Pincode" name="pin" required>
		   		<br></br>
	   		
   				<button type="submit" >Submit</button>
			</form>
	  	</div>
	</body>
</html>