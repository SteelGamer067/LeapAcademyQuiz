<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<script src="https://kit.fontawesome.com/bc28bc6ecb.js"></script>
		<link rel="stylesheet" type="text/css" href="resources/css/Style.css">
		<title>Sign Up</title>
	</head>
	<body>
		<h2 align="center">Sign Up</h2>
  		<div class="container" align="center">
  			<form method="post" action="SignupServlet">
	    		<label for="uname"><b>User Name:</b></label>
	    		<input type="text" placeholder="Enter Username" name="uname" required>
	    		<br></br>
	
	    		<label for="psw"><b>Password:</b></label>
	    		<input type="password" placeholder="Enter Password" name="psw" required>
	    		<br></br>
	    
	    		<label for="psw"><b>Confirm Password: </b></label>
	    		<input type="password" placeholder="Enter Password" name="cnfpsw" required>
	    		<br></br>
    		
	    		<button class="btn" type="submit" name="signup" value="SignUp"><i class="fa-solid fa-user-plus"></i> Sign Up</button>
	     	</form>
  		</div>
	</body>
</html>