<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Anderson Ito Java Bluemix project</title>
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/dashboard.css" rel="stylesheet">

</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Anderson Ito's Bluemix Java</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="showSettings.action?id=${id}">${userName}</a></li>
					<li><a href="logout.action">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li><a href="#">Start here <span class="sr-only">(current)</span></a></li>
					<li><a href="showSettings.action?id=${id }">Settings</a></li>
					<li><a href="translate.action?action=show">Translation</a>
					<li><a href="showTranslations.action">View translations</a>
					<li class="active"><a href="upload.action">Document conversion</a>
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h2 class="page-header">Watson Document Conversion Service:</h2>
				<form action="upload.action?action=convert" method="post" enctype="multipart/form-data">	
				<p>File to be converted:</p>  
				<input type="file" name="file" />
				<br>
				<p>Choose format:</p>
				<select name="conversionFormat">
					<option value="html">HTML</option>
					<option value="plain">Plain text</option>
					<option value="json">Answer units</option>
				</select>
				<br>
				<br>			
				<textarea rows="15" cols="100"  name="convertedText" id="convertedText" placeholder="The converted file will be displayed here" readonly="readonly" style="overflow:scroll">${translatedText }</textarea>				
				<br>
				<button type="submit" class="btn btn-success">Upload and convert</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
