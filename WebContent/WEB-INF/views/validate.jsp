<%@ page import="java.sql.*"%>
<%@ page import="java.security.MessageDigest" %>
<%
	try {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");
		System.out.println(password);
		
		md.update(password.getBytes());
		byte[] byteData = md.digest();
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<byteData.length; i++){
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		System.out.println(sb.toString());
		
		Class.forName("com.mysql.jdbc.Driver"); // Connect to MySQL database
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://db316.ccewzfeuzond.us-west-2.rds.amazonaws.com:3306/db316?"
						+ "user=db316&password=DB316Rocks!");
		PreparedStatement pst = conn
				.prepareStatement("select * from User where user_name=? and password=?");
		pst.setString(1, user_name);
		pst.setString(2, sb.toString());
		ResultSet rs = pst.executeQuery();
		if (rs.next()){
			session.setAttribute("user_name", user_name);
			response.sendRedirect("http://localhost:8080/Database-Final-Project/dashboard");
		}
		else
			out.println("Invalid password <a href='http://localhost:8080/Database-Final-Project/login'> try again</a>");
	} catch (Exception e) {
		System.out.println(e);
		out.println("Try again!");
	}
%>
