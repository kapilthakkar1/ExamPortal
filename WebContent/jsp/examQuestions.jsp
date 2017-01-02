<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.ssdi.tables.UserDtls, com.ssdi.tables.QuestionDtls"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%--String str1 = request.getAttribute("StringTest"); --%>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="bootstrap/jquery-1.11.2.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="bootstrap/flipclock.min.js"></script>
<script src="js/md5.js"></script>
<link rel="stylesheet" type="text/css"
	href="bootstrap/flipclock.css">


<title>Exam Portal</title>
<script>
window.onblur = function(){
	//alert('You cannot navigate away during an exam. Please clik cancel exam if you do not wish to continue.');
} 
function nextQues()
{
	clock.stop();
	document.getElementById("actionName").value = "nextQuestion";
	document.getElementById("classId").value = "6";
var questionForm = document.getElementById("questionForm");
questionForm.action = "main";
questionForm.method = "post";
clearTimeout(timeOutVar);
questionForm.submit();
}
function seeResults()
{
	document.getElementById("actionName").value = "certification";
	document.getElementById("classId").value = "9";
var questionForm = document.getElementById("questionForm");
questionForm.action = "main";
questionForm.method = "post";
questionForm.submit();
}


</script>
<%
	List question = request.getSession().getAttribute("questionList") != null ? (List) request
			.getSession().getAttribute("questionList") : null;
	String examName = request.getSession().getAttribute("examName").toString();
	String seqNoStr = request.getSession().getAttribute("seqNo").toString();
	int seqNo = Integer.parseInt(seqNoStr);
	if(seqNo>=question.size())
	{
		seqNo = (question.size()-1);
	}
	String alreadyGiven = request.getAttribute("alreadyGiven")!=null?request.getAttribute("alreadyGiven").toString():"";
	QuestionDtls qdtls = null;
	long time = 0;
	if(alreadyGiven.equals(""))
	{
		 qdtls= (QuestionDtls)question.get(seqNo);
		 time = qdtls.getTime()*1000;

	}
	String examCompleted = request.getAttribute("examComplete")!=null?request.getAttribute("examComplete").toString():"";
	
	 
%>
<%if(examCompleted.equals("")){ %>
<script>
var timeOutVar = setTimeout("nextQues()",<%=time%>);
</script>
<%}%>
</head>
<body >

	<jsp:include page="common/header.jsp"></jsp:include>


	<!-- Page Content -->
	<div class="container-full">
<form id="questionForm">
			<input type="hidden" name="actionName" id="actionName" value="" />
			<input	type="hidden" name="classId" id="classId" value="" />
			
			
		<!-- Page Heading -->
		<div class="row">
			<div class="col-md-12">
				<h1 class="page-header text-center">
					<%= examName %>
				</h1>
			</div>
		</div>
		<%if(examCompleted.equals("")){ %>
		<input	type="hidden" name="quesNum" id="quesNum" value="<%= qdtls.getQuestionNum()%>" />
			<input	type="hidden" name="opCorrect" id="opCorrect" value="<%= qdtls.getQuesCorrectOpt()%>" />
			<input	type="hidden" name="examId" id="examId" value="<%= qdtls.getExamId()%>" />
		<div class="row ">
			<div class="col-md-4" ></div>
			<div class="col-md-4" >
			<div id ="timer"></div>
			<div class="col-md-4" ></div>
			</div>
		</div>
		<!-- /.row -->

		<!-- Question Details-->
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-1 text-right">
				<label><%=seqNo+ 1 %>.
				</label></div>
			<div class="col-md-9">
			<label><%=qdtls.getQuesName() %></label>
			</div>
			<div class="col-md-1">
			</div>
		</div>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-1 text-right"> 
				<label>
				<input type="radio" id="givenOp" name="givenOp" value="1">
				</label>
			</div>
			<div class="col-md-8 text-left">
				<label><%=qdtls.getQuesOpt1() %></label>
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-1 text-right"> 
				<label>
				<input type="radio" id="givenOp" name="givenOp" value="2">
				</label>
			</div>
			<div class="col-md-8 text-left">
				<label><%=qdtls.getQuesOpt2() %></label>
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-1 text-right"> 
				<label>
				<input type="radio" id="givenOp" name="givenOp" value="3">
				</label>
			</div>
			<div class="col-md-8 text-left">
				<label><%=qdtls.getQuesOpt3() %></label>
			</div>
			<div class="col-md-1"></div>
		</div>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-1 text-right"> 
				<label>
				<input type="radio" id="givenOp" name="givenOp" value="4">
				</label>
			</div>
			<div class="col-md-8 text-left">
				<label><%=qdtls.getQuesOpt4() %></label>
			</div>
			<div class="col-md-1"></div>
		</div>
		<!-- /.row -->
		<div class="row">
			<div class="col-md-12 text-center">
			&nbsp;
			</div>
			</div>
		<div class="row">
			<div class="col-md-12 text-center">
			<%if(seqNo==(question.size()-1)){ %>
			<input type="button" class="btn btn-primary" value="Submit Exam" id="focusEle"onclick="nextQues();"/>
			<%}else{ %>
			<input type="button" class="btn btn-primary" value="Next Question" id="focusEle" onclick="nextQues();"/>
			<%} %>
			</div>
		</div>
		<%}else{ %>
		
		<%if(alreadyGiven.equals("")) {%>
		<input type="hidden" id="examId" name="examId" value="<%=request.getAttribute("examId").toString()%>"/>
		<div class="row">
			<div class="col-md-12  text-success text-center">
			<h4>You have completed the Exam.</h4>
			</div>
			</div>
			
			<div class="row">
			<div class="col-md-12   text-center">
			&nbsp;</div>
			</div>
			<div class="row">
			<div class="col-md-12   text-center">
			<input type="button" class="btn btn-primary" value="See Results" onclick="seeResults();">
			</div>
			</div>
		<%} else if(alreadyGiven.equals("alreadyGiven")){ %>
		<div class="row">
			<div class="col-md-12  text-success text-center">
			<h4>You have Already given this Exam.</h4>
			</div>
			</div>
		<%} %>
		<%} %>
		<hr>
		<!-- Footer -->
		</form>
	</div>
	
	<!-- /.container -->

	<jsp:include page="common/footer.jsp"></jsp:include>



</body>
<script>
<%if(examCompleted.equals("")){ %>
var clock = new FlipClock($('#timer'), {
	clockFace: 'MinuteCounter'
	});
	clock.setCountdown(true);
	clock.setTime(<%=time/1000-1%>);
	<%}%>
</script>
</html>