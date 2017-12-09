<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<head>
<%-- <spring:url value="/resources/jquery-1.11.1/" var="jquery" />
<spring:url value="/resources/bootstrap/css" var="bootstrapCSS" />
<spring:url value="/resources/bootstrap/js" var="bootstrapJS" />
<link rel="stylesheet" href="${bootstrapCSS}/bootstrap.min.css" />
<link rel="stylesheet" href="${bootstrapCSS}/bootstrap-theme.min.css" /> --%>

 <!-- Bootstrap core CSS-->
  <spring:url value="/resources/vendor" var="vendor" />
  <spring:url value="/resources/css" var="css" />
  <spring:url value="/resources/js" var ="js" />
  <link href="${vendor}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="${vendor}/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="${vendor}/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="${css}/sb-admin.css" rel="stylesheet">

<title>Account Form</title>
</head>

<style>
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #eee;
}

.form-signup {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signup .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signup .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}

.form-signup .form-control:focus {
	z-index: 2;
}

.form-signup input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signup input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>

<body>
	<!-- navbar -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
			 	<!-- <button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button> -->
				<p></p>
				<a class="navbar-brand" href="login">Home</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<ul class="active"><a href="<c:url value='/dashboard' />">Dashboard</a></ul>
				</ul>
			</div>
		</div>
	</nav>
	<!-- navbar end -->



<%-- <td><label for="first_name">First Name: </label></td>
<td><form:input path="first_name" id="first_name" /></td>
<td><form:errors path="first_name" cssClass="error" /></td> --%>

<c:choose>
		<c:when test="${loggedinID == null}">
			<div class="container">
				<form class="form-signup" action="validate" method="get">
					<label for="first_name"> First Name</label> 
					<input type="text" name="first_name" class="form-control"
						placeholder="First Name" required autofocus> 
					<form:errors path="first_name" cssClass="error" />
					<p></p>		
					<label for="last_name">Last Name</label> 
					<input type="text" name="last_name" class="form-control"
						placeholder="Last Name" required autofocus> 
					<p></p>	
					<label for="userID">User ID</label> 
					<input type="text" name="userID" class="form-control"
						placeholder="User ID" required autofocus> 
					<p></p>
					<label for="email">Email</label> 
					<input type="text" name="email" class="form-control"
						placeholder="Email" required autofocus> 
					<p></p>
							
					<label for="password">Password</label> 
					<input type="password" name="password" class="form-control" 
						placeholder="Password" required>
					<p></p>	
					<label for="confirmpassword">Confirm Password</label> 
					<input type="confirmpassword" name="confirmpassword" class="form-control" 
						placeholder="Confirm Password" required>
					<p></p>
					<input class="btn btn-lg btn-primary btn-block" name="btnLogin"
						type="submit" value="Sign Up"> 
				</form>
			</div>
		</c:when>
		<c:otherwise>
			<%
				response.sendRedirect("http://localhost:8080/Database-Final-Project/dashboard");
			%>
		</c:otherwise>
	</c:choose>



<%-- 	<div class="Instruction">
		<c:choose>
			<c:when test="${edit}">
				<h1>Modify Your Account</h1>
			</c:when>
			<c:otherwise>
				<h1>Create Your Account</h1>
			</c:otherwise>
		</c:choose>
	</div>

	<form:form method="POST" modelAttribute="user">
		<table class="userDetails" align="center">
			<tr>
				<td><label for="first_name">First Name: </label></td>
				<td><form:input path="first_name" id="first_name" /></td>
				<td><form:errors path="first_name" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="last_name">Last Name: </label></td>
				<td><form:input path="last_name" id="last_name" /></td>
				<td><form:errors path="last_name" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="email">Email: </label></td>
				<td><form:input path="email" id="email" /></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="user_name">User ID: </label></td>
				<c:choose>
					<c:when test="${edit}">
						<td><form:input path="user_name" id="user_name" readonly="true" /></td>
					</c:when>
					<c:otherwise>
						<td><form:input path="user_name" id="user_name" /></td>
					</c:otherwise>
				</c:choose>				
				<td><form:errors path="user_name" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="password">Password: </label>
				<td><form:input type="password" path="password" id="password" /></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Update" />
						</c:when>
						<c:otherwise>
							<input type="submit" value="Register" />
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form:form>
	<br />
	<br />  --%>
	
	<p></p>
	<p></p>
	Go back to <a href="login">Login Page</a>
</body>
</html>