<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="DateTime" class="java.util.Date" />


<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>User Profile</title>
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
</head>


<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="dashboard">Recruit Monster</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link" href="dashboard">
            <i class="fa fa-fw fa-dashboard"></i>
            <span class="nav-link-text">Dashboard</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="User Profile">
          <a class="nav-link" href="profile">
            <i class="fa fa-fw fa-file"></i>
            <span class="nav-link-text">My Profile</span>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <form class="form-inline my-2 my-lg-0 mr-lg-2">
            <div class="input-group">
              <input class="form-control" type="text" placeholder="Search for...">
              <span class="input-group-btn">
                <button class="btn btn-primary" type="button">
                  <i class="fa fa-search"></i>
                </button>
              </span>
            </div>
          </form>
        </li>
        <li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-fw fa-sign-out"></i>Logout</a>
        </li>
      </ul>
    </div>
  </nav>
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="dashboard">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">My Profile</li>
      </ol>
      <div class="row">
        <div class="col-12">
          <h1>My Profile</h1>
          
          <!-- Start Profile -->
          				
						<div class="row">
							<div class="col-12"> <!-- "col-md-offset-2 col-md-8 col-lg-offset-3 col-lg-6" -->
								<div class="profile card">
									<div class="col-sm-12">
										<div class="col-xs-12 col-sm-8">
											<h2>${User.first_name} ${User.last_name }</h2>
											<p>
												<strong>User Name: </strong> ${User.user_name}
											</p>
											<p>
												<strong>Email: </strong> ${User.email}
											</p>
											<p>
												<strong>Current Company: </strong> <c:out value="${empty User.current_company ? 'N/A' : User.current_company}" />
											</p>
										</div>
									</div>
									<div class="form-inline text-center">
										<div class="col-xs-12 col-sm-4 emphasis">
											<h2>
												<strong> <c:out value="${empty NumFollowers ? '0' : NumFollowers}" /> </strong>
											</h2>
											<p>
												<small>Followers</small>
											</p>
										</div>
										<div class="col-xs-12 col-sm-4 emphasis">
											<h2>
												<strong>${fn:length(FollowedUsers)}</strong>
											</h2>
											<p>
												<small>Following</small>
											</p>
										</div>
										<div class="col-xs-12 col-sm-4 emphasis">
											<h2>
												<strong>${fn:length(Posts)}</strong>
											</h2>
											<p>
												<small>Posts</small>
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					
										
			<!-- End Profile -->
			
          <p></p>
          
          <!-- start recent posts-->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fa fa-comments"></i> Recent Posts</div>
            <div class="list-group list-group-flush small">
            
            <c:forEach items="${Posts}" var="Post" varStatus="i">
            	<c:if test="${i.index < 9}"> 
				    <a class="list-group-item list-group-item-action">
	                <div class="media">
	                  <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/45x45" alt="">
	                  <div class="media-body">
	                    <strong>${Post.user_name } </strong> posted about
	                    <strong>${Post.company_name }</strong>.                    
	                    <div class="text-muted smaller">${Post.post_date}</div>
	                  </div>
	                </div>
	              </a>
              </c:if>
			</c:forEach>

              <a class="list-group-item list-group-item-action" >View more posts...</a>
            </div>
            <div class="card-footer small text-muted"> Updated at <fmt:formatDate value="${DateTime}" pattern="h:mm a ' on ' MM-dd-yyyy" /> </div>
          </div>
          <!-- end recent posts -->
          
          <!-- start followed people and companies -->
          <div class="row">
          	<div class="col-md-6">
	          	<div class="card mb-3">
	            <div class="card-header">
	              <i class="fa fa-users"></i> Followed Users</div>
	            <div class="list-group list-group-flush small">
	            
	            <c:forEach items="${FollowedUsers}" var="FollowedUser" varStatus="i">
            		<c:if test="${i.index < 5}"> 
					    <a class="list-group-item list-group-item-action" href="#">
		                <div class="media">
		                  <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/20x20" alt="">
		                  <div class="media-body">
		                    <strong>${FollowedUser.getFollowee()}</strong>
		                  </div>
		                </div>
		              </a>
              		</c:if>
				</c:forEach>
	            
	   
	              
	              <a class="list-group-item list-group-item-action" >View more...</a>
	            </div>
	            <div class="card-footer small text-muted"> Updated at <fmt:formatDate value="${DateTime}" pattern="h:mm a ' on ' MM-dd-yyyy" /> </div>
	          </div>          
          	</div>
          	
          	<div class="col-md-6">
	          	<div class="card mb-3">
	            <div class="card-header">
	              <i class="fa fa-building"></i> Followed Companies</div>
	            <div class="list-group list-group-flush small">
	            
	         <c:forEach items="${FollowedCompanies}" var="FollowedCompany" varStatus="i">
            	<c:if test="${i.index < 5}"> 
				    <a class="list-group-item list-group-item-action" href="#">
	                <div class="media">
	                  <div class="media-body">
	                    <strong>${FollowedCompany.getCompany_name()}</strong>
	                  </div>
	                </div>
	              </a>
              </c:if>
			</c:forEach>
	         
	              <a class="list-group-item list-group-item-action" >View more...</a>
	            </div>
	            <div class="card-footer small text-muted"> Updated at <fmt:formatDate value="${DateTime}" pattern="h:mm a ' on ' MM-dd-yyyy" /> </div>
	          </div>
          	</div>
          
          </div>
          
          <!-- end followed people and companies -->
          
        </div>
      </div>
    </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
    <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>Copyright © Recruit Monster 2017</small>
        </div>
      </div>
    </footer>
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">×</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
            <a class="btn btn-primary" href="login">Logout</a>
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