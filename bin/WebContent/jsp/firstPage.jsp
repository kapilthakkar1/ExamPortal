<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Work</title>
<script>
function submitForm()
{
	
	document.forms[0].submit();
}

</script>
</head>
<body>
Welcome Hello First1
<form id="indexForm2" action="main" method="post">
<input type="hidden" name="actionName" value="redirect"/>
<input type="hidden" name="classId" value="1"/>
<input type="button" value="Submit" onclick="submitForm();"/>
</form>
</body>
</html>