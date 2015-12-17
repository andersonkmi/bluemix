<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Java Web Starter Application</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" href="css/style.css" />
	<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.2.8/jquery.form-validator.min.js"></script>
</head>
<body>
	<table>
		<tr>
			<td style='width: 30%;'><img class = "newappIcon" src='images/newapp-icon.png'>
			</td>
			<td>
				<h1 id = "message">Welcome to my application:</h1>				
				<p class='description'></p>
				<form action="LoginServlet" method="post">
				User: <input type="text" name="username" id="username" data-validation="length alphanumeric" data-validation-length="3-12" data-validation-error-msg="User name has to be an alphanumeric value (3-12 chars)"/>
				<p/>
				Password: <input type="password" name="password" id="password" data-validation="length" data-validation-length="1-8" data-validation-error-msg="Password has must be 1-8 chars."/>
				<p/>
				<p/>
				<input type="submit" value="Submit" class='description' onsubmit="">
				</form>
				<p class='errorMessage'>${errorMessage}</p>
			</td>
		</tr>
	</table>
	<!-- Call SimpleServlet to get the "Hello World" message  -->
	<script type="text/javascript">
		$(document).ready(function() {
			$('#username').focus();
		});
		
		$.validate(); 
	</script>
</body>
</html>
