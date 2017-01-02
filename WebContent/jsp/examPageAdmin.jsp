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

<script>
function goToAddQuestion(examId,examName)
{
	document.getElementById('examId').value=examId;
	document.getElementById('examName').value=examName;
	document.forms[0].action="main";
	document.forms[0].method = "post";
	document.forms[0].submit();
}
function goToEditExam(examId)
{
	document.getElementById('examId').value=examId;
	document.getElementById('actionName').value="viewExistExam";
	document.getElementById('classId').value="11";
	document.forms[0].action="main";
	document.forms[0].method = "post";
	document.forms[0].submit();
	
	}
function searchExam()
{
	document.getElementById('actionName').value="viewExams";
	document.getElementById('classId').value="11";
	document.forms[0].action="main";
	document.forms[0].method = "post";
	document.forms[0].submit();
}

function resetExam()
{
	document.getElementById('searchStr').value="";
	document.getElementById('actionName').value="viewExams";
	document.getElementById('classId').value="11";
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


<title>Exam Portal</title>

<%
	List exams = request.getAttribute("examlist") != null ? (List) request
			.getAttribute("examlist") : null;
			String searchStr = request.getAttribute("searchStr") != null ?  request
					.getAttribute("searchStr").toString() : "";
%>
</head>
<body>

	<jsp:include page="common/header.jsp"></jsp:include>


	<!-- Page Content -->
	<div class="container-full">
<form >
<input type="hidden" name="actionName" id="actionName" value="addQuestion" />
<input type="hidden" name="classId"   id="classId" value="10" />
<input type="hidden" name="examId"   id="examId" value="" />
<input type="hidden" name="examName"   id="examName" value="" />
	
		<!-- Page Heading -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header text-center">
					View/Edit Exams
				</h1>
			</div>
		</div>
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
        </div>
        </form>
		
		<!-- /.row -->
		<!--Pagin -->
		<div class="row">
			<div class="col-md-12 text-center">
			<div class="holder text-center" id="holder">
			</div>
			</div>
		</div>
		<hr>
<ul id="page">
		<!-- Project One -->
		<%
			for (int i = 0; i < exams.size(); i++) {
				ExamDtls examDtls = (ExamDtls) exams.get(i);
		%>
		<li>
		<div class="row">
			<dir class="col-md-1"></dir>
			<div class="col-md-4">
				<a href="#"> <img class="img-responsive" src="images/exam.png"	alt="">
				</a>
			</div>
			<div class="col-md-6">
				<h3><%=examDtls.getExamName()%></h3>
				<h4>
					Exam Id :
					<%=examDtls.getExamId()%></h4>
				<p>
					<%=examDtls.getExamDescr()%>
				</p>
				<%--<a class="btn btn-primary" href="#" onclick="goToAddQuestion('<%=examDtls.getExamId()%>','<%=examDtls.getExamName()%>');">Add Questions <span
					class="glyphicon glyphicon-chevron-right"></span></a> --%>
					<a class="btn btn-primary" href="#" onclick="goToEditExam('<%=examDtls.getExamId()%>');">Edit Exam <span
					class="glyphicon glyphicon-chevron-right"></span></a>
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


		<hr>

		<!-- Footer -->

	</div>

	<!-- /.container -->

	<jsp:include page="common/footer.jsp"></jsp:include>




</body>

</html>