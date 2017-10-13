<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Dashboard</title>
</head>

<style>
body {
	padding-top: 70px;
	padding-bottom: 30px;
}

.theme-dropdown .dropdown-menu {
	position: static;
	display: block;
	margin-bottom: 20px;
}

.theme-showcase>p>.btn {
	margin: 5px 0;
}

.theme-showcase .navbar .container {
	width: auto;
}

.thead-inverse th {
	color: #fff;
	background-color: #373a3c;
}

.input-group {
	z-index: 2;
	width: 50%;
	margin-bottom: 10px;
	margin-left: 880px;
}
</style>

<!--
change button color to black
.btn-primary {
	background-image: linear-gradient(#484e55, #3a3f44 60%, #313539);
}
-->

<body>
	<%
		String loggedinID = (String) session.getAttribute("user_id");
		request.setAttribute("loggedinID", loggedinID);
	%>
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
					<li class="active"><a href="#">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- navbar end -->
	<div class="container">
		<!-- jumbotron for a primary marketing message or call to action -->
		<div class="jumbotron">
			<h1>
				Welcome <%=loggedinID%>!
			</h1>
			<p>Contact xxx-xxx-xxxx for issue</p>
		</div>
		<!-- jumbotron end -->
		<div class="page-header">
			<h1>Posts</h1>
		</div>
	
		<div class="row">
			<div class="col-lg-6">
				<div class="input-group">
					<input type="text" class="form-control"
						placeholder="Search Title..."> <span
						class="input-group-btn">
						<button class="btn btn-default" type="button">Search!</button>
					</span>
				</div>
			</div>
			<!-- table -->
			<table class="table table-striped">
				<thead class="thead-inverse">
					<tr>
						<th>Title</th>
						<th>Post date</th>
						<th>User Id</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${posts}" var="post">
						<tr>
							<td><a href="<c:url value='/view-${post.id}-post' />">${post.title}</a></td>
							<td>${post.post_date}</td>
							<td>${post.user_id}</td>
							<c:choose>
								<c:when test="${loggedinID == post.user_id}">
									<td><a class="btn btn-primary" href="<c:url value='/edit-${post.id}-post' />"><span
								class="glyphicon glyphicon-envelope" aria-hidden="true"></span><span class="glyphicon-class">Edit</span></a>
										<a class="btn btn-primary" href="<c:url value='/delete-${post.id}-post' />"><span
								class="glyphicon glyphicon-envelope" aria-hidden="true"></span><span class="glyphicon-class">Delete</span></a>
										
									</td>
								</c:when>
								<c:otherwise>
									<td>N/A</td>
								</c:otherwise>
							</c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<!-- table end -->
		</div>
	
	
	
		<div id="action" align="center">
			<a class="btn btn-lg btn-primary" href="newPost"><span
				class="glyphicon glyphicon-plus" aria-hidden="true"></span> <span
				class="glyphicon-class">Create a new post</span></a> <a
				class="btn btn-lg btn-primary"
				href=<c:url value='/edit-${loggedinID}-user' />><span
				class="glyphicon glyphicon-pencil" aria-hidden="true"></span> <span
				class="glyphicon-class">Edit Account</span></a> <a
				class="btn btn-lg btn-primary" href="logout"><span
				class="glyphicon glyphicon-off" aria-hidden="true"></span> <span
				class="glyphicon-class">Logout</span></a>
		</div>	
	</div>
</body>
</html>