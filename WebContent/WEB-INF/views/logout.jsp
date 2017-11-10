<%
	session.setAttribute("user_id", null);
	session.invalidate();
	response.sendRedirect("http://localhost:8080/Database-Final-Project/login");
%>
