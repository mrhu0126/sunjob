<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${goods.goodsid}
${goods.goodsname}
<img src="${pageContext.request.contextPath}/image/${goods.goodspic}">
${goods.goodscount}
${goods.goodsdesc}
</body>
</html>
