<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>

  <%
    request.setAttribute("a" , 10);
    pageContext.setAttribute("c" , 20);
  %>
  <body>
  ${requestScope.a}
  ${pageScope.a}
  </body>
</html>
