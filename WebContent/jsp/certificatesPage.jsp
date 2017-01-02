<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList, com.ssdi.tables.CertificationDtls"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%--String str1 = request.getAttribute("StringTest"); --%>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="bootstrap/jquery-1.11.2.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

<script src="bootstrap/jPages.min.js"></script>
<link type="text/css" rel="stylesheet" href="bootstrap/jPages.css"/>
<script>
var jq = $.noConflict();
jq(function(){
	jq("#holder").jPages({
		    containerID : "page",
		    perPage : 5,
		    previous    : false,
		      next        : false
		  });
	

		});
</script>


<title>Exam Portal</title>
<%
 ArrayList list = request.getAttribute("certificatelist")!=null?
		(ArrayList)request.getAttribute("certificatelist"):null;
		//CertificateDtls certificates
		
%>
</head>
<body>

	<jsp:include page="common/header.jsp"></jsp:include>


	<!-- Page Content -->
	<div class="container-full">

		<!-- Page Heading -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header text-center">
					Your Certificates
				</h1>
			</div>
		</div>
		<!-- /.row -->

		<!-- Pagin -->
		<div class="row">
			<div class="col-md-12 text-center">
			<div class="holder text-center" id="holder">
			</div>
			</div>
		</div>
		<hr>
		<ul id="page">
		<%
			for (int i = 0; i < list.size(); i++) {
				
				CertificationDtls certificates = (CertificationDtls)list.get(i);
		%>
		<li>
		<div class="row">
			<dir class="col-md-1"></dir>
			<div class="col-md-4">
				<a href="#"> <img class="img-responsive" src="images/cc.jpg"
					alt="">
				</a>
			</div>
			<div class="col-md-6">
				<h3><%=certificates.getCertificationName()%></h3>
				<h4>
					Exam Id :
					<%=certificates.getExamId()%></h4>
				<p>
					Percentage Scored : <%=certificates.getPercentage()%> %
				</p>
				<p>
					Certification Date : <%=certificates.getExamDate()%>
				</p>
			</div>
			<dir class="col-md-1"></dir>
		</div>
		<hr>
		</li>
		<%
			}
		%>
		<!-- /.row -->
</ul>

<% if( list.size()==0){%>
<br>
<div class="row">
			<div class="col-md-12 text-center">
			<h4>No Certificates Yet</h4>
			</div>
</div>
<br>
<br>
<br>
<br>
<br>
<%} %>	
		<!-- Pagination -->
		<!-- /.row -->

		<hr>

		<!-- Footer -->

	</div>
	<!-- /.container -->

	<jsp:include page="common/footer.jsp"></jsp:include>


	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

</body>

</html>