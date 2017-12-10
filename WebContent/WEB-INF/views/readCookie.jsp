<html>
	<%
    Cookie[] cookies= request.getCookies();
    // check null because there are chances that there are no cookies
    if(cookies !=null)
    {
      for(int i=0 ;i<cookies.length;i++ )
      {
        Cookie cookie = cookies[i];
        out.println(" <tr> ");
        out.println("<td>" + cookie.getName() + "</td>" );
        out.println("<td>" + cookie.getValue() + "</td>" );
        out.println("<td>" + cookie.getMaxAge() + "</td>" );
        out.println(" </tr> ");
      }
    }
	%>
</html>