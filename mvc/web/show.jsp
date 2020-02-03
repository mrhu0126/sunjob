<%@ page import="java.util.List" %>
<%@ page import="com.pojo.UserInfo" %><%--
  Created by IntelliJ IDEA.
  User: Mr胡
  Date: 2019/10/21
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<%
    List<UserInfo> list = (List<UserInfo>) request.getAttribute("list");
%>

<body>

  11
    <%for (UserInfo userInfo : list) {%>
        <%=userInfo.getUsername()%>
        <%=userInfo.getPassword()%>
        <a>删除</a><br>
    <%}%>

</body>
</html>
