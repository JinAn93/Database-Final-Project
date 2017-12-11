<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
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

<title>Register Success</title>
</head>


<body class="bg-dark">
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">You have successfully registered an account</div>
      <div class="card-body">
        <div class="text-center">
        	
          <a class="d-block" href="login">Login Here</a>
        </div>
      </div>
    </div>
  </div>
  
  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>



<%-- <body>
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
	
	<h4>${success}</h4>
	<br />
	<%
		String loggedinID = (String) session.getAttribute("user_id");
		request.setAttribute("loggedinID", loggedinID);
	%>
	<c:choose>
		<c:when test="${loggedinID != null}">
			Go to <a href="dashboard">Dashboard</a>
		</c:when>
		<c:otherwise>
			<a href="login">Login Here!</a>
		</c:otherwise>
	</c:choose>
</body> --%>
</html>