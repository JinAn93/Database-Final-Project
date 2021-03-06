<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>SB Admin - Start Bootstrap Template</title>
<!-- Bootstrap core CSS-->
<spring:url value="/resources/vendor" var="vendor" />
<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/js" var="js" />
<link href="${vendor}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom fonts for this template-->
<link href="${vendor}/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<link href="${vendor}/datatables/dataTables.bootstrap4.css"
	rel="stylesheet">
<!-- Custom styles for this template-->
<link href="${css}/sb-admin.css" rel="stylesheet">
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<!-- Navigation-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
		id="mainNav">
		<a class="navbar-brand" href="index.html">Recruit Monster</a>
		<button class="navbar-toggler navbar-toggler-right" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="Dashboard"><a class="nav-link" href="dashboard"> <i
						class="fa fa-fw fa-dashboard"></i> <span class="nav-link-text">Dashboard</span>
				</a></li>
				<li class="nav-item" data-toggle="tooltip" data-placement="right"
					title="profile"><a class="nav-link" href="profile"> <i
						class="fa fa-fw fa-area-chart"></i> <span class="nav-link-text">My
							Profile</span>
				</a></li>
			</ul>
			<ul class="navbar-nav sidenav-toggler">
				<li class="nav-item"><a class="nav-link text-center"
					id="sidenavToggler"> <i class="fa fa-fw fa-angle-left"></i>
				</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle mr-lg-2" id="messagesDropdown"
					href="#" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i class="fa fa-fw fa-envelope"></i> <span
						class="d-lg-none">Messages <span
							class="badge badge-pill badge-primary">12 New</span>
					</span> <span class="indicator text-primary d-none d-lg-block"> <i
							class="fa fa-fw fa-circle"></i>
					</span>
				</a>
					<div class="dropdown-menu" aria-labelledby="messagesDropdown">
						<h6 class="dropdown-header">New Messages:</h6>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#"> <strong>David
								Miller</strong> <span class="small float-right text-muted">11:21
								AM</span>
							<div class="dropdown-message small">Hey there! This new
								version of SB Admin is pretty awesome! These messages clip off
								when they reach the end of the box so they don't overflow over
								to the sides!</div>
						</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#"> <strong>Jane Smith</strong>
							<span class="small float-right text-muted">11:21 AM</span>
							<div class="dropdown-message small">I was wondering if you
								could meet for an appointment at 3:00 instead of 4:00. Thanks!</div>
						</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#"> <strong>John Doe</strong> <span
							class="small float-right text-muted">11:21 AM</span>
							<div class="dropdown-message small">I've sent the final
								files over to you for review. When you're able to sign off of
								them let me know and we can discuss distribution.</div>
						</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item small" href="#">View all messages</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle mr-lg-2" id="alertsDropdown"
					href="#" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> <i class="fa fa-fw fa-bell"></i> <span
						class="d-lg-none">Alerts <span
							class="badge badge-pill badge-warning">6 New</span>
					</span> <span class="indicator text-warning d-none d-lg-block"> <i
							class="fa fa-fw fa-circle"></i>
					</span>
				</a>
					<div class="dropdown-menu" aria-labelledby="alertsDropdown">
						<h6 class="dropdown-header">New Alerts:</h6>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#"> <span class="text-success">
								<strong> <i class="fa fa-long-arrow-up fa-fw"></i>Status
									Update
							</strong>
						</span> <span class="small float-right text-muted">11:21 AM</span>
							<div class="dropdown-message small">This is an automated
								server response message. All systems are online.</div>
						</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#"> <span class="text-danger">
								<strong> <i class="fa fa-long-arrow-down fa-fw"></i>Status
									Update
							</strong>
						</span> <span class="small float-right text-muted">11:21 AM</span>
							<div class="dropdown-message small">This is an automated
								server response message. All systems are online.</div>
						</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#"> <span class="text-success">
								<strong> <i class="fa fa-long-arrow-up fa-fw"></i>Status
									Update
							</strong>
						</span> <span class="small float-right text-muted">11:21 AM</span>
							<div class="dropdown-message small">This is an automated
								server response message. All systems are online.</div>
						</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item small" href="#">View all alerts</a>
					</div></li>
				<li class="nav-item">
					<form class="form-inline my-2 my-lg-0 mr-lg-2">
						<div class="input-group">
							<input class="form-control" type="text"
								placeholder="Search for..."> <span
								class="input-group-btn">
								<button class="btn btn-primary" type="button">
									<i class="fa fa-search"></i>
								</button>
							</span>
						</div>
					</form>
				</li>
				<li class="nav-item"><a class="nav-link" data-toggle="modal"
					data-target="#exampleModal"> <i class="fa fa-fw fa-sign-out"></i>Logout
				</a></li>
			</ul>
		</div>
	</nav>
	<div class="content-wrapper">
		<%
 			Cookie cookie = null;
 			Cookie[] cookies = null;
 			cookies = request.getCookies();
 			String user_name = "";
 			if(cookies != null) {
 	            for (int i = 0; i < cookies.length; i++) {
	               cookie = cookies[i];
 	               if (cookie.getName().equals("user_name"))
 	            	   request.setAttribute("user_name", cookie.getValue());
 	               }
 	         }
 		%>
		<div class="container-fluid">
			<a href="newPost">New</a>
			<c:if test="${user_name == post.user_name}">
				<a href="edit-${post.post_id}-post">Edit</a>
			</c:if>
			<div class="row">
				<div class="col-12">
					<h1>View Post</h1>
					<table class="postForm">
						<tr>
							<td height="50" width="150"><label for="user_name">User
									Name </label></td>
							<td height="50" width="750">${post.user_name}</td>
						</tr>

						<tr>
							<td height="50" width="150"><label for="company_name">Company
									Name </label></td>
							<td height="50" width="750">${post.company_name}</td>
						</tr>

						<tr>
							<td height="50" width="150"><label for="company_rating">Company
									Rating </label></td>
							<td height="50" width="750">${post.company_rating}</td>
						</tr>

						<tr>
							<td height="50" width="150"><label for="interview_result">Interview
									Result </label></td>
							<td height="50" width="750">${post.interview_result}</td>
						</tr>

						<tr>
							<td height="100" width="150"><label for="content">Content
							</label></td>
							<td height="100" width="750">${post.content}</td>
						</tr>

						<tr>
							<td height="50" width="150"><label for="interview_year">Interview
									Year </label></td>
							<td height="50" width="750">${post.interview_year}</td>
						</tr>

						<tr>
							<td height="50" width="150"><label for="interview_season">Interview
									Season </label></td>
							<td height="50" width="750">${post.interview_season}</td>
						</tr>

						<tr>
							<td height="50" width="150"><label for="interview_position">Interview
									Position </label></td>
							<td height="50" width="750">${post.interview_position}</td>
						</tr>
					</table>

					<div class="card mb-3">
						<div class="card-header">
							<i class="fa fa-table"></i> Post Feedbacks
						</div>
						<div class="card-body">
							<table class="table table-bordered" id="DataTable" width="100%"cellspacing-"0">
								<thead>
									<tr>
										<th>User Name</th>
										<th>Rating</th>
										<th>Comment</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${postFeedbacks}" var="onepostfeedback">
										<tr>
											<td>${onepostfeedback.user_name }</td>
											<td>${onepostfeedback.rating }</td>
											<td>${onepostfeedback.comment }</td>
										</tr>

									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>

					<h1>Your Post Feedback</h1>
					<form:form method="POST" modelAttribute="postFeedback"
						action="view-${post.post_id}-post">
						<table class="postFeedbackForm">
							<tr>
								<td height="50" width="150"><label for="rating">Rating</label></td>
								<td height="50" width="750"><form:input
										style="width: 500px" path="rating" id="rating" /></td>
								<td height="50" width="100"><form:errors path="rating"
										cssClass="error" /></td>
							</tr>

							<tr>
								<td height="50" width="150"><label for="comment">Comment</label></td>
								<td height="50" width="750"><form:input
										style="width: 500px" path="comment" id="comment" /></td>
								<td height="50" width="100"><form:errors path="comment"
										cssClass="error" /></td>
							</tr>

							<tr style="display: none;">
								<td height="50" width="150"><label for="user_name">User
										Name </label></td>
								<td height="50" width="750"><form:input
										style="width: 500px" path="user_name" id="user_name"
										value="${user_name}" /></td>
								<td height="50" width="100"><form:errors path="user_name"
										cssClass="error" /></td>
							</tr>

							<tr style="display: none;">
								<td height="50" width="150"><label for="post_id">Post
										ID</label></td>
								<td height="50" width="750"><form:input
										style="width: 500px" path="post_id" id="post_id"
										value="${ post.post_id }" /></td>
								<td height="50" width="100"><form:errors path="post_id"
										cssClass="error" /></td>
							</tr>


						</table>
						<button type="submit">Submit Feedback</button>
					</form:form>

				</div>
			</div>
		</div>
		<!-- /.container-fluid-->
		<!-- /.content-wrapper-->
		<footer class="sticky-footer">
			<div class="container">
				<div class="text-center">
					<small>Copyright © Your Website 2017</small>
				</div>
			</div>
		</footer>
		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fa fa-angle-up"></i>
		</a>
		<!-- Logout Modal-->
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Ready to
							Leave?</h5>
						<button class="close" type="button" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">Select "Logout" below if you are
						ready to end your current session.</div>
					<div class="modal-footer">
						<button class="btn btn-secondary" type="button"
							data-dismiss="modal">Cancel</button>
						<a class="btn btn-primary" href="login.html">Logout</a>
					</div>
				</div>
			</div>
		</div>
		<!-- Bootstrap core JavaScript-->
		<script src="${vendor}/jquery/jquery.min.js"></script>
		<script src="${vendor}/bootstrap/js/bootstrap.bundle.min.js"></script>
		<!-- Core plugin JavaScript-->
		<script src="${vendor}/jquery-easing/jquery.easing.min.js"></script>
		<!-- Custom scripts for all pages-->
		<script src="${js}/sb-admin.min.js"></script>
	</div>
</body>

</html>