<%--
  Created by IntelliJ IDEA.
  User: Mr胡
  Date: 2019/10/15
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String username = (String)session.getAttribute("username");
    if(username==null){
        response.sendRedirect("login.jsp");
    }

%>


这是主界面
</body>
</html>
