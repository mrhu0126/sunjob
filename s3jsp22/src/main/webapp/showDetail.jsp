<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${goods.goodsid}
${goods.goodsname}
${goods.goodsprice}
${goods.goodscount}
${goods.goodsdesc}
<c:forEach items="${goods.pics}" var="pic">
    <img src="image/${pic.pname}"><br>
</c:forEach>

<a href="javascript:void(0)" onclick="addCar()">加入购物车</a>
<input type="text" id="num" value="1">

<a href="user.do?p=addCollection&goodsid=${goods.goodsid}" >收藏</a>
</body>
</html>

<script>

    function addCar(){
        //得到需要加入购物车的数量
        var num = document.getElementById("num").value;
        location="goods.do?p=addCar&goodsid=${goods.goodsid}&num="+num ;

    }


</script>


