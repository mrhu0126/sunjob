
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${page.total}${page.current}
<c:forEach items="${page.records}" var="userinfo">
    ${userinfo.username}${userinfo.password}<a href="user.do?p=deletebyusername&username=${userinfo.username}">刪除</a><br>
</c:forEach>
<a href="user.do?p=fenye&page=${page.current+1}&size=${page.size}">下一页</a>
</body>
</html>
