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

<title>Edit Exam</title>
<script type="text/javascript">
	function verify() {
		validateEditExam();
		if (confirm('Are you Sure You Want to Edit This Exam?')) {
			var editexam = document.getElementById("editexam");
			editexam.action = "main";
			editexam.method = "post";
			editexam.submit();
		}
	}

	function cancelF() {
		if (confirm('Are you Sure You Want to Cancel?')) {
		document.getElementById("classId").value="11";
		document.getElementById("actionName").value="viewExams";
			var editexam = document.getElementById("editexam");
			editexam.action = "main";
			editexam.method = "post";
			editexam.submit();
		}
	}
	
	function validateEditExam() {
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
	String EditMessage = request.getAttribute("editMessage") != null ? request
			.getAttribute("editMessage").toString() : "";
	ExamDtls examDtls =  request.getAttribute("examDtls") != null ? (ExamDtls)request
			.getAttribute("examDtls") : null;
%>
</head>
<body>
	<jsp:include page="common/header.jsp"></jsp:include>
	<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header text-center">
					Edit Exam : <%=examDtls.getExamName()%>
				</h1>
			</div>
		</div>
	<form id="editexam" class="form-horizontal" data-toggle="validator">
		<input type="hidden" name="actionName" id="actionName"
			value="updateExam" />
			 <input type="hidden" name="classId" id="classId"
			value="11" />
			<input type="hidden" name="examId" id="examId"
			value="<%=examDtls.getExamId() %>" />
		<div class="form-group">
			<label for="inputExamName" class="col-sm-2 control-label">Exam
				Name:</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" name="examName"
					id="examName" value="<%=examDtls.getExamName()%>"/><br>
			</div>
		</div>
		<div class="form-group">
			<label for="inputExamDesc" class="col-sm-2 control-label">Exam
				Description:</label>
			<div class="col-sm-5">
				<textarea rows="3" name="examDescription" id="examDescription"
					class="form-control" ><%=examDtls.getExamDescr()%></textarea>
				<br>
			</div>
		</div>
		<div class="form-group">
			<label for="inputCutoff" class="col-sm-2 control-label">Cut
				Off:</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" name="cutoff" id="cutoff" value="<%=examDtls.getcutoff()%>" /><br>
			</div>
		</div>
		<div class="form-group">
			<label for="inputCutoff" class="col-sm-2 control-label">No of Questions per Exam</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" name="noOfQues" id="noOfQues" value="<%=examDtls.getNoOfQuestion()%>"/><br>
			</div>
		</div>
		<div class="form-group">
			<label for="inputCertificationName" class="col-sm-2 control-label">Certification
				name:</label>
			<div class="col-sm-5">
				<input type="text" name="certificateName" class="form-control"
					id="certificateName" value="<%=examDtls.getcertificateName()%>" /><br>
			</div>
		</div>
		<div class=" text-center">
			<input type="button" value="Save" class="btn btn-primary"
				onclick="verify();" /> <input type="button" class="btn btn-default"
				value="Cancel" onclick="cancelF();">
		</div>
		<br> <br> <br>
	</form>

</body>
<%
examDtls = null;
	if (!EditMessage.equals("")) {
%>
<script>alert("Exam has been edited Successfully");</script>
<%} %>
<jsp:include page="common/footer.jsp"></jsp:include>
</html>