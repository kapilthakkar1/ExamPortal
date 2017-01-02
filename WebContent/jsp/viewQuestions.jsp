<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList, com.ssdi.tables.QuestionDtls"%>
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
function goBack()
{
	document.getElementById('classId').value="10";
	document.getElementById('actionName').value="viewExams";
	var backForm = document.getElementById('backForm');
	backForm.action="main";
	backForm.method = "post";
	backForm.submit();
	
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
		
function updateQuestion(i)
{
	
	if(validateQuestion(i))
		{
		document.getElementById('classId'+i).value="13";
		document.getElementById('actionName'+i).value="updateQuestion";
		var quesForm = document.getElementById('questionForm'+i);
		quesForm.action="main";
		quesForm.method = "post";
		quesForm.submit();
		
		}
	
}

function deleteQuestion(i)
{
	confirm("Are you sure you want to Delete this Question");
	document.getElementById('classId'+i).value="13";
	document.getElementById('actionName'+i).value="deleteQuestion";
	var quesForm = document.getElementById('questionForm'+i);
	quesForm.action="main";
	quesForm.method = "post";
	quesForm.submit();
}

function validateQuestion(i)
{
	var regex = /^[0-9]*$/;
	var timeVal = document.getElementById('time'+i).value;
	
	if(document.getElementById('question'+i).value=='')
		{
		alert('Please enter a Question.');
		document.getElementById('question'+i).focus();
		return false;
		}
	else if(document.getElementById('Option1'+i).value=='')
	{
	alert('Please enter a Option A.');
	document.getElementById('Option1'+i).focus();
	return false;
	}
	else if(document.getElementById('Option2'+i).value=='')
	{
	alert('Please enter a Option B.');
	document.getElementById('Option2'+i).focus();
	return false;
	}
	else if(document.getElementById('Option3'+i).value=='')
	{
	alert('Please enter a Option C.');
	document.getElementById('Option3'+i).focus();
	return false;
	}
	else if(document.getElementById('Option4'+i).value=='')
	{
	alert('Please enter a Option D.');
	document.getElementById('Option4'+i).focus();
	return false;
	}
	else if(document.getElementById('time'+i).value=='')
	{
	alert('Please enter time.');
	document.getElementById('time'+i).focus();
	return false;
	}
	else if( !regex.test(timeVal)
			|| (parseInt(timeVal) < parseInt(0)) )
		{
		alert('Time should a number greater than 0.');
		document.getElementById('time').value ="";
		document.getElementById('time').focus();
		return false;
		}
	else if(!(document.getElementById('answer1'+i).checked||
			document.getElementById('answer2'+i).checked ||
			document.getElementById('answer3'+i).checked ||
			document.getElementById('answer4'+i).checked 
	))
	{
	alert('Please Choose Correct Answer.');
	return false;
	}
	return true;
}
</script>
<title>Exam Portal</title>
<%

ArrayList list = request.getAttribute("questionList")!=null?
		(ArrayList)request.getAttribute("questionList"):null;
String examId = request.getAttribute("examId")!=null?request.getAttribute("examId").toString():"";
String examName = request.getAttribute("examName")!=null?request.getAttribute("examName").toString():"";
		//ExamDtls exam
String SuccessMsg = request.getAttribute("SuccessMsg")!=null?request.getAttribute("SuccessMsg").toString():"";
%>
</head>

<body>
  <jsp:include page="common/header.jsp"></jsp:include>
  <form id ="backForm">
  <input type="hidden" name="actionName" id="actionName" value="" />
<input type="hidden" name="classId"   id="classId" value="" />
<input type="hidden" name="examId"   id="examId" value="<%=examId %>" />
<input type="hidden" name="examName"   id="examName" value=""<%=examName %>" />
  </form>
  	<!-- Page Content -->
	<div class="container-full">

		<!-- Page Heading -->
  <div class="row">
			<div class="col-lg-12">
				<h1 class="page-header text-center">
					View/Edit Question
				</h1>
			</div>
		</div>
		 <div class="row">
			<div class="col-lg-12 text-center">
			<a class="btn btn-primary" href="#" onclick="goBack();"><span
					class="glyphicon glyphicon-triangle-left"></span>Back</a> 
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
				
				QuestionDtls questions = (QuestionDtls)list.get(i);
		%>
		<li>
		<form id="questionForm<%=i%>">
		<input type="hidden" name="actionName" id="actionName<%=i%>" value="" />
<input type="hidden" name="classId"   id="classId<%=i%>" value="" />
<input type="hidden" name="examId"   id="examId<%=i%>" value="<%=examId %>" />
<input type="hidden" name="quesNum"   id="quesNum<%=i%>" value="<%=questions.getQuestionNum() %>" />
		<div class="row">
			<div class="col-md-1"></div>
			
			<div class="col-md-2 text-right">
			<h3><%= i+1%>.</h3>
			</div>
			<div class="col-md-8">
			    <textarea rows="1"  class="form-control" id="question<%=i%>" name="question"> <%= questions.getQuesName()%></textarea> 
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="row">
			<div class="col-md-1"></div>
			
			<div class="col-md-2">&nbsp;</div>
			<div class="col-md-4">
				     <label>Option A:</label> 
				</div>
			<div class="col-md-4">
			    <input type="text"  class="form-control" name="Option1" id ="Option1<%=i%>" value="<%= questions.getQuesOpt1()%>"/> 
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="row">
			<div class="col-md-1"></div>
			
			<div class="col-md-2">&nbsp;</div>
			<div class="col-md-4">
				     <label>Option B:</label> 
				</div>
			<div class="col-md-4">
			   <input type="text"  class="form-control" name="Option2" id ="Option2<%=i%>" value="<%= questions.getQuesOpt2()%>"/>
			</div>
			
			<div class="col-md-1"></div>
		</div>
		<div class="row">
			<div class="col-md-1"></div>
			
			<div class="col-md-2">&nbsp;</div>
			<div class="col-md-4">
				     <label>Option C:</label> 
				</div>
			<div class="col-md-4">
				  <input type="text"  class="form-control" name="Option3" id ="Option3<%=i%>" value="<%= questions.getQuesOpt3()%>"/>
				</div>
			<div class="col-md-1"></div>
		</div>
			<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-2">&nbsp;</div>
				<div class="col-md-4">
				     <label>Option D:</label> 
				</div>
				<div class="col-md-4">
				    <input type="text"  class="form-control" name="Option4" id ="Option4<%=i%>" value="<%= questions.getQuesOpt4()%>"/>
				</div>
			<div class="col-md-1"></div>
		</div>
		<div class="row">
			<div class="col-md-1"></div>
			
			<div class="col-md-2">&nbsp;</div>
			<div class="col-md-4">
				     <label>Time in Seconds:</label> 
				</div>
			<div class="col-md-4">
				   <input type="text" class="form-control" name="time" id ="time<%=i %>" value="<%= questions.getTime()%>"/>
				</div>
			<div class="col-md-1"></div>
		</div>
		<div class="row">
			<div class="col-md-1"></div>
			
			<div class="col-md-2">&nbsp;</div>
				<div class="col-md-4">
				     <label>Correct Option:</label> 
				</div>
				<div class="col-md-1">
				 <label class=""><input type="radio" name="answer"  id="answer1<%=i %>" value="1"  class="form-control">&nbsp;A </label>
				 </div><div class="col-md-1">
				 <label class=""><input type="radio" name="answer"  id="answer2<%=i %>" value="2"  class="form-control">&nbsp;B </label>
				 </div><div class="col-md-1">
				 <label class=""><input type="radio" name="answer"  id="answer3<%=i %>" value="3"  class="form-control">&nbsp;C </label>
				 </div><div class="col-md-1">
				 <label class=""><input type="radio" name="answer"  id="answer4<%=i %>" value="4"  class="form-control">&nbsp;D </label>
				 <script>
				 document.getElementById("answer<%=questions.getQuesCorrectOpt()%><%=i %>").checked=true;
				 </script>
				</div>
			<div class="col-md-1"></div>
		</div>
			<div class="row">
			<div class="col-md-12 text-center">
			<a class="btn btn-primary"  onclick="updateQuestion('<%=i%>');">Update <span
					class="glyphicon glyphicon-copy"></span></a> 
					<a class="btn btn-primary"  onclick="deleteQuestion('<%=i%>');">Delete <span
					class="glyphicon glyphicon-remove"></span></a> 
			</div>
			</div>
			
		
		</form>
		<hr>
		</li>
		<%
			}
		%>
		<!-- /.row -->
</ul>

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
  <%if(!SuccessMsg.equals("")){ %>
   <script>alert('<%=SuccessMsg%>');</script>
  <%} %>
</body>
</html>