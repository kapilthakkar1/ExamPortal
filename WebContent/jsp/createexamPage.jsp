<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, com.ssdi.tables.ExamDtls"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<%--String str1 = request.getAttribute("StringTest"); --%>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="bootstrap/jquery-1.11.2.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="ui/jquery-ui.min.js"></script>
<script src="js/md5.js"></script>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="ui/jquery-ui.min.css">


<title>Create Exam</title>
<script type="text/javascript">
	function verify() {
		validateCreateExam();
		if (confirm('Are you Sure You Want to Create This Exam?')) {
			var createexam = document.getElementById("createexam");
			createexam.action = "main";
			createexam.method = "post";
			createexam.submit();
		}
	}

	function validateCreateExam() {
		var retVal = false;
		var regex = /^[0-9]*$/;
		var cuttOffP = document.getElementById('cutoff').value;
		var noOfQuesP = document.getElementById('noOfQues').value;
		
		if (document.getElementById('examName').value == '') {
			alert('Please Enter ExamName.');
			document.getElementById('examName').focus();
			return retval;
		} else if (document.getElementById('examDescription').value == '') {
			alert('Please Enter Exam Description.');
			document.getElementById('examDescription').focus();
			return retval;
		} else if (document.getElementById('cutoff').value == '') {
			alert('Please Enter Cutoff Percentage.');
			document.getElementById('cutoff').focus();
			return retval;
		}
		
		else if (!regex.test(noOfQuesP) || parseInt(noOfQuesP) > 1000
				|| parseInt(noOfQuesP) < 1) {
			alert('No of Questions per Exam Should be number between 1 to 1000.');
			document.getElementById('noOfQues').value = "";
			document.getElementById('noOfQues').focus();
			return retval;
		} 
		else if (!regex.test(cuttOffP) || parseInt(cuttOffP) > 100
				|| parseInt(cuttOffP) < 1) {
			alert('Cutoff Percentage Should be number between 1 to 100.');
			document.getElementById('cutoff').value = "";
			document.getElementById('cutoff').focus();
			return retval;
		} else if (document.getElementById('certificateName').value == '') {
			alert('Please Enter Certification Name.');
			document.getElementById('certificateName').focus();
			return retval;
		}
		return true;
	}
</script>
<%
	String creationMessage = request.getAttribute("creationMessage") != null ? request
			.getAttribute("creationMessage").toString() : "";
%>
</head>
<body>
	<jsp:include page="common/header.jsp"></jsp:include>
	<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header text-center">
					Create Exam
				</h1>
			</div>
		</div>
	<form id="createexam" class="form-horizontal" data-toggle="validator">
		<input type="hidden" name="actionName" id="actionName"
			value="createexam" /> <input type="hidden" name="classId"
			id="classId" value="7" />
		<div class="form-group">
			<label for="inputExamName" class="col-sm-2 control-label">Exam
				Name:</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" name="examName"
					id="examName" /><br>
			</div>
		</div>
		<div class="form-group">
			<label for="inputExamDesc" class="col-sm-2 control-label">Exam
				Description:</label>
			<div class="col-sm-5">
				<textarea rows="3" name="examDescription" id="examDescription"
					class="form-control"></textarea>
				<br>
			</div>
		</div>
		<div class="form-group">
			<label for="inputCutoff" class="col-sm-2 control-label">Cut
				Off:</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" name="cutoff" id="cutoff" /><br>
			</div>
		</div>
		<div class="form-group">
			<label for="inputCutoff" class="col-sm-2 control-label">No of Questions per Exam</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" name="noOfQues" id="noOfQues" /><br>
			</div>
		</div>
		<div class="form-group">
			<label for="inputCertificationName" class="col-sm-2 control-label">Certification
				name:</label>
			<div class="col-sm-5">
				<input type="text" name="certificateName" class="form-control"
					id="certificateName" /><br>
			</div>
		</div>
		<div class=" text-center">
			<input type="button" value="Save" class="btn btn-primary"
				onclick="verify();" /> <input type="reset" class="btn btn-default"
				value="Reset">
		</div>
		<br> <br> <br>
	</form>

</body>
<%
	if (!creationMessage.equals("")) {
%>
<script>alert("Exam has been Created Successfully");</script>
<%} %>
<jsp:include page="common/footer.jsp"></jsp:include>
</html>