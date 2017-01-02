<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%--String str1 = request.getAttribute("StringTest"); --%>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="bootstrap/jquery-1.11.2.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script>
function goToAddQuestion()
{
	if(validateQuestion())
		{
	document.forms[0].action="main";
	document.forms[0].method = "post";
	document.forms[0].submit();
		}
}
function goToBack()
{
	if(confirm('Are you Sure You want to Cancel?'))
		{
	document.getElementById('classId').value = "10";
	document.getElementById('actionName').value = "viewExams";
	document.forms[0].action="main";
	document.forms[0].method = "post";
	document.forms[0].submit();
		}
}
function validateQuestion()
{
	var regex = /^[0-9]*$/;
	var timeVal = document.getElementById('time').value;
	if(document.getElementById('question').value=='')
		{
		alert('Please enter a Question.');
		return false;
		}
	else if(document.getElementById('Option1').value=='')
	{
	alert('Please enter a Option A.');
	return false;
	}
	else if(document.getElementById('Option2').value=='')
	{
	alert('Please enter a Option B.');
	return false;
	}
	else if(document.getElementById('Option3').value=='')
	{
	alert('Please enter a Option C.');
	return false;
	}
	else if(document.getElementById('Option4').value=='')
	{
	alert('Please enter a Option D.');
	return false;
	}
	else if(document.getElementById('time').value=='')
	{
	alert('Please enter time.');
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
	else if(!(document.getElementById('answer1').checked||
			document.getElementById('answer2').checked ||
			document.getElementById('answer3').checked ||
			document.getElementById('answer4').checked 
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
String examId = request.getAttribute("examId") != null ?  request
		.getAttribute("examId").toString() : "";
String examName = request.getAttribute("examName") != null ?  request
				.getAttribute("examName").toString() : "";
String successMsg = request.getAttribute("SuccessMsg") != null ?  request
						.getAttribute("SuccessMsg").toString() : "";
				
				
%>
</head>
<body>

	<jsp:include page="common/header.jsp"></jsp:include>


	<!-- Page Content -->
	<div class="container-full">
<form >
<input type="hidden" name="actionName" id="actionName" value="saveQuestion" />
<input type="hidden" name="classId"   id="classId" value="10" />
<input type="hidden" name="examId"   id="examId" value="<%=examId %>" />
<input type="hidden" name="examName"   id="examName" value="<%=examName %>" />



                <div class="row">
			<div class="col-md-12">
				<h1 class="page-header text-center">
		 Add Questions To <%=examName %>			
				</h1>
			</div>
		</div>
        <div class="row">
         <div class="col-md-1"></div>
           <div class="col-md-2"><label>Write a new question:</label> </div>
           <div class="col-md-8"><textarea rows="1"  class="form-control" name="question" id="question"></textarea></div>
            <div class="col-md-1"></div>
        </div>
        <br>
        <br>
        <div class="row">
        <div class="col-md-1"></div>
           <div class="col-md-2  text-right"><label>A.</label></div>
           <div class="col-md-8"><input type="text"  class="form-control" name="Option1" id ="Option1"></div>
           <div class="col-md-1"></div>
        </div>
        <br>
         <div class="row">
         <div class="col-md-1"></div>
           <div class="col-md-2  text-right"><label>B.</label></div>
           <div class="col-md-8"><input type="text"  class="form-control" name="Option2" id ="Option2"></div>
           <div class="col-md-1"></div>
         </div>
        <br>
         <div class="row">
         <div class="col-md-1"></div>
           <div class="col-md-2  text-right"><label>C.</label></div>
           <div class="col-md-8"><input type="text"  class="form-control" name="Option3" id ="Option3"></div>
           <div class="col-md-1"></div>
         </div>
        <br>
         <div class="row">
         <div class="col-md-1"></div>
           <div class="col-md-2 text-right"><label>D.</label></div>
           <div class="col-md-8"><input type="text" class="form-control" name="Option4" id ="Option4"></div>
           <div class="col-md-1"></div>
         </div>
         <br>
         <div class="row">
         <div class="col-md-1"></div>
           <div class="col-md-2 text-right"><label>Time in Seconds</label></div>
           <div class="col-md-8"><input type="text" class="form-control" name="time" id ="time"></div>
           <div class="col-md-1"></div>
         </div>
        
          <br>
        <div class="row">
        <div class="col-md-1"></div>
           <div class="col-md-2"> <label> Choose correct option</label> </div>
           <div class="col-md-1 text-center">
           <input type="radio" name="answer"  id="answer1" value="1"  class="form-control"><label class="form-control">&nbsp;A </label>
           </div><div class="col-md-1 text-center">
           <input type="radio" name="answer" id="answer2" value="2"  class="form-control"><label class="form-control">&nbsp;B </label>
           </div><div class="col-md-1 text-center">
           <input type="radio" name="answer" id="answer3" value="3"  class="form-control"><label class="form-control">&nbsp;C </label>
           </div><div class="col-md-1 text-center">
           <input type="radio" name="answer" id="answer4" value="4"  class="form-control"><label class="form-control">&nbsp;D </label>
           </div>
        <div class="col-md-1"></div>
	</div>
		</form>
	</div>
	<div class="row">
        <div class="col-md-12 text-center">
        <input type="button" class="btn btn-primary" onclick="goToAddQuestion();" value="Add Question">
        <input type="button" class="btn btn-default" onclick="goToBack();" value="Cancel"></div>
        </div>

<br>
<br>
	<jsp:include page="common/footer.jsp"></jsp:include>




</body>
<%if(!successMsg.equals(""))
	{%>
<script>alert('<%=successMsg%>');</script>	
	<%}%>
</html>