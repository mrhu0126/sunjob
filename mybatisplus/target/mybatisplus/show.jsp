<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${ipage.total}&${ipage.current}&${ipage.size}
    <c:forEach items="${ipage.records}" var="userinfo">
        ${userinfo.username}&nbsp;&nbsp;${userinfo.password}<br>
    </c:forEach>
</body>
</html>
