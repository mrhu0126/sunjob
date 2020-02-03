<%--
  Created by IntelliJ IDEA.
  User: Mr胡
  Date: 2020/1/9
  Time: 8:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${ipage.records}" var="userinfo">
    ${userinfo.username}&nbsp;&nbsp;&nbsp;${userinfo.password}<a href="user.do?p=deletebyusername&username=${userinfo.username}">删除</a><br>
</c:forEach>
</body>
</html>
