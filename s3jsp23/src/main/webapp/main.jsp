<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${userinfo==null}">
        <c:redirect url="login.jsp"></c:redirect>
    </c:if>

    我是main
</body>
</html>
