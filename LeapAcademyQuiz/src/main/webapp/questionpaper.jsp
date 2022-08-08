<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Timer, java.util.TimerTask, java.io.IOException" %>
<%@ page import="leapacademyquiz.utilities.CountdownTimer" %>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="resources/css/QPStyle.css">
		<meta charset="ISO-8859-1">
		<title>Question Paper</title>
	</head>
	<body>
		<form method="post" action="SignoutServlet">
	    		<input type="submit" value="Sign Out">
	    </form>
	    <c:set var="username" value="${username}"></c:set>
	    <c:set var="courseID" value="${courseID}"></c:set>
	    <h2><c:out value="${courseID}"></c:out></h2>
  		<div class="container">
  			<table>
  				<tr>
	    			<td>
	    				<label style="margin:5px"><b>Time Left: 180 seconds</b></label>
	    				<br></br>		    				
	    			</td>	
	    				    			    			
	    		</tr>
	    	</table>
	    	<form method="post" action="QuestionPaperServlet">
	    		<input type="hidden" name="username" value="<% out.println(pageContext.getAttribute("username").toString()); %>">
	    		<input type="hidden" name="username" value="<% out.println(pageContext.getAttribute("courseID").toString()); %>">
	    		
		    	<c:set var="i" value="1"/>
		    	<c:forEach var="ques" items="${questionPaper}">
			    	<h3><c:out value="${ques.questionNo}. ${ques.question}"/></h3>
					<table>
			    		<tr>		
			    			<td>
			    				<input type="checkbox" id="is${i}ACorrect" name="chkbx_${i}A">
			    				<label><c:out value="${ques.optionA}"/></label>
			    			</td>
			    		</tr>
			    		
			    		<tr>		    					    			
			    			<td>
			    				<input type="checkbox" id="is${i}BCorrect" name="chkbx_${i}B" value="${i}">
			    				<label><c:out value="${ques.optionB}"/></label>
			    			</td>
			    		</tr>
			    		
			    		<tr>		    				    			
			    			<td>
			    				<input type="checkbox" id="is${i}CCorrect" name="chkbx_${i}C" value="${i}">
			    				<label><c:out value="${ques.optionC}"/></label>
			    			</td>
			    		</tr>
			    		
			    		<tr>
			    			<td>
			    				<input type="checkbox" id="is${i}DCorrect" name="chkbx_${i}D" value="${i}">
			    				<label><c:out value="${ques.optionD}"/></label>
			    			</td>
			    		</tr>
			    	</table>
			    	<c:set var="i" value="${i+1}"/>
		    	</c:forEach>
		    	<br></br>
		    	<table>
		    		<tr>
		    			<td>
		    				<input type="submit" value="Submit Test">
		    			</td>
		    		</tr>
		    	</table>
	    	</form>
	    </div>
	</body>
</html>