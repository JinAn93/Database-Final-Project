<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<head>
<spring:url value="/resources/jquery-1.11.1/" var="jquery" />
<spring:url value="/resources/bootstrap/css" var="bootstrapCSS" />
<spring:url value="/resources/bootstrap/js" var="bootstrapJS" />
<link rel="stylesheet" href="${bootstrapCSS}/bootstrap.min.css" />
<link rel="stylesheet" href="${bootstrapCSS}/bootstrap-theme.min.css" />
<script src="${jquery}/jquery-1.11.1.min.js"></script>
<script src="${bootstrapJS}/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Form</title>
</head>

<style>
.error {
	color: #ff0000;
}

body {
	margin: auto;
	text-align: center;
	padding: 70px;
	font-family: Helvetica;
}

input {
	font-family: Helvetica;
}

h1 {
	text-align: center;
}
</style>

<body>
	<!-- navbar -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Dashboard</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="<c:url value='/dashboard' />">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- navbar end -->
	<div class="Instruction">
		<c:choose>
			<c:when test="${edit}">
				<h1>Modify Your Account!</h1>
			</c:when>
			<c:otherwise>
				<h1>Create Your Account!</h1>
			</c:otherwise>
		</c:choose>
	</div>

	<form:form method="POST" modelAttribute="user">
		<table class="userDetails" align="center">
			<tr>
				<td><label for="name">Name: </label></td>
				<td><form:input path="name" id="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="email">Email: </label></td>
				<td><form:input path="email" id="email" /></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="user_id">User ID: </label></td>
				<c:choose>
					<c:when test="${edit}">
						<td><form:input path="user_id" id="user_id" readonly="true" /></td>
					</c:when>
					<c:otherwise>
						<td><form:input path="user_id" id="user_id" /></td>
					</c:otherwise>
				</c:choose>				
				<td><form:errors path="user_id" cssClass="error" /></td>
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
	<br /> 
	Go back to <a href="login">Login Page</a>
</body>
</html>