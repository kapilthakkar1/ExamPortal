<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page import="com.ssdi.tables.UserDtls" %>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="bootstrap/jquery-1.11.2.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
<% UserDtls userdtls = request.getSession().getAttribute("userDtls")!=null?
		(UserDtls)request.getSession().getAttribute("userDtls"):null;
long role=userdtls.getRole();
String isFirst = request.getAttribute("isFirst")!=null? request.getAttribute("isFirst").toString():"";
%>
<title>Exam Portal</title>

<script>
function logoutFunc()
{
	if(document.forms[0])
		{
			//alert("forms exist");
			var url = "main?classId=3&actionName=logout";
			document.forms[0].action=url;
			document.forms[0].method = "post";
			document.forms[0].submit();
		}
	else
		{
		//alert("no form");
		var f = document.createElement("form");
		f.setAttribute('method',"post");
		f.setAttribute('action',"main?classId=3&actionName=logout");
		document.getElementsByTagName('body')[0].appendChild(f);
		document.forms[0].submit();
		}
}

function homeFunc()
{
	if(document.forms[0])
		{
			//alert("forms exist");
			var url = "main?classId=3&actionName=home";
			document.forms[0].action=url;
			document.forms[0].method = "post";
			document.forms[0].submit();
		}
	else
		{
		//alert("no form");
		var f = document.createElement("form");
		f.setAttribute('method',"post");
		f.setAttribute('action',"main?classId=3&actionName=home");
		document.getElementsByTagName('body')[0].appendChild(f);
		document.forms[0].submit();
		}
}

function redirectToPage(url)
{
	if(document.forms[0])
		{
			//alert("forms exist");
			document.forms[0].action=url;
			document.forms[0].method = "post";
			document.forms[0].submit();
		}
	else
		{
		//alert("no form");
		var f = document.createElement("form");
		f.setAttribute('method',"post");
		f.setAttribute('action',url);
		document.getElementsByTagName('body')[0].appendChild(f);
		document.forms[0].submit();
		}
}
</script>

<style>
.navbar{
background-color: #3366FF;
color: #FFFFFF;
border-radius: 0px;
}
.navbar:a{
color: #FFFFFF;
}
.color-white
{
color: #FFFFFF;
}
.navbar-brand
{
font-size: 25px;
font-weight: 250;
}
.header-btn .icon-bar{
    background:#FFF;
}
</style>
</head>
<body>
	 <nav class="navbar navbar-static">
   <div class="container">
    <div class="navbar-header">
     <button type="button" class="navbar-toggle header-btn" data-toggle="collapse" data-target="#myNavbar" value="Menu">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand color-white" href="#" onclick="homeFunc();"><b>Exam Portal</b></a>
    </div>
      <div class="navbar-collapse collapse" id="myNavbar">
        <ul class="nav navbar-nav ">  
        <%if(role==1) {%>
          <li><a href="#" onclick="redirectToPage('main?classId=4&actionName=exams')"
          class="color-white">View/Take Exams</a></li>
          <li><a href="#" onclick="redirectToPage('main?classId=8&actionName=exams')"
          class="color-white">View Certificates</a></li>
          <%} %>
          <%if(role==2){ %>
           <li><a href="#" onclick="redirectToPage('main?classId=7&actionName=displayExam')"
          class="color-white">Create an Exam</a></li>
          <li><a href="#" onclick="redirectToPage('main?classId=11&actionName=viewExams')"
          class="color-white">View/Edit Exams</a></li>
           <li><a href="#" onclick="redirectToPage('main?classId=10&actionName=viewExams')"
          class="color-white">Add/Edit Question</a></li>
          <%} %>
          
        </ul>
        <ul class="nav navbar-right navbar-nav ">
          <li class="dropdown color-white">
            <a href="#" class="dropdown-toggle color-white" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i> <i class="glyphicon glyphicon-chevron-down"></i></a>
            <ul class="dropdown-menu">
              <li><a href="#" onclick="alert('The Profile Feature will be available in near future.');">Profile</a></li>
              <li class="divider"></li>
              <li><a href="#"  onclick="logoutFunc();">Log Out</a></li>
             </ul>
          </li>
        </ul>
      </div>
    </div>
</nav>

</body>

</html>