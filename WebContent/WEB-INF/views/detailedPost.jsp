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
<title>Detailed Post</title>
</head>
<style>

.action {
	padding-top: 50px;
	padding-right: 300px;
    padding-left: 300px;
}

.postDetails {
	margin-left: 300px;
	margin-right: 300px;
	border: 1px solid black;
	width: 1000px; 
	height: "500";
}

td, tr{
	border: 1px solid black;
}

td:not(#contents) {
	text-align: center;
}

.replies {
	padding-right: 300px;
    padding-left: 300px;
    border-collapse: collapse;
    width: 100%;
}

#editedReply {
    padding-left: ${indentSize}px;
}

#postContents {
	padding: 30px;
}
p {
	line-height: 10px;
	text-align: left;
	border-bottom: 1px solid #ddd;
	text-indent: 
}

pre {
	font-family: Helvetica;
}
</style>


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
					<li class="active"><a href="<c:url value='/dashboard' />">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- navbar end -->
	<div class="action">
		<a href="dashboard"> Go Back to Dashboard</a>

		<c:choose>
			<c:when test="${loggedinID == post.user_id}">
				<a href="<c:url value='/edit-${post.id}-post' />">Edit</a>
				<a href="<c:url value='/delete-${post.id}-post' />">Delete</a>
			</c:when>
		</c:choose>
		<br>
	</div>
	
	<table class="postDetails">
		<tr>
			<td width="150" height="45">Title</td>
			<td colspan="3">${post.title}</td>
		</tr>
		<tr>
			<td width="150" height="45">Date Posted</td>
			<td width="450">${post.post_date}</td>
			<td width="150" height="45">Created By</td>
			<td>${post.user_id}</td>
		</tr>
		<tr>
			<td rowspan="2" width="150" height="200">Contents</td>
			<td id="postContents" rowspan="2" colspan="3"><pre>${post.contents}</pre></td>
		</tr>

	</table>

	<div class="replies">
		<br>
		<div class="replyHistory">
			<c:forEach items="${replies}" var="onereply">
				<c:set var="depthForEachReply" value="${onereply.depth}" />
				<%
					Integer indentSize = (Integer) (pageContext.getAttribute("depthForEachReply"));
					request.setAttribute("indentSize", indentSize*40);
				%>
				<c:choose>
					<c:when test="${editReplyPressed && onereply.id == clickedReplyID}">
						<form:form id="editedReply" method="POST" modelAttribute="editReply">
							<form:input size="75" path="contents" id="contents" value="${onereply.contents}" />
							<form:input size="10" path="post_date" id="post_date" value="${onereply.post_date}" readOnly="true" />
							<input type="submit" value="Edit"/>
							<form:input path="parent_id" type="hidden" id="parent_id" value="${onereply.parent_id}" />
							<form:input path="post_id" type="hidden" id="post_id" value="${onereply.post_id}" />
							<form:input path="depth" type="hidden" id="depth" value="${onereply.depth}" />
							<form:input path="id" type="hidden" id="id" value="${onereply.id}" />
						</form:form>
					</c:when>
					<c:otherwise>
						<p id="replyDisplay" style="text-indent: ${indentSize}px">${onereply.user_id}: ${onereply.contents} (${onereply.post_date})
						<a href="<c:url value='/reply-${post.id}-${onereply.id}-${onereply.depth}-reply' />">Reply</a>
						<c:choose>
							<c:when test="${loggedinID == onereply.user_id}">
							<a href="<c:url value='/edit-${post.id}-${onereply.id}-reply' />">Edit</a>
							<a href="<c:url value='/delete-${post.id}-${onereply.id}-reply' />">Delete</a>
							</c:when>
						</c:choose>
						</p>
					</c:otherwise>
				</c:choose>
				<!--  This is where people could write reply of replies -->
				<c:choose>
					<c:when test="${recursiveReplyPressed && onereply.id == clickedReplyID}">
						<form:form method="POST" modelAttribute="recursiveReply">
							<form:input size="75" path="contents" id="contents" value="Write Your Reply Here!" />
							<form:input size="10" path="post_date" id="post_date" value="${onereply.post_date}" readOnly="true" />
							<input type="submit" value="Reply"/>
							<form:input path="parent_id" type="hidden" id="parent_id" value="${clickedReplyID}" />
							<form:input path="post_id" type="hidden" id="post_id" value="${post.id}" />
							<form:input path="depth" type="hidden" id="depth" value="${replyDepth}" />
						</form:form>
					</c:when>
				</c:choose>
			</c:forEach>
		</div>
			
		<div id="newReplyRow">
			<form:form method="POST" modelAttribute="reply">
				<form:input size="75" path="contents" id="contents" value="Write Your Reply Here!" />
				<form:input size="10" path="post_date" id="post_date" value="${reply.post_date}" readOnly="true" />
				<input type="submit" value="Reply"/>
				<form:input path="parent_id" type="hidden" id="parent_id" value="0" />
				<form:input path="post_id" type="hidden" id="post_id" value="${post.id}" />
				<form:input path="depth" type="hidden" id="depth" value="0" />
			</form:form>
		</div>
	</div>
</body>
</html>