<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ResultSet rs = (ResultSet) request.getAttribute("rs");
%>
<html>
<head>
    <title>显示所有</title>
</head>
<body>
    <table>
        <tr>
            <td>用户名</td>
            <td>密码</td>
            <td>操作</td>
        </tr>
        <%while(rs.next()){%>
            <tr>
                <td><%=rs.getString(1)%></td>
                <td><%=rs.getString(2)%></td>
                <td><a href="user.do?p=deletebyusername&username=<%=rs.getString(1)%>">删除</a></td>
            </tr>
        <%}%>
    </table>



</body>
</html>
