<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%String str1 = request.getAttribute("StringTest").toString(); %>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">

<title>BootStrap Example</title>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>My Second Bootstrap Page</h1>
			<p> Shiv Desai : Parameter Send from Business Class is : <%=str1 %>  </p>
		</div>
		<div class="row table-bordered">
			<div class="col-md-6 text-center table-bordered" >
				<h3>Column 1</h3>
				<p>One Column With Span 6</p>
			</div>
			<div class="col-md-6 text-nowrap table-bordered">
				<h3>Column 2</h3>
				<p>Other Column With Span 6</p>
			</div>
		</div>
	</div>
</body>
</html>