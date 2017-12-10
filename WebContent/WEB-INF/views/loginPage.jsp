<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<head>
<spring:url value="/resources/jquery-1.11.1/" var="jquery" />
<spring:url value="/resources/bootstrap/css" var="bootstrapCSS" />
<spring:url value="/resources/bootstrap/js" var="bootstrapJS" />
<link rel="stylesheet" href="${bootstrapCSS}/bootstrap.min.css" />
<link rel="stylesheet" href="${bootstrapCSS}/bootstrap-theme.min.css" />
<script src="${jquery}/jquery-1.11.1.min.js"></script>
<script src="${bootstrapJS}/bootstrap.min.js"></script>



<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>
<title>Login Page</title>
</head>

<style>
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #eee;
}
.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}
.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}
.form-signin .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}
.form-signin .form-control:focus {
	z-index: 2;
}
.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
<body>

	<c:choose>
		<c:when test="${loggedinID == null}">
			<div class="container">
				<form:form class="form-signin" action="login" modelAttribute="user" method="POST">

					<h2 class="form-signin-heading">Dashboard Project</h2>
					<label for="userID" class="sr-only">User ID</label> 
					<form:input type="text" path="user_name" name="userID" class="form-control"
						placeholder="User ID"/> 
						
					<label for="password" class="sr-only">Password</label> 
					<form:input type="password" path="password" name="password" class="form-control" 
						placeholder="Password" />
						
					<button type="submit">Login</button>

				</form:form>
				
				<a href="registration">Sign Up</a>
			</div>
		</c:when>
		<c:otherwise>
			<%
				response.sendRedirect("http://localhost:8080/Basic-Dashboard-Project/dashboard");
			%>
		</c:otherwise>
	</c:choose>

</body>