<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.ssdi.tables.ExamDtls"%>
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

<title>Exam Portal</title>
<script>
	function takeExam(examId,examName) {
		if(confirm('Begin Exam?'))
			{
		document.getElementById("actionName").value = "takeExam";
		document.getElementById("classId").value = "6";
		document.getElementById("examId").value = examId;
		document.getElementById("examName").value = examName;
		var takeExam = document.getElementById("takeExam");
		takeExam.action = "main";
		takeExam.method = "post";
		takeExam.submit();
			}
	}
	
	function searchExam()
	{
		document.getElementById('actionName').value="viewExams";
		document.getElementById('classId').value="4";
		document.forms[0].action="main";
		document.forms[0].method = "post";
		document.forms[0].submit();
	}
	function resetExam()
	{//here
		document.getElementById('searchStr').value="";
		document.getElementById('actionName').value="viewExams";
		document.getElementById('classId').value="4";
		document.forms[0].action="main";
		document.forms[0].method = "post";
		document.forms[0].submit();
	}

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
<%
	List exams = request.getAttribute("examlist") != null ? (List) request
			.getAttribute("examlist") : null;
			String searchStr = request.getAttribute("searchStr") != null ?  request
					.getAttribute("searchStr").toString() : "";
%>
</head>
<body>

	<jsp:include page="common/header.jsp"></jsp:include>
<form id="takeExam">
<input type="hidden" name="actionName" id="actionName" value="" />
			<input	type="hidden" name="classId" id="classId" value="" />
			<input	type="hidden" name="examId" id="examId" value="" />
			<input	type="hidden" name="examName" id="examName" value="" />


	<!-- Page Content -->
	<div class="container-full">

		<!-- Page Heading -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header text-center">
					Exams
				</h1>
			</div>
		</div>
		<!-- /.row -->
		
		<div class="row">
		  <div class="col-sm-6 col-sm-offset-3">
            <div id="imaginary_container"> 
                <div class="input-group stylish-input-group">
                    <input type="text" class="form-control" name="searchStr" id="searchStr" value="<%=searchStr%>"placeholder="Search" >
                    <span class="input-group-addon">
                        <button type="submit" onclick="searchExam()">
                            <span class="glyphicon glyphicon-search"></span>
                        </button>  
                    </span>
                    <span class="input-group-addon">
                        <button type="submit" onclick="resetExam()">
                            <span class="glyphicon glyphicon-refresh"></span>
                        </button>  
                    </span>
                </div>
            </div>
        </div>

		<!--Pagin -->
		<div class="row">
			<div class="col-md-12 text-center">
			<div class="holder text-center" id="holder">
			</div>
			</div>
		</div>
		<hr>
		<ul id="page">
		<%
			ArrayList buttonIds = new ArrayList();
			for (int i = 0; i < exams.size(); i++) {
				ExamDtls examDtls = (ExamDtls) exams.get(i);
		%>
		<li>
		<div class="row">
			<dir class="col-md-1"></dir>
			<div class="col-md-4">
				<a href="#"> <img class="img-responsive" src="images/exam.png"
					alt="">
				</a>
			</div>
			<div class="col-md-6">
				<h3><%=examDtls.getExamName()%></h3>
				<h4>
					Exam Id :
					<%=examDtls.getExamId()%></h4>
				<a href="#" class="btn btn-primary"
									data-toggle="modal" data-target="#viewCourseModal<%=i%>">View Details</a>
				
			</div>
			<dir class="col-md-1"></dir>
		</div>
		<hr>
		
		<!-- /.row -->

	
	<div class="modal fade" id="viewCourseModal<%=i %>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="exampleModalLabel"><%=examDtls.getExamName()%></h4>
      </div>
      <div class="modal-body">
      
         <p><%=examDtls.getExamDescr() %></p>
       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="takeExam('<%=examDtls.getExamId()%>','<%=examDtls.getExamName()%>')">Take Exam</button>
      </div>	
    </div>
  </div>
</div>
</li>
<%
	
			}
		%>

</ul>
	<% if( exams.size()==0){%>
<br>
<div class="row">
			<div class="col-md-12 text-center">
			<h4>No Exams Found</h4>
			</div>
</div>
<br>
<br>
<br>
<br>
<br>
<%} %>	
</div>
</form>
		<hr>

		<!-- Footer -->

	</div>
	<!-- /.container -->

	<jsp:include page="common/footer.jsp"></jsp:include>


</body>
</html>