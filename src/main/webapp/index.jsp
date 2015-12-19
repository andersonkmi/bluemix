<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Anderson Ito Java Bluemix project</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!--<link rel="stylesheet" href="css/style.css" />-->
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.2.8/jquery.form-validator.min.js"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/jumbotron.css" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Anderson Ito Bluemix Java
					project</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<!--<a class="navbar-right" href="#">${errorMessage }</a>-->
				<form class="navbar-form navbar-right" action="login.action"
					method="post">
					<div class="form-group">
						<input type="text" placeholder="E-mail" class="form-control"
							name="username" id="username">
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" class="form-control"
							name="password" id="password">
					</div>
					<button type="submit" class="btn btn-success">Sign in</button>
				</form>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>

	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		<div class="container">
			<h1>Anderson Ito Java Bluemix project!</h1>
			<p>This is a simple project developed to test some of the capabilities of the IBM Bluemix platform and
			may be used in the future for real-life projects.</p>
			<p>
				<a class="btn btn-primary btn-lg" href="http://www.ibm.com/Bluemix" role="button">Learn
					more &raquo;</a>
			</p>
		</div>
	</div>

	<div class="container">
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-md-4">
				<h2>IBM Bluemix</h2>
				<p>Create, deploy and manager. Your applications in the cloud.</p>
				<p>
					<a class="btn btn-default" href="http://www.ibm.com/Bluemix" role="button">View details
						&raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Build and run apps</h2>
				<p>Use powerful, open-source technologies to power your apps. Let Bluemix handle the rest.</p>
				<p>
					<a class="btn btn-default" href="https://www.ng.bluemix.net/docs/" role="button">View details
						&raquo;</a>
				</p>
			</div>
			<div class="col-md-4">
				<h2>Use Services & APIs</h2>
				<p>Choose IBM, third-party, and community services to extend the functionality of your apps.</p>
				<p>
					<a class="btn btn-default" href="https://console.ng.bluemix.net/catalog/#services" role="button">View details
						&raquo;</a>
				</p>
			</div>
		</div>

		<hr>

		<footer>
			<p>&copy; 2015 Anderson Ito, Inc.</p>
		</footer>
		<div id="errorDialog" title="Warning!!">
			<p>${errorMessage }</p>
		</div>
	</div>
	<!-- /container -->
	<!--<p class='errorMessage'>${errorMessage}</p>-->
	<!-- Call SimpleServlet to get the "Hello World" message  -->
	<script type="text/javascript">
		$(document).ready(function() {
			var errorMessage = "${errorMessage}";
			if(errorMessage != '') {
				$("#errorDialog").dialog({
				      modal: true,
				      buttons: {
				        Ok: function() {
				          $( this ).dialog( "close" );
				          $('#username').focus();
				        }
				      }
				    });
			}
			
			$('#username').focus();
		});
	</script>
</body>
</html>
