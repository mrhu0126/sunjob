<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <%= session.isNew() %>
    <%session.setMaxInactiveInterval(10);%>
  </body>

</html>
