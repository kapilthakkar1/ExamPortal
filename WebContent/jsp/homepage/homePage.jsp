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
<script src="ui/jquery-ui.min.js"></script>
<script src="js/md5.js"></script>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="ui/jquery-ui.min.css">
	

<title>Exam Portal</title>
<style>
.bc-color {
	background: #3366FF
}

.bc-font-color {
	color: #FFFFFF;
}

.hp-href {
	background: #FFFFFF;
	color: #3366FF;
	border-color: #FFFFFF;
	font-weight: 400;
	font-size: 30px;
	font-family: "Browallia New";
}

.hp-href:hover {
	background: #EBCCFF;
	color: #FFFFFF;
	border-color: #3366FF;
}

.all-font {
	color: #3366FF;
}

.bp-bc {
	min-height: 590px;
	background: url("images/homepage/home.jpg") no-repeat scroll center
		center/cover transparent;
	padding: 0px;
	background-repeat: no-repeat;
	text-shadow: 0px 1px 1px rgba(0, 0, 0, 0.1);
	font-weight: 500;
	border: 0px solid #CCC;
}

.overlay {
	padding-top: 90px;
	background-color: rgba(51, 102, 255, 0.75);
	min-height: 600px;
	color: #FFF;
}

#mainDesign h1 {
	padding-top: 80px;
	font-weight: 900;
	font-size: 100px;
	font-family: "Browallia New";
}

#mainDesign h4 {
	font-weight: 500;
	font-size: 35px;
	font-family: "Browallia New";
}

#mainContainer1 {
	opacity: 0.1;
	-webkit-transition: opacity 0.15s linear;
	-moz-transition: opacity 0.15s linear;
	-o-transition: opacity 0.15s linear;
	transition: opacity 0.15s linear;
}
</style>
<script type="text/javascript">
function loginFunc() {
	if(validateLogin())
		{
			document.getElementById("actionName").value = "login";
			document.getElementById("classId").value = "3";
			document.getElementById("encPwd").value = 
				CryptoJS.MD5(document.getElementById("pwd").value);
			var loginFom = document.getElementById("loginFom");
			loginFom.action = "main";
			loginFom.method = "post";
			loginFom.submit();
		}
}
function signUpFunc() {
	if(validateSignUp())
		{
		document.getElementById("actionName2").value = "signup";
		document.getElementById("classId2").value = "5";
		document.getElementById("encPwd2").value = 
			CryptoJS.MD5(document.getElementById("pwdS").value);
		var SignUpFom = document.getElementById("SignUpFom");
		SignUpFom.action = "main";
		SignUpFom.method = "post";
		SignUpFom.submit();
		}
}

function validateSignUp()
{
	var retVal = false;
	if(document.getElementById('emailS').value=='')
		{
		alert('Please Enter Email.');
		return retval;
		}
	if(!IsEmail(document.getElementById('emailS').value))
		{
		alert('Please Enter a Valid Email.');
		document.getElementById('emailS').value='';
		document.getElementById('emailS').focus();
		return retval;
		}
	if(document.getElementById('DOB').value=='')
	{
	alert('Please Enter DOB.');
	return retval;
	}
	if(document.getElementById('pwdS').value=='')
	{
	alert('Please Enter a Password.');
	return retval;
	}
	if(document.getElementById('confpwd').value=='')
	{
	alert('Please Confirm Password.');
	return retval;
	}
	if(document.getElementById('confpwd').value!=document.getElementById('pwdS').value)
		{
		alert('Passwords Do Not Match.');
		return retval;
		}
	return true;
}

function IsEmail(email) {
	  var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	  return regex.test(email);
	}
function checkEmail() {
     if(document.getElementById('emailS').value!='')
     	{
     (function ($) {
      
        $.post("main",
	   	 {
	        classId: "5",
	        actionName: "checkEmail",
	        ajax:"true",
	        emailS: document.getElementById('emailS').value
	    },
	    function(data, status){
    	if(document.getElementById('emailS').value == data + '')
    		{
    		alert('The Email is Already Regsitered. Please select a different Email.');
    		document.getElementById('emailS').value ='';
    		$('#DOB').trigger('blur');
    		document.getElementById('emailS').focus();
    		}
   });
     })(jQuery);
 }
}

function runScript(e)
{
	 if (e.keyCode == 13) {
		 loginFunc();
	 }
}
function runScript2(e)
{
	 if (e.keyCode == 13) {
		 document.getElementById('pwd').focus();
	 }
}
function validateLogin()
{
	if(document.getElementById('email').value =='')
		{
		alert('Please Enter Email.');
		document.getElementById('email').focus();
		return false;
		}
	else if(document.getElementById('pwd').value =='')
	{
		alert('Please Enter Password.');
		document.getElementById('pwd').focus();
	return false;
	}
return true;	 
	}

</script>
<%String homeMessage = request.getAttribute("homeMessage")!=null?
		 request.getAttribute("homeMessage").toString():"";%>
