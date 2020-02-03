<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <c:forEach items="${list}" var="goods">
            <div style="width: 200px ; height: 300px;float: left; margin-left: 30px;border: 1px solid red;">
            ${goods.goodsid}
            ${goods.goodsname}
                <a href="goods.do?p=findbyid&goodsid=${goods.goodsid}"><img src="${pageContext.request.contextPath}/image/${goods.goodspic}"></a>
            ${goods.goodscount}
            ${goods.goodsdesc}
            </div>
        </c:forEach>
</body>
</html>
