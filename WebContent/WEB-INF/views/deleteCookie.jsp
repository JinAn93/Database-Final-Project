<html>
    <%
     Cookie[] cookies= request.getCookies();
     //check null because there are chances that there are no cookies
     if(cookies !=null)
     {
       for(int i=0 ;i<cookies.length;i++ )
       {
         Cookie cookie = cookies[i];
         if(cookie.getName().equals("userID"))
         {
         cookie.setMaxAge(0);
            response.addCookie(cookie);
         }
       }
      }
    %>
</html>