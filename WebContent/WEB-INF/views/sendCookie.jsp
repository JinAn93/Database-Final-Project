<html>
   <%
     Cookie userIdCookie= new Cookie("userID", "guest");
     userIdCookie.setMaxAge(24*60*60);
     Cookie createdBy= new Cookie("createdBy","sendCookieJSP" );
     createdBy.setMaxAge(24*60*60);
     response.addCookie(userIdCookie);
     response.addCookie(createdBy);
   %>
</html>