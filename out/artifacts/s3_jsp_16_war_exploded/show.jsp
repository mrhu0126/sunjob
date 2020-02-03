<%@ page import="java.util.List" %>
<%@ page import="com.pojo.UserInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- 数据-->
<% List<UserInfo> list = (List<UserInfo>) request.getAttribute("list"); %>
<!-- 显示-->

<table>
    <tr>
        <td>用户名</td>
        <td>密码</td>
        <td>删除</td>
    </tr>

    <%
        for (UserInfo userInfo : list) {
    %>

    <tr>
        <td><%=userInfo.getUsername()%></td>
        <td><%=userInfo.getPassword()%></td>
        <td><a href="user.do?p=deletebyusername&username=<%=userInfo.getUsername()%>">删除</a></td>
    </tr>
    <%}%>
aaaaaaaassssssddddd
</table>



</body>
</html>
