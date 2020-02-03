<%--
  Created by IntelliJ IDEA.
  User: Mr胡
  Date: 2019/12/26
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${map.list}"  var="goods">
    ${goods.goodsid}${goods.goodsname}
</c:forEach>


<a href="goods.do?p=fenye&page=${map.page+1}&size=${map.size}">下一页</a>

</body>
</html>
