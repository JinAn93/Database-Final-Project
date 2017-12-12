<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Login Page</title>

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

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>
</head>

<body class="bg-dark">
      <div class="container">
    		<div class="card card-login mx-auto mt-5">
      		  <div class="card-header">Login</div>
      			<div class="card-body">
      			   <form:form class="form-signin" action="login" modelAttribute="user" method="POST">
                  	  <div class="form-group">              
						<label for="userID" class="sr-only">User ID</label> 
						<form:input type="text" path="user_name" name="userID" class="form-control"
							placeholder="User ID"/>
          		      </div>
          		      <div class="form-group">
						<label for="password" class="sr-only">Password</label> 
						<form:input type="password" path="password" name="password" class="form-control" 
							placeholder="Password" />
				      </div>
				  	  <input class="btn btn-lg btn-primary btn-block" type="submit" value="Login">
				  </form:form>
				<div class="text-center">
          	  	<a class="d-block small mt-3" href="registration">Create New Account</a>
          	  	<a class="d-block small" href="forgotPassword">Forgot Password?</a>
        		</div>
        	  </div>
        	</div>
        </div>		
</body>