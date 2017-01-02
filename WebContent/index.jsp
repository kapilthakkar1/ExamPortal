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
	document.getElementById("actionName").value="homePage";
	document.getElementById("classId").value="2";
	document.forms[0].action="main";
	document.forms[0].method="post";
	document.forms[0].submit();
}

</script>

</head>
<body onload="mainSubmit()">
	<div class="container">
		

		<div class="row">
		<form id="indexForm" method="post">
			<input type="hidden" name="actionName" id="actionName" value="" />
			 <input type="hidden" name="classId"   id="classId" value="" />
			 
		</form>
		</div>
	</div>

</body>
</html>