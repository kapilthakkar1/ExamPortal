<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">

<title>First Page</title>

<script>
function mainSubmit()
{
	  window.parent.location.replace("./index.jsp");
}
</script>

</head>
<body>
	<div class="container">
		

		<div class="row">
		<form id="indexForm" method="post">
			<input type="hidden" name="actionName" value="redirect" />
			 <input type="hidden" name="classId" value="1" />
			 <div class="row">
			 	<div class="col-sm-4 text-center">
			 	<h3>Opps..! Sorry we had a problem. Please try again later.</h3>
			 	<input type="button" value="OK" onclick="mainSubmit();"/>
			 	</div>
			 </div>

		</form>
		</div>
	</div>

</body>
</html>