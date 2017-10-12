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
<title>Post Creation</title>
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

tr {
	border: 1px solid black;
}

.postForm {
	margin-left: 300px;
	margin-right: 300px;
	width: 1000px; 
	height: 500px;
	text-align: center;
}

#title{
	height: 40px;
	width: 750px;
	padding: 30px;
}

#contents{
	height: 400px;
	width: 750px;
	padding: 30px;
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
	<form:form method="POST" modelAttribute="post" onkeypress="return entercheck(event)">
		<table class="postForm" >
			<tr>
				<td height="50" width="150"><label for="title">Title: </label></td>
				<td height="50" width="750"><form:input path="title" id="title"/></td>
				<td height="50" width="100"><form:errors path="title" cssClass="error" /></td>
			</tr>

			<tr>
				<td><label for="contents">Contents: </label></td>
				<td><form:textarea rows="60" cols="200" path="contents" id="contents"/></td>
				<td><form:errors path="contents" cssClass="error" /></td>
			</tr>

			<tr>
				<td><form:input path="user_id" type="hidden" value="<%=session.getAttribute(\"user_id\")%>" /></td>
			</tr>
		</table>

		<script>
			function entercheck(e){
				if(e.keyCode == 13){
					document.ge.getElementById('contents').innerHTML+="<br />";
					return false;
				}
				return true;
			}
		</script>
		<c:choose>
			<c:when test="${edit}">
				<input type="submit" value="Edit" />
			</c:when>
			<c:otherwise>
				<input type="submit" value="Create Post!" />
			</c:otherwise>
		</c:choose>
	</form:form>
	<br />
	<br /> Go back to
	<a href="dashboard">Dashboard</a>
</body>
</html>