</head>
<body>


	<div id="mainContainer" class="container-full">
		<div class="modal fade" id="basicModal" tabindex="-1" role="dialog"
			aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog" style="width:25%">
				<div class="modal-content">
				<form id="loginFom">
			<input type="hidden" name="actionName" id="actionName" value="" />
			<input	type="hidden" name="classId" id="classId" value="" />
			<input	type="hidden" name="encPwd" id="encPwd" value="" />
		
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">X</button>
						<h4 class="modal-title" id="myModalLabel">Login</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="email">UserName:</label> 
							 <input type="email"	class="form-control" id="email" name="email" value="" onkeyup="runScript2(event)">
						</div>
						<div class="form-group">
							<label for="pwd">Password:</label> <input type="password"
								class="form-control" id="pwd" name="pwd" value="" onkeyup="runScript(event)">
						
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary" onclick="loginFunc();">Login</button>
					</div>
					</form>
				</div>
			</div>
		</div>
		
		
		
		
		
		
		
		
		<div class="modal fade" id="SignupModal" tabindex="-1" role="dialog"
			aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog" style="width:25%">
				<div class="modal-content">
				<form id="SignUpFom">
			<input	type="hidden" name="encPwd2" id="encPwd2" value="" />
			<input type="hidden" name="actionName" id="actionName2" value="" />
			<input	type="hidden" name="classId" id="classId2" value="" />
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">X</button>
						<h4 class="modal-title" id="myModalLabel">SignUp</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label for="email">Email:</label> 
							 <input type="text"	class="form-control" id="emailS" name="emailS" onblur="checkEmail()">
						</div>
						<div class="form-group">
							<label for="DOB">DOB:</label> 
							 <input type="text"	 data-provide="datepicker" class="form-control" id="DOB" name="DOB" >
						</div>
						<div class="form-group">
							<label for="pwd">Password:</label> <input type="password"
								class="form-control" id="pwdS" name="pwdS">
						</div>
					
					<div class="form-group">
							<label for="pwd">Confirm Password:</label> <input type="password"
								class="form-control" id="confpwd" name="confpwd">
						</div>
						</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary" onclick="signUpFunc();">Signup</button>
					</div>
					</form>
				</div>
			</div>
		</div>
		
		
		
		
		
		
		
		
		
		
		
		<!-- 

		<div class="jumbotron bg-primary bc-color bc-font-color">
			<div class="row">
				<div class="col-md-9"></div>
				<div class="col-md-1">
					<a href="#" class="btn btn-info btn-lg hp-href">Login</a>
				</div>
				<div class="col-md-2">
					<a href="#" class="btn btn-info btn-lg hp-href">Signup</a>
				</div>
			</div>
			<h1>Exam Portal</h1>
		</div>
		 -->
		<div class="row">
			<div class="col-md-12 all-font ">
				<div class="bp-bc ">
					<div class="overlay" id="mainDesign">
						<div class="col-md-8 col-md-offset-2 text-center">
							<h1>Exam Portal</h1>
							<h4>
								<p></p>
								<p></p>
								<p></p>
								<p>&nbsp;&nbsp;&nbsp;&nbsp;Exam Portal is the your path to
									success. With thousands on online certificates available for a
									minimal fee, Exam Portal is the complete solution to online
									cretifcation. Signup Today!!!</p>
								<a href="#" class="btn btn-info btn-lg hp-href"
									data-toggle="modal" data-target="#basicModal">Login</a> <a
									href="#" class="btn btn-info btn-lg hp-href"
									data-toggle="modal" data-target="#SignupModal">Signup</a>
							</h4>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">

				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
						<li data-target="#myCarousel" data-slide-to="3"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="images/homepage/avail.jpg" alt="Chania">
							<div class="carousel-caption all-font">
								<h3>Availability</h3>
								<p>You can take up exams from Any Place at Any Time on Exam
									Portal</p>
							</div>
						</div>

						<div class="item">
							<img src="images/homepage/reliable.jpg" alt="Chania">
							<div class="carousel-caption all-font">
								<h3>Reliability</h3>
								<p>Exam Portal is one of the most reliable things you will
									find in Life..! So take any exam without any glicthes.</p>
							</div>
						</div>

						<div class="item">
							<img src="images/homepage/easy.jpg" alt="Flower">
							<div class="carousel-caption all-font">
								<h3>Easy</h3>
								<p>Exam Portal is the really easy to use. We believe
									simplicity is the best way to go.</p>
							</div>
						</div>

						<div class="item">
							<img src="images/homepage/trust.jpg" alt="Flower">
							<div class="carousel-caption all-font">
								<h3>Trust</h3>
								<p>All the certifications on Exam Portal are trusted by
									companies all over the world</p>
							</div>
						</div>
					</div>

					<!-- Left and right controls -->
					<a class="left carousel-control " href="#myCarousel" role="button"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control " href="#myCarousel"
						role="button" data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>


			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron bc-color bc-font-color">
					<div class="col-md-6  bc-font-color text-left">Copy Right
						SSDI Group 3 @ 2015</div>
					<div class="col-md-6  bc-font-color text-right">Last Updated
						29th March 2015</div>

				</div>
			</div>
		</div>

	</div>
</body>
<script>

    $('#DOB').datepicker({ defaultDate: '01/01/1990' });
</script>
<%if(!homeMessage.equals("")){ %>
<script>alert('<%=homeMessage%>')</script>
<%} %>
</html>