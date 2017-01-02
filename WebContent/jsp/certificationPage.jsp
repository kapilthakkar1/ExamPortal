<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.ssdi.tables.UserTxnDtls"%>

<html>
<head>
	<style>
	label {
    display: block;
    text-align: center;
    line-height: 150%;
    font-size: .85em;
}
	</style>
	
	<script src="bootstrap/jquery-1.11.2.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="ui/jquery-ui.min.js"></script>
<script src="js/md5.js"></script>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="ui/jquery-ui.min.css">
	
</head>
	<body>
	<jsp:include page="common/header.jsp"></jsp:include>
		
		<%
				boolean ispass = (boolean)request.getAttribute("ispass");
				float percentile = (float)request.getAttribute("percentile");
				float percentage = (float)request.getAttribute("percentage");
				String status;
				if(ispass)
					status="Congratulations! You have Passed.";
				else
					status="Sorry. You failed the exam.";
				%>
				<h1 style="text-align:center">Results</h1>
				<h3 style="text-align:center"><%=status %></h2>
				<h3 style="text-align:center">Percentage:<%=percentage %>%</h3>
				<h3 style="text-align:center">Percentile:<%=percentile %>%</h3>
			<br>
			<br>
			<br>
			<br>
			<br>
						<jsp:include page="common/footer.jsp"></jsp:include>
	</body>
</html>