<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车</title>
</head>
<body>
        <table>
            <tr>
                <td>商品编号</td>
                <td>商品名称</td>
                <td>数量</td>
            </tr>

            <c:forEach items="${map}" var="m">
                <tr>
                    <td> ${m.key.goodsid}</td>
                    <td> ${m.key.goodsname}</td>
                    <td><input type="button" value="-"><input type="text" value="${m.value}" style="width: 40px"><input type="button" value="+"></td>
                </tr>
            </c:forEach>
        </table>

</body>
</html>
